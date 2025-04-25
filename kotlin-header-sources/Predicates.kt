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

// Generated from "com/google/common/base/Predicates.java"
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


import com.google.common.base.CommonPattern
import com.google.common.base.Function



import com.google.common.base.Platform

import com.google.common.base.Predicate
import java.io.Serializable
import java.lang.Class



import java.util.regex.Pattern
import kotlin.Any

import kotlin.Boolean
import kotlin.CharSequence

import kotlin.Int

import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableCollection
import kotlin.collections.MutableIterable
import kotlin.collections.MutableList
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName



class Predicates {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun <T> alwaysTrue(): Predicate<T> { null!! }



  @JvmStatic
  
  fun <T> alwaysFalse(): Predicate<T> { null!! }



  @JvmStatic
  
  fun <T> isNull(): Predicate<T> { null!! }



  @JvmStatic
  
  fun <T> notNull(): Predicate<T> { null!! }



  @JvmStatic
  
  fun <T> not(
    predicate: Predicate<T>
  ): Predicate<T> { null!! }



  @JvmStatic
  
  fun <T> and(
    components: MutableIterable<Predicate<in T>>
  ): Predicate<T> { null!! }





  @JvmStatic
  
  fun <T> and(
   vararg  components: Predicate<in T>
  ): Predicate<T> { null!! }








  @JvmStatic
  
  fun <T> and(
    first: Predicate<in T>,
    second: Predicate<in T>
  ): Predicate<T> { null!! }








  @JvmStatic
  
  fun <T> or(
    components: MutableIterable<Predicate<in T>>
  ): Predicate<T> { null!! }





  @JvmStatic
  
  fun <T> or(
   vararg  components: Predicate<in T>
  ): Predicate<T> { null!! }








  @JvmStatic
  
  fun <T> or(
    first: Predicate<in T>,
    second: Predicate<in T>
  ): Predicate<T> { null!! }








  @JvmStatic
  
  fun <T> equalTo(
    target: T
  ): Predicate<T> { null!! }





  @JvmStatic
  
  fun <T> instanceOf(
    clazz: Class<*>
  ): Predicate<T> { null!! }



  @JvmStatic
  
  fun <T> `in`(
    target: MutableCollection<out T>
  ): Predicate<T> { null!! }



  @JvmStatic
  
  fun <A, B> compose(
    predicate: Predicate<B>,
    function: Function<A, out B>
  ): Predicate<A> { null!! }



  @JvmStatic
  
  fun containsPattern(
    pattern: String
  ): Predicate<CharSequence> { null!! }



  @JvmStatic
  
  fun contains(
    pattern: Pattern
  ): Predicate<CharSequence> { null!! }





  













  




  









  @JvmStatic
  internal fun <T: Any> defensiveCopy_pp_com_google_common_base(iterable: MutableIterable<T>): MutableList<T> { null!! }








 }

 
 enum class ObjectPredicate: Predicate<Any?> {
  
  ALWAYS_TRUE {
   override fun apply(o: Any?): Boolean { null!! }



   override fun toString(): String { null!! }


  },
  
  ALWAYS_FALSE {
   override fun apply(o: Any?): Boolean { null!! }



   override fun toString(): String { null!! }


  },
  
  IS_NULL {
   override fun apply(o: Any?): Boolean { null!! }



   override fun toString(): String { null!! }


  },
  
  NOT_NULL {
   override fun apply(o: Any?): Boolean { null!! }



   override fun toString(): String { null!! }


  };

  internal open fun <T> withNarrowedType_pp_com_google_common_base(): Predicate<T> { null!! }


 }

 
 open class NotPredicate<T>: Predicate<T>, Serializable {
  @JvmField
  internal val predicate_pp_com_google_common_base: Predicate<T>

  internal constructor(predicate: Predicate<T>) {}



  override fun apply(t: T): Boolean { null!! }



  override fun hashCode(): Int { null!! }



  override fun equals(obj: Any?): Boolean { null!! }









  override fun toString(): String { null!! }


 }

 
 open class AndPredicate<T>: Predicate<T>, Serializable {
  

  internal constructor(components: MutableList<out Predicate<in T>>) {}



  override fun apply(t: T): Boolean { null!! }










  override fun hashCode(): Int { null!! }



  override fun equals(obj: Any?): Boolean { null!! }









  override fun toString(): String { null!! }





 }

 
 open class OrPredicate<T>: Predicate<T>, Serializable {
  

  internal constructor(components: MutableList<out Predicate<in T>>) {}



  override fun apply(t: T): Boolean { null!! }










  override fun hashCode(): Int { null!! }



  override fun equals(obj: Any?): Boolean { null!! }









  override fun toString(): String { null!! }





 }

 
 open class IsEqualToPredicate: Predicate<Any?>, Serializable {
  

  internal constructor(target: Any) {}



  override fun apply(o: Any?): Boolean { null!! }



  override fun hashCode(): Int { null!! }



  override fun equals(obj: Any?): Boolean { null!! }









  override fun toString(): String { null!! }



  internal open fun <T> withNarrowedType_pp_com_google_common_base(): Predicate<T> { null!! }


 }

 
 open class InstanceOfPredicate<T>: Predicate<T>, Serializable {
  

  internal constructor(clazz: Class<*>) {}





  override fun apply(o: T): Boolean { null!! }



  override fun hashCode(): Int { null!! }



  override fun equals(obj: Any?): Boolean { null!! }







  override fun toString(): String { null!! }


 }

 
 open class InPredicate<T>: Predicate<T>, Serializable {
  

  internal constructor(target: MutableCollection<*>) {}



  override fun apply(t: T): Boolean { null!! }









  override fun equals(obj: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }



  override fun toString(): String { null!! }


 }

 
 open class CompositionPredicate<A, B>: Predicate<A>, Serializable {
  @JvmField
  internal val p_pp_com_google_common_base: Predicate<B>

  @JvmField
  internal val f_pp_com_google_common_base: Function<A, out B>

  internal constructor(p: Predicate<B>, f: Function<A, out B>) {}




  override fun apply(a: A): Boolean { null!! }





  override fun equals(obj: Any?): Boolean { null!! }











  override fun hashCode(): Int { null!! }





  override fun toString(): String { null!! }


 }

 
 open class ContainsPatternPredicate: Predicate<CharSequence>, Serializable {
  @JvmField
  internal val pattern_pp_com_google_common_base: CommonPattern

  internal constructor(pattern: CommonPattern) {}



  override fun apply(t: CharSequence): Boolean { null!! }



  override fun hashCode(): Int { null!! }








  override fun equals(obj: Any?): Boolean { null!! }










  override fun toString(): String { null!! }











 }

 
 open class ContainsPatternFromStringPredicate: ContainsPatternPredicate {
  internal constructor(string: String): super(
   Platform.compilePattern_pp_com_google_common_base(string),
  )

  override fun toString(): String { null!! }


 }
}
