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

// Generated from "com/google/common/base/Platform.java"
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
import com.google.common.base.CommonPattern

import com.google.common.base.Optional

import java.lang.Class



import kotlin.Any

import kotlin.Boolean
import kotlin.Double
import kotlin.Enum

import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class Platform {
 private constructor()

 
 companion object {
  @JvmStatic
  internal fun precomputeCharMatcher_pp_com_google_common_base(matcher: CharMatcher): CharMatcher { null!! }



  @JvmStatic
  internal fun <T: Enum<T>> getEnumIfPresent_pp_com_google_common_base(enumClass: Class<T>, value: String): Optional<T> { null!! }









  @JvmStatic
  internal fun formatCompact4Digits_pp_com_google_common_base(value: Double): String { null!! }






  @JvmStatic
  internal fun stringIsNullOrEmpty_pp_com_google_common_base(string: String?): Boolean { null!! }



  @JvmStatic
  internal fun nullToEmpty_pp_com_google_common_base(string: String?): String { null!! }



  @JvmStatic
  internal fun emptyToNull_pp_com_google_common_base(string: String?): String? { null!! }



  @JvmStatic
  internal fun compilePattern_pp_com_google_common_base(pattern: String): CommonPattern { null!! }





  @JvmStatic
  internal fun patternCompilerIsPcreLike_pp_com_google_common_base(): Boolean { null!! }



  @JvmStatic
  internal fun lenientFormat_pp_com_google_common_base(template: String?, vararg args: Any?): String { null!! }







  @JvmStatic
  internal fun stringValueOf_pp_com_google_common_base(o: Any?): String { null!! }


 }
}
