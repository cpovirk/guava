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

// Generated from "com/google/common/base/Preconditions.java"
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
import com.google.common.base.Strings
import java.lang.Character
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.IndexOutOfBoundsException
import java.lang.Integer
import java.lang.NullPointerException
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


class Preconditions {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun checkArgument(
    expression: Boolean
  ) {
   if (!expression) {
    throw IllegalArgumentException()
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessage: Any?
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.stringValueOf_pp_com_google_common_base(errorMessage),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
   vararg  errorMessageArgs: Any?
  ) {
   val errorMessageArgs_1: Array<Any?>? = errorMessageArgs as Array<Any?>?
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      *errorMessageArgs_1!!,
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Char
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Int
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Long
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Any?
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      Character.valueOf(p1),
      p2,
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Char
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Int
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Long
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Any?
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      Integer.valueOf(p1),
      p2,
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Char
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Int
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Long
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Any?
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      p2,
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Char
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      p1,
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Int
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      p1,
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Long
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      p1,
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String?,
    p1: Any?,
    p2: Any?
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1, p2),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1, p2, p3),
    )
   }
  }

  @JvmStatic
  
  fun checkArgument(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?,
    p4: Any?
  ) {
   if (!expression) {
    throw IllegalArgumentException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1, p2, p3, p4),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean
  ) {
   if (!expression) {
    throw IllegalStateException()
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessage: Any?
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.stringValueOf_pp_com_google_common_base(errorMessage),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String?,
   vararg  errorMessageArgs: Any?
  ) {
   val errorMessageArgs_1: Array<Any?>? = errorMessageArgs as Array<Any?>?
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      *errorMessageArgs_1!!,
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Char
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Int
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Long
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Char,
    p2: Any?
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      Character.valueOf(p1),
      p2,
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Char
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Int
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Long
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Int,
    p2: Any?
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      Integer.valueOf(p1),
      p2,
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Char
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Int
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Long
  ) {
   if (!expression) {
    throw IllegalStateException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Long,
    p2: Any?
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      p2,
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Char
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      p1,
      Character.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Int
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      p1,
      Integer.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Long
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      p1,
      java.lang.Long.valueOf(p2),
     ),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1, p2),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1, p2, p3),
    )
   }
  }

  @JvmStatic
  
  fun checkState(
    expression: Boolean,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?,
    p4: Any?
  ) {
   if (!expression) {
    throw IllegalStateException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1, p2, p3, p4),
    )
   }
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?
  ): T {
   if (reference == null) {
    throw NullPointerException()
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessage: Any?
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.stringValueOf_pp_com_google_common_base(errorMessage),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
   vararg  errorMessageArgs: Any?
  ): T {
   val errorMessageArgs_1: Array<Any?>? = errorMessageArgs as Array<Any?>?
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      *errorMessageArgs_1!!,
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Char
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Int
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Long
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Any?
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Char,
    p2: Char
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Char,
    p2: Int
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Char,
    p2: Long
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Character.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Char,
    p2: Any?
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      Character.valueOf(p1),
      p2,
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Int,
    p2: Char
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Int,
    p2: Int
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Int,
    p2: Long
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      Integer.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Int,
    p2: Any?
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      Integer.valueOf(p1),
      p2,
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Long,
    p2: Char
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      Character.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Long,
    p2: Int
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      Integer.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Long,
    p2: Long
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Strings.lenientFormat(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      java.lang.Long.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Long,
    p2: Any?
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      java.lang.Long.valueOf(p1),
      p2,
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Char
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      p1,
      Character.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Int
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      p1,
      Integer.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Long
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(
      errorMessageTemplate,
      p1,
      java.lang.Long.valueOf(p2),
     ),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1, p2),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1, p2, p3),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun <T: Any> checkNotNull(
    reference: T?,
    errorMessageTemplate: String,
    p1: Any?,
    p2: Any?,
    p3: Any?,
    p4: Any?
  ): T {
   if (reference == null) {
    throw NullPointerException(
     Platform.lenientFormat_pp_com_google_common_base(errorMessageTemplate, p1, p2, p3, p4),
    )
   }
   return reference!!
  }

  @JvmStatic
  
  fun checkElementIndex(
    index: Int,
    size: Int
  ): Int {
   return Preconditions.checkElementIndex(index, size, "index")
  }

  @JvmStatic
  
  fun checkElementIndex(
    index: Int,
    size: Int,
    desc: String
  ): Int {
   if (index < 0 || index >= size) {
    throw IndexOutOfBoundsException(
     Preconditions.badElementIndex(index, size, desc),
    )
   }
   return index
  }

  @JvmStatic
  private fun badElementIndex(index: Int, size: Int, desc: String): String {
   if (index < 0) {
    return Strings.lenientFormat(
     "%s (%s) must not be negative",
     desc,
     Integer.valueOf(index),
    )
   } else if (size < 0) {
    throw IllegalArgumentException(
     "negative size: " + size,
    )
   } else {
    return Strings.lenientFormat(
     "%s (%s) must be less than size (%s)",
     desc,
     Integer.valueOf(index),
     Integer.valueOf(size),
    )
   }
  }

  @JvmStatic
  
  fun checkPositionIndex(
    index: Int,
    size: Int
  ): Int {
   return Preconditions.checkPositionIndex(index, size, "index")
  }

  @JvmStatic
  
  fun checkPositionIndex(
    index: Int,
    size: Int,
    desc: String
  ): Int {
   if (index < 0 || index > size) {
    throw IndexOutOfBoundsException(
     Preconditions.badPositionIndex(index, size, desc),
    )
   }
   return index
  }

  @JvmStatic
  private fun badPositionIndex(index: Int, size: Int, desc: String): String {
   if (index < 0) {
    return Strings.lenientFormat(
     "%s (%s) must not be negative",
     desc,
     Integer.valueOf(index),
    )
   } else if (size < 0) {
    throw IllegalArgumentException(
     "negative size: " + size,
    )
   } else {
    return Strings.lenientFormat(
     "%s (%s) must not be greater than size (%s)",
     desc,
     Integer.valueOf(index),
     Integer.valueOf(size),
    )
   }
  }

  @JvmStatic
  
  fun checkPositionIndexes(
    start: Int,
    end: Int,
    size: Int
  ) {
   if (start < 0 || end < start || end > size) {
    throw IndexOutOfBoundsException(
     Preconditions.badPositionIndexes(start, end, size),
    )
   }
  }

  @JvmStatic
  private fun badPositionIndexes(start: Int, end: Int, size: Int): String {
   if (start < 0 || start > size) {
    return Preconditions.badPositionIndex(start, size, "start index")
   }
   if (end < 0 || end > size) {
    return Preconditions.badPositionIndex(end, size, "end index")
   }
   return Strings.lenientFormat(
    "end index (%s) must not be less than start index (%s)",
    Integer.valueOf(end),
    Integer.valueOf(start),
   )
  }
 }

 
 interface Impossible
}
