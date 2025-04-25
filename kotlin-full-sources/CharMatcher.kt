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

// Generated from "com/google/common/base/CharMatcher.java"
@file:OptIn(ExperimentalObjCName::class, ExperimentalObjCRefinement::class)
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
import com.google.common.base.Predicate
import com.google.common.base.SmallCharMatcher
import java.lang.Character
import java.lang.Integer
import java.lang.Long
import java.util.Arrays
import java.util.BitSet
import kotlin.Boolean
import kotlin.Char
import kotlin.CharArray
import kotlin.CharSequence
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.charArrayOf
import kotlin.experimental.ExperimentalObjCName
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.HiddenFromObjC
import kotlin.native.ObjCName
import kotlin.text.StringBuilder


abstract class CharMatcher: Predicate<Char> {
 constructor()

 
 abstract fun matches(
   c: Char
 ): Boolean

 override fun negate(): CharMatcher {
  return Negated(this@CharMatcher)
 }

 
 open fun and(
   other: CharMatcher
 ): CharMatcher {
  return And(this@CharMatcher, other)
 }

 
 open fun or(
   other: CharMatcher
 ): CharMatcher {
  return Or(this@CharMatcher, other)
 }

 
 open fun precomputed(): CharMatcher {
  return Platform.precomputeCharMatcher_pp_com_google_common_base(this)
 }

 internal open fun precomputedInternal_pp_com_google_common_base(): CharMatcher {
  val table: BitSet = BitSet()
  this.setBits_pp_com_google_common_base(table)
  val totalCharacters: Int = table.cardinality()
  if (totalCharacters * 2 <= CharMatcher.DISTINCT_CHARS) {
   return CharMatcher.precomputedPositive(
    totalCharacters,
    table,
    this.toString(),
   )
  } else {
   table.flip(
    Character.MIN_VALUE.code,
    Character.MAX_VALUE.code + 1,
   )
   val negatedCharacters: Int = CharMatcher.DISTINCT_CHARS - totalCharacters
   val suffix: String = ".negate()"
   val description: String = this.toString()
   val negatedDescription: String = if (description.endsWith(suffix)) description.substring(
    0,
    description.length - suffix.length,
   ) else description + suffix
   return object : NegatedFastMatcher(
    CharMatcher.precomputedPositive(negatedCharacters, table, negatedDescription),
   ) {
    override fun toString(): String {
     return description
    }
   }
  }
 }

