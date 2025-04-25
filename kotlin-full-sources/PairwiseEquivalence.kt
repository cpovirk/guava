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

// Generated from "com/google/common/base/PairwiseEquivalence.java"
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
import com.google.common.base.Preconditions
import java.io.Serializable
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
import kotlin.native.ObjCName


class PairwiseEquivalence<E: Any, T: E?>: Equivalence<MutableIterable<T>>, Serializable {
 @JvmField
 internal val elementEquivalence_pp_com_google_common_base: Equivalence<E>

 internal constructor(elementEquivalence: Equivalence<E>) {
  this.elementEquivalence_pp_com_google_common_base = Preconditions.checkNotNull<Equivalence<E>>(elementEquivalence)
 }

 override fun doEquivalent(iterableA: MutableIterable<T>, iterableB: MutableIterable<T>): Boolean {
  val iteratorA: MutableIterator<T> = iterableA.iterator()
  val iteratorB: MutableIterator<T> = iterableB.iterator()
  while (iteratorA.hasNext() && iteratorB.hasNext()) {
   if (!this.elementEquivalence_pp_com_google_common_base.equivalent(
    iteratorA.next(),
    iteratorB.next(),
   )) {
    return false
   }
  }
  return !iteratorA.hasNext() && !iteratorB.hasNext()
 }

 override fun doHash(iterable: MutableIterable<T>): Int {
  var hash: Int = 78721
  for (element in iterable) {
   hash = hash * 24943 + this.elementEquivalence_pp_com_google_common_base.hash(element)
  }
  return hash
 }

 override fun equals(obj: Any?): Boolean {
  if (obj is PairwiseEquivalence<*, *>) {
   val that: PairwiseEquivalence<Any, Any>? = obj as PairwiseEquivalence<Any, Any>?
   return this.elementEquivalence_pp_com_google_common_base.equals(
    that!!.elementEquivalence_pp_com_google_common_base,
   )
  }
  return false
 }

 override fun hashCode(): Int {
  return this.elementEquivalence_pp_com_google_common_base.hashCode().xor(1185147655)
 }

 override fun toString(): String {
  return "" + this.elementEquivalence_pp_com_google_common_base + ".pairwise()"
 }
}
