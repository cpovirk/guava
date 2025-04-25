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

// Generated from "com/google/common/base/Optional.java"
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


import com.google.common.base.Supplier
import java.io.Serializable

import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableIterable

import kotlin.collections.MutableSet
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


abstract class Optional<T: Any>: Serializable {
 
 open fun toJavaUtil(): java.util.Optional<T> { null!! }





 internal constructor()

 
 abstract fun isPresent(): Boolean

 
 abstract fun get(): T

 
 abstract fun or(
   defaultValue: T
 ): T

 
 abstract fun or(
   secondChoice: Optional<out T>
 ): Optional<T>

 
 abstract fun or(
   supplier: Supplier<out T>
 ): T

 
 abstract fun orNull(): T?

 
 abstract fun asSet(): MutableSet<T>

 
 abstract fun <V: Any> transform(
   function: Function<in T, V>
 ): Optional<V>

 abstract override fun equals(`object`: Any?): Boolean

 abstract override fun hashCode(): Int

 abstract override fun toString(): String

 
 companion object {
  @JvmStatic
  
  fun <T_1: Any> absent(): Optional<T_1> { null!! }



  @JvmStatic
  
  fun <T_1: Any> of(
    reference: T_1
  ): Optional<T_1> { null!! }





  @JvmStatic
  
  fun <T_1: Any> fromNullable(
    nullableReference: T_1?
  ): Optional<T_1> { null!! }





  @JvmStatic
  
  fun <T_1: Any> fromJavaUtil(
    javaUtilOptional: java.util.Optional<T_1>?
  ): Optional<T_1>? { null!! }





  @JvmStatic
  
  fun <T_1: Any> toJavaUtil(
    googleOptional: Optional<T_1>?
  ): java.util.Optional<T_1>? { null!! }



  @JvmStatic
  
  fun <T_1: Any> presentInstances(
    optionals: MutableIterable<Optional<out T_1>>
  ): MutableIterable<T_1> { null!! }



















 }
}
