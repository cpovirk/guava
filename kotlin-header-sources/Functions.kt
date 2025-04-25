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
 "REDUNDANT_ELSE_IN_WHEN", "MUST_BE_INITIALIZED", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT", "UNINITIALIZED_VARIABLE")

package com.google.common.base


import com.google.common.base.Function



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
  
  fun toStringFunction(): Function<Any, String> { null!! }



  @JvmStatic
  
  fun <E> identity(): Function<E, E> { null!! }



  @JvmStatic
  
  fun <K, V> forMap(
    map: MutableMap<K, V>
  ): Function<K, V> { null!! }



  @JvmStatic
  
  fun <K, V> forMap(
    map: MutableMap<K, out V>,
    defaultValue: V
  ): Function<K, V> { null!! }



  @JvmStatic
  
  fun <A, B, C> compose(
    g: Function<B, C>,
    f: Function<A, out B>
  ): Function<A, C> { null!! }



  @JvmStatic
  
  fun <T> forPredicate(
    predicate: Predicate<T>
  ): Function<T, Boolean> { null!! }



  @JvmStatic
  
  fun <E> constant(
    value: E
  ): Function<Any?, E> { null!! }



  @JvmStatic
  
  fun <F, T> forSupplier(
    supplier: Supplier<T>
  ): Function<F, T> { null!! }


 }

 
 enum class ToStringFunction: Function<Any, String> {
  
  INSTANCE;

  override fun apply(o: Any): String { null!! }




  override fun toString(): String { null!! }


 }

 
 enum class IdentityFunction: Function<Any?, Any?> {
  
  INSTANCE;

  override fun apply(o: Any?): Any? { null!! }



  override fun toString(): String { null!! }


 }

 
 open class FunctionForMapNoDefault<K, V>: Function<K, V>, Serializable {
  @JvmField
  internal val map_pp_com_google_common_base: MutableMap<K, V>

  internal constructor(map: MutableMap<K, V>) {}



  override fun apply(key: K): V { null!! }









  override fun equals(o: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }



  override fun toString(): String { null!! }


 }

 
 open class ForMapWithDefault<K, V>: Function<K, V>, Serializable {
  @JvmField
  internal val map_pp_com_google_common_base: MutableMap<K, out V>

  @JvmField
  internal val defaultValue_pp_com_google_common_base: V

  internal constructor(map: MutableMap<K, out V>, defaultValue: V) {}




  override fun apply(key: K): V { null!! }




  override fun equals(o: Any?): Boolean { null!! }












  override fun hashCode(): Int { null!! }






  override fun toString(): String { null!! }


 }

 
 open class FunctionComposition<A, B, C>: Function<A, C>, Serializable {
  

  

  constructor(
    g: Function<B, C>,
    f: Function<A, out B>
  ) {}




  override fun apply(a: A): C { null!! }





  override fun equals(obj: Any?): Boolean { null!! }











  override fun hashCode(): Int { null!! }





  override fun toString(): String { null!! }


 }

 
 open class PredicateFunction<T>: Function<T, Boolean>, Serializable {
  

  internal constructor(predicate: Predicate<T>) {}



  override fun apply(t: T): Boolean { null!! }





  override fun equals(obj: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }



  override fun toString(): String { null!! }


 }

 
 open class ConstantFunction<E>: Function<Any?, E>, Serializable {
  

  constructor(
    value: E
  ) {}



  override fun apply(from: Any?): E { null!! }



  override fun equals(obj: Any?): Boolean { null!! }










  override fun hashCode(): Int { null!! }



  override fun toString(): String { null!! }


 }

 
 open class SupplierFunction<F, T>: Function<F, T>, Serializable {
  

  internal constructor(supplier: Supplier<T>) {}



  override fun apply(input: F): T { null!! }



  override fun equals(obj: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }



  override fun toString(): String { null!! }


 }
}
