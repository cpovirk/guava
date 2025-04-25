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
 "REDUNDANT_ELSE_IN_WHEN", "MUST_BE_INITIALIZED", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT", "UNINITIALIZED_VARIABLE")

package com.google.common.base




import com.google.common.base.Predicate





import java.util.BitSet
import kotlin.Boolean
import kotlin.Char
import kotlin.CharArray
import kotlin.CharSequence
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress

import kotlin.experimental.ExperimentalObjCName
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

import kotlin.native.ObjCName



abstract class CharMatcher: Predicate<Char> {
 constructor()

 
 abstract fun matches(
   c: Char
 ): Boolean

 override fun negate(): CharMatcher { null!! }



 
 open fun and(
   other: CharMatcher
 ): CharMatcher { null!! }



 
 open fun or(
   other: CharMatcher
 ): CharMatcher { null!! }



 
 open fun precomputed(): CharMatcher { null!! }



 internal open fun precomputedInternal_pp_com_google_common_base(): CharMatcher { null!! }































 internal open fun setBits_pp_com_google_common_base(table: BitSet) {}











 
 open fun matchesAnyOf(
   sequence: CharSequence
 ): Boolean { null!! }



 
 open fun matchesAllOf(
   sequence: CharSequence
 ): Boolean { null!! }












 
 open fun matchesNoneOf(
   sequence: CharSequence
 ): Boolean { null!! }



 
 open fun indexIn(
   sequence: CharSequence
 ): Int { null!! }



 
 open fun indexIn(
   sequence: CharSequence,
   start: Int
 ): Int { null!! }














 
 open fun lastIndexIn(
   sequence: CharSequence
 ): Int { null!! }












 
 open fun countIn(
   sequence: CharSequence
 ): Int { null!! }













 
 open fun removeFrom(
   sequence: CharSequence
 ): String { null!! }






























 
 open fun retainFrom(
   sequence: CharSequence
 ): String { null!! }



 
 open fun replaceFrom(
   sequence: CharSequence,
   replacement: Char
 ): String { null!! }



















 
 open fun replaceFrom(
   sequence: CharSequence,
   replacement: CharSequence
 ): String { null!! }






























 
 open fun trimFrom(
   sequence: CharSequence
 ): String { null!! }



























 
 open fun trimLeadingFrom(
   sequence: CharSequence
 ): String { null!! }













 
 open fun trimTrailingFrom(
   sequence: CharSequence
 ): String { null!! }
















 
 open fun collapseFrom(
   sequence: CharSequence,
   replacement: Char
 ): String { null!! }




























 
 open fun trimAndCollapseFrom(
   sequence: CharSequence,
   replacement: Char
 ): String { null!! }

























 



















 override fun apply(character: Char): Boolean { null!! }





 override fun test(character: Char): Boolean { null!! }





 override fun toString(): String { null!! }



 
 companion object {
  @JvmStatic
  
  fun any(): CharMatcher { null!! }



  @JvmStatic
  
  fun none(): CharMatcher { null!! }



  @JvmStatic
  
  fun whitespace(): CharMatcher { null!! }



  @JvmStatic
  
  fun breakingWhitespace(): CharMatcher { null!! }



  @JvmStatic
  
  fun ascii(): CharMatcher { null!! }



  @JvmStatic
  
  fun digit(): CharMatcher { null!! }



  @JvmStatic
  
  fun javaDigit(): CharMatcher { null!! }



  @JvmStatic
  
  fun javaLetter(): CharMatcher { null!! }



  @JvmStatic
  
  fun javaLetterOrDigit(): CharMatcher { null!! }



  @JvmStatic
  
  fun javaUpperCase(): CharMatcher { null!! }



  @JvmStatic
  
  fun javaLowerCase(): CharMatcher { null!! }



  @JvmStatic
  
  fun javaIsoControl(): CharMatcher { null!! }



  @JvmStatic
  
  fun invisible(): CharMatcher { null!! }



  @JvmStatic
  
  fun singleWidth(): CharMatcher { null!! }



  @JvmStatic
  
  fun `is`(
    match: Char
  ): CharMatcher { null!! }



  @JvmStatic
  
  fun isNot(
    match: Char
  ): CharMatcher { null!! }



  @JvmStatic
  
  fun anyOf(
    sequence: CharSequence
  ): CharMatcher { null!! }





















  @JvmStatic
  
  fun noneOf(
    sequence: CharSequence
  ): CharMatcher { null!! }



  @JvmStatic
  
  fun inRange(
    startInclusive: Char,
    endInclusive: Char
  ): CharMatcher { null!! }



  @JvmStatic
  
  fun forPredicate(
    predicate: Predicate<in Char>
  ): CharMatcher { null!! }





  

  


























  




  















  



 }

 
 abstract class FastMatcher internal constructor(): CharMatcher() {
  final override fun precomputed(): CharMatcher { null!! }



