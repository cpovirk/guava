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

// Generated from "com/google/common/base/Suppliers.java"
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
import com.google.common.base.Objects
import com.google.common.base.Preconditions
import com.google.common.base.Supplier
import com.google.common.base.XplatMonitor
import java.io.Serializable
import java.lang.IllegalStateException
import java.lang.System
import java.lang.Void
import java.util.concurrent.TimeUnit
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName
import kotlin.synchronized


class Suppliers {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun <F, T> compose(
    function: Function<in F, T>,
    supplier: Supplier<F>
  ): Supplier<T> {
   return SupplierComposition<F, T>(function, supplier)
  }

  @JvmStatic
  
  fun <T> memoize(
    delegate: Supplier<T>
  ): Supplier<T> {
   if (delegate is NonSerializableMemoizingSupplier<*> || delegate is MemoizingSupplier<*>) {
    return delegate
   }
   return if (delegate is Serializable) MemoizingSupplier<T>(delegate) else NonSerializableMemoizingSupplier<T>(delegate)
  }

  @JvmStatic
  
  fun <T> memoizeWithExpiration(
    delegate: Supplier<T>,
    duration: Long,
    unit: TimeUnit
  ): Supplier<T> {
   Preconditions.checkNotNull<Supplier<T>>(delegate)
   Preconditions.checkArgument(
    duration > 0.toLong(),
    "duration (%s %s) must be > 0" as String,
    duration,
    unit as Any?,
   )
   return ExpiringMemoizingSupplier<T>(
    delegate,
    unit.toNanos(duration),
   )
  }

  @JvmStatic
  
  fun <T> ofInstance(
    instance: T
  ): Supplier<T> {
   return SupplierOfInstance<T>(instance)
  }

  @JvmStatic
  
