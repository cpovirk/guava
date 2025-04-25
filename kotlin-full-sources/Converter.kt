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

// Generated from "com/google/common/base/Converter.java"
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
import com.google.common.base.NullnessCasts
import com.google.common.base.Preconditions
import java.io.Serializable
import java.lang.AssertionError
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableIterable
import kotlin.collections.MutableIterator
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName
import kotlin.run


abstract class Converter<A: Any, B: Any>: Function<A, B> {
 private val handleNullAutomatically: Boolean

 private var reverse: Converter<B, A>? = null

 constructor(): this(true)

 internal constructor(handleNullAutomatically: Boolean) {
  this.handleNullAutomatically = handleNullAutomatically
 }

 
 abstract fun doForward(
   a: A
 ): B

 
 abstract fun doBackward(
   b: B
 ): A

 
 fun convert(
   a: A?
 ): B? {
  return this.correctedDoForward_pp_com_google_common_base(a)
 }

 internal open fun correctedDoForward_pp_com_google_common_base(a: A?): B? {
  if (this.handleNullAutomatically) {
   return if (a == null) null else Preconditions.checkNotNull<B>(
    this.doForward(
     a!!,
    ),
   )
  } else {
   return this.unsafeDoForward(a)
  }
 }

 internal open fun correctedDoBackward_pp_com_google_common_base(b: B?): A? {
  if (this.handleNullAutomatically) {
   return if (b == null) null else Preconditions.checkNotNull<A>(
    this.doBackward(
     b!!,
    ),
   )
  } else {
   return this.unsafeDoBackward(b)
  }
 }

 private fun unsafeDoForward(a: A?): B? {
  return this.doForward(
   NullnessCasts.uncheckedCastNullableTToT_pp_com_google_common_base<A?>(a)!!,
  )
 }

 private fun unsafeDoBackward(b: B?): A? {
  return this.doBackward(
   NullnessCasts.uncheckedCastNullableTToT_pp_com_google_common_base<B?>(b)!!,
  )
 }

 
 open fun convertAll(
   fromIterable: MutableIterable<A>
 ): MutableIterable<B> {
  Preconditions.checkNotNull(
   fromIterable,
   "fromIterable" as Any?,
  )
  return null!!
 }

 
 open fun reverse(): Converter<B, A> {
  val result: Converter<B, A>? = this.reverse
  return (if (result == null) run {
   val ___qualifier: Converter<A, B> = this
   val ___value: Converter<B, A> = ReverseConverter<A, B>(this@Converter)
   ___qualifier.reverse = ___value
   ___value
  } else result)!!
 }

 
 fun <C: Any> andThen(
   secondConverter: Converter<B, C>
 ): Converter<A, C> {
  return this.doAndThen_pp_com_google_common_base<C>(secondConverter)
 }

 internal open fun <C: Any> doAndThen_pp_com_google_common_base(secondConverter: Converter<B, C>): Converter<A, C> {
  return ConverterComposition<A, B, C>(
   this@Converter,
   Preconditions.checkNotNull<Converter<B, C>>(secondConverter),
  )
 }

 final override fun apply(a: A): B {
  return this.convert(a)!!
 }

 override fun equals(`object`: Any?): Boolean {
  return super.equals(`object`)
 }

 
 companion object {
  @JvmStatic
  
  fun <A_1: Any, B_1: Any> from(
    forwardFunction: Function<in A_1, out B_1>,
    backwardFunction: Function<in B_1, out A_1>
  ): Converter<A_1, B_1> {
   return FunctionBasedConverter<A_1, B_1>(forwardFunction, backwardFunction)
  }

  @JvmStatic
  
  fun <T: Any> identity(): Converter<T, T> {
   return IdentityConverter.INSTANCE_pp_com_google_common_base as IdentityConverter<T>
  }
 }

 
 class ReverseConverter<A: Any, B: Any>: Converter<B, A>, Serializable {
  @JvmField
  internal val original_pp_com_google_common_base: Converter<A, B>

  internal constructor(original: Converter<A, B>) {
   this.original_pp_com_google_common_base = original
  }

  override fun doForward(b: B): A {
   throw AssertionError()
  }

  override fun doBackward(a: A): B {
   throw AssertionError()
  }

  override fun correctedDoForward_pp_com_google_common_base(b: B?): A? {
   return this.original_pp_com_google_common_base.correctedDoBackward_pp_com_google_common_base(b)
  }

