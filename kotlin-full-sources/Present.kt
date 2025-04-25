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

// Generated from "com/google/common/base/Present.java"
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
import java.util.Collections
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableSet
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName


class Present<T: Any>: Optional<T> {
 private val reference: T

 internal constructor(reference: T) {
  this.reference = reference
 }

 override fun isPresent(): Boolean {
  return true
 }

 override fun get(): T {
  return this.reference
 }

 override fun or(defaultValue: T): T {
  Preconditions.checkNotNull<T>(
   defaultValue as T?,
   "use Optional.orNull() instead of Optional.or(null)" as Any?,
  )
  return this.reference
 }

 override fun or(secondChoice: Optional<out T>): Optional<T> {
  Preconditions.checkNotNull(secondChoice)
  return this
 }

 override fun or(supplier: Supplier<out T>): T {
  Preconditions.checkNotNull(supplier)
  return this.reference
 }

 override fun orNull(): T {
  return this.reference
 }

 override fun asSet(): MutableSet<T> {
  return Collections.singleton<T>(
   this.reference,
  )
 }

 override fun <V: Any> transform(function: Function<in T, V>): Optional<V> {
  return Present<V>(
   Preconditions.checkNotNull<V>(
    function.apply(
     this@Present.reference,
    ) as V?,
    "the Function passed to Optional.transform() must not return null." as Any?,
   ),
  )
 }

 override fun equals(obj: Any?): Boolean {
  if (obj is Present<*>) {
   val other: Present<*>? = obj as Present<*>?
   return this.reference.equals(
    other!!.reference,
   )
  }
  return false
 }

 override fun hashCode(): Int {
  return 1502476572 + this.reference.hashCode()
 }

 override fun toString(): String {
  return "Optional.of(" + this.reference + ")"
 }
}
