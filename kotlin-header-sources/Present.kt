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

// Generated from "com/google/common/base/Present.java"
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


import com.google.common.base.Function
import com.google.common.base.Optional

import com.google.common.base.Supplier

import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableSet
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName


class Present<T: Any>: Optional<T> {
 

 internal constructor(reference: T) {}



 override fun isPresent(): Boolean { null!! }



 override fun get(): T { null!! }



 override fun or(defaultValue: T): T { null!! }







 override fun or(secondChoice: Optional<out T>): Optional<T> { null!! }




 override fun or(supplier: Supplier<out T>): T { null!! }




 override fun orNull(): T { null!! }



 override fun asSet(): MutableSet<T> { null!! }





 override fun <V: Any> transform(function: Function<in T, V>): Optional<V> { null!! }










 override fun equals(obj: Any?): Boolean { null!! }









 override fun hashCode(): Int { null!! }



 override fun toString(): String { null!! }


}
