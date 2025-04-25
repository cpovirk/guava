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
 "REDUNDANT_ELSE_IN_WHEN", "MUST_BE_INITIALIZED", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT", "UNINITIALIZED_VARIABLE")

package com.google.common.base




import java.security.SecureRandom

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
  

  

  

  @JvmStatic
  
  fun secureRandom(): SecureRandom { null!! }



  @JvmStatic
  
  fun secureRandom(
    seed: ByteArray
  ): SecureRandom { null!! }





  @JvmStatic
  
  fun threadLocalSecureRandom(): Random { null!! }



  @JvmStatic
  
  fun insecureRandom(): Random { null!! }



  @JvmStatic
  
  fun insecureRandom(
    seed: Long
  ): Random { null!! }



  






  




 }

 
 open class ReadOnlyRandom: Random {
  

  internal constructor() {}



  override fun setSeed(seed: Long) {}





 }

 
 class ThreadLocalSecureRandom: Random {
  

  internal constructor() {}



  internal fun current_pp_com_google_common_base(): SecureRandom { null!! }





  override fun next(bits: Int): Int { null!! }



  override fun nextBoolean(): Boolean { null!! }



  override fun nextBytes(bytes: ByteArray) {}



  override fun nextDouble(): Double { null!! }



  override fun nextFloat(): Float { null!! }



  override fun nextGaussian(): Double { null!! }



  override fun nextInt(): Int { null!! }



  override fun nextInt(n: Int): Int { null!! }



  override fun nextLong(): Long { null!! }



  override fun setSeed(seed: Long) {}





 }
}