  override fun negate(): CharMatcher { null!! }


 }

 
 abstract class NamedFastMatcher: FastMatcher {
  private val description: String

  internal constructor(description: String) {}



  final override fun toString(): String { null!! }


 }

 
 open class NegatedFastMatcher: Negated {
  internal constructor(original: CharMatcher): super(original)

  final override fun precomputed(): CharMatcher { null!! }


 }

 
 class BitSetMatcher: NamedFastMatcher {
  

  internal constructor(table: BitSet, description: String): super(description) {}







  override fun matches(c: Char): Boolean { null!! }





  override fun setBits_pp_com_google_common_base(bitSet: BitSet) {}




 }

 
 class Any: NamedFastMatcher {
  private constructor(): super("CharMatcher.any()")

  override fun matches(c: Char): Boolean { null!! }



  override fun indexIn(sequence: CharSequence): Int { null!! }



  override fun indexIn(sequence: CharSequence, start: Int): Int { null!! }





  override fun lastIndexIn(sequence: CharSequence): Int { null!! }



  override fun matchesAllOf(sequence: CharSequence): Boolean { null!! }




  override fun matchesNoneOf(sequence: CharSequence): Boolean { null!! }



  override fun removeFrom(sequence: CharSequence): String { null!! }




  override fun replaceFrom(sequence: CharSequence, replacement: Char): String { null!! }





  override fun replaceFrom(sequence: CharSequence, replacement: CharSequence): String { null!! }











  override fun collapseFrom(sequence: CharSequence, replacement: Char): String { null!! }



  override fun trimFrom(sequence: CharSequence): String { null!! }




  override fun countIn(sequence: CharSequence): Int { null!! }



  override fun and(other: CharMatcher): CharMatcher { null!! }



  override fun or(other: CharMatcher): CharMatcher { null!! }