 internal open fun setBits_pp_com_google_common_base(table: BitSet) {
  var c: Int = Character.MAX_VALUE.code
  while (c >= Character.MIN_VALUE.code) {
   if (this.matches(
    c.toChar(),
   )) {
    table.set(c)
   }
   c = c - 1
  }
 }

 
 open fun matchesAnyOf(
   sequence: CharSequence
 ): Boolean {
  return !this.matchesNoneOf(sequence)
 }

 
 open fun matchesAllOf(
   sequence: CharSequence
 ): Boolean {
  var i: Int = sequence.length - 1
  while (i >= 0) {
   if (!this.matches(
    sequence.get(i),
   )) {
    return false
   }
   i = i - 1
  }
  return true
 }

 
 open fun matchesNoneOf(
   sequence: CharSequence
 ): Boolean {
  return this.indexIn(sequence) == - 1
 }

 
 open fun indexIn(
   sequence: CharSequence
 ): Int {
  return this.indexIn(sequence, 0)
 }

 
 open fun indexIn(
   sequence: CharSequence,
   start: Int
 ): Int {
  val length: Int = sequence.length
  Preconditions.checkPositionIndex(start, length)
  var i: Int = start
  while (i < length) {
   if (this.matches(
    sequence.get(i),
   )) {
    return i
   }
   i = i + 1
  }
  return - 1
 }

 
 open fun lastIndexIn(
   sequence: CharSequence
 ): Int {
  var i: Int = sequence.length - 1
  while (i >= 0) {
   if (this.matches(
    sequence.get(i),
   )) {
    return i
   }
   i = i - 1
  }
  return - 1
 }

 
 open fun countIn(
   sequence: CharSequence
 ): Int {
  var count: Int = 0
  var i: Int = 0
  while (i < sequence.length) {
   if (this.matches(
    sequence.get(i),
   )) {
    count = count + 1
   }
   i = i + 1
  }
  return count
 }

 
 open fun removeFrom(
   sequence: CharSequence
 ): String {
  val string: String = sequence.toString()
  var pos: Int = this.indexIn(string)
  if (pos == - 1) {
   return string
  }
  val chars: CharArray = string.toCharArray()
  var spread: Int = 1
  OUT@ while (true) {
   pos = pos + 1
   while (true) {
    if (pos == chars.size) {
     break@OUT
    }
    if (this.matches(
     chars[pos],
    )) {
     break
    }
    chars[pos - spread] = chars[pos]
    pos = pos + 1
   }
   spread = spread + 1
  }
  return String(
   chars,
   0,
   pos - spread,
  )
 }

 
 open fun retainFrom(
   sequence: CharSequence
 ): String {
  return this.negate().removeFrom(sequence)
 }

 
 open fun replaceFrom(
   sequence: CharSequence,
   replacement: Char
 ): String {
  val string: String = sequence.toString()
  val pos: Int = this.indexIn(string)
  if (pos == - 1) {
   return string
  }
  val chars: CharArray = string.toCharArray()
  chars[pos] = replacement
  var i: Int = pos + 1
  while (i < chars.size) {
   if (this.matches(
    chars[i],
   )) {
    chars[i] = replacement
   }
   i = i + 1
  }
  return String(chars)
 }

 
 open fun replaceFrom(
   sequence: CharSequence,
   replacement: CharSequence
 ): String {
  val replacementLen: Int = replacement.length
  if (replacementLen == 0) {
   return this.removeFrom(sequence)
  }
  if (replacementLen == 1) {
   return this.replaceFrom(
    sequence,
    replacement.get(0),
   )
  }
  val string: String = sequence.toString()
  var pos: Int = this.indexIn(string)
  if (pos == - 1) {
   return string
  }
  val len: Int = string.length
  val buf: StringBuilder = StringBuilder(
   len * 3 / 2 + 16,
  )
  var oldpos: Int = 0
  do {
   buf.append(string, oldpos, pos)
   buf.append(replacement)
   oldpos = pos + 1
   pos = this.indexIn(string, oldpos)
  } while (pos != - 1)
  buf.append(string, oldpos, len)
  return buf.toString()
 }

 
 open fun trimFrom(
   sequence: CharSequence
 ): String {
  val len: Int = sequence.length
  var first: Int = 0
  var last: Int = 0
  first = 0
  while (first < len) {
   if (!this.matches(
    sequence.get(first),
   )) {
    break
   }
   first = first + 1
  }
  last = len - 1
  while (last > first) {
   if (!this.matches(
    sequence.get(last),
   )) {
    break
   }
   last = last - 1
  }
  return sequence.subSequence(
   first,
   last + 1,
  ).toString()
 }

 
 open fun trimLeadingFrom(
   sequence: CharSequence
 ): String {
  val len: Int = sequence.length
  var first: Int = 0
  while (first < len) {
   if (!this.matches(
    sequence.get(first),
   )) {
    return sequence.subSequence(first, len).toString()
   }
   first = first + 1
  }
  return ""
 }

 
 open fun trimTrailingFrom(
   sequence: CharSequence
 ): String {
  val len: Int = sequence.length
  var last: Int = len - 1
  while (last >= 0) {
   if (!this.matches(
    sequence.get(last),
   )) {
    return sequence.subSequence(
     0,
     last + 1,
    ).toString()
   }
   last = last - 1
  }
  return ""
 }

 
 open fun collapseFrom(
   sequence: CharSequence,
   replacement: Char
 ): String {
  val len: Int = sequence.length
  var i: Int = 0
  while (i < len) {
   val c: Char = sequence.get(i)
   if (this.matches(c)) {
    if (c.code == replacement.code && (i == len - 1 || !this.matches(
     sequence.get(
      i + 1,
     ),
    ))) {
     i = i + 1
    } else {
     val builder: StringBuilder = StringBuilder(len).append(sequence, 0, i).append(replacement)
     return this.finishCollapseFrom(
      sequence,
      i + 1,
      len,
      replacement,
      builder,
      true,
     )
    }
   }
   i = i + 1
  }
  return sequence.toString()
 }

 
 open fun trimAndCollapseFrom(
   sequence: CharSequence,
   replacement: Char
 ): String {
  val len: Int = sequence.length
  var first: Int = 0
  var last: Int = len - 1
  while (first < len && this.matches(
   sequence.get(first),
  )) {
   first = first + 1
  }
  while (last > first && this.matches(
   sequence.get(last),
  )) {
   last = last - 1
  }
  return if (first == 0 && last == len - 1) this.collapseFrom(sequence, replacement) else this.finishCollapseFrom(
   sequence,
   first,
   last + 1,
   replacement,
   StringBuilder(
    last + 1 - first,
   ),
   false,
  )
 }

 
 private fun finishCollapseFrom(sequence: CharSequence, start: Int, end: Int, replacement: Char, builder: StringBuilder, inMatchingGroup: Boolean): String {
  var inMatchingGroup_1: Boolean = inMatchingGroup
  var i: Int = start
  while (i < end) {
   val c: Char = sequence.get(i)
   if (this.matches(c)) {
    if (!inMatchingGroup_1) {
     builder.append(replacement)
     inMatchingGroup_1 = true
    }
   } else {
    builder.append(c)
    inMatchingGroup_1 = false
   }
   i = i + 1
  }
  return builder.toString()
 }

