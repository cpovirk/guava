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

// Generated from "com/google/common/base/Receivers.java"
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


import com.google.common.base.Joiner
import com.google.common.base.Preconditions
import com.google.common.base.Receiver
import java.lang.System
import java.util.ArrayList
import java.util.Arrays
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableCollection
import kotlin.collections.MutableIterable
import kotlin.collections.MutableList
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class Receivers {
 private constructor()

 
 companion object {
  private val IGNORING_RECEIVER: Receiver<Any?> = object : Receiver<Any?> {
   override fun accept(`object`: Any?) {}

   override fun toString(): String {
    return "Receivers.ignore()"
   }
  }

  @JvmStatic
  
  fun <T> ignore(): Receiver<T> {
   return Receivers.IGNORING_RECEIVER as Receiver<T>
  }

  @JvmStatic
  
  fun <T> collect(
    collection: MutableCollection<in T>
  ): Receiver<T> {
   return CollectingReceiver<T>(collection)
  }

  @JvmStatic
  
  fun <T> compose(
   vararg  receivers: Receiver<in T>
  ): Receiver<T> {
   val receivers_1: Array<Receiver<in T>> = receivers as Array<Receiver<in T>>
   return CompositeReceiver<T>(
    Arrays.asList<Receiver<in T>>(
     *receivers_1,
    ),
   )
  }

  @JvmStatic
  
  fun <T> compose(
    receivers: MutableIterable<Receiver<T>>
  ): Receiver<T> {
   return CompositeReceiver<T>(receivers)
  }
 }

 
 class CompositeReceiver<T>: Receiver<T> {
  private val receivers: MutableList<Receiver<in T>>

  internal constructor(receivers: MutableIterable<Receiver<in T>>) {
   this.receivers = CompositeReceiver.copy<Receiver<in T>>(receivers)
  }

  override fun accept(`object`: T) {
   for (receiver in this.receivers) {
    receiver!!.accept(`object`)
   }
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is CompositeReceiver<*>) {
    val that: CompositeReceiver<*>? = obj as CompositeReceiver<*>?
    return this.receivers.equals(
     that!!.receivers,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.receivers.hashCode()
  }

  override fun toString(): String {
   return "Receivers.compose(" + Joiner.on(", ").join(
    this.receivers,
   ) + ")"
  }

  
  companion object {
   @JvmStatic
   private fun <E: Any> copy(elements: MutableIterable<E>): MutableList<E> {
    val list: MutableList<E> = ArrayList<E>()
    for (element in elements) {
     list.add(
      Preconditions.checkNotNull<E>(element),
     )
    }
    return list
   }
  }
 }

 
 class CollectingReceiver<T>: Receiver<T> {
  private val collection: MutableCollection<in T>

  internal constructor(collection: MutableCollection<in T>) {
   this.collection = Preconditions.checkNotNull(collection)
  }

  override fun accept(`object`: T) {
   this.collection.add(`object`)
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is CollectingReceiver<*>) {
    val that: CollectingReceiver<*>? = obj as CollectingReceiver<*>?
    return this.collection === that!!.collection
   }
   return false
  }

  override fun hashCode(): Int {
   return System.identityHashCode(
    this.collection,
   )
  }
 }
}