  override fun negate(): CharMatcher { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class None: NamedFastMatcher {
  private constructor(): super("CharMatcher.none()")

  override fun matches(c: Char): Boolean { null!! }



  override fun indexIn(sequence: CharSequence): Int { null!! }




  override fun indexIn(sequence: CharSequence, start: Int): Int { null!! }





  override fun lastIndexIn(sequence: CharSequence): Int { null!! }




  override fun matchesAllOf(sequence: CharSequence): Boolean { null!! }



  override fun matchesNoneOf(sequence: CharSequence): Boolean { null!! }




  override fun removeFrom(sequence: CharSequence): String { null!! }



  override fun replaceFrom(sequence: CharSequence, replacement: Char): String { null!! }



  override fun replaceFrom(sequence: CharSequence, replacement: CharSequence): String { null!! }




  override fun collapseFrom(sequence: CharSequence, replacement: Char): String { null!! }



  override fun trimFrom(sequence: CharSequence): String { null!! }



  override fun trimLeadingFrom(sequence: CharSequence): String { null!! }



  override fun trimTrailingFrom(sequence: CharSequence): String { null!! }



  override fun countIn(sequence: CharSequence): Int { null!! }




  override fun and(other: CharMatcher): CharMatcher { null!! }




  override fun or(other: CharMatcher): CharMatcher { null!! }



  override fun negate(): CharMatcher { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class Whitespace: NamedFastMatcher {
  internal constructor(): super("CharMatcher.whitespace()")

  override fun matches(c: Char): Boolean { null!! }







  override fun setBits_pp_com_google_common_base(table: BitSet) {}









  
  companion object {
   internal const val TABLE_pp_com_google_common_base: String = "\u2002\u3000\r\u0085\u200A\u2005\u2000\u3000\u2029\u000B\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\u00A0\u000C\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000"

   internal const val MULTIPLIER_pp_com_google_common_base: Int = 1682554634

   @JvmField
   internal val SHIFT_pp_com_google_common_base: Int = null!!



   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class BreakingWhitespace internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean { null!! }













  override fun toString(): String { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class Ascii: NamedFastMatcher {
  internal constructor(): super("CharMatcher.ascii()")

  override fun matches(c: Char): Boolean { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 open class RangesMatcher: CharMatcher {
  private val description: String

  

  

  internal constructor(description: String, rangeStarts: CharArray, rangeEnds: CharArray) {}




















  override fun matches(c: Char): Boolean { null!! }












  override fun toString(): String { null!! }


 }

 
 class Digit: RangesMatcher {
  private constructor(): super(
   "CharMatcher.digit()",
   Digit.zeroes(),
   Digit.nines(),
  )

  
  companion object {
   

   @JvmStatic
   private fun zeroes(): CharArray { null!! }



   @JvmStatic
   private fun nines(): CharArray { null!! }









   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class JavaDigit internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean { null!! }



  override fun toString(): String { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class JavaLetter internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean { null!! }



  override fun toString(): String { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class JavaLetterOrDigit internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean { null!! }



  override fun toString(): String { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class JavaUpperCase internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean { null!! }



  override fun toString(): String { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class JavaLowerCase internal constructor(): CharMatcher() {
  override fun matches(c: Char): Boolean { null!! }



  override fun toString(): String { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 class JavaIsoControl: NamedFastMatcher {
  private constructor(): super("CharMatcher.javaIsoControl()")

  override fun matches(c: Char): Boolean { null!! }



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
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
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
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
   internal val INSTANCE_pp_com_google_common_base: CharMatcher = null!!
  }
 }

 
 open class Negated: CharMatcher {
  @JvmField
  internal val original_pp_com_google_common_base: CharMatcher

  internal constructor(original: CharMatcher) {}



  override fun matches(c: Char): Boolean { null!! }



  override fun matchesAllOf(sequence: CharSequence): Boolean { null!! }



  override fun matchesNoneOf(sequence: CharSequence): Boolean { null!! }



  override fun countIn(sequence: CharSequence): Int { null!! }



  override fun setBits_pp_com_google_common_base(table: BitSet) {}









  override fun negate(): CharMatcher { null!! }



  override fun toString(): String { null!! }


 }

 
 class And: CharMatcher {
  @JvmField
  internal val first_pp_com_google_common_base: CharMatcher

  @JvmField
  internal val second_pp_com_google_common_base: CharMatcher

  internal constructor(a: CharMatcher, b: CharMatcher) {}




  override fun matches(c: Char): Boolean { null!! }



  override fun setBits_pp_com_google_common_base(table: BitSet) {}








  override fun toString(): String { null!! }


 }

 
 class Or: CharMatcher {
  @JvmField
  internal val first_pp_com_google_common_base: CharMatcher

  @JvmField
  internal val second_pp_com_google_common_base: CharMatcher

  internal constructor(a: CharMatcher, b: CharMatcher) {}




  override fun setBits_pp_com_google_common_base(table: BitSet) {}




  override fun matches(c: Char): Boolean { null!! }



  override fun toString(): String { null!! }


 }

 
 class Is: FastMatcher {
  

  internal constructor(match: Char) {}



  override fun matches(c: Char): Boolean { null!! }



  override fun replaceFrom(sequence: CharSequence, replacement: Char): String { null!! }






  override fun and(other: CharMatcher): CharMatcher { null!! }





  override fun or(other: CharMatcher): CharMatcher { null!! }





  override fun negate(): CharMatcher { null!! }





  override fun setBits_pp_com_google_common_base(table: BitSet) {}





  override fun toString(): String { null!! }




 }

 
 class IsNot: FastMatcher {
  

  internal constructor(match: Char) {}



  override fun matches(c: Char): Boolean { null!! }



  override fun and(other: CharMatcher): CharMatcher { null!! }





  override fun or(other: CharMatcher): CharMatcher { null!! }





  override fun setBits_pp_com_google_common_base(table: BitSet) {}










  override fun negate(): CharMatcher { null!! }





  override fun toString(): String { null!! }




 }

 
 class IsEither: FastMatcher {
  

  

  internal constructor(match1: Char, match2: Char) {}




  override fun matches(c: Char): Boolean { null!! }



  override fun setBits_pp_com_google_common_base(table: BitSet) {}








  override fun toString(): String { null!! }






 }

 
 class AnyOf: CharMatcher {
  

  constructor(
    chars: CharSequence
  ) {}






  override fun matches(c: Char): Boolean { null!! }






  override fun setBits_pp_com_google_common_base(table: BitSet) {}








  override fun toString(): String { null!! }










 }

 
 class InRange: FastMatcher {
  

  

  internal constructor(startInclusive: Char, endInclusive: Char) {}







  override fun matches(c: Char): Boolean { null!! }



  override fun setBits_pp_com_google_common_base(table: BitSet) {}






  override fun toString(): String { null!! }






 }

 
 class ForPredicate: CharMatcher {
  

  internal constructor(predicate: Predicate<in Char>) {}



  override fun matches(c: Char): Boolean { null!! }





  override fun toString(): String { null!! }


 }
}