 override fun apply(character: Char): Boolean {
  return this.matches(
   character.toChar(),
  )
 }

 override fun test(character: Char): Boolean {
  return this.matches(
   character.toChar(),
  )
 }

 override fun toString(): String {
  return super.toString()
 }

 
 companion object {
  @JvmStatic
  
  fun any(): CharMatcher {
   return Any.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun none(): CharMatcher {
   return None.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun whitespace(): CharMatcher {
   return Whitespace.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun breakingWhitespace(): CharMatcher {
   return BreakingWhitespace.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun ascii(): CharMatcher {
   return Ascii.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun digit(): CharMatcher {
   return Digit.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun javaDigit(): CharMatcher {
   return JavaDigit.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun javaLetter(): CharMatcher {
   return JavaLetter.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun javaLetterOrDigit(): CharMatcher {
   return JavaLetterOrDigit.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun javaUpperCase(): CharMatcher {
   return JavaUpperCase.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun javaLowerCase(): CharMatcher {
   return JavaLowerCase.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun javaIsoControl(): CharMatcher {
   return JavaIsoControl.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun invisible(): CharMatcher {
   return Invisible.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun singleWidth(): CharMatcher {
   return SingleWidth.INSTANCE_pp_com_google_common_base
  }

  @JvmStatic
  
  fun `is`(
    match: Char
  ): CharMatcher {
   return Is(match)
  }

  @JvmStatic
  
  fun isNot(
    match: Char
  ): CharMatcher {
   return IsNot(match)
  }

  @JvmStatic
  
  fun anyOf(
    sequence: CharSequence
  ): CharMatcher {
   when (sequence.length) {
    0 -> {
     return CharMatcher.none()
    }
    1 -> {
     return CharMatcher.`is`(
      sequence.get(0),
     )
    }
    2 -> {
     return CharMatcher.isEither(
      sequence.get(0),
      sequence.get(1),
     )
    }
    else -> {
     return AnyOf(sequence)
    }
   }
  }

  @JvmStatic
  
  fun noneOf(
    sequence: CharSequence
  ): CharMatcher {
   return CharMatcher.anyOf(sequence).negate()
  }

  @JvmStatic
  
  fun inRange(
    startInclusive: Char,
    endInclusive: Char
  ): CharMatcher {
   return InRange(startInclusive, endInclusive)
  }

  @JvmStatic
  
  fun forPredicate(
    predicate: Predicate<in Char>
  ): CharMatcher {
   return if (predicate is CharMatcher) predicate as CharMatcher else ForPredicate(
    predicate as Predicate<in Char>,
   )
  }

  private const val DISTINCT_CHARS: Int = 65536

  @JvmStatic
  private fun precomputedPositive(totalCharacters: Int, table: BitSet, description: String): CharMatcher {
   when (totalCharacters) {
    0 -> {
     return CharMatcher.none()
    }
    1 -> {
     return CharMatcher.`is`(
      table.nextSetBit(0).toChar(),
     )
    }
    2 -> {
     val c1: Char = table.nextSetBit(0).toChar()
     val c2: Char = table.nextSetBit(
      c1.code + 1,
     ).toChar()
     return CharMatcher.isEither(c1, c2)
    }
    else -> {
     return if (CharMatcher.isSmall(
      totalCharacters,
      table.length(),
     )) SmallCharMatcher.from_pp_com_google_common_base(table, description) else BitSetMatcher(table, description)
    }
   }
  }

  @JvmStatic
  private fun isSmall(totalCharacters: Int, tableLength: Int): Boolean {
   return totalCharacters <= SmallCharMatcher.MAX_SIZE_pp_com_google_common_base && tableLength > totalCharacters * 4 * Character.SIZE
  }

  @JvmStatic
  private fun showCharacter(c: Char): String {
   var c_1: Char = c
   val hex: String = "0123456789ABCDEF"
   val tmp: CharArray = charArrayOf('\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000')
   var i: Int = 0
   while (i < 4) {
    tmp[5 - i] = hex.get(
     c_1.code.and(15),
    )
    c_1 = c_1.code.shr(4).toChar()
    i = i + 1
   }
   return java.lang.String.copyValueOf(tmp)
  }

  @JvmStatic
  private fun isEither(c1: Char, c2: Char): IsEither {
   return IsEither(c1, c2)
  }
 }

 
 abstract class FastMatcher internal constructor(): CharMatcher() {
  final override fun precomputed(): CharMatcher {
   return this
  }

  override fun negate(): CharMatcher {
   return NegatedFastMatcher(this@FastMatcher)
  }
 }

 
 abstract class NamedFastMatcher: FastMatcher {
  private val description: String

  internal constructor(description: String) {
   this.description = Preconditions.checkNotNull<String>(description)
  }

  final override fun toString(): String {
   return this.description
  }
 }

 
 open class NegatedFastMatcher: Negated {
  internal constructor(original: CharMatcher): super(original)

  final override fun precomputed(): CharMatcher {
   return this
  }
 }

 
 class BitSetMatcher: NamedFastMatcher {
  private val table: BitSet

  internal constructor(table: BitSet, description: String): super(description) {
   var table_1: BitSet = table
   if (table_1.length() + Long.SIZE < table_1.size()) {
    table_1 = table_1.clone() as BitSet
   }
   this.table = table_1
  }

  override fun matches(c: Char): Boolean {
   return this.table.get(
    c.code,
   )
  }

  override fun setBits_pp_com_google_common_base(bitSet: BitSet) {
   bitSet.or(
    this.table,
   )
  }
 }

 
 class Any: NamedFastMatcher {
  private constructor(): super("CharMatcher.any()")

  override fun matches(c: Char): Boolean {
   return true
  }

  override fun indexIn(sequence: CharSequence): Int {
   return if (sequence.length == 0) - 1 else 0
  }

  override fun indexIn(sequence: CharSequence, start: Int): Int {
   val length: Int = sequence.length
   Preconditions.checkPositionIndex(start, length)
   return if (start == length) - 1 else start
  }

  override fun lastIndexIn(sequence: CharSequence): Int {
   return sequence.length - 1
  }

  override fun matchesAllOf(sequence: CharSequence): Boolean {
   Preconditions.checkNotNull<CharSequence>(sequence)
   return true
  }

  override fun matchesNoneOf(sequence: CharSequence): Boolean {
   return sequence.length == 0
  }

  override fun removeFrom(sequence: CharSequence): String {
   Preconditions.checkNotNull<CharSequence>(sequence)
   return ""
  }

  override fun replaceFrom(sequence: CharSequence, replacement: Char): String {
   val array: CharArray = CharArray(sequence.length)
   Arrays.fill(array, replacement)
   return String(array)
  }

  override fun replaceFrom(sequence: CharSequence, replacement: CharSequence): String {
   val result: StringBuilder = StringBuilder(
    sequence.length * replacement.length,
   )
   var i: Int = 0
   while (i < sequence.length) {
    result.append(replacement)
    i = i + 1
   }
   return result.toString()
  }

  override fun collapseFrom(sequence: CharSequence, replacement: Char): String {
   return if (sequence.length == 0) "" else java.lang.String.valueOf(replacement)
  }

  override fun trimFrom(sequence: CharSequence): String {
   Preconditions.checkNotNull<CharSequence>(sequence)
   return ""
  }

  override fun countIn(sequence: CharSequence): Int {
   return sequence.length
  }

  override fun and(other: CharMatcher): CharMatcher {
   return Preconditions.checkNotNull<CharMatcher>(other)
  }

  override fun or(other: CharMatcher): CharMatcher {
   Preconditions.checkNotNull<CharMatcher>(other)
   return this
  }

  override fun negate(): CharMatcher {
   return CharMatcher.none()
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = Any()
  }
 }

 
 class None: NamedFastMatcher {
  private constructor(): super("CharMatcher.none()")

  override fun matches(c: Char): Boolean {
   return false
  }

  override fun indexIn(sequence: CharSequence): Int {
   Preconditions.checkNotNull<CharSequence>(sequence)
   return - 1
  }

  override fun indexIn(sequence: CharSequence, start: Int): Int {
   val length: Int = sequence.length
   Preconditions.checkPositionIndex(start, length)
   return - 1
  }

  override fun lastIndexIn(sequence: CharSequence): Int {
   Preconditions.checkNotNull<CharSequence>(sequence)
   return - 1
  }

  override fun matchesAllOf(sequence: CharSequence): Boolean {
   return sequence.length == 0
  }

  override fun matchesNoneOf(sequence: CharSequence): Boolean {
   Preconditions.checkNotNull<CharSequence>(sequence)
   return true
  }

  override fun removeFrom(sequence: CharSequence): String {
   return sequence.toString()
  }

  override fun replaceFrom(sequence: CharSequence, replacement: Char): String {
   return sequence.toString()
  }

  override fun replaceFrom(sequence: CharSequence, replacement: CharSequence): String {
   Preconditions.checkNotNull<CharSequence>(replacement)
   return sequence.toString()
  }

  override fun collapseFrom(sequence: CharSequence, replacement: Char): String {
   return sequence.toString()
  }

  override fun trimFrom(sequence: CharSequence): String {
   return sequence.toString()
  }

  override fun trimLeadingFrom(sequence: CharSequence): String {
   return sequence.toString()
  }

  override fun trimTrailingFrom(sequence: CharSequence): String {
   return sequence.toString()
  }

  override fun countIn(sequence: CharSequence): Int {
   Preconditions.checkNotNull<CharSequence>(sequence)
   return 0
  }

  override fun and(other: CharMatcher): CharMatcher {
   Preconditions.checkNotNull<CharMatcher>(other)
   return this
  }

  override fun or(other: CharMatcher): CharMatcher {
   return Preconditions.checkNotNull<CharMatcher>(other)
  }

  override fun negate(): CharMatcher {
   return CharMatcher.any()
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = None()
  }
 }

 
 class Whitespace: NamedFastMatcher {
  internal constructor(): super("CharMatcher.whitespace()")

  override fun matches(c: Char): Boolean {
   return Whitespace.TABLE_pp_com_google_common_base.get(
    (Whitespace.MULTIPLIER_pp_com_google_common_base * c.code).ushr(
     Whitespace.SHIFT_pp_com_google_common_base,
    ),
   ).code == c.code
  }

  override fun setBits_pp_com_google_common_base(table: BitSet) {
   var i: Int = 0
   while (i < Whitespace.TABLE_pp_com_google_common_base.length) {
    table.set(
     Whitespace.TABLE_pp_com_google_common_base.get(i).code,
    )
    i = i + 1
   }
  }

  
  companion object {
   internal const val TABLE_pp_com_google_common_base: String = "\u2002\u3000\r\u0085\u200A\u2005\u2000\u3000\u2029\u000B\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\u00A0\u000C\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000"

   internal const val MULTIPLIER_pp_com_google_common_base: Int = 1682554634

   @JvmField
   internal val SHIFT_pp_com_google_common_base: Int = Integer.numberOfLeadingZeros(
    Whitespace.TABLE_pp_com_google_common_base.length - 1,
   )

   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = Whitespace()
  }
 }

 
 class BreakingWhitespace internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean {
   when (c) {
    '\t', '\n', '\u000B', '\u000C', '\r', ' ', '\u0085', '\u1680', '\u2028', '\u2029', '\u205F', '\u3000' -> {
     return true
    }
    '\u2007' -> {
     return false
    }
    else -> {
     return c.code >= '\u2000'.code && c.code <= '\u200A'.code
    }
   }
  }

  override fun toString(): String {
   return "CharMatcher.breakingWhitespace()"
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = BreakingWhitespace()
  }
 }

 
 class Ascii: NamedFastMatcher {
  internal constructor(): super("CharMatcher.ascii()")

  override fun matches(c: Char): Boolean {
   return c.code <= '\u007F'.code
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = Ascii()
  }
 }

 
 open class RangesMatcher: CharMatcher {
  private val description: String

  private val rangeStarts: CharArray

  private val rangeEnds: CharArray

  internal constructor(description: String, rangeStarts: CharArray, rangeEnds: CharArray) {
   this.description = description
   this.rangeStarts = rangeStarts
   this.rangeEnds = rangeEnds
   Preconditions.checkArgument(
    rangeStarts.size == rangeEnds.size,
   )
   var i: Int = 0
   while (i < rangeStarts.size) {
    Preconditions.checkArgument(
     rangeStarts[i].code <= rangeEnds[i].code,
    )
    if (i + 1 < rangeStarts.size) {
     Preconditions.checkArgument(
      rangeEnds[i].code < rangeStarts[i + 1].code,
     )
    }
    i = i + 1
   }
  }

  override fun matches(c: Char): Boolean {
   var index: Int = Arrays.binarySearch(
    this.rangeStarts,
    c,
   )
   if (index >= 0) {
    return true
   } else {
    index = index.inv() - 1
    return index >= 0 && c.code <= this.rangeEnds[index].code
   }
  }

  override fun toString(): String {
   return this.description
  }
 }

 
 class Digit: RangesMatcher {
  private constructor(): super(
   "CharMatcher.digit()",
   Digit.zeroes(),
   Digit.nines(),
  )

  
  companion object {
   private const val ZEROES: String = "0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0DE6\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1A80\u1A90\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uA9D0\uA9F0\uAA50\uABF0\uFF10"

   @JvmStatic
   private fun zeroes(): CharArray {
    return Digit.ZEROES.toCharArray()
   }

   @JvmStatic
   private fun nines(): CharArray {
    val nines: CharArray = CharArray(Digit.ZEROES.length)
    var i: Int = 0
    while (i < Digit.ZEROES.length) {
     nines[i] = (Digit.ZEROES.get(i).code + 9).toChar()
     i = i + 1
    }
    return nines
   }

   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = Digit()
  }
 }

 
 class JavaDigit internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean {
   return Character.isDigit(c)
  }

  override fun toString(): String {
   return "CharMatcher.javaDigit()"
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = JavaDigit()
  }
 }

 
 class JavaLetter internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean {
   return Character.isLetter(c)
  }

  override fun toString(): String {
   return "CharMatcher.javaLetter()"
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = JavaLetter()
  }
 }

 
 class JavaLetterOrDigit internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean {
   return Character.isLetterOrDigit(c)
  }

  override fun toString(): String {
   return "CharMatcher.javaLetterOrDigit()"
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = JavaLetterOrDigit()
  }
 }

 
 class JavaUpperCase internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean {
   return Character.isUpperCase(c)
  }

  override fun toString(): String {
   return "CharMatcher.javaUpperCase()"
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = JavaUpperCase()
  }
 }

 
 class JavaLowerCase internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean {
   return Character.isLowerCase(c)
  }

  override fun toString(): String {
   return "CharMatcher.javaLowerCase()"
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = JavaLowerCase()
  }
 }

 
 class JavaIsoControl: NamedFastMatcher {
  private constructor(): super("CharMatcher.javaIsoControl()")

  override fun matches(c: Char): Boolean {
   return c.code <= '\u001F'.code || c.code >= '\u007F'.code && c.code <= '\u009F'.code
  }

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = JavaIsoControl()
  }
 }

 
 class Invisible: RangesMatcher {
  private constructor(): super(
   "CharMatcher.invisible()",
   Invisible.RANGE_STARTS.toCharArray(),
   Invisible.RANGE_ENDS.toCharArray(),
  )

  
  companion object {
   private const val RANGE_STARTS: String = "\u0000\u007F\u00AD\u0600\u061C\u06DD\u070F\u0890\u08E2\u1680\u180E\u2000\u2028\u205F\u2066\u3000\uD800\uFEFF\uFFF9"

   private const val RANGE_ENDS: String = " \u00A0\u00AD\u0605\u061C\u06DD\u070F\u0891\u08E2\u1680\u180E\u200F\u202F\u2064\u206F\u3000\uF8FF\uFEFF\uFFFB"

   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = Invisible()
  }
 }

 
 class SingleWidth: RangesMatcher {
  private constructor(): super(
   "CharMatcher.singleWidth()",
   "\u0000\u05BE\u05D0\u05F3\u0600\u0750\u0E00\u1E00\u2100\uFB50\uFE70\uFF61".toCharArray(),
   "\u04F9\u05BE\u05EA\u05F4\u06FF\u077F\u0E7F\u20AF\u213A\uFDFF\uFEFF\uFFDC".toCharArray(),
  )

  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = SingleWidth()
  }
 }

 
 open class Negated: CharMatcher {
  @JvmField
  internal val original_pp_com_google_common_base: CharMatcher

  internal constructor(original: CharMatcher) {
   this.original_pp_com_google_common_base = Preconditions.checkNotNull<CharMatcher>(original)
  }

  override fun matches(c: Char): Boolean {
   return !this.original_pp_com_google_common_base.matches(c)
  }

  override fun matchesAllOf(sequence: CharSequence): Boolean {
   return this.original_pp_com_google_common_base.matchesNoneOf(sequence)
  }

  override fun matchesNoneOf(sequence: CharSequence): Boolean {
   return this.original_pp_com_google_common_base.matchesAllOf(sequence)
  }

  override fun countIn(sequence: CharSequence): Int {
   return sequence.length - this.original_pp_com_google_common_base.countIn(sequence)
  }

  override fun setBits_pp_com_google_common_base(table: BitSet) {
   val tmp: BitSet = BitSet()
   this.original_pp_com_google_common_base.setBits_pp_com_google_common_base(tmp)
   tmp.flip(
    Character.MIN_VALUE.code,
    Character.MAX_VALUE.code + 1,
   )
   table.or(tmp)
  }

  override fun negate(): CharMatcher {
   return this.original_pp_com_google_common_base
  }

  override fun toString(): String {
   return "" + this.original_pp_com_google_common_base + ".negate()"
  }
 }

 
 class And: CharMatcher {
  @JvmField
  internal val first_pp_com_google_common_base: CharMatcher

  @JvmField
  internal val second_pp_com_google_common_base: CharMatcher

  internal constructor(a: CharMatcher, b: CharMatcher) {
   this.first_pp_com_google_common_base = Preconditions.checkNotNull<CharMatcher>(a)
   this.second_pp_com_google_common_base = Preconditions.checkNotNull<CharMatcher>(b)
  }

  override fun matches(c: Char): Boolean {
   return this.first_pp_com_google_common_base.matches(c) && this.second_pp_com_google_common_base.matches(c)
  }

  override fun setBits_pp_com_google_common_base(table: BitSet) {
   val tmp1: BitSet = BitSet()
   this.first_pp_com_google_common_base.setBits_pp_com_google_common_base(tmp1)
   val tmp2: BitSet = BitSet()
   this.second_pp_com_google_common_base.setBits_pp_com_google_common_base(tmp2)
   tmp1.and(tmp2)
   table.or(tmp1)
  }

  override fun toString(): String {
   return "CharMatcher.and(" + this.first_pp_com_google_common_base + ", " + this.second_pp_com_google_common_base + ")"
  }
 }

 
 class Or: CharMatcher {
  @JvmField
  internal val first_pp_com_google_common_base: CharMatcher

  @JvmField
  internal val second_pp_com_google_common_base: CharMatcher

  internal constructor(a: CharMatcher, b: CharMatcher) {
   this.first_pp_com_google_common_base = Preconditions.checkNotNull<CharMatcher>(a)
   this.second_pp_com_google_common_base = Preconditions.checkNotNull<CharMatcher>(b)
  }

  override fun setBits_pp_com_google_common_base(table: BitSet) {
   this.first_pp_com_google_common_base.setBits_pp_com_google_common_base(table)
   this.second_pp_com_google_common_base.setBits_pp_com_google_common_base(table)
  }

  override fun matches(c: Char): Boolean {
   return this.first_pp_com_google_common_base.matches(c) || this.second_pp_com_google_common_base.matches(c)
  }

  override fun toString(): String {
   return "CharMatcher.or(" + this.first_pp_com_google_common_base + ", " + this.second_pp_com_google_common_base + ")"
  }
 }

 
 class Is: FastMatcher {
  private val match: Char

  internal constructor(match: Char) {
   this.match = match
  }

  override fun matches(c: Char): Boolean {
   return c.code == this.match.code
  }

  override fun replaceFrom(sequence: CharSequence, replacement: Char): String {
   return sequence.toString().replace(
    this.match,
    replacement,
   )
  }

  override fun and(other: CharMatcher): CharMatcher {
   return if (other.matches(
    this.match,
   )) this else CharMatcher.none()
  }

  override fun or(other: CharMatcher): CharMatcher {
   return if (other.matches(
    this.match,
   )) other else super<FastMatcher>.or(other)
  }

  override fun negate(): CharMatcher {
   return CharMatcher.isNot(
    this.match,
   )
  }

  override fun setBits_pp_com_google_common_base(table: BitSet) {
   table.set(
    this.match.code,
   )
  }

  override fun toString(): String {
   return "CharMatcher.is(\'" + CharMatcher.showCharacter(
    this.match,
   ) + "\')"
  }
 }

 
 class IsNot: FastMatcher {
  private val match: Char

  internal constructor(match: Char) {
   this.match = match
  }

  override fun matches(c: Char): Boolean {
   return c.code != this.match.code
  }

  override fun and(other: CharMatcher): CharMatcher {
   return if (other.matches(
    this.match,
   )) super<FastMatcher>.and(other) else other
  }

  override fun or(other: CharMatcher): CharMatcher {
   return if (other.matches(
    this.match,
   )) CharMatcher.any() else this
  }

  override fun setBits_pp_com_google_common_base(table: BitSet) {
   table.set(
    0,
    this.match.code,
   )
   table.set(
    this.match.code + 1,
    Character.MAX_VALUE.code + 1,
   )
  }

  override fun negate(): CharMatcher {
   return CharMatcher.`is`(
    this.match,
   )
  }

  override fun toString(): String {
   return "CharMatcher.isNot(\'" + CharMatcher.showCharacter(
    this.match,
   ) + "\')"
  }
 }

 
 class IsEither: FastMatcher {
  private val match1: Char

  private val match2: Char

  internal constructor(match1: Char, match2: Char) {
   this.match1 = match1
   this.match2 = match2
  }

  override fun matches(c: Char): Boolean {
   return c.code == this.match1.code || c.code == this.match2.code
  }

  override fun setBits_pp_com_google_common_base(table: BitSet) {
   table.set(
    this.match1.code,
   )
   table.set(
    this.match2.code,
   )
  }

  override fun toString(): String {
   return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(
    this.match1,
   ) + CharMatcher.showCharacter(
    this.match2,
   ) + "\")"
  }
 }

 
 class AnyOf: CharMatcher {
  private val chars: CharArray

  constructor(
    chars: CharSequence
  ) {
   this.chars = chars.toString().toCharArray()
   Arrays.sort(
    this.chars,
   )
  }

  override fun matches(c: Char): Boolean {
   return Arrays.binarySearch(
    this.chars,
    c,
   ) >= 0
  }

  override fun setBits_pp_com_google_common_base(table: BitSet) {
   for (c in this.chars) {
    val c_1: Char = c
    table.set(
     c_1.code,
    )
   }
  }

  override fun toString(): String {
   val description: StringBuilder = StringBuilder("CharMatcher.anyOf(\"")
   for (c in this.chars) {
    val c_1: Char = c
    description.append(
     CharMatcher.showCharacter(c_1),
    )
   }
   description.append("\")")
   return description.toString()
  }
 }

 
 class InRange: FastMatcher {
  private val startInclusive: Char

  private val endInclusive: Char

  internal constructor(startInclusive: Char, endInclusive: Char) {
   Preconditions.checkArgument(
    endInclusive.code >= startInclusive.code,
   )
   this.startInclusive = startInclusive
   this.endInclusive = endInclusive
  }

  override fun matches(c: Char): Boolean {
   return this.startInclusive.code <= c.code && c.code <= this.endInclusive.code
  }

  override fun setBits_pp_com_google_common_base(table: BitSet) {
   table.set(
    this.startInclusive.code,
    this.endInclusive.code + 1,
   )
  }

  override fun toString(): String {
   return "CharMatcher.inRange(\'" + CharMatcher.showCharacter(
    this.startInclusive,
   ) + "\', \'" + CharMatcher.showCharacter(
    this.endInclusive,
   ) + "\')"
  }
 }

 
 class ForPredicate: CharMatcher {
  private val predicate: Predicate<in Char>

  internal constructor(predicate: Predicate<in Char>) {
   this.predicate = Preconditions.checkNotNull(predicate)
  }

  override fun matches(c: Char): Boolean {
   return this.predicate.apply(
    Character.valueOf(c),
   )
  }

  override fun toString(): String {
   return "CharMatcher.forPredicate(" + this.predicate + ")"
  }
 }
}
