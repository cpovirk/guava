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

// Generated from "com/google/common/base/Predicates.java"
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


import com.google.common.base.CommonPattern
import com.google.common.base.Function
import com.google.common.base.JdkPattern
import com.google.common.base.MoreObjects
import com.google.common.base.Objects
import com.google.common.base.Platform
import com.google.common.base.Preconditions
import com.google.common.base.Predicate
import java.io.Serializable
import java.lang.Class
import java.lang.Integer
import java.util.ArrayList
import java.util.Arrays
import java.util.regex.Pattern
import kotlin.Any
import kotlin.Array
import kotlin.Boolean
import kotlin.CharSequence
import kotlin.ClassCastException
import kotlin.Int
import kotlin.NullPointerException
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.MutableCollection
import kotlin.collections.MutableIterable
import kotlin.collections.MutableList
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName
import kotlin.text.StringBuilder


class Predicates {
 private constructor()

 
 companion object {
  @JvmStatic
  
  fun <T> alwaysTrue(): Predicate<T> {
   return ObjectPredicate.ALWAYS_TRUE.withNarrowedType_pp_com_google_common_base<T>()
  }

  @JvmStatic
  
  fun <T> alwaysFalse(): Predicate<T> {
   return ObjectPredicate.ALWAYS_FALSE.withNarrowedType_pp_com_google_common_base<T>()
  }

  @JvmStatic
  
  fun <T> isNull(): Predicate<T> {
   return ObjectPredicate.IS_NULL.withNarrowedType_pp_com_google_common_base<T>()
  }

  @JvmStatic
  
  fun <T> notNull(): Predicate<T> {
   return ObjectPredicate.NOT_NULL.withNarrowedType_pp_com_google_common_base<T>()
  }

  @JvmStatic
  
  fun <T> not(
    predicate: Predicate<T>
  ): Predicate<T> {
   return NotPredicate<T>(predicate)
  }

  @JvmStatic
  
  fun <T> and(
    components: MutableIterable<Predicate<in T>>
  ): Predicate<T> {
   return AndPredicate<T>(
    Predicates.defensiveCopy_pp_com_google_common_base(components),
   )
  }

  @JvmStatic
  
  fun <T> and(
   vararg  components: Predicate<in T>
  ): Predicate<T> {
   val components_1: Array<Predicate<in T>> = components as Array<Predicate<in T>>
   return AndPredicate<T>(
    Predicates.defensiveCopy<Predicate<in T>>(
     *components_1,
    ),
   )
  }

  @JvmStatic
  
  fun <T> and(
    first: Predicate<in T>,
    second: Predicate<in T>
  ): Predicate<T> {
   return AndPredicate<T>(
    Predicates.asList<T>(
     Preconditions.checkNotNull(first),
     Preconditions.checkNotNull(second),
    ),
   )
  }

  @JvmStatic
  
  fun <T> or(
    components: MutableIterable<Predicate<in T>>
  ): Predicate<T> {
   return OrPredicate<T>(
    Predicates.defensiveCopy_pp_com_google_common_base(components),
   )
  }

  @JvmStatic
  
  fun <T> or(
   vararg  components: Predicate<in T>
  ): Predicate<T> {
   val components_1: Array<Predicate<in T>> = components as Array<Predicate<in T>>
   return OrPredicate<T>(
    Predicates.defensiveCopy<Predicate<in T>>(
     *components_1,
    ),
   )
  }

  @JvmStatic
  
  fun <T> or(
    first: Predicate<in T>,
    second: Predicate<in T>
  ): Predicate<T> {
   return OrPredicate<T>(
    Predicates.asList<T>(
     Preconditions.checkNotNull(first),
     Preconditions.checkNotNull(second),
    ),
   )
  }

  @JvmStatic
  
  fun <T> equalTo(
    target: T
  ): Predicate<T> {
   return if (target == null) Predicates.isNull<T>() else IsEqualToPredicate(
    target!!,
   ).withNarrowedType_pp_com_google_common_base<T>()
  }

  @JvmStatic
  
  fun <T> instanceOf(
    clazz: Class<*>
  ): Predicate<T> {
   return InstanceOfPredicate<T>(clazz)
  }

  @JvmStatic
  
  fun <T> `in`(
    target: MutableCollection<out T>
  ): Predicate<T> {
   return InPredicate<T>(target)
  }

  @JvmStatic
  
  fun <A, B> compose(
    predicate: Predicate<B>,
    function: Function<A, out B>
  ): Predicate<A> {
   return CompositionPredicate<A, B>(predicate, function)
  }

  @JvmStatic
  
  fun containsPattern(
    pattern: String
  ): Predicate<CharSequence> {
   return ContainsPatternFromStringPredicate(pattern)
  }

  @JvmStatic
  
  fun contains(
    pattern: Pattern
  ): Predicate<CharSequence> {
   return ContainsPatternPredicate(
    JdkPattern(pattern),
   )
  }

  @JvmStatic
  private fun toStringHelper(methodName: String, components: MutableIterable<*>): String {
   val builder: StringBuilder = StringBuilder("Predicates.").append(methodName).append('(')
   var first: Boolean = true
   for (o in components) {
    if (!first) {
     builder.append(',')
    }
    builder.append(o)
    first = false
   }
   return builder.append(')').toString()
  }

  @JvmStatic
  private fun <T> asList(first: Predicate<in T>, second: Predicate<in T>): MutableList<Predicate<in T>> {
   return Arrays.asList<Predicate<in T>>(first, second)
  }

  @JvmStatic
  private fun <T: Any> defensiveCopy(vararg array: T): MutableList<T> {
   val array_1: Array<T> = array as Array<T>
   return Predicates.defensiveCopy_pp_com_google_common_base<T>(
    Arrays.asList<T>(
     *array_1,
    ) as MutableIterable<T>,
   )
  }

  @JvmStatic
  internal fun <T: Any> defensiveCopy_pp_com_google_common_base(iterable: MutableIterable<T>): MutableList<T> {
   val list: ArrayList<T> = ArrayList<T>()
   for (element in iterable) {
    list.add(
     Preconditions.checkNotNull<T>(element),
    )
   }
   return list
  }
 }

 
 enum class ObjectPredicate: Predicate<Any?> {
  
