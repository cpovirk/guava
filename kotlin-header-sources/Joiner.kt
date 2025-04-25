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

// Generated from "com/google/common/base/Joiner.java"
@file:OptIn(ExperimentalObjCName::class, ExperimentalObjCRefinement::class)
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



import java.io.IOException








import kotlin.Any
import kotlin.Array
import kotlin.Char
import kotlin.CharSequence

import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableIterable
import kotlin.collections.MutableIterator

import kotlin.collections.MutableMap
import kotlin.collections.MutableMap.MutableEntry
import kotlin.experimental.ExperimentalObjCName
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.jvm.JvmStatic
import kotlin.jvm.Throws
import kotlin.native.HiddenFromObjC
import kotlin.native.ObjCName

import kotlin.text.Appendable
import kotlin.text.StringBuilder


open class Joiner {
 

 private constructor(separator: String) {}



 private constructor(prototype: Joiner) {}



 
 @Throws(IOException::class)
 open fun <A: Appendable> appendTo(appendable: A, parts: MutableIterable<*>): A { null!! }






 
 @Throws(IOException::class)
 open fun <A: Appendable> appendTo(appendable: A, parts: MutableIterator<*>): A { null!! }





















 
 @Throws(IOException::class)
 fun <A: Appendable> appendTo(appendable: A, parts: Array<Any?>): A { null!! }






 
 @Throws(IOException::class)
 fun <A: Appendable> appendTo(appendable: A, first: Any?, second: Any?, vararg rest: Any?): A { null!! }







 
 fun appendTo(builder: StringBuilder, parts: MutableIterable<*>): StringBuilder { null!! }






 
 fun appendTo(builder: StringBuilder, parts: MutableIterator<*>): StringBuilder { null!! }











 
 fun appendTo(builder: StringBuilder, parts: Array<Any?>): StringBuilder { null!! }






 
 fun appendTo(builder: StringBuilder, first: Any?, second: Any?, vararg rest: Any?): StringBuilder { null!! }







 
 open fun join(
   parts: MutableIterable<*>
 ): String { null!! }







































 
 fun join(
   parts: MutableIterator<*>
 ): String { null!! }






 
 fun join(
   parts: Array<Any?>
 ): String { null!! }






 
 fun join(
   first: Any?,
   second: Any?,
  vararg  rest: Any?
 ): String { null!! }






 
 open fun useForNull(
   nullText: String
 ): Joiner { null!! }
















 
 open fun skipNulls(): Joiner { null!! }



















































 
 open fun withKeyValueSeparator(
   keyValueSeparator: Char
 ): MapJoiner { null!! }





 
 open fun withKeyValueSeparator(
   keyValueSeparator: String
 ): MapJoiner { null!! }



 internal open fun toString_pp_com_google_common_base(part: Any?): CharSequence { null!! }




 
 companion object {
  @JvmStatic
  
  fun on(
    separator: String
  ): Joiner { null!! }



  @JvmStatic
  
  fun on(
    separator: Char
  ): Joiner { null!! }





  
























  

















 }

 
 class MapJoiner {
  

  

  internal constructor(joiner: Joiner, keyValueSeparator: String) {}




  
  @Throws(IOException::class)
  fun <A: Appendable> appendTo(appendable: A, map: MutableMap<*, *>): A { null!! }






  
  fun appendTo(builder: StringBuilder, map: MutableMap<*, *>): StringBuilder { null!! }






  
  @Throws(IOException::class)
  fun <A: Appendable> appendTo(appendable: A, entries: MutableIterable<MutableEntry<*, *>>): A { null!! }






  
  @Throws(IOException::class)
  fun <A: Appendable> appendTo(appendable: A, parts: MutableIterator<MutableEntry<*, *>>): A { null!! }







































  
  fun appendTo(builder: StringBuilder, entries: MutableIterable<MutableEntry<*, *>>): StringBuilder { null!! }






  
  fun appendTo(builder: StringBuilder, entries: MutableIterator<MutableEntry<*, *>>): StringBuilder { null!! }











  
  fun join(
    map: MutableMap<*, *>
  ): String { null!! }





  
  fun join(
    entries: MutableIterable<MutableEntry<*, *>>
  ): String { null!! }





  
  fun join(
    entries: MutableIterator<MutableEntry<*, *>>
  ): String { null!! }






  
  fun useForNull(
    nullText: String
  ): MapJoiner { null!! }





 }
}
