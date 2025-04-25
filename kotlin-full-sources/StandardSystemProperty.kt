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

// Generated from "com/google/common/base/StandardSystemProperty.java"
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


import java.lang.System
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName


enum class StandardSystemProperty {
 
 JAVA_VERSION("java.version"),
 
 JAVA_VENDOR("java.vendor"),
 
 JAVA_VENDOR_URL("java.vendor.url"),
 
 JAVA_HOME("java.home"),
 
 JAVA_VM_SPECIFICATION_VERSION("java.vm.specification.version"),
 
 JAVA_VM_SPECIFICATION_VENDOR("java.vm.specification.vendor"),
 
 JAVA_VM_SPECIFICATION_NAME("java.vm.specification.name"),
 
 JAVA_VM_VERSION("java.vm.version"),
 
 JAVA_VM_VENDOR("java.vm.vendor"),
 
 JAVA_VM_NAME("java.vm.name"),
 
 JAVA_SPECIFICATION_VERSION("java.specification.version"),
 
 JAVA_SPECIFICATION_VENDOR("java.specification.vendor"),
 
 JAVA_SPECIFICATION_NAME("java.specification.name"),
 
 JAVA_CLASS_VERSION("java.class.version"),
 
 JAVA_CLASS_PATH("java.class.path"),
 
 JAVA_LIBRARY_PATH("java.library.path"),
 
 JAVA_IO_TMPDIR("java.io.tmpdir"),
 
 JAVA_COMPILER("java.compiler"),
 
 JAVA_EXT_DIRS("java.ext.dirs"),
 
 OS_NAME("os.name"),
 
 OS_ARCH("os.arch"),
 
 OS_VERSION("os.version"),
 
 FILE_SEPARATOR("file.separator"),
 
 PATH_SEPARATOR("path.separator"),
 
 LINE_SEPARATOR("line.separator"),
 
 USER_NAME("user.name"),
 
 USER_HOME("user.home"),
 
 USER_DIR("user.dir");

 private val key: String

 constructor(key: String) {
  this.key = key
 }

 
 fun key(): String {
  return this.key
 }

 
 fun value(): String? {
  return System.getProperty(
   this.key,
  )
 }

 override fun toString(): String {
  return this.key() + "=" + this.value()
 }
}
