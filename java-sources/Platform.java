/*
 * Copyright (C) 2009 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.common.base;

import static com.google.common.base.SneakyThrows.sneakyThrow;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.jspecify.annotations.Nullable;

/**
 * Methods factored out so that they can be emulated differently in GWT.
 *
 * @author Jesse Wilson
 */
final class Platform {
  private static final Logger logger = Logger.getLogger(Platform.class.getName());
  private static final PatternCompiler patternCompiler = loadPatternCompiler();

  private Platform() {}

  private static class ProtobufHandleConstants {
    /**
     * The handle to the Protobuf method that configures the output format of {@link
     * com.google.protobuf.Message#toString()}.
     */
    static final @Nullable MethodHandle PROTOBUF_CALL_WITH_DEBUG_FORMAT_METHOD =
        findDebugFormatMethod();

    static @Nullable MethodHandle findDebugFormatMethod() {
      MethodType methodType = MethodType.methodType(void.class, Runnable.class);
      Lookup lookup = MethodHandles.publicLookup();
      try {
        Class<?> protobufToStringOutputClass =
            Class.forName("com.google.protobuf.ProtobufToStringOutput");
        return lookup.findStatic(protobufToStringOutputClass, "callWithDebugFormat", methodType);
      } catch (ReflectiveOperationException e) {
        // Tolerate it when protobufToStringOutputClass is missing.
        return null;
      }
    }
  }

  static CharMatcher precomputeCharMatcher(CharMatcher matcher) {
    return matcher.precomputedInternal();
  }


  static String formatCompact4Digits(double value) {
    return String.format(Locale.ROOT, "%.4g", value);
  }

  static boolean stringIsNullOrEmpty(@Nullable String string) {
    return string == null || string.isEmpty();
  }

  /**
   * Returns the string if it is not null, or an empty string otherwise.
   *
   * @param string the string to test and possibly return
   * @return {@code string} if it is not null; {@code ""} otherwise
   */
  static String nullToEmpty(@Nullable String string) {
    return (string == null) ? "" : string;
  }

  /**
   * Returns the string if it is not empty, or a null string otherwise.
   *
   * @param string the string to test and possibly return
   * @return {@code string} if it is not empty; {@code null} otherwise
   */
  static @Nullable String emptyToNull(@Nullable String string) {
    return stringIsNullOrEmpty(string) ? null : string;
  }

  static String lenientFormat(@Nullable String template, @Nullable Object @Nullable ... args) {
    // PUBLIC:begin_strip
    if (ProtobufHandleConstants.PROTOBUF_CALL_WITH_DEBUG_FORMAT_METHOD != null) {
      String[] result = new String[1];
      try {
        ProtobufHandleConstants.PROTOBUF_CALL_WITH_DEBUG_FORMAT_METHOD.invokeExact(
            (Runnable) () -> result[0] = Strings.lenientFormat(template, args));
        return result[0];
      } catch (Throwable e) {
        throw sneakyThrow(e);
      }
    }
    // PUBLIC:end_strip
    return Strings.lenientFormat(template, args);
  }

  static String stringValueOf(@Nullable Object o) {
    // PUBLIC:begin_strip
    if (ProtobufHandleConstants.PROTOBUF_CALL_WITH_DEBUG_FORMAT_METHOD != null) {
      String[] result = new String[1];
      try {
        ProtobufHandleConstants.PROTOBUF_CALL_WITH_DEBUG_FORMAT_METHOD.invokeExact(
            (Runnable) () -> result[0] = String.valueOf(o));
        return result[0];
      } catch (Throwable e) {
        throw sneakyThrow(e);
      }
    }
    // PUBLIC:end_strip
    return String.valueOf(o);
  }

  static CommonPattern compilePattern(String pattern) {
    Preconditions.checkNotNull(pattern);
    return patternCompiler.compile(pattern);
  }

  static boolean patternCompilerIsPcreLike() {
    return patternCompiler.isPcreLike();
  }

  private static PatternCompiler loadPatternCompiler() {
    // MOE:begin_strip
    // See https://github.com/google/guava/issues/3147
    ServiceLoader<PatternCompiler> loader = ServiceLoader.load(PatternCompiler.class);
    // Returns the first PatternCompiler that loads successfully.
    try {
      for (Iterator<PatternCompiler> it = loader.iterator(); it.hasNext(); ) {
        try {
          return it.next();
        } catch (ServiceConfigurationError e) {
          logPatternCompilerError(e);
        }
      }
    } catch (ServiceConfigurationError e) { // from hasNext()
      logPatternCompilerError(e);
    }
    // Fall back to the JDK regex library.
    // MOE:end_strip
    return new JdkPatternCompiler();
  }

  private static void logPatternCompilerError(ServiceConfigurationError e) {
    logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", e);
  }

  private static final class JdkPatternCompiler implements PatternCompiler {
    @Override
    public CommonPattern compile(String pattern) {
      return new JdkPattern(Pattern.compile(pattern));
    }

    @Override
    public boolean isPcreLike() {
      return true;
    }
  }
}
