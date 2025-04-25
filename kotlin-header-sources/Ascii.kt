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
 "REDUNDANT_ELSE_IN_WHEN", "MUST_BE_INITIALIZED", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT", "UNINITIALIZED_VARIABLE")

package com.google.common.base



import kotlin.Boolean
import kotlin.Byte
import kotlin.Char

import kotlin.CharSequence
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName



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

  

  @JvmStatic
  
  fun toLowerCase(
    string: String
  ): String { null!! }























  @JvmStatic
  
  fun toLowerCase(
    chars: CharSequence
  ): String { null!! }
















  @JvmStatic
  
  fun toLowerCase(
    c: Char
  ): Char { null!! }





  @JvmStatic
  
  fun toUpperCase(
    string: String
  ): String { null!! }























  @JvmStatic
  
  fun toUpperCase(
    chars: CharSequence
  ): String { null!! }
















  @JvmStatic
  
  fun toUpperCase(
    c: Char
  ): Char { null!! }





  @JvmStatic
  
  fun isLowerCase(
    c: Char
  ): Boolean { null!! }



  @JvmStatic
  
  fun isUpperCase(
    c: Char
  ): Boolean { null!! }



  @JvmStatic
  
  fun truncate(
    seq: CharSequence,
    maxLength: Int,
    truncationIndicator: String
  ): String { null!! }



















  @JvmStatic
  
  fun equalsIgnoreCase(
    s1: CharSequence,
    s2: CharSequence
  ): Boolean { null!! }


























  





 }
}
