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

// Generated from "com/google/common/base/Splitter.java"
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


import com.google.common.base.AbstractIterator
import com.google.common.base.CharMatcher

import com.google.common.base.CommonPattern




import java.lang.Integer



import java.util.regex.Pattern
import java.util.stream.Stream



import kotlin.Boolean
import kotlin.Char
import kotlin.CharSequence
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableIterable
import kotlin.collections.MutableIterator
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName



class Splitter {
 

 

 private val strategy: Strategy

 

 private constructor(strategy: Strategy): this(
  strategy,
  false,
  CharMatcher.none(),
  Integer.MAX_VALUE,
 )

 private constructor(strategy: Strategy, omitEmptyStrings: Boolean, trimmer: CharMatcher, limit: Int) {}






 
 fun omitEmptyStrings(): Splitter { null!! }








 
 fun limit(
   maxItems: Int
 ): Splitter { null!! }













 
 fun trimResults(): Splitter { null!! }





 
 fun trimResults(
   trimmer: CharMatcher
 ): Splitter { null!! }









 
 fun split(
   sequence: CharSequence
 ): MutableIterable<String> { null!! }















 



 
 fun splitToList(
   sequence: CharSequence
 ): MutableList<String> { null!! }











 
 fun splitToStream(
   sequence: CharSequence
 ): Stream<String> { null!! }






 
 fun withKeyValueSeparator(
   separator: String
 ): MapSplitter { null!! }





 
 fun withKeyValueSeparator(
   separator: Char
 ): MapSplitter { null!! }





 
 fun withKeyValueSeparator(
   keyValueSplitter: Splitter
 ): MapSplitter { null!! }



 
 companion object {
  @JvmStatic
  
  fun on(
    separator: Char
  ): Splitter { null!! }





  @JvmStatic
  
  fun on(
    separatorMatcher: CharMatcher
  ): Splitter { null!! }



















  @JvmStatic
  
  fun on(
    separator: String
  ): Splitter { null!! }


















































  @JvmStatic
  
  fun on(
    separatorPattern: Pattern
  ): Splitter { null!! }





  @JvmStatic
  
  fun onPatternInternal(
    separatorPattern: CommonPattern
  ): Splitter { null!! }





























  @JvmStatic
  
  fun onPattern(
    separatorPattern: String
  ): Splitter { null!! }





  @JvmStatic
  
  fun fixedLength(
    length: Int
  ): Splitter { null!! }



























 }

 
 class MapSplitter {
  

  

  internal constructor(outerSplitter: Splitter, entrySplitter: Splitter) {}




  
  fun split(
    sequence: CharSequence
  ): MutableMap<String, String> { null!! }



































  
  companion object {
   
  }
 }

 
 fun interface Strategy {
  
  fun iterator(
    splitter: Splitter,
    toSplit: CharSequence
  ): MutableIterator<String>
 }

 
 abstract class SplittingIterator: AbstractIterator<String> {
  @JvmField
  internal val toSplit_pp_com_google_common_base: CharSequence

  @JvmField
  internal val trimmer_pp_com_google_common_base: CharMatcher

  @JvmField
  internal val omitEmptyStrings_pp_com_google_common_base: Boolean

  internal abstract fun separatorStart_pp_com_google_common_base(start: Int): Int

  internal abstract fun separatorEnd_pp_com_google_common_base(separatorPosition: Int): Int

  @JvmField
  internal var offset_pp_com_google_common_base: Int = null!!

  @JvmField
  internal var limit_pp_com_google_common_base: Int = null!!

  constructor(
    splitter: Splitter,
    toSplit: CharSequence
  ) {}






  override fun computeNext(): String? { null!! }






















































 }
}
