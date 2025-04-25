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

// Generated from "com/google/common/base/SmallCharMatcher.java"
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
import com.google.common.base.CharMatcher.NamedFastMatcher

import java.util.BitSet
import kotlin.Boolean
import kotlin.Char
import kotlin.CharArray

import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class SmallCharMatcher: NamedFastMatcher {
 

 

 

 private constructor(table: CharArray, filter: Long, containsZero: Boolean, description: String): super(description) {}





 





 override fun matches(c: Char): Boolean { null!! }

























 override fun setBits_pp_com_google_common_base(table: BitSet) {}













 
 companion object {
  internal const val MAX_SIZE_pp_com_google_common_base: Int = 1023

  

  

  @JvmStatic
  internal fun smear_pp_com_google_common_base(hashCode: Int): Int { null!! }






  

  @JvmStatic
  internal fun chooseTableSize_pp_com_google_common_base(setSize: Int): Int { null!! }












  @JvmStatic
  internal fun from_pp_com_google_common_base(chars: BitSet, description: String): CharMatcher { null!! }
























 }
}
