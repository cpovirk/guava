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

// Generated from "com/google/common/base/Splitter.java"
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


import com.google.common.base.AbstractIterator
import com.google.common.base.CharMatcher
import com.google.common.base.CommonMatcher
import com.google.common.base.CommonPattern
import com.google.common.base.JdkPattern
import com.google.common.base.Joiner
import com.google.common.base.Platform
import com.google.common.base.Preconditions
import java.lang.Integer
import java.util.ArrayList
import java.util.Collections
import java.util.LinkedHashMap
import java.util.regex.Pattern
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.Any
import kotlin.Boolean
import kotlin.Char
import kotlin.CharSequence
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableIterable
import kotlin.collections.MutableIterator
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName
import kotlin.text.StringBuilder


class Splitter {
 private val trimmer: CharMatcher

 private val omitEmptyStrings: Boolean

 private val strategy: Strategy

 private val limit: Int

 private constructor(strategy: Strategy): this(
  strategy,
  false,
  CharMatcher.none(),
  Integer.MAX_VALUE,
 )

 private constructor(strategy: Strategy, omitEmptyStrings: Boolean, trimmer: CharMatcher, limit: Int) {
  this.strategy = strategy
  this.omitEmptyStrings = omitEmptyStrings
  this.trimmer = trimmer
  this.limit = limit
 }

 
 fun omitEmptyStrings(): Splitter {
  return Splitter(
   this@Splitter.strategy,
   true,
   this@Splitter.trimmer,
   this@Splitter.limit,
  )
 }

 
 fun limit(
   maxItems: Int
 ): Splitter {
  Preconditions.checkArgument(
   maxItems > 0,
   "must be greater than zero: %s",
   maxItems,
  )
  return Splitter(
   this@Splitter.strategy,
   this@Splitter.omitEmptyStrings,
   this@Splitter.trimmer,
   maxItems,
  )
 }

 
 fun trimResults(): Splitter {
  return this.trimResults(
   CharMatcher.whitespace(),
  )
 }

 
 fun trimResults(
   trimmer: CharMatcher
 ): Splitter {
  Preconditions.checkNotNull<CharMatcher>(trimmer)
  return Splitter(
   this@Splitter.strategy,
   this@Splitter.omitEmptyStrings,
   trimmer,
   this@Splitter.limit,
  )
 }

 
 fun split(
   sequence: CharSequence
 ): MutableIterable<String> {
  Preconditions.checkNotNull<CharSequence>(sequence)
  return null!!
 }

