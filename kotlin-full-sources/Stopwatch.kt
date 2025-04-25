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

// Generated from "com/google/common/base/Stopwatch.java"
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
import com.google.common.base.Ticker
import java.lang.AssertionError
import java.util.concurrent.TimeUnit
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class Stopwatch {
 private val ticker: Ticker

 private var isRunning: Boolean = false

 private var elapsedNanos: Long = 0L

 private var startTick: Long = 0L

 internal constructor() {
  this.ticker = Ticker.systemTicker()
 }

 internal constructor(ticker: Ticker) {
  this.ticker = Preconditions.checkNotNull<Ticker>(
   ticker as Ticker?,
   "ticker" as Any?,
  )
 }

 
 fun isRunning(): Boolean {
  return this.isRunning
 }

 
 fun start(): Stopwatch {
  Preconditions.checkState(
   !this.isRunning,
   "This stopwatch is already running." as Any?,
  )
  this.isRunning = true
  this.startTick = this.ticker.read()
  return this
 }

 
 fun stop(): Stopwatch {
  val tick: Long = this.ticker.read()
  Preconditions.checkState(
   this.isRunning,
   "This stopwatch is already stopped." as Any?,
  )
  this.isRunning = false
  this.elapsedNanos = this.elapsedNanos + (tick - this.startTick)
  return this
 }

 
 fun reset(): Stopwatch {
  this.elapsedNanos = 0L
  this.isRunning = false
  return this
 }

 private fun elapsedNanos(): Long {
  return if (this.isRunning) this.ticker.read() - this.startTick + this.elapsedNanos else this.elapsedNanos
 }

 
 fun elapsed(
   desiredUnit: TimeUnit
 ): Long {
  return desiredUnit.convert(
   this.elapsedNanos(),
   TimeUnit.NANOSECONDS,
  )
 }

 override fun toString(): String {
  val nanos: Long = this.elapsedNanos()
  val unit: TimeUnit = Stopwatch.chooseUnit(nanos)
  val value: Double = nanos.toDouble() / TimeUnit.NANOSECONDS.convert(
   1.toLong(),
   unit,
  ).toDouble()
  return Platform.formatCompact4Digits_pp_com_google_common_base(value) + " " + Stopwatch.abbreviate(unit)
 }

 
 companion object {
  @JvmStatic
  
  fun createUnstarted(): Stopwatch {
   return Stopwatch()
  }

  @JvmStatic
  
  fun createUnstarted(
    ticker: Ticker
  ): Stopwatch {
   return Stopwatch(ticker)
  }

  @JvmStatic
  
  fun createStarted(): Stopwatch {
   return Stopwatch().start()
  }

  @JvmStatic
  
  fun createStarted(
    ticker: Ticker
  ): Stopwatch {
   return Stopwatch(ticker).start()
  }

  @JvmStatic
  private fun chooseUnit(nanos: Long): TimeUnit {
   if (TimeUnit.DAYS.convert(
    nanos,
    TimeUnit.NANOSECONDS,
   ) > 0.toLong()) {
    return TimeUnit.DAYS
   }
   if (TimeUnit.HOURS.convert(
    nanos,
    TimeUnit.NANOSECONDS,
   ) > 0.toLong()) {
    return TimeUnit.HOURS
   }
   if (TimeUnit.MINUTES.convert(
    nanos,
    TimeUnit.NANOSECONDS,
   ) > 0.toLong()) {
    return TimeUnit.MINUTES
   }
   if (TimeUnit.SECONDS.convert(
    nanos,
    TimeUnit.NANOSECONDS,
   ) > 0.toLong()) {
    return TimeUnit.SECONDS
   }
   if (TimeUnit.MILLISECONDS.convert(
    nanos,
    TimeUnit.NANOSECONDS,
   ) > 0.toLong()) {
    return TimeUnit.MILLISECONDS
   }
   if (TimeUnit.MICROSECONDS.convert(
    nanos,
    TimeUnit.NANOSECONDS,
   ) > 0.toLong()) {
    return TimeUnit.MICROSECONDS
   }
   return TimeUnit.NANOSECONDS
  }

  @JvmStatic
  private fun abbreviate(unit: TimeUnit): String {
   when (unit) {
    TimeUnit.NANOSECONDS -> {
     return "ns"
    }
    TimeUnit.MICROSECONDS -> {
     return "\u03BCs"
    }
    TimeUnit.MILLISECONDS -> {
     return "ms"
    }
    TimeUnit.SECONDS -> {
     return "s"
    }
    TimeUnit.MINUTES -> {
     return "min"
    }
    TimeUnit.HOURS -> {
     return "h"
    }
    TimeUnit.DAYS -> {
     return "d"
    }
    else -> {}
   }
   throw AssertionError()
  }
 }
}
