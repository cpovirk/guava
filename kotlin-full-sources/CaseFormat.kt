/*
 * Copyright (C) 2003 The Guava Authors
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

// Generated from "com/google/common/base/CaseFormat.java"
@file:OptIn(ExperimentalObjCName::class)
@file:Suppress(
 "ALWAYS_NULL",
 "PARAMETER_NAME_CHANGED_ON_OVERRIDE",
 "SENSELESS_COMPARISON",
 "UNCHECKED_CAST",
 "UNNECESSARY_LATEINIT",
 "UNNECESSARY_NOT_NULL_ASSERTION",
 "UNREACHABLE_CODE",
 "UNUSED_ANONYMOUS_PARAMETER",
 "UNUSED_PARAMETER",
 "UNUSED_VARIABLE",
 "USELESS_CAST",
 "VARIABLE_IN_SINGLETON_WITHOUT_THREAD_LOCAL",
 "VARIABLE_WITH_REDUNDANT_INITIALIZER",
 "REDUNDANT_ELSE_IN_WHEN")

package com.google.common.base


import com.google.common.base.Ascii
import com.google.common.base.CharMatcher
import com.google.common.base.Converter
import com.google.common.base.Preconditions
import java.io.Serializable
import java.util.Objects
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName
import kotlin.run
import kotlin.text.StringBuilder


enum class CaseFormat {
 
 LOWER_HYPHEN(
  CharMatcher.`is`('-'),
  "-",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String {
   return Ascii.toLowerCase(word)
  }

  override fun convert_pp_com_google_common_base(format: CaseFormat, s: String): String {
   if (format === CaseFormat.LOWER_UNDERSCORE) {
    return s.replace('-', '_')
   }
   if (format === CaseFormat.UPPER_UNDERSCORE) {
    return Ascii.toUpperCase(
     s.replace('-', '_'),
    )
   }
   return super<CaseFormat>.convert_pp_com_google_common_base(format, s)
  }
 },
 
 LOWER_UNDERSCORE(
  CharMatcher.`is`('_'),
  "_",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String {
   return Ascii.toLowerCase(word)
  }

  override fun convert_pp_com_google_common_base(format: CaseFormat, s: String): String {
   if (format === CaseFormat.LOWER_HYPHEN) {
    return s.replace('_', '-')
   }
   if (format === CaseFormat.UPPER_UNDERSCORE) {
    return Ascii.toUpperCase(s)
   }
   return super<CaseFormat>.convert_pp_com_google_common_base(format, s)
  }
 },
 
 LOWER_CAMEL(
  CharMatcher.inRange('A', 'Z'),
  "",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String {
   return CaseFormat.firstCharOnlyToUpper(word)
  }

  override fun normalizeFirstWord_pp_com_google_common_base(word: String): String {
   return Ascii.toLowerCase(word)
  }
 },
 
 UPPER_CAMEL(
  CharMatcher.inRange('A', 'Z'),
  "",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String {
   return CaseFormat.firstCharOnlyToUpper(word)
  }
 },
 
 UPPER_UNDERSCORE(
  CharMatcher.`is`('_'),
  "_",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String {
   return Ascii.toUpperCase(word)
  }

  override fun convert_pp_com_google_common_base(format: CaseFormat, s: String): String {
   if (format === CaseFormat.LOWER_HYPHEN) {
    return Ascii.toLowerCase(
     s.replace('_', '-'),
    )
   }
   if (format === CaseFormat.LOWER_UNDERSCORE) {
    return Ascii.toLowerCase(s)
   }
   return super<CaseFormat>.convert_pp_com_google_common_base(format, s)
  }
 };

 private val wordBoundary: CharMatcher

 private val wordSeparator: String

 constructor(wordBoundary: CharMatcher, wordSeparator: String) {
  this.wordBoundary = wordBoundary
  this.wordSeparator = wordSeparator
 }

 
 fun to(
   format: CaseFormat,
   str: String
 ): String {
  Preconditions.checkNotNull<CaseFormat>(format)
  Preconditions.checkNotNull<String>(str)
  return if (format === this) str else this.convert_pp_com_google_common_base(format, str)
 }

 internal open fun convert_pp_com_google_common_base(format: CaseFormat, s: String): String {
  var out: StringBuilder? = null
  var i: Int = 0
  var j: Int = - 1
  while (run {
   j = this.wordBoundary.indexIn(
    s,
    run {
     j = j + 1
     j
    },
   )
   j
  } != - 1) {
   if (i == 0) {
    out = StringBuilder(
     s.length + 4 * format.wordSeparator.length,
    )
    out!!.append(
     format.normalizeFirstWord_pp_com_google_common_base(
      s.substring(i, j),
     ),
    )
   } else {
    Objects.requireNonNull<StringBuilder>(out).append(
     format.normalizeWord_pp_com_google_common_base(
      s.substring(i, j),
     ),
    )
   }
   out!!.append(
    format.wordSeparator,
   )
   i = j + this.wordSeparator.length
  }
  return if (i == 0) format.normalizeFirstWord_pp_com_google_common_base(s) else Objects.requireNonNull<StringBuilder>(out).append(
   format.normalizeWord_pp_com_google_common_base(
    s.substring(i),
   ),
  ).toString()
 }

 
 open fun converterTo(
   targetFormat: CaseFormat
 ): Converter<String, String> {
  return StringConverter(this@CaseFormat, targetFormat)
 }

 internal abstract fun normalizeWord_pp_com_google_common_base(word: String): String

 internal open fun normalizeFirstWord_pp_com_google_common_base(word: String): String {
  return this.normalizeWord_pp_com_google_common_base(word)
 }

 
 companion object {
  @JvmStatic
  private fun firstCharOnlyToUpper(word: String): String {
   return if (word.isEmpty()) word else "" + Ascii.toUpperCase(
    word.get(0),
   ) + Ascii.toLowerCase(
    word.substring(1),
   )
  }
 }

 
 class StringConverter: Converter<String, String>, Serializable {
  private val sourceFormat: CaseFormat

  private val targetFormat: CaseFormat

  internal constructor(sourceFormat: CaseFormat, targetFormat: CaseFormat) {
   this.sourceFormat = Preconditions.checkNotNull<CaseFormat>(sourceFormat)
   this.targetFormat = Preconditions.checkNotNull<CaseFormat>(targetFormat)
  }

  override fun doForward(s: String): String {
   return this.sourceFormat.to(
    this.targetFormat,
    s,
   )
  }

  override fun doBackward(s: String): String {
   return this.targetFormat.to(
    this.sourceFormat,
    s,
   )
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is StringConverter) {
    val that: StringConverter? = obj as StringConverter?
    return this.sourceFormat.equals(
     that!!.sourceFormat,
    ) && this.targetFormat.equals(
     that!!.targetFormat,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.sourceFormat.hashCode().xor(
    this.targetFormat.hashCode(),
   )
  }

  override fun toString(): String {
   return "" + this.sourceFormat + ".converterTo(" + this.targetFormat + ")"
  }
 }
}