  fun <T> supplierFunction(): Function<Supplier<T>, T> {
   val sf: SupplierFunction<T> = SupplierFunctionImpl.INSTANCE as SupplierFunction<T>
   return sf
  }
 }

 
 open class SupplierComposition<F, T>: Supplier<T>, Serializable {
  @JvmField
  internal val function_pp_com_google_common_base: Function<in F, T>

  @JvmField
  internal val supplier_pp_com_google_common_base: Supplier<F>

  internal constructor(function: Function<in F, T>, supplier: Supplier<F>) {
   this.function_pp_com_google_common_base = Preconditions.checkNotNull(function)
   this.supplier_pp_com_google_common_base = Preconditions.checkNotNull<Supplier<F>>(supplier)
  }

  override fun get(): T {
   return this.function_pp_com_google_common_base.apply(
    this.supplier_pp_com_google_common_base.get(),
   )
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is SupplierComposition<*, *>) {
    val that: SupplierComposition<*, *>? = obj as SupplierComposition<*, *>?
    return this.function_pp_com_google_common_base.equals(
     that!!.function_pp_com_google_common_base,
    ) && this.supplier_pp_com_google_common_base.equals(
     that!!.supplier_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return Objects.hashCode(
    this.function_pp_com_google_common_base,
    this.supplier_pp_com_google_common_base,
   )
  }

  override fun toString(): String {
   return "Suppliers.compose(" + this.function_pp_com_google_common_base + ", " + this.supplier_pp_com_google_common_base + ")"
  }
 }

 
 open class MemoizingSupplier<T>: Supplier<T>, Serializable {
  private var lock: XplatMonitor = XplatMonitor()

  @JvmField
  internal val delegate_pp_com_google_common_base: Supplier<T>

  @JvmField
  internal var initialized_pp_com_google_common_base: Boolean = false

  @JvmField
  internal var value_pp_com_google_common_base: T? = null

  internal constructor(delegate: Supplier<T>) {
   this.delegate_pp_com_google_common_base = Preconditions.checkNotNull<Supplier<T>>(delegate)
  }

  override fun get(): T {
   if (!this.initialized_pp_com_google_common_base) {
    synchronized<Unit>(this.lock) {
     if (!this.initialized_pp_com_google_common_base) {
      val t: T? = this.delegate_pp_com_google_common_base.get()
      this.value_pp_com_google_common_base = t
      this.initialized_pp_com_google_common_base = true
      return t as T
     }
    }
   }
   return NullnessCasts.uncheckedCastNullableTToT_pp_com_google_common_base<T?>(
    this.value_pp_com_google_common_base,
   ) as T
  }

  override fun toString(): String {
   return "Suppliers.memoize(" + (if (this.initialized_pp_com_google_common_base) "<supplier that returned " + this.value_pp_com_google_common_base + ">" else this.delegate_pp_com_google_common_base) + ")"
  }
 }

 
 open class NonSerializableMemoizingSupplier<T>: Supplier<T> {
  private val lock: XplatMonitor = XplatMonitor()

  private var delegate: Supplier<T>

  private var value: T? = null

  internal constructor(delegate: Supplier<T>) {
   this.delegate = Preconditions.checkNotNull<Supplier<T>>(delegate)
  }

  override fun get(): T {
   if (this.delegate !== NonSerializableMemoizingSupplier.SUCCESSFULLY_COMPUTED) {
    synchronized<Unit>(this.lock) {
     if (this.delegate !== NonSerializableMemoizingSupplier.SUCCESSFULLY_COMPUTED) {
      val t: T? = this.delegate.get()
      this.value = t
      this.delegate = NonSerializableMemoizingSupplier.SUCCESSFULLY_COMPUTED as Supplier<T>
      return t as T
     }
    }
   }
   return NullnessCasts.uncheckedCastNullableTToT_pp_com_google_common_base<T?>(
    this.value,
   ) as T
  }

  override fun toString(): String {
   val delegate: Supplier<T> = this.delegate
   return "Suppliers.memoize(" + (if (delegate === NonSerializableMemoizingSupplier.SUCCESSFULLY_COMPUTED) "<supplier that returned " + this.value + ">" else delegate) + ")"
  }

  
  companion object {
   private val SUCCESSFULLY_COMPUTED: Supplier<Void?> = Supplier {
    throw IllegalStateException()
   }
  }
 }

 
 open class ExpiringMemoizingSupplier<T>: Supplier<T>, Serializable {
  private var lock: XplatMonitor = XplatMonitor()

  @JvmField
  internal val delegate_pp_com_google_common_base: Supplier<T>

  @JvmField
  internal val durationNanos_pp_com_google_common_base: Long

  @JvmField
  internal var value_pp_com_google_common_base: T? = null

  @JvmField
  internal var expirationNanos_pp_com_google_common_base: Long = 0L

  internal constructor(delegate: Supplier<T>, durationNanos: Long) {
   this.delegate_pp_com_google_common_base = delegate
   this.durationNanos_pp_com_google_common_base = durationNanos
  }

  override fun get(): T {
   var nanos: Long = this.expirationNanos_pp_com_google_common_base
   val now: Long = System.nanoTime()
   if (nanos == 0.toLong() || now - nanos >= 0.toLong()) {
    synchronized<Unit>(this.lock) {
     if (nanos == this.expirationNanos_pp_com_google_common_base) {
      val t: T? = this.delegate_pp_com_google_common_base.get()
      this.value_pp_com_google_common_base = t
      nanos = now + this.durationNanos_pp_com_google_common_base
      this.expirationNanos_pp_com_google_common_base = if (nanos == 0.toLong()) 1L else nanos
      return t as T
     }
    }
   }
   return NullnessCasts.uncheckedCastNullableTToT_pp_com_google_common_base<T?>(
    this.value_pp_com_google_common_base,
   ) as T
  }

  override fun toString(): String {
   return "Suppliers.memoizeWithExpiration(" + this.delegate_pp_com_google_common_base + ", " + this.durationNanos_pp_com_google_common_base + ", NANOS)"
  }
 }

 
 open class SupplierOfInstance<T>: Supplier<T>, Serializable {
  @JvmField
  internal val instance_pp_com_google_common_base: T

  internal constructor(instance: T) {
   this.instance_pp_com_google_common_base = instance
  }

  override fun get(): T {
   return this.instance_pp_com_google_common_base
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is SupplierOfInstance<*>) {
    val that: SupplierOfInstance<*>? = obj as SupplierOfInstance<*>?
    return Objects.equal(
     this.instance_pp_com_google_common_base,
     that!!.instance_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return Objects.hashCode(
    this.instance_pp_com_google_common_base,
   )
  }

  override fun toString(): String {
   return "Suppliers.ofInstance(" + this.instance_pp_com_google_common_base + ")"
  }
 }

 
 fun interface SupplierFunction<T>: Function<Supplier<T>, T>

 
 enum class SupplierFunctionImpl: SupplierFunction<Any?> {
  
  INSTANCE;

  override fun apply(input: Supplier<Any?>): Any? {
   return input.get()
  }

  override fun toString(): String {
   return "Suppliers.supplierFunction()"
  }
 }
}
