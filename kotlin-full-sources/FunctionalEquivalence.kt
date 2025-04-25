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

// Generated from "com/google/common/base/FunctionalEquivalence.java"
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


import com.google.common.base.Equivalence
import com.google.common.base.Function
import com.google.common.base.Objects
import com.google.common.base.Preconditions
import java.io.Serializable
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName


class FunctionalEquivalence<F: Any, T: Any>: Equivalence<F>, Serializable {
 private val function: Function<in F, out T?>

 private val resultEquivalence: Equivalence<T>

 internal constructor(function: Function<in F, out T?>, resultEquivalence: Equivalence<T>) {
  this.function = Preconditions.checkNotNull(function)
  this.resultEquivalence = Preconditions.checkNotNull<Equivalence<T>>(resultEquivalence)
 }

 override fun doEquivalent(a: F, b: F): Boolean {
  return this.resultEquivalence.equivalent(
   this.function.apply(a),
   this.function.apply(b),
  )
 }

 override fun doHash(a: F): Int {
  return this.resultEquivalence.hash(
   this.function.apply(a),
  )
 }

 override fun equals(obj: Any?): Boolean {
  if (obj === this) {
   return true
  }
  if (obj is FunctionalEquivalence<*, *>) {
   val that: FunctionalEquivalence<*, *>? = obj as FunctionalEquivalence<*, *>?
   return this.function.equals(
    that!!.function,
   ) && this.resultEquivalence.equals(
    that!!.resultEquivalence,
   )
  }
  return false
 }

 override fun hashCode(): Int {
  return Objects.hashCode(
   this.function,
   this.resultEquivalence,
  )
 }

 override fun toString(): String {
  return "" + this.resultEquivalence + ".onResultOf(" + this.function + ")"
 }
}
