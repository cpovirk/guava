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

// Generated from "com/google/common/base/Randoms.java"
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


import java.lang.ThreadLocal
import java.lang.UnsupportedOperationException
import java.security.SecureRandom
import java.util.Objects
import java.util.Random
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class Randoms {
 private constructor()

 
 companion object {
  private val random: Random = ReadOnlyRandom()

  private val secureRandom: SecureRandom = Randoms.newDefaultSecureRandom()

  private val threadLocalSecureRandom: Random = ThreadLocalSecureRandom()

  @JvmStatic
  
  fun secureRandom(): SecureRandom {
   return Randoms.secureRandom
  }

  @JvmStatic
  
  fun secureRandom(
    seed: ByteArray
  ): SecureRandom {
   val retval: SecureRandom = SecureRandom(seed)
   retval.nextLong()
   return retval
  }

  @JvmStatic
  
  fun threadLocalSecureRandom(): Random {
   return Randoms.threadLocalSecureRandom
  }

  @JvmStatic
  
  fun insecureRandom(): Random {
   return Randoms.random
  }

  @JvmStatic
  
  fun insecureRandom(
    seed: Long
  ): Random {
   return Random(seed)
  }

  @JvmStatic
  private fun newDefaultSecureRandom(): SecureRandom {
   val retval: SecureRandom = SecureRandom()
   retval.nextLong()
   return retval
  }

  private val localRandom: ThreadLocal<SecureRandom> = object : ThreadLocal<SecureRandom>() {
   override fun initialValue(): SecureRandom {
    return Randoms.newDefaultSecureRandom()
   }
  }
 }

 
 open class ReadOnlyRandom: Random {
  private var initializationComplete: Boolean = false

  internal constructor() {
   this.initializationComplete = true
  }

  override fun setSeed(seed: Long) {
   if (this.initializationComplete) {
    throw UnsupportedOperationException("Setting the seed on the shared Random object is not permitted")
   }
   super<Random>.setSeed(seed)
  }
 }

 
 class ThreadLocalSecureRandom: Random {
  private var initializationComplete: Boolean = false

  internal constructor() {
   this.initializationComplete = true
  }

  internal fun current_pp_com_google_common_base(): SecureRandom {
   return Objects.requireNonNull<SecureRandom>(
    Randoms.localRandom.get(),
   )
  }

  override fun next(bits: Int): Int {
   throw UnsupportedOperationException()
  }

  override fun nextBoolean(): Boolean {
   return this.current_pp_com_google_common_base().nextBoolean()
  }

  override fun nextBytes(bytes: ByteArray) {
   this.current_pp_com_google_common_base().nextBytes(bytes)
  }

  override fun nextDouble(): Double {
   return this.current_pp_com_google_common_base().nextDouble()
  }

  override fun nextFloat(): Float {
   return this.current_pp_com_google_common_base().nextFloat()
  }

  override fun nextGaussian(): Double {
   return this.current_pp_com_google_common_base().nextGaussian()
  }

  override fun nextInt(): Int {
   return this.current_pp_com_google_common_base().nextInt()
  }

  override fun nextInt(n: Int): Int {
   return this.current_pp_com_google_common_base().nextInt(n)
  }

  override fun nextLong(): Long {
   return this.current_pp_com_google_common_base().nextLong()
  }

  override fun setSeed(seed: Long) {
   if (this.initializationComplete) {
    throw UnsupportedOperationException("Setting the seed on a thread-local Random object is not permitted")
   }
   super<Random>.setSeed(seed)
  }
 }
}
