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

// Generated from "com/google/common/base/Strings.java"
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


import com.google.common.base.Platform
import com.google.common.base.Preconditions
import java.lang.ArrayIndexOutOfBoundsException
import java.lang.Character
import java.lang.Integer
import java.lang.Math
import java.lang.System
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.Char
import kotlin.CharArray
import kotlin.CharSequence
import kotlin.Exception
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.arrayOf
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName
import kotlin.run
import kotlin.text.StringBuilder


class Strings {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun nullToEmpty(
    string: String?
  ): String {
   return Platform.nullToEmpty_pp_com_google_common_base(string)
  }

  @JvmStatic
  
  fun emptyToNull(
    string: String?
  ): String? {
   return Platform.emptyToNull_pp_com_google_common_base(string)
  }

  @JvmStatic
  
  fun isNullOrEmpty(
    string: String?
  ): Boolean {
   return Platform.stringIsNullOrEmpty_pp_com_google_common_base(string)
  }

  @JvmStatic
  
  fun padStart(
    string: String,
    minLength: Int,
    padChar: Char
  ): String {
   Preconditions.checkNotNull<String>(string)
   if (string.length >= minLength) {
    return string
   }
   val sb: StringBuilder = StringBuilder(minLength)
   var i: Int = string.length
   while (i < minLength) {
    sb.append(padChar)
    i = i + 1
   }
   sb.append(string)
   return sb.toString()
  }

  @JvmStatic
  
  fun padEnd(
    string: String,
    minLength: Int,
    padChar: Char
  ): String {
   Preconditions.checkNotNull<String>(string)
   if (string.length >= minLength) {
    return string
   }
   val sb: StringBuilder = StringBuilder(minLength)
   sb.append(string)
   var i: Int = string.length
   while (i < minLength) {
    sb.append(padChar)
    i = i + 1
   }
   return sb.toString()
  }

  @JvmStatic
  
  fun repeat(
    string: String,
    count: Int
  ): String {
   Preconditions.checkNotNull<String>(string)
   if (count <= 1) {
    Preconditions.checkArgument(
     count >= 0,
     "invalid count: %s",
     count,
    )
    return if (count == 0) "" else string
   }
   val len: Int = string.length
   val longSize: Long = len.toLong() * count.toLong()
   val size: Int = longSize.toInt()
   if (size.toLong() != longSize) {
    throw ArrayIndexOutOfBoundsException(
     "Required array size too large: " + longSize,
    )
   }
   val array: CharArray = CharArray(size)
   var n: Int = 0
   n = len
   while (n < size - n) {
    System.arraycopy(array, 0, array, n, n)
    n = n.shl(1)
   }
   System.arraycopy(
    array,
    0,
    array,
    n,
    size - n,
   )
   return String(array)
  }

  @JvmStatic
  
  fun commonPrefix(
    a: CharSequence,
    b: CharSequence
  ): String {
   Preconditions.checkNotNull<CharSequence>(a)
   Preconditions.checkNotNull<CharSequence>(b)
   val maxPrefixLength: Int = Math.min(
    a.length,
    b.length,
   )
   var p: Int = 0
   while (p < maxPrefixLength && a.get(p).code == b.get(p).code) {
    p = p + 1
   }
   if (Strings.validSurrogatePairAt_pp_com_google_common_base(
    a,
    p - 1,
   ) || Strings.validSurrogatePairAt_pp_com_google_common_base(
    b,
    p - 1,
   )) {
    p = p - 1
   }
   return a.subSequence(0, p).toString()
  }

  @JvmStatic
  
  fun commonSuffix(
    a: CharSequence,
    b: CharSequence
  ): String {
   Preconditions.checkNotNull<CharSequence>(a)
   Preconditions.checkNotNull<CharSequence>(b)
   val maxSuffixLength: Int = Math.min(
    a.length,
    b.length,
   )
   var s: Int = 0
   while (s < maxSuffixLength && a.get(
    a.length - s - 1,
   ).code == b.get(
    b.length - s - 1,
   ).code) {
    s = s + 1
   }
   if (Strings.validSurrogatePairAt_pp_com_google_common_base(
    a,
    a.length - s - 1,
   ) || Strings.validSurrogatePairAt_pp_com_google_common_base(
    b,
    b.length - s - 1,
   )) {
    s = s - 1
   }
   return a.subSequence(
    a.length - s,
    a.length,
   ).toString()
  }

  @JvmStatic
  internal fun validSurrogatePairAt_pp_com_google_common_base(string: CharSequence, index: Int): Boolean {
   return index >= 0 && index <= string.length - 2 && Character.isHighSurrogate(
    string.get(index),
   ) && Character.isLowSurrogate(
    string.get(
     index + 1,
    ),
   )
  }

  @JvmStatic
  
  fun lenientFormat(
    template: String?,
   vararg  args: Any?
  ): String {
   var template_1: String? = template
   var args_1: Array<Any?>? = args as Array<Any?>?
   template_1 = java.lang.String.valueOf(template_1)
   if (args_1 == null) {
    args_1 = arrayOf<Any?>("(Object[])null")
   } else {
    var i: Int = 0
    while (i < args_1!!.size) {
     args_1!![i] = Strings.lenientToString(
      args_1!![i],
     )
     i = i + 1
    }
   }
   val builder: StringBuilder = StringBuilder(
    template_1!!.length + 16 * args_1!!.size,
   )
   var templateStart: Int = 0
   var i_1: Int = 0
   while (i_1 < args_1!!.size) {
    val placeholderStart: Int = template_1!!.indexOf("%s", templateStart)
    if (placeholderStart == - 1) {
     break
    }
    builder.append(template_1, templateStart, placeholderStart)
    builder.append(
     args_1!![run {
      val ___value: Int = i_1
      i_1 = i_1 + 1
      ___value
     }],
    )
    templateStart = placeholderStart + 2
   }
   builder.append(
    template_1,
    templateStart,
    template_1!!.length,
   )
   if (i_1 < args_1!!.size) {
    builder.append(" [")
    builder.append(
     args_1!![run {
      val ___value_1: Int = i_1
      i_1 = i_1 + 1
      ___value_1
     }],
    )
    while (i_1 < args_1!!.size) {
     builder.append(", ")
     builder.append(
      args_1!![run {
       val ___value_2: Int = i_1
       i_1 = i_1 + 1
       ___value_2
      }],
     )
    }
    builder.append(']')
   }
   return builder.toString()
  }

  @JvmStatic
  private fun lenientToString(o: Any?): String {
   if (o == null) {
    return "null"
   }
   try {
    return o!!.toString()
   } catch (e: Exception) {
    val objectToString: String = "SimpleNameGoesHere" + '@' + Integer.toHexString(
     System.identityHashCode(o),
    )
    Logger.getLogger("com.google.common.base.Strings").log(
     Level.WARNING,
     "Exception during lenientFormat for " + objectToString,
     e,
    )
    return "<" + objectToString + " threw " + "SimpleNameGoesHere" + ">"
   }
  }
 }
}