  override fun correctedDoBackward_pp_com_google_common_base(a: A?): B? {
   return this.original_pp_com_google_common_base.correctedDoForward_pp_com_google_common_base(a)
  }

  override fun reverse(): Converter<A, B> {
   return this.original_pp_com_google_common_base
  }

  override fun equals(`object`: Any?): Boolean {
   if (`object` is ReverseConverter<*, *>) {
    val that: ReverseConverter<*, *>? = `object` as ReverseConverter<*, *>?
    return this.original_pp_com_google_common_base.equals(
     that!!.original_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.original_pp_com_google_common_base.hashCode().inv()
  }

  override fun toString(): String {
   return "" + this.original_pp_com_google_common_base + ".reverse()"
  }
 }

 
 class ConverterComposition<A: Any, B: Any, C: Any>: Converter<A, C>, Serializable {
  @JvmField
  internal val first_pp_com_google_common_base: Converter<A, B>

  @JvmField
  internal val second_pp_com_google_common_base: Converter<B, C>

  internal constructor(first: Converter<A, B>, second: Converter<B, C>) {
   this.first_pp_com_google_common_base = first
   this.second_pp_com_google_common_base = second
  }

  override fun doForward(a: A): C {
   throw AssertionError()
  }

  override fun doBackward(c: C): A {
   throw AssertionError()
  }

  override fun correctedDoForward_pp_com_google_common_base(a: A?): C? {
   return this.second_pp_com_google_common_base.correctedDoForward_pp_com_google_common_base(
    this.first_pp_com_google_common_base.correctedDoForward_pp_com_google_common_base(a),
   )
  }

  override fun correctedDoBackward_pp_com_google_common_base(c: C?): A? {
   return this.first_pp_com_google_common_base.correctedDoBackward_pp_com_google_common_base(
    this.second_pp_com_google_common_base.correctedDoBackward_pp_com_google_common_base(c),
   )
  }

  override fun equals(`object`: Any?): Boolean {
   if (`object` is ConverterComposition<*, *, *>) {
    val that: ConverterComposition<*, *, *>? = `object` as ConverterComposition<*, *, *>?
    return this.first_pp_com_google_common_base.equals(
     that!!.first_pp_com_google_common_base,
    ) && this.second_pp_com_google_common_base.equals(
     that!!.second_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return 31 * this.first_pp_com_google_common_base.hashCode() + this.second_pp_com_google_common_base.hashCode()
  }

  override fun toString(): String {
   return "" + this.first_pp_com_google_common_base + ".andThen(" + this.second_pp_com_google_common_base + ")"
  }
 }

 
 class FunctionBasedConverter<A: Any, B: Any>: Converter<A, B>, Serializable {
  private val forwardFunction: Function<in A, out B>

  private val backwardFunction: Function<in B, out A>

  internal constructor(forwardFunction: Function<in A, out B>, backwardFunction: Function<in B, out A>) {
   this.forwardFunction = Preconditions.checkNotNull(forwardFunction)
   this.backwardFunction = Preconditions.checkNotNull(backwardFunction)
  }

  override fun doForward(a: A): B {
   return this.forwardFunction.apply(a)
  }

  override fun doBackward(b: B): A {
   return this.backwardFunction.apply(b)
  }

  override fun equals(`object`: Any?): Boolean {
   if (`object` is FunctionBasedConverter<*, *>) {
    val that: FunctionBasedConverter<*, *>? = `object` as FunctionBasedConverter<*, *>?
    return this.forwardFunction.equals(
     that!!.forwardFunction,
    ) && this.backwardFunction.equals(
     that!!.backwardFunction,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode()
  }

  override fun toString(): String {
   return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")"
  }
 }

 
 class IdentityConverter<T: Any> internal constructor(): Converter<T, T>(), Serializable {
  override fun doForward(t: T): T {
   return t
  }

  override fun doBackward(t: T): T {
   return t
  }

  override fun reverse(): IdentityConverter<T> {
   return this
  }

  override fun <S: Any> doAndThen_pp_com_google_common_base(otherConverter: Converter<T, S>): Converter<T, S> {
   return Preconditions.checkNotNull<Converter<T, S>>(
    otherConverter as Converter<T, S>?,
    "otherConverter" as Any?,
   )
  }

  override fun toString(): String {
   return "Converter.identity()"
  }

  private fun readResolve(): Any {
   return IdentityConverter.INSTANCE_pp_com_google_common_base
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: Converter<*, *> = IdentityConverter<Any>()
  }
 }
}
