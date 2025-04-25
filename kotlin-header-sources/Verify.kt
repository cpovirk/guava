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

// Generated from "com/google/common/base/Verify.java"
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






import kotlin.Any

import kotlin.Boolean
import kotlin.Char
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName


class Verify {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun verify(
    expression: Boolean
  ) {}





  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
   vararg  errorMessageArgs: Any?
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char
  ) {}










  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int
  ) {}










  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long
  ) {}










  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?
  ) {}







  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Char
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Char
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Char
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Char
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Int
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Int
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Int
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Int
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Long
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Long
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Long
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Long
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Any?
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Any?
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Any?
  ) {}











  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?
  ) {}







  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?
  ) {}







  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?,
    p4: Any?
  ) {}







  @JvmStatic
  
  fun <T: Any> verifyNotNull(
    reference: T?
  ): T { null!! }



  @JvmStatic
  
  fun <T: Any> verifyNotNull(
    reference: T?,
    errorMessageTemplate: String,
   vararg  errorMessageArgs: Any?
  ): T { null!! }











 }
}
