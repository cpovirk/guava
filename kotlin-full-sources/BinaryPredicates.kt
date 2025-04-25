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
 "REDUNDANT_ELSE_IN_WHEN")

package com.google.common.base


import com.google.common.base.BinaryPredicate
import com.google.common.base.Objects
import com.google.common.base.Preconditions
import com.google.common.base.Predicate
import java.io.Serializable
import java.util.Arrays
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.Suppress
import kotlin.collections.MutableIterable
import kotlin.collections.MutableIterator
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class BinaryPredicates {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun <X, Y> alwaysTrue(): BinaryPredicate<X, Y> {
   return BinaryPredicates.restrict<X, Y>(
    AlwaysTrue.AlwaysTrue,
   )
  }

  @JvmStatic
  
  fun <X, Y> alwaysFalse(): BinaryPredicate<X, Y> {
   return BinaryPredicates.restrict<X, Y>(
    AlwaysFalse.AlwaysFalse,
   )
  }

  @JvmStatic
  
  fun <X, Y> equality(): BinaryPredicate<X, Y> {
   return BinaryPredicates.restrict<X, Y>(
    Equality.Equality,
   )
  }

  @JvmStatic
  
  fun <X, Y> identity(): BinaryPredicate<X, Y> {
   return BinaryPredicates.restrict<X, Y>(
    Identity.Identity,
   )
  }

  @JvmStatic
  
  fun <X, Y> first(
    predicate: Predicate<in X>
  ): BinaryPredicate<X, Y> {
   return First<X, Y>(predicate)
  }

  @JvmStatic
  
  fun <X, Y> second(
    predicate: Predicate<in Y>
  ): BinaryPredicate<X, Y> {
   return Second<X, Y>(predicate)
  }

  @JvmStatic
  
  fun <X, Y> and(
    binaryPredicate1: BinaryPredicate<in X, in Y>,
    binaryPredicate2: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> {
   val restricted1: BinaryPredicate<X, Y> = BinaryPredicates.restrict<X, Y>(binaryPredicate1)
   val restricted2: BinaryPredicate<X, Y> = BinaryPredicates.restrict<X, Y>(binaryPredicate2)
   val iterable: MutableIterable<BinaryPredicate<X, Y>> = Arrays.asList<BinaryPredicate<X, Y>>(restricted1, restricted2)
   return And<X, Y>(iterable)
  }

  @JvmStatic
  
  fun <X, Y> and(
   vararg  components: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> {
   val components_1: Array<BinaryPredicate<in X, in Y>> = components as Array<BinaryPredicate<in X, in Y>>
   return And<X, Y>(
    Arrays.asList<BinaryPredicate<in X, in Y>>(
     *components_1,
    ),
   )
  }

  @JvmStatic
  
  fun <X, Y> and(
    components: MutableIterable<BinaryPredicate<in X, in Y>>
  ): BinaryPredicate<X, Y> {
   return And<X, Y>(components)
  }

  @JvmStatic
  
  fun <X, Y> or(
    binaryPredicate1: BinaryPredicate<in X, in Y>,
    binaryPredicate2: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> {
   val restricted1: BinaryPredicate<X, Y> = BinaryPredicates.restrict<X, Y>(binaryPredicate1)
   val restricted2: BinaryPredicate<X, Y> = BinaryPredicates.restrict<X, Y>(binaryPredicate2)
   val iterable: MutableIterable<BinaryPredicate<X, Y>> = Arrays.asList<BinaryPredicate<X, Y>>(restricted1, restricted2)
   return Or<X, Y>(iterable)
  }

  @JvmStatic
  
  fun <X, Y> or(
   vararg  components: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> {
   val components_1: Array<BinaryPredicate<in X, in Y>> = components as Array<BinaryPredicate<in X, in Y>>
   return Or<X, Y>(
    Arrays.asList<BinaryPredicate<in X, in Y>>(
     *components_1,
    ),
   )
  }

  @JvmStatic
  
  fun <X, Y> or(
    components: MutableIterable<BinaryPredicate<in X, in Y>>
  ): BinaryPredicate<X, Y> {
   return Or<X, Y>(components)
  }

  @JvmStatic
  
  fun <X, Y> not(
    binaryPredicate: BinaryPredicate<in X, in Y>
  ): BinaryPredicate<X, Y> {
   return Not<X, Y>(binaryPredicate)
  }

  @JvmStatic
  private fun <X, Y> restrict(predicate: BinaryPredicate<in X, in Y>): BinaryPredicate<X, Y> {
   return predicate as BinaryPredicate<X, Y>
  }

  @JvmStatic
  private fun iterableElementsEqual(iterable1: MutableIterable<Any>, iterable2: MutableIterable<Any>): Boolean {
   val iterator1: MutableIterator<Any> = iterable1.iterator() as MutableIterator<Any>
   val iterator2: MutableIterator<Any> = iterable2.iterator() as MutableIterator<Any>
   while (iterator1.hasNext()) {
    if (!iterator2.hasNext()) {
     return false
    }
    if (!iterator1.next()!!.equals(
     iterator2.next(),
    )) {
     return false
    }
   }
   return !iterator2.hasNext()
  }

  @JvmStatic
  private fun iterableAsListHashCode(iterable: MutableIterable<Any>): Int {
   val iterator: MutableIterator<Any> = iterable.iterator() as MutableIterator<Any>
   var result: Int = 1
   while (iterator.hasNext()) {
    val obj: Any? = iterator.next()
    result = 31 * result + obj!!.hashCode()
   }
   return result
  }
 }

 
 enum class AlwaysTrue: BinaryPredicate<Any?, Any?> {
  
  AlwaysTrue;

  override fun apply(o1: Any?, o2: Any?): Boolean {
   return true
  }
 }

 
 enum class AlwaysFalse: BinaryPredicate<Any?, Any?> {
  
  AlwaysFalse;

  override fun apply(o1: Any?, o2: Any?): Boolean {
   return false
  }
 }

 
 enum class Equality: BinaryPredicate<Any?, Any?> {
  
  Equality;

  override fun apply(o1: Any?, o2: Any?): Boolean {
   return Objects.equal(o1, o2)
  }
 }

 
 enum class Identity: BinaryPredicate<Any?, Any?> {
  
  Identity;

  override fun apply(o1: Any?, o2: Any?): Boolean {
   return o1 === o2
  }
 }

 
 class Not<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicate_pp_com_google_common_base: BinaryPredicate<in X, in Y>

  internal constructor(predicate: BinaryPredicate<in X, in Y>) {
   this.predicate_pp_com_google_common_base = Preconditions.checkNotNull(predicate)
  }

  override fun apply(x: X, y: Y): Boolean {
   return !this.predicate_pp_com_google_common_base.apply(x, y)
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is Not<*, *>) {
    val other: Not<*, *>? = obj as Not<*, *>?
    return this.predicate_pp_com_google_common_base.equals(
     other!!.predicate_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.predicate_pp_com_google_common_base.hashCode()
  }
 }

 
 class And<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicates_pp_com_google_common_base: MutableIterable<BinaryPredicate<in X, in Y>>

  internal constructor(predicates: MutableIterable<BinaryPredicate<in X, in Y>>) {
   for (predicate in predicates) {
    Preconditions.checkNotNull(predicate)
   }
   this.predicates_pp_com_google_common_base = predicates
  }

  override fun apply(x: X, y: Y): Boolean {
   for (predicate in this.predicates_pp_com_google_common_base) {
    if (!predicate!!.apply(x, y)) {
     return false
    }
   }
   return true
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is And<*, *>) {
    return BinaryPredicates.iterableElementsEqual(
     this.predicates_pp_com_google_common_base,
     (obj as And<*, *>?)!!.predicates_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return BinaryPredicates.iterableAsListHashCode(
    this.predicates_pp_com_google_common_base,
   )
  }
 }

 
 class Or<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicates_pp_com_google_common_base: MutableIterable<BinaryPredicate<in X, in Y>>

  internal constructor(predicates: MutableIterable<BinaryPredicate<in X, in Y>>) {
   for (predicate in predicates) {
    Preconditions.checkNotNull(predicate)
   }
   this.predicates_pp_com_google_common_base = predicates
  }

  override fun apply(x: X, y: Y): Boolean {
   for (predicate in this.predicates_pp_com_google_common_base) {
    if (predicate!!.apply(x, y)) {
     return true
    }
   }
   return false
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is Or<*, *>) {
    return BinaryPredicates.iterableElementsEqual(
     this.predicates_pp_com_google_common_base,
     (obj as Or<*, *>?)!!.predicates_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return BinaryPredicates.iterableAsListHashCode(
    this.predicates_pp_com_google_common_base,
   )
  }
 }

 
 class First<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicate_pp_com_google_common_base: Predicate<in X>

  internal constructor(predicate: Predicate<in X>) {
   this.predicate_pp_com_google_common_base = Preconditions.checkNotNull(predicate)
  }

  override fun apply(x: X, y: Y): Boolean {
   return this.predicate_pp_com_google_common_base.apply(x)
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is First<*, *>) {
    val other: First<*, *>? = obj as First<*, *>?
    return this.predicate_pp_com_google_common_base.equals(
     other!!.predicate_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.predicate_pp_com_google_common_base.hashCode()
  }
 }

 
 class Second<X, Y>: BinaryPredicate<X, Y>, Serializable {
  @JvmField
  internal val predicate_pp_com_google_common_base: Predicate<in Y>

  internal constructor(predicate: Predicate<in Y>) {
   this.predicate_pp_com_google_common_base = Preconditions.checkNotNull(predicate)
  }

  override fun apply(x: X, y: Y): Boolean {
   return this.predicate_pp_com_google_common_base.apply(y)
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is Second<*, *>) {
    val other: Second<*, *>? = obj as Second<*, *>?
    return this.predicate_pp_com_google_common_base.equals(
     other!!.predicate_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.predicate_pp_com_google_common_base.hashCode()
  }
 }
}
