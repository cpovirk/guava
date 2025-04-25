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
 "REDUNDANT_ELSE_IN_WHEN", "MUST_BE_INITIALIZED", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT", "UNINITIALIZED_VARIABLE")

package com.google.common.base



import com.google.common.base.CharMatcher
import com.google.common.base.Converter

import java.io.Serializable

import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName

import kotlin.native.ObjCName




enum class CaseFormat {
 
 LOWER_HYPHEN(
  CharMatcher.`is`('-'),
  "-",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String { null!! }



  override fun convert_pp_com_google_common_base(format: CaseFormat, s: String): String { null!! }










 },
 
 LOWER_UNDERSCORE(
  CharMatcher.`is`('_'),
  "_",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String { null!! }



  override fun convert_pp_com_google_common_base(format: CaseFormat, s: String): String { null!! }








 },
 
 LOWER_CAMEL(
  CharMatcher.inRange('A', 'Z'),
  "",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String { null!! }



  override fun normalizeFirstWord_pp_com_google_common_base(word: String): String { null!! }


 },
 
 UPPER_CAMEL(
  CharMatcher.inRange('A', 'Z'),
  "",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String { null!! }


 },
 
 UPPER_UNDERSCORE(
  CharMatcher.`is`('_'),
  "_",
 ) {
  override fun normalizeWord_pp_com_google_common_base(word: String): String { null!! }



  override fun convert_pp_com_google_common_base(format: CaseFormat, s: String): String { null!! }










 };

 

 

 constructor(wordBoundary: CharMatcher, wordSeparator: String) {}




 
 fun to(
   format: CaseFormat,
   str: String
 ): String { null!! }





 internal open fun convert_pp_com_google_common_base(format: CaseFormat, s: String): String { null!! }









































 
 open fun converterTo(
   targetFormat: CaseFormat
 ): Converter<String, String> { null!! }



 internal abstract fun normalizeWord_pp_com_google_common_base(word: String): String

 internal open fun normalizeFirstWord_pp_com_google_common_base(word: String): String { null!! }



 
 companion object {
  







 }

 
 class StringConverter: Converter<String, String>, Serializable {
  

  

  internal constructor(sourceFormat: CaseFormat, targetFormat: CaseFormat) {}




  override fun doForward(s: String): String { null!! }






  override fun doBackward(s: String): String { null!! }






  override fun equals(obj: Any?): Boolean { null!! }











  override fun hashCode(): Int { null!! }





  override fun toString(): String { null!! }


 }
}
