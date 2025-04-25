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

// Generated from "com/google/common/base/Equivalence.java"
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


import com.google.common.base.Function




import com.google.common.base.Predicate
import java.io.Serializable

import java.util.function.BiPredicate
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableIterable
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


abstract class Equivalence<T: Any>: BiPredicate<T?, T?> {
 constructor()

 
 fun equivalent(
   a: T?,
   b: T?
 ): Boolean { null!! }












 final override fun test(t: T?, u: T?): Boolean { null!! }



 
 abstract fun doEquivalent(
   a: T,
   b: T
 ): Boolean

 
 fun hash(
   t: T?
 ): Int { null!! }








 
 abstract fun doHash(
   t: T
 ): Int

 
 fun <F: Any> onResultOf(
   function: Function<in F, out T?>
 ): Equivalence<F> { null!! }



 
 fun <S: T?> wrap(
   reference: S
 ): Wrapper<S> { null!! }



 
 fun <S: T?> pairwise(): Equivalence<MutableIterable<S>> { null!! }



 
 fun equivalentTo(
   target: T?
 ): Predicate<T?> { null!! }



 
 companion object {
  @JvmStatic
  
  fun equals(): Equivalence<Any> { null!! }



  @JvmStatic
  
  fun identity(): Equivalence<Any> { null!! }


 }

 
 class Wrapper<T>: Serializable {
  

  

  internal constructor(equivalence: Equivalence<in T & Any>, reference: T) {}




  
  fun get(): T { null!! }



  override fun equals(obj: Any?): Boolean { null!! }


















  override fun hashCode(): Int { null!! }





  override fun toString(): String { null!! }


 }

 
 class EquivalentToPredicate<T: Any>: Predicate<T?>, Serializable {
  

  

  internal constructor(equivalence: Equivalence<T>, target: T?) {}




  override fun apply(input: T?): Boolean { null!! }






  override fun equals(obj: Any?): Boolean { null!! }















  override fun hashCode(): Int { null!! }






  override fun toString(): String { null!! }


 }

 
 class Equals internal constructor(): Equivalence<Any>(), Serializable {
  override fun doEquivalent(a: Any, b: Any): Boolean { null!! }



  override fun doHash(o: Any): Int { null!! }



  



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: Equals = null!!
  }
 }

 
 class Identity internal constructor(): Equivalence<Any>(), Serializable {
  override fun doEquivalent(a: Any, b: Any): Boolean { null!! }



  override fun doHash(o: Any): Int { null!! }



  



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: Identity = null!!
  }
 }
}