 private fun splittingIterator(sequence: CharSequence): MutableIterator<String> {
  return this.strategy.iterator(this, sequence)
 }

 
 fun splitToList(
   sequence: CharSequence
 ): MutableList<String> {
  Preconditions.checkNotNull<CharSequence>(sequence)
  val iterator: MutableIterator<String> = this.splittingIterator(sequence)
  val result: MutableList<String> = ArrayList<String>()
  while (iterator.hasNext()) {
   result.add(
    iterator.next(),
   )
  }
  return Collections.unmodifiableList<String>(result)
 }

 
 fun splitToStream(
   sequence: CharSequence
 ): Stream<String> {
  return StreamSupport.stream<String>(
   this.split(sequence).spliterator(),
   false,
  )
 }

 
 fun withKeyValueSeparator(
   separator: String
 ): MapSplitter {
  return this.withKeyValueSeparator(
   Splitter.on(separator),
  )
 }

 
 fun withKeyValueSeparator(
   separator: Char
 ): MapSplitter {
  return this.withKeyValueSeparator(
   Splitter.on(separator),
  )
 }

 
 fun withKeyValueSeparator(
   keyValueSplitter: Splitter
 ): MapSplitter {
  return MapSplitter(this@Splitter, keyValueSplitter)
 }

 
 companion object {
  @JvmStatic
  
  fun on(
    separator: Char
  ): Splitter {
   return Splitter.on(
    CharMatcher.`is`(separator),
   )
  }

  @JvmStatic
  
  fun on(
    separatorMatcher: CharMatcher
  ): Splitter {
   Preconditions.checkNotNull<CharMatcher>(separatorMatcher)
   return Splitter(
    Strategy { splitter: Splitter, toSplit: CharSequence ->
     return@Strategy object : SplittingIterator(splitter, toSplit) {
      override fun separatorStart_pp_com_google_common_base(start: Int): Int {
       return separatorMatcher.indexIn(
        toSplit_pp_com_google_common_base,
        start,
       )
      }

      override fun separatorEnd_pp_com_google_common_base(separatorPosition: Int): Int {
       return separatorPosition + 1
      }
     }
    },
   )
  }

  @JvmStatic
  
  fun on(
    separator: String
  ): Splitter {
   Preconditions.checkArgument(
    separator.length != 0,
    "The separator may not be the empty string." as Any?,
   )
   if (separator.length == 1) {
    return Splitter.on(
     separator.get(0),
    )
   }
   return Splitter(
    Strategy { splitter: Splitter, toSplit: CharSequence ->
     return@Strategy object : SplittingIterator(splitter, toSplit) {
      public fun separatorStart(start: Int): Int {
       val separatorLength: Int = separator.length
       var p: Int = start
       val last: Int = toSplit_pp_com_google_common_base.length - separatorLength
       while (p <= last) {
        positions_CONTINUE@ do {
         var i: Int = 0
         while (i < separatorLength) {
          if (toSplit_pp_com_google_common_base.get(
           i + p,
          ).code != separator.get(i).code) {
           break@positions_CONTINUE
          }
          i = i + 1
         }
         return p
        } while (false)
        p = p + 1
       }
       return - 1
      }

      public fun separatorEnd(separatorPosition: Int): Int {
       return separatorPosition + separator.length
      }

      override fun separatorStart_pp_com_google_common_base(arg0: Int): Int {
       return separatorStart(arg0)
      }

      override fun separatorEnd_pp_com_google_common_base(arg0: Int): Int {
       return separatorEnd(arg0)
      }
     }
    },
   )
  }

  @JvmStatic
  
  fun on(
    separatorPattern: Pattern
  ): Splitter {
   return Splitter.onPatternInternal(
    JdkPattern(separatorPattern),
   )
  }

  @JvmStatic
  
  fun onPatternInternal(
    separatorPattern: CommonPattern
  ): Splitter {
   Preconditions.checkArgument(
    !separatorPattern.matcher("").matches(),
    "The pattern may not match the empty string: %s" as String,
    separatorPattern as Any?,
   )
   return Splitter(
    Strategy { splitter: Splitter, toSplit: CharSequence ->
     val matcher: CommonMatcher = separatorPattern.matcher(toSplit)
     return@Strategy object : SplittingIterator(splitter, toSplit) {
      public fun separatorStart(start: Int): Int {
       return if (matcher.find(start)) matcher.start() else - 1
      }

      public fun separatorEnd(separatorPosition: Int): Int {
       return matcher.end()
      }

      override fun separatorStart_pp_com_google_common_base(arg0: Int): Int {
       return separatorStart(arg0)
      }

      override fun separatorEnd_pp_com_google_common_base(arg0: Int): Int {
       return separatorEnd(arg0)
      }
     }
    },
   )
  }

  @JvmStatic
  
  fun onPattern(
    separatorPattern: String
  ): Splitter {
   return Splitter.onPatternInternal(
    Platform.compilePattern_pp_com_google_common_base(separatorPattern),
   )
  }

  @JvmStatic
  
  fun fixedLength(
    length: Int
  ): Splitter {
   Preconditions.checkArgument(
    length > 0,
    "The length may not be less than 1" as Any?,
   )
   return Splitter(
    Strategy { splitter: Splitter, toSplit: CharSequence ->
     return@Strategy object : SplittingIterator(splitter, toSplit) {
      public fun separatorStart(start: Int): Int {
       val nextChunkStart: Int = start + length
       return if (nextChunkStart < toSplit_pp_com_google_common_base.length) nextChunkStart else - 1
      }

      public fun separatorEnd(separatorPosition: Int): Int {
       return separatorPosition
      }

      override fun separatorStart_pp_com_google_common_base(arg0: Int): Int {
       return separatorStart(arg0)
      }

      override fun separatorEnd_pp_com_google_common_base(arg0: Int): Int {
       return separatorEnd(arg0)
      }
     }
    },
   )
  }
 }

 
 class MapSplitter {
  private val outerSplitter: Splitter

  private val entrySplitter: Splitter

