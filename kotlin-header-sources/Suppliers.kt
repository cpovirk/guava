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
 "REDUNDANT_ELSE_IN_WHEN", "MUST_BE_INITIALIZED", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT", "UNINITIALIZED_VARIABLE")

package com.google.common.base


import com.google.common.base.Function



import com.google.common.base.Supplier

import java.io.Serializable



import java.util.concurrent.TimeUnit
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress

import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName



class Suppliers {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun <F, T> compose(
    function: Function<in F, T>,
    supplier: Supplier<F>
  ): Supplier<T> { null!! }



  @JvmStatic
  
  fun <T> memoize(
    delegate: Supplier<T>
  ): Supplier<T> { null!! }






  @JvmStatic
  
  fun <T> memoizeWithExpiration(
    delegate: Supplier<T>,
    duration: Long,
    unit: TimeUnit
  ): Supplier<T> { null!! }













  @JvmStatic
  
  fun <T> ofInstance(
    instance: T
  ): Supplier<T> { null!! }



  @JvmStatic
  
  fun <T> supplierFunction(): Function<Supplier<T>, T> { null!! }



 }

 
 open class SupplierComposition<F, T>: Supplier<T>, Serializable {
  @JvmField
  internal val function_pp_com_google_common_base: Function<in F, T>

  @JvmField
  internal val supplier_pp_com_google_common_base: Supplier<F>

  internal constructor(function: Function<in F, T>, supplier: Supplier<F>) {}




  override fun get(): T { null!! }





  override fun equals(obj: Any?): Boolean { null!! }











  override fun hashCode(): Int { null!! }






  override fun toString(): String { null!! }


 }

 
 open class MemoizingSupplier<T>: Supplier<T>, Serializable {
  

  @JvmField
  internal val delegate_pp_com_google_common_base: Supplier<T>

  @JvmField
  internal var initialized_pp_com_google_common_base: Boolean = null!!

  @JvmField
  internal var value_pp_com_google_common_base: T? = null!!

  internal constructor(delegate: Supplier<T>) {}



  override fun get(): T { null!! }















  override fun toString(): String { null!! }


 }

 
 open class NonSerializableMemoizingSupplier<T>: Supplier<T> {
  

  

  

  internal constructor(delegate: Supplier<T>) {}



  override fun get(): T { null!! }















  override fun toString(): String { null!! }




  
  companion object {
   


  }
 }

 
 open class ExpiringMemoizingSupplier<T>: Supplier<T>, Serializable {
  

  @JvmField
  internal val delegate_pp_com_google_common_base: Supplier<T>

  @JvmField
  internal val durationNanos_pp_com_google_common_base: Long

  @JvmField
  internal var value_pp_com_google_common_base: T? = null!!

  @JvmField
  internal var expirationNanos_pp_com_google_common_base: Long = null!!

  internal constructor(delegate: Supplier<T>, durationNanos: Long) {}




  override fun get(): T { null!! }


















  override fun toString(): String { null!! }


 }

 
 open class SupplierOfInstance<T>: Supplier<T>, Serializable {
  @JvmField
  internal val instance_pp_com_google_common_base: T

  internal constructor(instance: T) {}



  override fun get(): T { null!! }



  override fun equals(obj: Any?): Boolean { null!! }










  override fun hashCode(): Int { null!! }





  override fun toString(): String { null!! }


 }

 
 fun interface SupplierFunction<T>: Function<Supplier<T>, T>

 
 enum class SupplierFunctionImpl: SupplierFunction<Any?> {
  
  INSTANCE;

  override fun apply(input: Supplier<Any?>): Any? { null!! }



  override fun toString(): String { null!! }


 }
}
