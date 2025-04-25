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

// Generated from "com/google/common/base/AbstractIterator.java"
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


import com.google.common.base.NullnessCasts
import com.google.common.base.Preconditions
import java.lang.UnsupportedOperationException
import java.util.NoSuchElementException

import kotlin.Boolean
import kotlin.OptIn
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName


abstract class AbstractIterator<T> {
 private var state: State = State.NOT_READY

 constructor()

 private var next: T? = null

 
 abstract fun computeNext(): T?

 
 fun endOfData(): T? {
  this.state = State.DONE
  return null
 }

 final  fun hasNext(): Boolean {
  Preconditions.checkState(
   this.state !== State.FAILED,
  )
  when (this.state) {
   State.DONE -> {
    return false
   }
   State.READY -> {
    return true
   }
   else -> {}
  }
  return this.tryToComputeNext()
 }

 private fun tryToComputeNext(): Boolean {
  this.state = State.FAILED
  this.next = this.computeNext()
  if (this.state !== State.DONE) {
   this.state = State.READY
   return true
  }
  return false
 }

 final  fun next(): T {
  if (!this.hasNext()) {
   throw NoSuchElementException()
  }
  this.state = State.NOT_READY
  val result: T? = NullnessCasts.uncheckedCastNullableTToT_pp_com_google_common_base<T?>(
   this.next,
  )
  this.next = null
  return result as T
 }

 final  fun remove() {
  throw UnsupportedOperationException()
 }

 
 enum class State {
  
  READY,
  
  NOT_READY,
  
  DONE,
  
  FAILED;
 }
}
