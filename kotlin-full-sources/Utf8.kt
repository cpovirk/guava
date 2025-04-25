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

// Generated from "com/google/common/base/Utf8.java"
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
import java.lang.ArrayIndexOutOfBoundsException
import java.lang.Character
import java.lang.IllegalArgumentException
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Char
import kotlin.CharSequence
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName
import kotlin.run


class Utf8 {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun encodedLength(
    sequence: CharSequence
  ): Int {
   val utf16Length: Int = sequence.length
   var utf8Length: Int = utf16Length
   var i: Int = 0
   while (i < utf16Length && sequence.get(i).code < 128) {
    i = i + 1
   }
   while (i < utf16Length) {
    val c: Char = sequence.get(i)
    if (c.code < 2048) {
     utf8Length = utf8Length + (127 - c.code).ushr(31)
    } else {
     utf8Length = utf8Length + Utf8.encodedLengthGeneral(sequence, i)
     break
    }
    i = i + 1
   }
   if (utf8Length < utf16Length) {
    throw IllegalArgumentException(
     "UTF-8 length does not fit in int: " + (utf8Length.toLong() + 1L.shl(32)),
    )
   }
   return utf8Length
  }

  @JvmStatic
  private fun encodedLengthGeneral(sequence: CharSequence, start: Int): Int {
   val utf16Length: Int = sequence.length
   var utf8Length: Int = 0
   var i: Int = start
   while (i < utf16Length) {
    val c: Char = sequence.get(i)
    if (c.code < 2048) {
     utf8Length = utf8Length + (127 - c.code).ushr(31)
    } else {
     utf8Length = utf8Length + 2
     if (Character.MIN_SURROGATE.code <= c.code && c.code <= Character.MAX_SURROGATE.code) {
      if (Character.codePointAt(sequence, i) == c.code) {
       throw IllegalArgumentException(
        Utf8.unpairedSurrogateMsg(i),
       )
      }
      i = i + 1
     }
    }
    i = i + 1
   }
   return utf8Length
  }

  @JvmStatic
  
  fun encode(
    sequence: CharSequence,
    bytes: ByteArray
  ): Int {
   return Utf8.encode(
    sequence,
    bytes,
    0,
    bytes.size,
   )
  }

  @JvmStatic
  
  fun encode(
    sequence: CharSequence,
    bytes: ByteArray,
    offset: Int
  ): Int {
   return Utf8.encode(
    sequence,
    bytes,
    offset,
    bytes.size - offset,
   )
  }

  @JvmStatic
  private fun encode(sequence: CharSequence, bytes: ByteArray, offset: Int, length: Int): Int {
   val utf16Length: Int = sequence.length
   var j: Int = offset
   var i: Int = 0
   val limit: Int = offset + length
   var c: Char = '\u0000'
   while (i < utf16Length && i + j < limit && run {
    c = sequence.get(i)
    c
   }.code < 128) {
    bytes[j + i] = c.code.toByte()
    i = i + 1
   }
   if (i == utf16Length) {
    return j + utf16Length
   }
   j = j + i
   var c_1: Char = '\u0000'
   while (i < utf16Length) {
    c_1 = sequence.get(i)
    if (c_1.code < 128 && j < limit) {
     bytes[run {
      val ___value: Int = j
      j = j + 1
      ___value
     }] = c_1.code.toByte()
    } else if (c_1.code < 2048 && j <= limit - 2) {
     bytes[run {
      val ___value_1: Int = j
      j = j + 1
      ___value_1
     }] = 15.shl(6).or(
      c_1.code.ushr(6),
     ).toByte()
     bytes[run {
      val ___value_2: Int = j
      j = j + 1
      ___value_2
     }] = 128.or(
      63.and(
       c_1.code,
      ),
     ).toByte()
    } else if ((c_1.code < Character.MIN_SURROGATE.code || c_1.code > Character.MAX_SURROGATE.code) && j <= limit - 3) {
     bytes[run {
      val ___value_3: Int = j
      j = j + 1
      ___value_3
     }] = 15.shl(5).or(
      c_1.code.ushr(12),
     ).toByte()
     bytes[run {
      val ___value_4: Int = j
      j = j + 1
      ___value_4
     }] = 128.or(
      63.and(
       c_1.code.ushr(6),
      ),
     ).toByte()
     bytes[run {
      val ___value_5: Int = j
      j = j + 1
      ___value_5
     }] = 128.or(
      63.and(
       c_1.code,
      ),
     ).toByte()
    } else if (j <= limit - 4) {
     var codePoint: Int = 0
     if (run {
      codePoint = Character.codePointAt(sequence, i)
      codePoint
     } == c_1.code) {
      throw IllegalArgumentException(
       Utf8.unpairedSurrogateMsg(i),
      )
     }
     i = i + 1
     bytes[run {
      val ___value_6: Int = j
      j = j + 1
      ___value_6
     }] = 15.shl(4).or(
      codePoint.ushr(18),
     ).toByte()
     bytes[run {
      val ___value_7: Int = j
      j = j + 1
      ___value_7
     }] = 128.or(
      63.and(
       codePoint.ushr(12),
      ),
     ).toByte()
     bytes[run {
      val ___value_8: Int = j
      j = j + 1
      ___value_8
     }] = 128.or(
      63.and(
       codePoint.ushr(6),
      ),
     ).toByte()
     bytes[run {
      val ___value_9: Int = j
      j = j + 1
      ___value_9
     }] = 128.or(
      63.and(codePoint),
     ).toByte()
    } else {
     if (Utf8.unpairedSurrogateAt(sequence, i)) {
      throw IllegalArgumentException(
       Utf8.unpairedSurrogateMsg(i),
      )
     }
     throw ArrayIndexOutOfBoundsException(
      "Failed writing " + c_1 + " at index " + j,
     )
    }
    i = i + 1
   }
   return j
  }

