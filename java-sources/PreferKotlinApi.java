package com.google.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a call from Kotlin code to the annotated Java API should be replaced with an
 * equivalent Kotlin expression.
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface PreferKotlinApi {

  /**
   * A Kotlin expression to replace the Java call with. If no value is provided, then this field is
   * ignored and no replacement is made.
   */
  String replacement() default "";

  /**
   * The new imports to add to the caller. Must contain any symbol used in {@link #replacement()}
   * that may have to be imported. If no value is provided for replacement, this must be empty.
   */
  String[] imports() default {};

  /**
   * A comment to show Kotlin callers of the annotated method. This field is required if no value is
   * provided for {@link #replacement()}.
   */
  String comment() default "";
}
