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

// Generated from "com/google/common/base/Functions.java"
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
import com.google.common.base.Predicate
import com.google.common.base.Supplier
import java.io.Serializable
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableMap
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class Functions {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun toStringFunction(): Function<Any, String> {
   return ToStringFunction.INSTANCE
  }

  @JvmStatic
  
  fun <E> identity(): Function<E, E> {
   return IdentityFunction.INSTANCE as Function<E, E>
  }

  @JvmStatic
  
  fun <K, V> forMap(
    map: MutableMap<K, V>
  ): Function<K, V> {
   return FunctionForMapNoDefault<K, V>(map)
  }

  @JvmStatic
  
  fun <K, V> forMap(
    map: MutableMap<K, out V>,
    defaultValue: V
  ): Function<K, V> {
   return ForMapWithDefault<K, V>(map, defaultValue)
  }

  @JvmStatic
  
  fun <A, B, C> compose(
    g: Function<B, C>,
    f: Function<A, out B>
  ): Function<A, C> {
   return FunctionComposition<A, B, C>(g, f)
  }

  @JvmStatic
  
  fun <T> forPredicate(
    predicate: Predicate<T>
  ): Function<T, Boolean> {
   return PredicateFunction<T>(predicate)
  }

  @JvmStatic
  
  fun <E> constant(
    value: E
  ): Function<Any?, E> {
   return ConstantFunction<E>(value)
  }

  @JvmStatic
  
  fun <F, T> forSupplier(
    supplier: Supplier<T>
  ): Function<F, T> {
   return SupplierFunction<F, T>(supplier)
  }
 }

 
 enum class ToStringFunction: Function<Any, String> {
  
  INSTANCE;

  override fun apply(o: Any): String {
   Preconditions.checkNotNull<Any>(o)
   return o.toString()
  }

  override fun toString(): String {
   return "Functions.toStringFunction()"
  }
 }

 
 enum class IdentityFunction: Function<Any?, Any?> {
  
  INSTANCE;

  override fun apply(o: Any?): Any? {
   return o
  }

  override fun toString(): String {
   return "Functions.identity()"
  }
 }

 
 open class FunctionForMapNoDefault<K, V>: Function<K, V>, Serializable {
  @JvmField
  internal val map_pp_com_google_common_base: MutableMap<K, V>

  internal constructor(map: MutableMap<K, V>) {
   this.map_pp_com_google_common_base = Preconditions.checkNotNull<MutableMap<K, V>>(map)
  }

  override fun apply(key: K): V {
   val result: V? = this.map_pp_com_google_common_base.get(key)
   Preconditions.checkArgument(
    result != null || this.map_pp_com_google_common_base.containsKey(key),
    "Key \'%s\' not present in map" as String,
    key as Any?,
   )
   return NullnessCasts.uncheckedCastNullableTToT_pp_com_google_common_base<V>(result)
  }

  override fun equals(o: Any?): Boolean {
   if (o is FunctionForMapNoDefault<*, *>) {
    val that: FunctionForMapNoDefault<*, *>? = o as FunctionForMapNoDefault<*, *>?
    return this.map_pp_com_google_common_base.equals(
     that!!.map_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.map_pp_com_google_common_base.hashCode()
  }

  override fun toString(): String {
   return "Functions.forMap(" + this.map_pp_com_google_common_base + ")"
  }
 }

 
 open class ForMapWithDefault<K, V>: Function<K, V>, Serializable {
  @JvmField
  internal val map_pp_com_google_common_base: MutableMap<K, out V>

  @JvmField
  internal val defaultValue_pp_com_google_common_base: V

  internal constructor(map: MutableMap<K, out V>, defaultValue: V) {
   this.map_pp_com_google_common_base = Preconditions.checkNotNull(map)
   this.defaultValue_pp_com_google_common_base = defaultValue
  }

  override fun apply(key: K): V {
   val result: V? = this.map_pp_com_google_common_base.get(key)
   return (if (result != null || this.map_pp_com_google_common_base.containsKey(key)) NullnessCasts.uncheckedCastNullableTToT_pp_com_google_common_base<V>(result) else this.defaultValue_pp_com_google_common_base) as V
  }

  override fun equals(o: Any?): Boolean {
   if (o is ForMapWithDefault<*, *>) {
    val that: ForMapWithDefault<*, *>? = o as ForMapWithDefault<*, *>?
    return this.map_pp_com_google_common_base.equals(
     that!!.map_pp_com_google_common_base,
    ) && Objects.equal(
     this.defaultValue_pp_com_google_common_base,
     that!!.defaultValue_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return Objects.hashCode(
    this.map_pp_com_google_common_base,
    this.defaultValue_pp_com_google_common_base,
   )
  }

  override fun toString(): String {
   return "Functions.forMap(" + this.map_pp_com_google_common_base + ", defaultValue=" + this.defaultValue_pp_com_google_common_base + ")"
  }
 }

 
 open class FunctionComposition<A, B, C>: Function<A, C>, Serializable {
  private val g: Function<B, C>

  private val f: Function<A, out B>

  constructor(
    g: Function<B, C>,
    f: Function<A, out B>
  ) {
   this.g = Preconditions.checkNotNull<Function<B, C>>(g)
   this.f = Preconditions.checkNotNull(f)
  }

  override fun apply(a: A): C {
   return this.g.apply(
    this.f.apply(a),
   )
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is FunctionComposition<*, *, *>) {
    val that: FunctionComposition<*, *, *>? = obj as FunctionComposition<*, *, *>?
    return this.f.equals(
     that!!.f,
    ) && this.g.equals(
     that!!.g,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.f.hashCode().xor(
    this.g.hashCode(),
   )
  }

  override fun toString(): String {
   return "" + this.g + "(" + this.f + ")"
  }
 }

 
 open class PredicateFunction<T>: Function<T, Boolean>, Serializable {
  private val predicate: Predicate<T>

  internal constructor(predicate: Predicate<T>) {
   this.predicate = Preconditions.checkNotNull<Predicate<T>>(predicate)
  }

  override fun apply(t: T): Boolean {
   return java.lang.Boolean.valueOf(
    this.predicate.apply(t),
   )
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is PredicateFunction<*>) {
    val that: PredicateFunction<*>? = obj as PredicateFunction<*>?
    return this.predicate.equals(
     that!!.predicate,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.predicate.hashCode()
  }

  override fun toString(): String {
   return "Functions.forPredicate(" + this.predicate + ")"
  }
 }

 
 open class ConstantFunction<E>: Function<Any?, E>, Serializable {
  private val value: E

  constructor(
    value: E
  ) {
   this.value = value
  }

  override fun apply(from: Any?): E {
   return this.value
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is ConstantFunction<*>) {
    val that: ConstantFunction<*>? = obj as ConstantFunction<*>?
    return Objects.equal(
     this.value,
     that!!.value,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return if (this.value == null) 0 else this.value!!.hashCode()
  }

  override fun toString(): String {
   return "Functions.constant(" + this.value + ")"
  }
 }

 
 open class SupplierFunction<F, T>: Function<F, T>, Serializable {
  private val supplier: Supplier<T>

  internal constructor(supplier: Supplier<T>) {
   this.supplier = Preconditions.checkNotNull<Supplier<T>>(supplier)
  }

  override fun apply(input: F): T {
   return this.supplier.get()
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is SupplierFunction<*, *>) {
    val that: SupplierFunction<*, *>? = obj as SupplierFunction<*, *>?
    return this.supplier.equals(
     that!!.supplier,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.supplier.hashCode()
  }

  override fun toString(): String {
   return "Functions.forSupplier(" + this.supplier + ")"
  }
 }
}
