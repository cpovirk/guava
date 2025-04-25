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

// Generated from "com/google/common/base/Ascii.java"
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
import kotlin.Boolean
import kotlin.Byte
import kotlin.Char
import kotlin.CharArray
import kotlin.CharSequence
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName
import kotlin.text.StringBuilder


class Ascii {
 private constructor()

 
 companion object {
  
  const val NUL: Byte = 0.toByte()

  
  const val SOH: Byte = 1.toByte()

  
  const val STX: Byte = 2.toByte()

  
  const val ETX: Byte = 3.toByte()

  
  const val EOT: Byte = 4.toByte()

  
  const val ENQ: Byte = 5.toByte()

  
  const val ACK: Byte = 6.toByte()

  
  const val BEL: Byte = 7.toByte()

  
  const val BS: Byte = 8.toByte()

  
  const val HT: Byte = 9.toByte()

  
  const val LF: Byte = 10.toByte()

  
  const val NL: Byte = 10.toByte()

  
  const val VT: Byte = 11.toByte()

  
  const val FF: Byte = 12.toByte()

  
  const val CR: Byte = 13.toByte()

  
  const val SO: Byte = 14.toByte()

  
  const val SI: Byte = 15.toByte()

  
  const val DLE: Byte = 16.toByte()

  
  const val DC1: Byte = 17.toByte()

  
  const val XON: Byte = 17.toByte()

  
  const val DC2: Byte = 18.toByte()

  
  const val DC3: Byte = 19.toByte()

  
  const val XOFF: Byte = 19.toByte()

  
  const val DC4: Byte = 20.toByte()

  
  const val NAK: Byte = 21.toByte()

  
  const val SYN: Byte = 22.toByte()

  
  const val ETB: Byte = 23.toByte()

  
  const val CAN: Byte = 24.toByte()

  
  const val EM: Byte = 25.toByte()

  
  const val SUB: Byte = 26.toByte()

  
  const val ESC: Byte = 27.toByte()

  
  const val FS: Byte = 28.toByte()

  
  const val GS: Byte = 29.toByte()

  
  const val RS: Byte = 30.toByte()

  
  const val US: Byte = 31.toByte()

  
  const val SP: Byte = 32.toByte()

  
  const val SPACE: Byte = 32.toByte()

  
  const val DEL: Byte = 127.toByte()

  
  const val MIN: Char = '\u0000'

  
  const val MAX: Char = '\u007F'

  private const val CASE_MASK: Char = ' '

  @JvmStatic
  
  fun toLowerCase(
    string: String
  ): String {
   val length: Int = string.length
   var i: Int = 0
   while (i < length) {
    if (Ascii.isUpperCase(
     string.get(i),
    )) {
     val chars: CharArray = string.toCharArray()
     while (i < length) {
      val c: Char = chars[i]
      if (Ascii.isUpperCase(c)) {
       chars[i] = c.code.xor(
        Ascii.CASE_MASK.code,
       ).toChar()
      }
      i = i + 1
     }
     return java.lang.String.valueOf(chars)
    }
    i = i + 1
   }
   return string
  }

  @JvmStatic
  
  fun toLowerCase(
    chars: CharSequence
  ): String {
   if (chars is String) {
    return Ascii.toLowerCase(
     chars as String,
    )
   }
   val newChars: CharArray = CharArray(chars.length)
   var i: Int = 0
   while (i < newChars.size) {
    newChars[i] = Ascii.toLowerCase(
     chars.get(i),
    )
    i = i + 1
   }
   return java.lang.String.valueOf(newChars)
  }

  @JvmStatic
  
  fun toLowerCase(
    c: Char
  ): Char {
   return if (Ascii.isUpperCase(c)) c.code.xor(
    Ascii.CASE_MASK.code,
   ).toChar() else c
  }

  @JvmStatic
  
  fun toUpperCase(
    string: String
  ): String {
   val length: Int = string.length
   var i: Int = 0
   while (i < length) {
    if (Ascii.isLowerCase(
     string.get(i),
    )) {
     val chars: CharArray = string.toCharArray()
     while (i < length) {
      val c: Char = chars[i]
      if (Ascii.isLowerCase(c)) {
       chars[i] = c.code.xor(
        Ascii.CASE_MASK.code,
       ).toChar()
      }
      i = i + 1
     }
     return java.lang.String.valueOf(chars)
    }
    i = i + 1
   }
   return string
  }

  @JvmStatic
  
  fun toUpperCase(
    chars: CharSequence
  ): String {
   if (chars is String) {
    return Ascii.toUpperCase(
     chars as String,
    )
   }
   val newChars: CharArray = CharArray(chars.length)
   var i: Int = 0
   while (i < newChars.size) {
    newChars[i] = Ascii.toUpperCase(
     chars.get(i),
    )
    i = i + 1
   }
   return java.lang.String.valueOf(newChars)
  }

  @JvmStatic
  
  fun toUpperCase(
    c: Char
  ): Char {
   return if (Ascii.isLowerCase(c)) c.code.xor(
    Ascii.CASE_MASK.code,
   ).toChar() else c
  }

  @JvmStatic
  
  fun isLowerCase(
    c: Char
  ): Boolean {
   return c.code >= 'a'.code && c.code <= 'z'.code
  }

  @JvmStatic
  
  fun isUpperCase(
    c: Char
  ): Boolean {
   return c.code >= 'A'.code && c.code <= 'Z'.code
  }

  @JvmStatic
  
  fun truncate(
    seq: CharSequence,
    maxLength: Int,
    truncationIndicator: String
  ): String {
   var seq_1: CharSequence = seq
   Preconditions.checkNotNull<CharSequence>(seq_1)
   val truncationLength: Int = maxLength - truncationIndicator.length
   Preconditions.checkArgument(
    truncationLength >= 0,
    "maxLength (%s) must be >= length of the truncation indicator (%s)",
    maxLength,
    truncationIndicator.length,
   )
   if (seq_1.length <= maxLength) {
    val string: String = seq_1.toString()
    if (string.length <= maxLength) {
     return string
    }
    seq_1 = string
   }
   return StringBuilder(maxLength).append(seq_1, 0, truncationLength).append(truncationIndicator).toString()
  }

  @JvmStatic
  
  fun equalsIgnoreCase(
    s1: CharSequence,
    s2: CharSequence
  ): Boolean {
   val length: Int = s1.length
   if (s1 === s2) {
    return true
   }
   if (length != s2.length) {
    return false
   }
   var i: Int = 0
   while (i < length) {
    do {
     val c1: Char = s1.get(i)
     val c2: Char = s2.get(i)
     if (c1.code == c2.code) {
      break
     }
     val alphaIndex: Int = Ascii.getAlphaIndex(c1)
     if (alphaIndex < 26 && alphaIndex == Ascii.getAlphaIndex(c2)) {
      break
     }
     return false
    } while (false)
    i = i + 1
   }
   return true
  }

  @JvmStatic
  private fun getAlphaIndex(c: Char): Int {
   return (c.code.or(
    Ascii.CASE_MASK.code,
   ) - 'a'.code).toChar().code
  }
 }
}
