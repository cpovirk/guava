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

// Generated from "com/google/common/base/JdkPattern.java"
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


import com.google.common.base.CommonMatcher
import com.google.common.base.CommonPattern
import com.google.common.base.Preconditions
import java.io.Serializable
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.Boolean
import kotlin.CharSequence
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.native.ObjCName


class JdkPattern: CommonPattern, Serializable {
 private val pattern: Pattern

 internal constructor(pattern: Pattern) {
  this.pattern = Preconditions.checkNotNull<Pattern>(pattern)
 }

 override fun matcher(t: CharSequence): CommonMatcher {
  return JdkMatcher(
   this@JdkPattern.pattern.matcher(t),
  )
 }

 override fun pattern(): String {
  return this.pattern.pattern()
 }

 override fun flags(): Int {
  return this.pattern.flags()
 }

 override fun toString(): String {
  return this.pattern.toString()
 }

 
 class JdkMatcher: CommonMatcher {
  @JvmField
  internal val matcher_pp_com_google_common_base: Matcher

  internal constructor(matcher: Matcher) {
   this.matcher_pp_com_google_common_base = Preconditions.checkNotNull<Matcher>(matcher)
  }

  override fun matches(): Boolean {
   return this.matcher_pp_com_google_common_base.matches()
  }

  override fun find(): Boolean {
   return this.matcher_pp_com_google_common_base.find()
  }

  override fun find(index: Int): Boolean {
   return this.matcher_pp_com_google_common_base.find(index)
  }

  override fun replaceAll(replacement: String): String {
   return this.matcher_pp_com_google_common_base.replaceAll(replacement)
  }

  override fun end(): Int {
   return this.matcher_pp_com_google_common_base.end()
  }

  override fun start(): Int {
   return this.matcher_pp_com_google_common_base.start()
  }
 }
}
