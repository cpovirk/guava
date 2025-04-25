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

// Generated from "com/google/common/base/Converter.java"
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


import java.io.Serializable



import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableIterable

import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName



abstract class Converter<A: Any, B: Any>: Function<A, B> {
 

 

 constructor(): this(true)

 internal constructor(handleNullAutomatically: Boolean) {}



 
 abstract fun doForward(
   a: A
 ): B

 
 abstract fun doBackward(
   b: B
 ): A

 
 fun convert(
   a: A?
 ): B? { null!! }



 internal open fun correctedDoForward_pp_com_google_common_base(a: A?): B? { null!! }











 internal open fun correctedDoBackward_pp_com_google_common_base(b: B?): A? { null!! }











 





 





 
 open fun convertAll(
   fromIterable: MutableIterable<A>
 ): MutableIterable<B> { null!! }

























 
 open fun reverse(): Converter<B, A> { null!! }









 
 fun <C: Any> andThen(
   secondConverter: Converter<B, C>
 ): Converter<A, C> { null!! }



 internal open fun <C: Any> doAndThen_pp_com_google_common_base(secondConverter: Converter<B, C>): Converter<A, C> { null!! }






 final override fun apply(a: A): B { null!! }



 override fun equals(`object`: Any?): Boolean { null!! }



 
 companion object {
  @JvmStatic
  
  fun <A_1: Any, B_1: Any> from(
    forwardFunction: Function<in A_1, out B_1>,
    backwardFunction: Function<in B_1, out A_1>
  ): Converter<A_1, B_1> { null!! }



  @JvmStatic
  
  fun <T: Any> identity(): Converter<T, T> { null!! }


 }

 
 class ReverseConverter<A: Any, B: Any>: Converter<B, A>, Serializable {
  @JvmField
  internal val original_pp_com_google_common_base: Converter<A, B>

  internal constructor(original: Converter<A, B>) {}



  override fun doForward(b: B): A { null!! }



  override fun doBackward(a: A): B { null!! }



  override fun correctedDoForward_pp_com_google_common_base(b: B?): A? { null!! }



  override fun correctedDoBackward_pp_com_google_common_base(a: A?): B? { null!! }



  override fun reverse(): Converter<A, B> { null!! }



  override fun equals(`object`: Any?): Boolean { null!! }









  override fun hashCode(): Int { null!! }



  override fun toString(): String { null!! }


 }

 
 class ConverterComposition<A: Any, B: Any, C: Any>: Converter<A, C>, Serializable {
  @JvmField
  internal val first_pp_com_google_common_base: Converter<A, B>

  @JvmField
  internal val second_pp_com_google_common_base: Converter<B, C>

  internal constructor(first: Converter<A, B>, second: Converter<B, C>) {}




  override fun doForward(a: A): C { null!! }



  override fun doBackward(c: C): A { null!! }



  override fun correctedDoForward_pp_com_google_common_base(a: A?): C? { null!! }





  override fun correctedDoBackward_pp_com_google_common_base(c: C?): A? { null!! }





  override fun equals(`object`: Any?): Boolean { null!! }











  override fun hashCode(): Int { null!! }



  override fun toString(): String { null!! }


 }

 
 class FunctionBasedConverter<A: Any, B: Any>: Converter<A, B>, Serializable {
  

  

  internal constructor(forwardFunction: Function<in A, out B>, backwardFunction: Function<in B, out A>) {}




  override fun doForward(a: A): B { null!! }



  override fun doBackward(b: B): A { null!! }



  override fun equals(`object`: Any?): Boolean { null!! }











  override fun hashCode(): Int { null!! }



  override fun toString(): String { null!! }


 }

 
 class IdentityConverter<T: Any> internal constructor(): Converter<T, T>(), Serializable {
  override fun doForward(t: T): T { null!! }



  override fun doBackward(t: T): T { null!! }



  override fun reverse(): IdentityConverter<T> { null!! }



  override fun <S: Any> doAndThen_pp_com_google_common_base(otherConverter: Converter<T, S>): Converter<T, S> { null!! }






  override fun toString(): String { null!! }



  



  
  companion object {
   @JvmField
   internal val INSTANCE_pp_com_google_common_base: Converter<*, *> = null!!
  }
 }
}
