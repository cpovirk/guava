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
 "REDUNDANT_ELSE_IN_WHEN")

package com.google.common.base


import com.google.common.base.Strings
import com.google.common.base.VerifyException
import java.lang.Character
import java.lang.Integer
import kotlin.Any
import kotlin.Array
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
  ) {
   if (!expression) {
    throw VerifyException()
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
   vararg  errorMessageArgs: Any?
  ) {
   val errorMessageArgs_1: Array<Any?>? = errorMessageArgs as Array<Any?>?
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      *errorMessageArgs_1!!,
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(errorMessageTemplate, p1),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Char
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Char
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Char
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Char
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      p1,
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Int
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Int
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Int
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Int
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      p1,
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Long
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Long
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Long
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Long
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      p1,
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Any?
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      p2,
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Any?
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      p2,
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Any?
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      p2,
     ),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(errorMessageTemplate, p1, p2),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(errorMessageTemplate, p1, p2, p3),
    )
   }
  }

  @JvmStatic
  
  fun verify(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?,
    p4: Any?
  ) {
   if (!expression) {
    throw VerifyException(
     Strings.lenientFormat(errorMessageTemplate, p1, p2, p3, p4),
    )
   }
  }

  @JvmStatic
  
  fun <T: Any> verifyNotNull(
    reference: T?
  ): T {
   return Verify.verifyNotNull<T>(reference, "expected a non-null reference")
  }

  @JvmStatic
  
  fun <T: Any> verifyNotNull(
    reference: T?,
    errorMessageTemplate: String,
   vararg  errorMessageArgs: Any?
  ): T {
   val errorMessageArgs_1: Array<Any?>? = errorMessageArgs as Array<Any?>?
   if (reference == null) {
    throw VerifyException(
     Strings.lenientFormat(
      errorMessageTemplate,
      *errorMessageArgs_1!!,
     ),
    )
   }
   return reference!!
  }
 }
}
