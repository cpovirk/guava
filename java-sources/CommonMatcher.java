/*
 * Copyright (C) 2016 The Guava Authors
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


/**
 * The subset of the {@link java.util.regex.Matcher} API which is used by this package, and also
 * shared with the {@code re2j} library. For internal use only. Please refer to the {@code Matcher}
 * javadoc for details.
 */

// PUBLIC:begin_strip
// We don't *want* to expose this to google3 Android users, but we had to because google3 JRE users
// were mixing the Android copy of common.base (which didn't previously have this class as public)
// with the JRE copy of common.primitives (which uses this class). Ideally we'd fix their deps.
public
// PUBLIC:end_strip
abstract class CommonMatcher {
  public abstract boolean matches();

  public abstract boolean find();

  public abstract boolean find(int index);

  public abstract String replaceAll(String replacement);

  public abstract int end();

  public abstract int start();
}
