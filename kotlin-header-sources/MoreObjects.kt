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

// Generated from "com/google/common/base/MoreObjects.java"
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



import java.lang.Class






import kotlin.Any

import kotlin.Boolean
import kotlin.Char

import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress



import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName




class MoreObjects {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun <T: Any> firstNonNull(
    first: T?,
    second: T?
  ): T { null!! }









  @JvmStatic
  
  fun toStringHelper(
    self: Any
  ): ToStringHelper { null!! }





  @JvmStatic
  
  fun toStringHelper(
    clazz: Class<*>
  ): ToStringHelper { null!! }





  @JvmStatic
  
  fun toStringHelper(
    className: String
  ): ToStringHelper { null!! }


 }

 
 class ToStringHelper {
  

  

  

  

  

  internal constructor(className: String) {}



  
  fun omitNullValues(): ToStringHelper { null!! }




  
  fun omitEmptyValues(): ToStringHelper { null!! }




  
  fun add(
    name: String,
    value: Any?
  ): ToStringHelper { null!! }



  
  fun add(
    name: String,
    value: Boolean
  ): ToStringHelper { null!! }






  
  fun add(
    name: String,
    value: Char
  ): ToStringHelper { null!! }






  
  fun add(
    name: String,
    value: Double
  ): ToStringHelper { null!! }






  
  fun add(
    name: String,
    value: Float
  ): ToStringHelper { null!! }






  
  fun add(
    name: String,
    value: Int
  ): ToStringHelper { null!! }






  
  fun add(
    name: String,
    value: Long
  ): ToStringHelper { null!! }






  
  fun addValue(
    value: Any?
  ): ToStringHelper { null!! }



  
  fun addValue(
    value: Boolean
  ): ToStringHelper { null!! }





  
  fun addValue(
    value: Char
  ): ToStringHelper { null!! }





  
  fun addValue(
    value: Double
  ): ToStringHelper { null!! }





  
  fun addValue(
    value: Float
  ): ToStringHelper { null!! }





  
  fun addValue(
    value: Int
  ): ToStringHelper { null!! }





  
  fun addValue(
    value: Long
  ): ToStringHelper { null!! }





  override fun toString(): String { null!! }






































  










  





  






  










  





  






  
  companion object {
   






















  }

  
  open class ValueHolder internal constructor() {
   @JvmField
   internal var name_pp_com_google_common_base: String? = null!!

   @JvmField
   internal var value_pp_com_google_common_base: Any? = null!!

   @JvmField
   internal var next_pp_com_google_common_base: ValueHolder? = null!!
  }

  
  class UnconditionalValueHolder internal constructor(): ValueHolder()
 }
}
