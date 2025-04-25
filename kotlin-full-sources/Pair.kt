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

// Generated from "com/google/common/base/Pair.java"
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
import com.google.common.base.Objects
import java.io.Serializable
import kotlin.Any
import kotlin.Boolean
import kotlin.Comparable
import kotlin.Comparator
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


open class Pair<A, B>: Serializable {
 @JvmField
 
 val first: A

 @JvmField
 
 val second: B

 constructor(
   first: A,
   second: B
 ) {
  this.first = first
  this.second = second
 }

 
 open fun getFirst(): A {
  return this.first
 }

 
 open fun getSecond(): B {
  return this.second
 }

 override fun equals(`object`: Any?): Boolean {
  if (`object` is Pair<*, *>) {
   val that: Pair<*, *>? = `object` as Pair<*, *>?
   return Objects.equal(
    this.getFirst(),
    that!!.getFirst(),
   ) && Objects.equal(
    this.getSecond(),
    that!!.getSecond(),
   )
  }
  return false
 }

 override fun hashCode(): Int {
  val hash1: Int = if (this.first == null) 0 else this.first!!.hashCode()
  val hash2: Int = if (this.second == null) 0 else this.second!!.hashCode()
  return 31 * hash1 + hash2
 }

 override fun toString(): String {
  return "(" + this.getFirst() + ", " + this.getSecond() + ")"
 }

 
 companion object {
  @JvmStatic
  
  fun <A_1, B_1> of(
    first: A_1,
    second: B_1
  ): Pair<A_1, B_1> {
   return Pair<A_1, B_1>(first, second)
  }

  @JvmStatic
  
  fun <A_1, B_1> firstFunction(): Function<Pair<A_1, B_1>, A_1> {
   return PairFirstFunction.INSTANCE_pp_com_google_common_base as Function<Pair<A_1, B_1>, A_1>
  }

  @JvmStatic
  
  fun <A_1, B_1> secondFunction(): Function<Pair<A_1, B_1>, B_1> {
   return PairSecondFunction.INSTANCE_pp_com_google_common_base as Function<Pair<A_1, B_1>, B_1>
  }

  @JvmStatic
  
  fun <A_1: Comparable<A_1>, B_1> compareByFirst(): Comparator<Pair<A_1, B_1>> {
   return FirstComparator.FIRST_COMPARATOR as Comparator<Pair<A_1, B_1>>
  }

  @JvmStatic
  
  fun <A_1, B_1: Comparable<B_1>> compareBySecond(): Comparator<Pair<A_1, B_1>> {
   return SecondComparator.SECOND_COMPARATOR as Comparator<Pair<A_1, B_1>>
  }
 }

 
 class PairFirstFunction<A, B> internal constructor(): Function<Pair<A, B>, A>, Serializable {
  override fun apply(from: Pair<A, B>): A {
   return from.getFirst()
  }

  private fun readResolve(): Any {
   return PairFirstFunction.INSTANCE_pp_com_google_common_base
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: Function<Pair<Any, Any>, Any> = PairFirstFunction<Any, Any>()
  }
 }

 
 class PairSecondFunction<A, B> internal constructor(): Function<Pair<A, B>, B>, Serializable {
  override fun apply(from: Pair<A, B>): B {
   return from.getSecond()
  }

  private fun readResolve(): Any {
   return PairSecondFunction.INSTANCE_pp_com_google_common_base
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: Function<Pair<Any, Any>, Any> = PairSecondFunction<Any, Any>()
  }
 }

 
 enum class FirstComparator: java.util.Comparator<Pair<Comparable<*>, Any?>> {
  
  FIRST_COMPARATOR;

  override fun compare(pair1: Pair<Comparable<*>, Any?>, pair2: Pair<Comparable<*>, Any?>): Int {
   val left: Comparable<Any> = pair1.getFirst() as Comparable<Any>
   val right: Comparable<*>? = pair2.getFirst() as Comparable<*>?
   val result: Int = left.compareTo(
    right!!,
   )
   return result
  }
 }

 
 enum class SecondComparator: java.util.Comparator<Pair<Any?, Comparable<*>>> {
  
  SECOND_COMPARATOR;

  override fun compare(pair1: Pair<Any?, Comparable<*>>, pair2: Pair<Any?, Comparable<*>>): Int {
   val left: Comparable<Any> = pair1.getSecond() as Comparable<Any>
   val right: Comparable<*>? = pair2.getSecond() as Comparable<*>?
   val result: Int = left.compareTo(
    right!!,
   )
   return result
  }
 }
}
