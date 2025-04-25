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

// Generated from "com/google/common/base/BinaryPredicates.java"
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


import com.google.common.base.BinaryPredicate


import com.google.common.base.Predicate
import java.io.Serializable

import kotlin.Any

import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.Suppress
import kotlin.collections.MutableIterable

import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class BinaryPredicates {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun <X, Y> alwaysTrue(): BinaryPredicate<X, Y> { null!! }





  @JvmStatic
  
  fun <X, Y> alwaysFalse(): BinaryPredicate<X, Y> { null!! }





  @JvmStatic
  
  fun <X, Y> equality(): BinaryPredicate<X, Y> { null!! }





  @JvmStatic
  
  fun <X, Y> identity(): BinaryPredicate<X, Y> { null!! }





  @JvmStatic
  
  fun <X, Y> first(
    predicate: Predicate<in X>
  ): BinaryPredicate<X, Y> { null!! }



  @JvmStatic
  
  fun <X, Y> second(
    predicate: Predicate<in Y>
  ): BinaryPredicate<X, Y> { null!! }



  @JvmStatic
  
  fun <X, Y> and(
    binaryPredicate1: BinaryPredicate<in X, in Y>,
    binaryPredicate2: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> { null!! }






  @JvmStatic
  
  fun <X, Y> and(
   vararg  components: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> { null!! }








  @JvmStatic
  
  fun <X, Y> and(
    components: MutableIterable<BinaryPredicate<in X, in Y>>
  ): BinaryPredicate<X, Y> { null!! }



  @JvmStatic
  
  fun <X, Y> or(
    binaryPredicate1: BinaryPredicate<in X, in Y>,
    binaryPredicate2: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> { null!! }






  @JvmStatic
  
  fun <X, Y> or(
   vararg  components: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> { null!! }








  @JvmStatic
  
  fun <X, Y> or(
    components: MutableIterable<BinaryPredicate<in X, in Y>>
  ): BinaryPredicate<X, Y> { null!! }



  @JvmStatic
  
  fun <X, Y> not(
    binaryPredicate: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> { null!! }



  




  
















  









 }

 
 enum class AlwaysTrue: BinaryPredicate<Any?, Any?> {
  
  AlwaysTrue;

  override fun apply(o1: Any?, o2: Any?): Boolean { null!! }


 }

 
 enum class AlwaysFalse: BinaryPredicate<Any?, Any?> {
  
  AlwaysFalse;

  override fun apply(o1: Any?, o2: Any?): Boolean { null!! }


 }

 
 enum class Equality: BinaryPredicate<Any?, Any?> {
  
  Equality;

  override fun apply(o1: Any?, o2: Any?): Boolean { null!! }


 }

 
 enum class Identity: BinaryPredicate<Any?, Any?> {
  
  Identity;

  override fun apply(o1: Any?, o2: Any?): Boolean { null!! }


 }

 
 class Not<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicate_pp_com_google_common_base: BinaryPredicate<in X, in Y>

  internal constructor(predicate: BinaryPredicate<in X, in Y>) {}



  override fun apply(x: X, y: Y): Boolean { null!! }



  override fun equals(obj: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }


 }

 
 class And<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicates_pp_com_google_common_base: MutableIterable<BinaryPredicate<in X, in Y>>

  internal constructor(predicates: MutableIterable<BinaryPredicate<in X, in Y>>) {}






  override fun apply(x: X, y: Y): Boolean { null!! }








  override fun equals(obj: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }




 }

 
 class Or<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicates_pp_com_google_common_base: MutableIterable<BinaryPredicate<in X, in Y>>

  internal constructor(predicates: MutableIterable<BinaryPredicate<in X, in Y>>) {}






  override fun apply(x: X, y: Y): Boolean { null!! }








  override fun equals(obj: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }




 }

 
 class First<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicate_pp_com_google_common_base: Predicate<in X>

  internal constructor(predicate: Predicate<in X>) {}



  override fun apply(x: X, y: Y): Boolean { null!! }



  override fun equals(obj: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }


 }

 
 class Second<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicate_pp_com_google_common_base: Predicate<in Y>

  internal constructor(predicate: Predicate<in Y>) {}



  override fun apply(x: X, y: Y): Boolean { null!! }



  override fun equals(obj: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }


 }
}