  @JvmStatic
  
  fun isWellFormed(
    bytes: ByteArray
  ): Boolean {
   return Utf8.isWellFormed(
    bytes,
    0,
    bytes.size,
   )
  }

  @JvmStatic
  
  fun isWellFormed(
    bytes: ByteArray,
    off: Int,
    len: Int
  ): Boolean {
   val end: Int = off + len
   Preconditions.checkPositionIndexes(
    off,
    end,
    bytes.size,
   )
   var i: Int = off
   while (i < end) {
    if (bytes[i].toInt() < 0) {
     return Utf8.isWellFormedSlowPath(bytes, i, end)
    }
    i = i + 1
   }
   return true
  }

  @JvmStatic
  private fun isWellFormedSlowPath(bytes: ByteArray, off: Int, end: Int): Boolean {
   var index: Int = off
   while (true) {
    var byte1: Int = 0
    do {
     if (index >= end) {
      return true
     }
    } while (run {
     byte1 = bytes[run {
      val ___value: Int = index
      index = index + 1
      ___value
     }].toInt()
     byte1
    } >= 0)
    if (byte1 < 224.toByte().toInt()) {
     if (index == end) {
      return false
     }
     if (byte1 < 194.toByte().toInt() || bytes[run {
      val ___value_1: Int = index
      index = index + 1
      ___value_1
     }].toInt() > 191.toByte().toInt()) {
      return false
     }
    } else if (byte1 < 240.toByte().toInt()) {
     if (index + 1 >= end) {
      return false
     }
     val byte2: Int = bytes[run {
      val ___value_2: Int = index
      index = index + 1
      ___value_2
     }].toInt()
     if (byte2 > 191.toByte().toInt() || byte1 == 224.toByte().toInt() && byte2 < 160.toByte().toInt() || byte1 == 237.toByte().toInt() && byte2 >= 160.toByte().toInt() || bytes[run {
      val ___value_3: Int = index
      index = index + 1
      ___value_3
     }].toInt() > 191.toByte().toInt()) {
      return false
     }
    } else {
     if (index + 2 >= end) {
      return false
     }
     val byte2_1: Int = bytes[run {
      val ___value_4: Int = index
      index = index + 1
      ___value_4
     }].toInt()
     if (byte2_1 > 191.toByte().toInt() || (byte1.shl(28) + (byte2_1 - 144.toByte().toInt())).shr(30) != 0 || bytes[run {
      val ___value_5: Int = index
      index = index + 1
      ___value_5
     }].toInt() > 191.toByte().toInt() || bytes[run {
      val ___value_6: Int = index
      index = index + 1
      ___value_6
     }].toInt() > 191.toByte().toInt()) {
      return false
     }
    }
   }
  }

  @JvmStatic
  private fun unpairedSurrogateAt(sequence: CharSequence, i: Int): Boolean {
   val codePoint: Int = Character.codePointAt(sequence, i)
   return Character.MIN_SURROGATE.code <= codePoint && codePoint <= Character.MAX_SURROGATE.code
  }

  @JvmStatic
  private fun unpairedSurrogateMsg(i: Int): String {
   return "Unpaired surrogate at index " + i
  }
 }
}