  internal constructor(outerSplitter: Splitter, entrySplitter: Splitter) {
   this.outerSplitter = outerSplitter
   this.entrySplitter = Preconditions.checkNotNull<Splitter>(entrySplitter)
  }

  
  fun split(
    sequence: CharSequence
  ): MutableMap<String, String> {
   val map: MutableMap<String, String> = LinkedHashMap<String, String>()
   for (entry in this.outerSplitter.split(sequence)) {
    val entryFields: MutableIterator<String> = this.entrySplitter.splittingIterator(
     entry!!,
    )
    Preconditions.checkArgument(
     entryFields.hasNext(),
     MapSplitter.INVALID_ENTRY_MESSAGE as String,
     entry as Any?,
    )
    val key: String? = entryFields.next()
    Preconditions.checkArgument(
     !map.containsKey(key),
     "Duplicate key [%s] found." as String,
     key as Any?,
    )
    Preconditions.checkArgument(
     entryFields.hasNext(),
     MapSplitter.INVALID_ENTRY_MESSAGE as String,
     entry as Any?,
    )
    val value: String? = entryFields.next()
    map.put(
     key!!,
     value!!,
    )
    Preconditions.checkArgument(
     !entryFields.hasNext(),
     MapSplitter.INVALID_ENTRY_MESSAGE as String,
     entry as Any?,
    )
   }
   return Collections.unmodifiableMap<String, String>(map)
  }

  
  companion object {
   private const val INVALID_ENTRY_MESSAGE: String = "Chunk [%s] is not a valid entry"
  }
 }

 
 fun interface Strategy {
  
  fun iterator(
    splitter: Splitter,
    toSplit: CharSequence
  ): MutableIterator<String>
 }

 
 abstract class SplittingIterator: AbstractIterator<String>, MutableIterator<String> {
  @JvmField
  internal val toSplit_pp_com_google_common_base: CharSequence

  @JvmField
  internal val trimmer_pp_com_google_common_base: CharMatcher

  @JvmField
  internal val omitEmptyStrings_pp_com_google_common_base: Boolean

  internal abstract fun separatorStart_pp_com_google_common_base(start: Int): Int

  internal abstract fun separatorEnd_pp_com_google_common_base(separatorPosition: Int): Int

  @JvmField
  internal var offset_pp_com_google_common_base: Int = 0

  @JvmField
  internal var limit_pp_com_google_common_base: Int = 0

  constructor(
    splitter: Splitter,
    toSplit: CharSequence
  ) {
   this.trimmer_pp_com_google_common_base = splitter.trimmer
   this.omitEmptyStrings_pp_com_google_common_base = splitter.omitEmptyStrings
   this.limit_pp_com_google_common_base = splitter.limit
   this.toSplit_pp_com_google_common_base = toSplit
  }

  override fun computeNext(): String? {
   var nextStart: Int = this.offset_pp_com_google_common_base
   while (this.offset_pp_com_google_common_base != - 1) {
    var start: Int = nextStart
    var end: Int = 0
    val separatorPosition: Int = this.separatorStart_pp_com_google_common_base(
     this.offset_pp_com_google_common_base,
    )
    if (separatorPosition == - 1) {
     end = this.toSplit_pp_com_google_common_base.length
     this.offset_pp_com_google_common_base = - 1
    } else {
     end = separatorPosition
     this.offset_pp_com_google_common_base = this.separatorEnd_pp_com_google_common_base(separatorPosition)
    }
    if (this.offset_pp_com_google_common_base == nextStart) {
     this.offset_pp_com_google_common_base = this.offset_pp_com_google_common_base + 1
     if (this.offset_pp_com_google_common_base > this.toSplit_pp_com_google_common_base.length) {
      this.offset_pp_com_google_common_base = - 1
     }
     continue
    }
    while (start < end && this.trimmer_pp_com_google_common_base.matches(
     this.toSplit_pp_com_google_common_base.get(start),
    )) {
     start = start + 1
    }
    while (end > start && this.trimmer_pp_com_google_common_base.matches(
     this.toSplit_pp_com_google_common_base.get(
      end - 1,
     ),
    )) {
     end = end - 1
    }
    if (this.omitEmptyStrings_pp_com_google_common_base && start == end) {
     nextStart = this.offset_pp_com_google_common_base
     continue
    }
    if (this.limit_pp_com_google_common_base == 1) {
     end = this.toSplit_pp_com_google_common_base.length
     this.offset_pp_com_google_common_base = - 1
     while (end > start && this.trimmer_pp_com_google_common_base.matches(
      this.toSplit_pp_com_google_common_base.get(
       end - 1,
      ),
     )) {
      end = end - 1
     }
    } else {
     this.limit_pp_com_google_common_base = this.limit_pp_com_google_common_base - 1
    }
    return this.toSplit_pp_com_google_common_base.subSequence(start, end).toString()
   }
   return this.endOfData()
  }
 }
}
