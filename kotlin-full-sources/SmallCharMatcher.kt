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

// Generated from "com/google/common/base/SmallCharMatcher.java"
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


import com.google.common.base.CharMatcher
import com.google.common.base.CharMatcher.NamedFastMatcher
import java.lang.Integer
import java.util.BitSet
import kotlin.Boolean
import kotlin.Char
import kotlin.CharArray
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class SmallCharMatcher: NamedFastMatcher {
 private val table: CharArray

 private val containsZero: Boolean

 private val filter: Long

 private constructor(table: CharArray, filter: Long, containsZero: Boolean, description: String): super(description) {
  this.table = table
  this.filter = filter
  this.containsZero = containsZero
 }

 private fun checkFilter(c: Int): Boolean {
  return this.filter.shr(c).and(
   1.toLong(),
  ) == 1.toLong()
 }

 override fun matches(c: Char): Boolean {
  if (c.code == 0) {
   return this.containsZero
  }
  if (!this.checkFilter(
   c.code,
  )) {
   return false
  }
  val mask: Int = this.table.size - 1
  val startingIndex: Int = SmallCharMatcher.smear_pp_com_google_common_base(
   c.code,
  ).and(mask)
  var index: Int = startingIndex
  do {
   if (this.table[index].code == 0) {
    return false
   } else if (this.table[index].code == c.code) {
    return true
   } else {
    index = (index + 1).and(mask)
   }
  } while (index != startingIndex)
  return false
 }

 override fun setBits_pp_com_google_common_base(table: BitSet) {
  if (this.containsZero) {
   table.set(0)
  }
  for (c in this.table) {
   val c_1: Char = c
   if (c_1.code != 0) {
    table.set(
     c_1.code,
    )
   }
  }
 }

 
 companion object {
  internal const val MAX_SIZE_pp_com_google_common_base: Int = 1023

  private const val C1: Int = -862048943

  private const val C2: Int = 461845907

  @JvmStatic
  internal fun smear_pp_com_google_common_base(hashCode: Int): Int {
   return SmallCharMatcher.C2 * Integer.rotateLeft(
    hashCode * SmallCharMatcher.C1,
    15,
   )
  }

  private const val DESIRED_LOAD_FACTOR: Double = 0.5

  @JvmStatic
  internal fun chooseTableSize_pp_com_google_common_base(setSize: Int): Int {
   if (setSize == 1) {
    return 2
   }
   var tableSize: Int = Integer.highestOneBit(
    setSize - 1,
   ).shl(1)
   while (tableSize.toDouble() * SmallCharMatcher.DESIRED_LOAD_FACTOR < setSize.toDouble()) {
    tableSize = tableSize.shl(1)
   }
   return tableSize
  }

  @JvmStatic
  internal fun from_pp_com_google_common_base(chars: BitSet, description: String): CharMatcher {
   var filter: Long = 0L
   val size: Int = chars.cardinality()
   val containsZero: Boolean = chars.get(0)
   val table: CharArray = CharArray(SmallCharMatcher.chooseTableSize_pp_com_google_common_base(size))
   val mask: Int = table.size - 1
   var c: Int = chars.nextSetBit(0)
   while (c != - 1) {
    filter = filter.or(
     1L.shl(c),
    )
    var index: Int = SmallCharMatcher.smear_pp_com_google_common_base(c).and(mask)
    while (true) {
     if (table[index].code == 0) {
      table[index] = c.toChar()
      break
     }
     index = (index + 1).and(mask)
    }
    c = chars.nextSetBit(
     c + 1,
    )
   }
   return SmallCharMatcher(table, filter, containsZero, description)
  }
 }
}
