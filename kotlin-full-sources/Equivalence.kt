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
 "REDUNDANT_ELSE_IN_WHEN")

package com.google.common.base


import com.google.common.base.Function
import com.google.common.base.FunctionalEquivalence
import com.google.common.base.Objects
import com.google.common.base.PairwiseEquivalence
import com.google.common.base.Preconditions
import com.google.common.base.Predicate
import java.io.Serializable
import java.lang.System
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
 ): Boolean {
  if (a === b) {
   return true
  }
  if (a == null || b == null) {
   return false
  }
  return this.doEquivalent(
   a!!,
   b!!,
  )
 }

 final override fun test(t: T?, u: T?): Boolean {
  return this.equivalent(t, u)
 }

 
 abstract fun doEquivalent(
   a: T,
   b: T
 ): Boolean

 
 fun hash(
   t: T?
 ): Int {
  if (t == null) {
   return 0
  }
  return this.doHash(
   t!!,
  )
 }

 
 abstract fun doHash(
   t: T
 ): Int

 
 fun <F: Any> onResultOf(
   function: Function<in F, out T?>
 ): Equivalence<F> {
  return FunctionalEquivalence<F, T>(function, this@Equivalence)
 }

 
 fun <S: T?> wrap(
   reference: S
 ): Wrapper<S> {
  return Wrapper<S>(this@Equivalence, reference)
 }

 
 fun <S: T?> pairwise(): Equivalence<MutableIterable<S>> {
  return PairwiseEquivalence<T, S>(this@Equivalence)
 }

 
 fun equivalentTo(
   target: T?
 ): Predicate<T?> {
  return EquivalentToPredicate<T>(this@Equivalence, target)
 }

 
 companion object {
  @JvmStatic
  
  fun equals(): Equivalence<Any> {
   return Equals.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun identity(): Equivalence<Any> {
   return Identity.INSTANCE_pp_com_google_common_base
  }
 }

 
 class Wrapper<T>: Serializable {
  private val equivalence: Equivalence<in T & Any>

  private val reference: T

  internal constructor(equivalence: Equivalence<in T & Any>, reference: T) {
   this.equivalence = Preconditions.checkNotNull(equivalence)
   this.reference = reference
  }

  
  fun get(): T {
   return this.reference
  }

  override fun equals(obj: Any?): Boolean {
   if (obj === this) {
    return true
   }
   if (obj is Wrapper<*>) {
    val that: Wrapper<*>? = obj as Wrapper<*>?
    if (this.equivalence.equals(
     that!!.equivalence,
    )) {
     val equivalence: Equivalence<Any> = this.equivalence as Equivalence<Any>
     return equivalence.equivalent(
      this.reference,
      that!!.reference,
     )
    }
   }
   return false
  }

  override fun hashCode(): Int {
   return this.equivalence.hash(
    this.reference,
   )
  }

  override fun toString(): String {
   return "" + this.equivalence + ".wrap(" + this.reference + ")"
  }
 }

 
 class EquivalentToPredicate<T: Any>: Predicate<T?>, Serializable {
  private val equivalence: Equivalence<T>

  private val target: T?

  internal constructor(equivalence: Equivalence<T>, target: T?) {
   this.equivalence = Preconditions.checkNotNull<Equivalence<T>>(equivalence)
   this.target = target
  }

  override fun apply(input: T?): Boolean {
   return this.equivalence.equivalent(
    input,
    this.target,
   )
  }

  override fun equals(obj: Any?): Boolean {
   if (this === obj) {
    return true
   }
   if (obj is EquivalentToPredicate<*>) {
    val that: EquivalentToPredicate<*>? = obj as EquivalentToPredicate<*>?
    return this.equivalence.equals(
     that!!.equivalence,
    ) && Objects.equal(
     this.target,
     that!!.target,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return Objects.hashCode(
    this.equivalence,
    this.target,
   )
  }

  override fun toString(): String {
   return "" + this.equivalence + ".equivalentTo(" + this.target + ")"
  }
 }

 
 class Equals internal constructor(): Equivalence<Any>(), Serializable {
  override fun doEquivalent(a: Any, b: Any): Boolean {
   return a.equals(b)
  }

  override fun doHash(o: Any): Int {
   return o.hashCode()
  }

  private fun readResolve(): Any {
   return Equals.INSTANCE_pp_com_google_common_base
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: Equals = Equals()
  }
 }

 
 class Identity internal constructor(): Equivalence<Any>(), Serializable {
  override fun doEquivalent(a: Any, b: Any): Boolean {
   return false
  }

  override fun doHash(o: Any): Int {
   return System.identityHashCode(o)
  }

  private fun readResolve(): Any {
   return Identity.INSTANCE_pp_com_google_common_base
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: Identity = Identity()
  }
 }
}