  ALWAYS_TRUE {
   override fun apply(o: Any?): Boolean {
    return true
   }

   override fun toString(): String {
    return "Predicates.alwaysTrue()"
   }
  },
  
  ALWAYS_FALSE {
   override fun apply(o: Any?): Boolean {
    return false
   }

   override fun toString(): String {
    return "Predicates.alwaysFalse()"
   }
  },
  
  IS_NULL {
   override fun apply(o: Any?): Boolean {
    return o == null
   }

   override fun toString(): String {
    return "Predicates.isNull()"
   }
  },
  
  NOT_NULL {
   override fun apply(o: Any?): Boolean {
    return o != null
   }

   override fun toString(): String {
    return "Predicates.notNull()"
   }
  };

  internal open fun <T> withNarrowedType_pp_com_google_common_base(): Predicate<T> {
   return this as Predicate<T>
  }
 }

 
 open class NotPredicate<T>: Predicate<T>, Serializable {
  @JvmField
  internal val predicate_pp_com_google_common_base: Predicate<T>

  internal constructor(predicate: Predicate<T>) {
   this.predicate_pp_com_google_common_base = Preconditions.checkNotNull<Predicate<T>>(predicate)
  }

  override fun apply(t: T): Boolean {
   return !this.predicate_pp_com_google_common_base.apply(t)
  }

  override fun hashCode(): Int {
   return this.predicate_pp_com_google_common_base.hashCode().inv()
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is NotPredicate<*>) {
    val that: NotPredicate<*>? = obj as NotPredicate<*>?
    return this.predicate_pp_com_google_common_base.equals(
     that!!.predicate_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun toString(): String {
   return "Predicates.not(" + this.predicate_pp_com_google_common_base + ")"
  }
 }

 
 open class AndPredicate<T>: Predicate<T>, Serializable {
  private val components: MutableList<out Predicate<in T>>

  internal constructor(components: MutableList<out Predicate<in T>>) {
   this.components = components
  }

  override fun apply(t: T): Boolean {
   var i: Int = 0
   while (i < this.components.size) {
    if (!this.components.get(i)!!.apply(t)) {
     return false
    }
    i = i + 1
   }
   return true
  }

  override fun hashCode(): Int {
   return this.components.hashCode() + 306654252
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is AndPredicate<*>) {
    val that: AndPredicate<*>? = obj as AndPredicate<*>?
    return this.components.equals(
     that!!.components,
    )
   }
   return false
  }

  override fun toString(): String {
   return Predicates.toStringHelper(
    "and",
    this.components,
   )
  }
 }

 
 open class OrPredicate<T>: Predicate<T>, Serializable {
  private val components: MutableList<out Predicate<in T>>

  internal constructor(components: MutableList<out Predicate<in T>>) {
   this.components = components
  }

  override fun apply(t: T): Boolean {
   var i: Int = 0
   while (i < this.components.size) {
    if (this.components.get(i)!!.apply(t)) {
     return true
    }
    i = i + 1
   }
   return false
  }

  override fun hashCode(): Int {
   return this.components.hashCode() + 87855567
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is OrPredicate<*>) {
    val that: OrPredicate<*>? = obj as OrPredicate<*>?
    return this.components.equals(
     that!!.components,
    )
   }
   return false
  }

  override fun toString(): String {
   return Predicates.toStringHelper(
    "or",
    this.components,
   )
  }
 }

 
 open class IsEqualToPredicate: Predicate<Any?>, Serializable {
  private val target: Any

  internal constructor(target: Any) {
   this.target = target
  }

  override fun apply(o: Any?): Boolean {
   return this.target.equals(o)
  }

  override fun hashCode(): Int {
   return this.target.hashCode()
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is IsEqualToPredicate) {
    val that: IsEqualToPredicate? = obj as IsEqualToPredicate?
    return this.target.equals(
     that!!.target,
    )
   }
   return false
  }

