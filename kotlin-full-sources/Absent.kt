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

// Generated from "com/google/common/base/Absent.java"
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
import com.google.common.base.Optional
import com.google.common.base.Preconditions
import com.google.common.base.Supplier
import java.lang.IllegalStateException
import java.util.Collections
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableSet
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class Absent<T: Any>: Optional<T> {
 private constructor()

 override fun isPresent(): Boolean {
  return false
 }

 override fun get(): T {
  throw IllegalStateException("Optional.get() cannot be called on an absent value")
 }

 override fun or(defaultValue: T): T {
  return Preconditions.checkNotNull<T>(
   defaultValue as T?,
   "use Optional.orNull() instead of Optional.or(null)" as Any?,
  )
 }

 override fun or(secondChoice: Optional<out T>): Optional<T> {
  return Preconditions.checkNotNull(secondChoice) as Optional<T>
 }

 override fun or(supplier: Supplier<out T>): T {
  return Preconditions.checkNotNull(
   supplier.get() as T?,
   "use Optional.orNull() instead of a Supplier that returns null" as Any?,
  )
 }

 override fun orNull(): T? {
  return null
 }

 override fun asSet(): MutableSet<T> {
  return Collections.emptySet<T>()
 }

 override fun <V: Any> transform(function: Function<in T, V>): Optional<V> {
  Preconditions.checkNotNull(function)
  return Optional.absent<V>()
 }

 override fun equals(obj: Any?): Boolean {
  return this === obj
 }

 override fun hashCode(): Int {
  return 2040732332
 }

 override fun toString(): String {
  return "Optional.absent()"
 }

 private fun readResolve(): Any {
  return Absent.INSTANCE_pp_com_google_common_base
 }

 
 companion object {
  @JvmField
  internal val INSTANCE_pp_com_google_common_base: Absent<Any> = Absent<Any>()

  @JvmStatic
  internal fun <T_1: Any> withType_pp_com_google_common_base(): Optional<T_1> {
   return Absent.INSTANCE_pp_com_google_common_base as Optional<T_1>
  }
 }
}
