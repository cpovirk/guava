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
 "REDUNDANT_ELSE_IN_WHEN")

package com.google.common.base


import com.google.common.base.Preconditions
import java.lang.Class
import java.lang.NullPointerException
import java.util.Arrays
import java.util.Optional
import java.util.OptionalDouble
import java.util.OptionalInt
import java.util.OptionalLong
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.Char
import kotlin.CharSequence
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.arrayOf
import kotlin.collections.MutableCollection
import kotlin.collections.MutableMap
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName
import kotlin.run
import kotlin.text.StringBuilder


class MoreObjects {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun <T: Any> firstNonNull(
    first: T?,
    second: T?
  ): T {
   if (first != null) {
    return first!!
   }
   if (second != null) {
    return second!!
   }
   throw NullPointerException("Both parameters are null")
  }

  @JvmStatic
  
  fun toStringHelper(
    self: Any
  ): ToStringHelper {
   return ToStringHelper(
    "SimpleNameGoesHere",
   )
  }

  @JvmStatic
  
  fun toStringHelper(
    clazz: Class<*>
  ): ToStringHelper {
   return ToStringHelper(
    clazz.getSimpleName(),
   )
  }

  @JvmStatic
  
  fun toStringHelper(
    className: String
  ): ToStringHelper {
   return ToStringHelper(className)
  }
 }

 
 class ToStringHelper {
  private val className: String

  private val holderHead: ValueHolder = ValueHolder()

  private var holderTail: ValueHolder = this.holderHead

  private var omitNullValues: Boolean = false

  private var omitEmptyValues: Boolean = false

  internal constructor(className: String) {
   this.className = Preconditions.checkNotNull<String>(className)
  }

  
  fun omitNullValues(): ToStringHelper {
   this.omitNullValues = true
   return this
  }

  
  fun omitEmptyValues(): ToStringHelper {
   this.omitEmptyValues = true
   return this
  }

  
  fun add(
    name: String,
    value: Any?
  ): ToStringHelper {
   return this.addHolder(name, value)
  }

  
  fun add(
    name: String,
    value: Boolean
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    name,
    java.lang.String.valueOf(value),
   )
  }

  
  fun add(
    name: String,
    value: Char
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    name,
    java.lang.String.valueOf(value),
   )
  }

  
  fun add(
    name: String,
    value: Double
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    name,
    java.lang.String.valueOf(value),
   )
  }

  
  fun add(
    name: String,
    value: Float
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    name,
    java.lang.String.valueOf(value),
   )
  }

  
  fun add(
    name: String,
    value: Int
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    name,
    java.lang.String.valueOf(value),
   )
  }

  
  fun add(
    name: String,
    value: Long
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    name,
    java.lang.String.valueOf(value),
   )
  }

  
  fun addValue(
    value: Any?
  ): ToStringHelper {
   return this.addHolder(value)
  }

  
  fun addValue(
    value: Boolean
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    java.lang.String.valueOf(value),
   )
  }

  
  fun addValue(
    value: Char
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    java.lang.String.valueOf(value),
   )
  }

  
  fun addValue(
    value: Double
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    java.lang.String.valueOf(value),
   )
  }

  
  fun addValue(
    value: Float
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    java.lang.String.valueOf(value),
   )
  }

  
  fun addValue(
    value: Int
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    java.lang.String.valueOf(value),
   )
  }

  
  fun addValue(
    value: Long
  ): ToStringHelper {
   return this.addUnconditionalHolder(
    java.lang.String.valueOf(value),
   )
  }

  override fun toString(): String {
   val omitNullValuesSnapshot: Boolean = this.omitNullValues
   val omitEmptyValuesSnapshot: Boolean = this.omitEmptyValues
   var nextSeparator: String = ""
   val builder: StringBuilder = StringBuilder(32).append(
    this.className,
   ).append('{')
   var valueHolder: ValueHolder? = this.holderHead.next_pp_com_google_common_base
   while (valueHolder != null) {
    val value: Any? = valueHolder!!.value_pp_com_google_common_base
    if (valueHolder is UnconditionalValueHolder || (if (value == null) !omitNullValuesSnapshot else !omitEmptyValuesSnapshot || !ToStringHelper.isEmpty(
     value!!,
    ))) {
     builder.append(nextSeparator)
     nextSeparator = ", "
     if (valueHolder!!.name_pp_com_google_common_base != null) {
      builder.append(
       valueHolder!!.name_pp_com_google_common_base,
      ).append('=')
     }
     if (value != null && value!! is Array<*>) {
      val objectArray: Array<Any> = arrayOf<Any?>(value) as Array<Any>
      val arrayString: String = Arrays.deepToString(
       objectArray as Array<Any?>?,
      )
      builder.append(
       arrayString,
       1,
       arrayString.length - 1,
      )
     } else {
      builder.append(value)
     }
    }
    valueHolder = valueHolder!!.next_pp_com_google_common_base
   }
   return builder.append('}').toString()
  }

  private fun addHolder(): ValueHolder {
   val valueHolder: ValueHolder = ValueHolder()
   this.holderTail = run {
    val ___qualifier: ValueHolder = this.holderTail
    val ___value: ValueHolder = valueHolder
    ___qualifier.next_pp_com_google_common_base = ___value
    ___value
   }
   return valueHolder
  }

  private fun addHolder(value: Any?): ToStringHelper {
   val valueHolder: ValueHolder = this.addHolder()
   valueHolder.value_pp_com_google_common_base = value
   return this
  }

  private fun addHolder(name: String, value: Any?): ToStringHelper {
   val valueHolder: ValueHolder = this.addHolder()
   valueHolder.value_pp_com_google_common_base = value
   valueHolder.name_pp_com_google_common_base = Preconditions.checkNotNull<String>(name)
   return this
  }

  private fun addUnconditionalHolder(): UnconditionalValueHolder {
   val valueHolder: UnconditionalValueHolder = UnconditionalValueHolder()
   this.holderTail = run {
    val ___qualifier: ValueHolder = this.holderTail
    val ___value: ValueHolder = valueHolder
    ___qualifier.next_pp_com_google_common_base = ___value
    ___value
   }
   return valueHolder
  }

  private fun addUnconditionalHolder(value: Any): ToStringHelper {
   val valueHolder: UnconditionalValueHolder = this.addUnconditionalHolder()
   valueHolder.value_pp_com_google_common_base = value
   return this
  }

  private fun addUnconditionalHolder(name: String, value: Any): ToStringHelper {
   val valueHolder: UnconditionalValueHolder = this.addUnconditionalHolder()
   valueHolder.value_pp_com_google_common_base = value
   valueHolder.name_pp_com_google_common_base = Preconditions.checkNotNull<String>(name)
   return this
  }

  
  companion object {
   @JvmStatic
   private fun isEmpty(value: Any): Boolean {
    if (value is CharSequence) {
     return (value as CharSequence).length == 0
    } else if (value is MutableCollection<*>) {
     return (value as MutableCollection<*>).isEmpty()
    } else if (value is MutableMap<*, *>) {
     return (value as MutableMap<*, *>).isEmpty()
    } else if (value is Optional<*>) {
     return !(value as Optional<*>).isPresent()
    } else if (value is OptionalInt) {
     return !(value as OptionalInt).isPresent()
    } else if (value is OptionalLong) {
     return !(value as OptionalLong).isPresent()
    } else if (value is OptionalDouble) {
     return !(value as OptionalDouble).isPresent()
    } else if (value is com.google.common.base.Optional<*>) {
     return !(value as com.google.common.base.Optional<Any>).isPresent()
    } else if (value is Array<*>) {
     return java.lang.reflect.Array.getLength(value) == 0
    }
    return false
   }
  }

  
  open class ValueHolder internal constructor() {
   @JvmField
   internal var name_pp_com_google_common_base: String? = null

   @JvmField
   internal var value_pp_com_google_common_base: Any? = null

   @JvmField
   internal var next_pp_com_google_common_base: ValueHolder? = null
  }

  
  class UnconditionalValueHolder internal constructor(): ValueHolder()
 }
}