  override fun toString(): String {
   return "Predicates.equalTo(" + this.target + ")"
  }

  internal open fun <T> withNarrowedType_pp_com_google_common_base(): Predicate<T> {
   return this as Predicate<T>
  }
 }

 
 open class InstanceOfPredicate<T>: Predicate<T>, Serializable {
  private val clazz: Class<*>

  internal constructor(clazz: Class<*>) {
   this.clazz = Preconditions.checkNotNull(
    clazz as Class<*>?,
   ) as Class<*>
  }

  override fun apply(o: T): Boolean {
   return this.clazz.isInstance(o)
  }

  override fun hashCode(): Int {
   return this.clazz.hashCode()
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is InstanceOfPredicate<*>) {
    val that: InstanceOfPredicate<*>? = obj as InstanceOfPredicate<*>?
    return this.clazz === that!!.clazz
   }
   return false
  }

  override fun toString(): String {
   return "Predicates.instanceOf(" + this.clazz.getName() + ")"
  }
 }

 
 open class InPredicate<T>: Predicate<T>, Serializable {
  private val target: MutableCollection<*>

  internal constructor(target: MutableCollection<*>) {
   this.target = Preconditions.checkNotNull(target)
  }

  override fun apply(t: T): Boolean {
   try {
    return this.target.contains(t)
   } catch (e: NullPointerException) {
    return false
   } catch (e: ClassCastException) {
    return false
   }
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is InPredicate<*>) {
    val that: InPredicate<*>? = obj as InPredicate<*>?
    return this.target.equals(
     that!!.target,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.target.hashCode()
  }

  override fun toString(): String {
   return "Predicates.in(" + this.target + ")"
  }
 }

 
 open class CompositionPredicate<A, B>: Predicate<A>, Serializable {
  @JvmField
  internal val p_pp_com_google_common_base: Predicate<B>

  @JvmField
  internal val f_pp_com_google_common_base: Function<A, out B>

  internal constructor(p: Predicate<B>, f: Function<A, out B>) {
   this.p_pp_com_google_common_base = Preconditions.checkNotNull<Predicate<B>>(p)
   this.f_pp_com_google_common_base = Preconditions.checkNotNull(f)
  }

  override fun apply(a: A): Boolean {
   return this.p_pp_com_google_common_base.apply(
    this.f_pp_com_google_common_base.apply(a),
   )
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is CompositionPredicate<*, *>) {
    val that: CompositionPredicate<*, *>? = obj as CompositionPredicate<*, *>?
    return this.f_pp_com_google_common_base.equals(
     that!!.f_pp_com_google_common_base,
    ) && this.p_pp_com_google_common_base.equals(
     that!!.p_pp_com_google_common_base,
    )
   }
   return false
  }

  override fun hashCode(): Int {
   return this.f_pp_com_google_common_base.hashCode().xor(
    this.p_pp_com_google_common_base.hashCode(),
   )
  }

  override fun toString(): String {
   return "" + this.p_pp_com_google_common_base + "(" + this.f_pp_com_google_common_base + ")"
  }
 }

 
 open class ContainsPatternPredicate: Predicate<CharSequence>, Serializable {
  @JvmField
  internal val pattern_pp_com_google_common_base: CommonPattern

  internal constructor(pattern: CommonPattern) {
   this.pattern_pp_com_google_common_base = Preconditions.checkNotNull<CommonPattern>(pattern)
  }

  override fun apply(t: CharSequence): Boolean {
   return this.pattern_pp_com_google_common_base.matcher(t).find()
  }

  override fun hashCode(): Int {
   return Objects.hashCode(
    this.pattern_pp_com_google_common_base.pattern(),
    Integer.valueOf(
     this.pattern_pp_com_google_common_base.flags(),
    ),
   )
  }

  override fun equals(obj: Any?): Boolean {
   if (obj is ContainsPatternPredicate) {
    val that: ContainsPatternPredicate? = obj as ContainsPatternPredicate?
    return Objects.equal(
     this.pattern_pp_com_google_common_base.pattern(),
     that!!.pattern_pp_com_google_common_base.pattern(),
    ) && this.pattern_pp_com_google_common_base.flags() == that!!.pattern_pp_com_google_common_base.flags()
   }
   return false
  }

  override fun toString(): String {
   val patternString: String = MoreObjects.toStringHelper(
    this.pattern_pp_com_google_common_base,
   ).add(
    "pattern",
    this.pattern_pp_com_google_common_base.pattern(),
   ).add(
    "pattern.flags",
    this.pattern_pp_com_google_common_base.flags(),
   ).toString()
   return "Predicates.contains(" + patternString + ")"
  }
 }

 
 open class ContainsPatternFromStringPredicate: ContainsPatternPredicate {
  internal constructor(string: String): super(
   Platform.compilePattern_pp_com_google_common_base(string),
  )

  override fun toString(): String {
   return "Predicates.containsPattern(" + this.pattern_pp_com_google_common_base.pattern() + ")"
  }
 }
}
