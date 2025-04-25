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

// Generated from "com/google/common/base/Throwables.java"
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


import com.google.common.base.Preconditions
import java.io.PrintWriter
import java.io.StringWriter
import java.lang.Class
import java.lang.IllegalArgumentException
import java.util.ArrayList
import java.util.Collections
import kotlin.Boolean
import kotlin.ClassCastException
import kotlin.Error
import kotlin.OptIn
import kotlin.RuntimeException
import kotlin.String
import kotlin.Suppress
import kotlin.Throwable
import kotlin.collections.MutableList
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.jvm.Throws
import kotlin.native.ObjCName
import kotlin.run


class Throwables {
 private constructor()

 
 companion object {
  @JvmStatic
  
  @Throws(Throwable::class)
  fun <X: Throwable> throwIfInstanceOf(
    throwable: Throwable,
    declaredType: Class<X>
  ) {
   Preconditions.checkNotNull<Throwable>(throwable)
   if (declaredType.isInstance(throwable)) {
    throw declaredType.cast(throwable)!!
   }
  }

  @JvmStatic
  
  fun throwIfUnchecked(
    throwable: Throwable
  ) {
   Preconditions.checkNotNull<Throwable>(throwable)
   if (throwable is RuntimeException) {
    throw throwable as RuntimeException
   }
   if (throwable is Error) {
    throw throwable as Error
   }
  }

  @JvmStatic
  
  fun getRootCause(
    throwable: Throwable
  ): Throwable {
   var throwable_1: Throwable? = throwable
   var slowPointer: Throwable? = throwable_1
   var advanceSlowPointer: Boolean = false
   var cause: Throwable? = null
   while (run {
    cause = throwable_1!!.cause
    cause
   } != null) {
    throwable_1 = cause
    if (throwable_1 === slowPointer) {
     throw IllegalArgumentException("Loop in causal chain detected.", throwable_1)
    }
    if (advanceSlowPointer) {
     slowPointer = slowPointer!!.cause
    }
    advanceSlowPointer = !advanceSlowPointer
   }
   return throwable_1!!
  }

  @JvmStatic
  
  fun getCausalChain(
    throwable: Throwable
  ): MutableList<Throwable> {
   var throwable_1: Throwable? = throwable
   Preconditions.checkNotNull<Throwable>(throwable_1)
   val causes: MutableList<Throwable> = ArrayList<Throwable>(4)
   causes.add(
    throwable_1!!,
   )
   var slowPointer: Throwable? = throwable_1
   var advanceSlowPointer: Boolean = false
   var cause: Throwable? = null
   while (run {
    cause = throwable_1!!.cause
    cause
   } != null) {
    throwable_1 = cause
    causes.add(
     throwable_1!!,
    )
    if (throwable_1 === slowPointer) {
     throw IllegalArgumentException("Loop in causal chain detected.", throwable_1)
    }
    if (advanceSlowPointer) {
     slowPointer = slowPointer!!.cause
    }
    advanceSlowPointer = !advanceSlowPointer
   }
   return Collections.unmodifiableList<Throwable>(causes)
  }

  @JvmStatic
  
  fun <X: Throwable> getCauseAs(
    throwable: Throwable,
    expectedCauseType: Class<X>
  ): X? {
   try {
    return expectedCauseType.cast(
     throwable.cause,
    )
   } catch (e: ClassCastException) {
    e.initCause(throwable)
    throw e
   }
  }

  @JvmStatic
  
  fun getStackTraceAsString(
    throwable: Throwable
  ): String {
   val stringWriter: StringWriter = StringWriter()
   throwable.printStackTrace(
    PrintWriter(stringWriter),
   )
   return stringWriter.toString()
  }
 }
}
