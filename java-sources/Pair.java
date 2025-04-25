/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.base;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import org.jspecify.annotations.Nullable;

/**
 * A <em>meaningless</em> immutable ordered pair of nullable values, with fieldwise ("value-based")
 * equality. However...
 *
 * <h2>Use records instead</h2>
 *
 * The Java ethos (particularly at Google) places a high value on <b>named semantic types</b>. That
 * means you should usually write your own class and give it a good name. You can use a <a
 * href="http://go/java21walkthrough/records">record class</a> (or <a
 * href="http://go/autovalue/records">occasionally</a> AutoValue). This opens up many opportunities;
 * you might:
 *
 * <ul>
 *   <li>find a good name for the class
 *   <li>find a good name for its fields/accessors
 *   <li>add integrity constraints to the values or the relationship between them
 *   <li>add a useful method or two, perhaps even saving some clients from having to extract the two
 *       values at all
 *   <li>give it a better {@code toString} form
 * </ul>
 *
 * In particular, being able to name your two accessor methods can have a huge effect on call-site
 * readability (compared to {@code getFirst}/{@code getSecond}!).
 *
 * <p>Instead of this:
 *
 * {@snippet :
 *   Pair<Foo, Bar> getFooAndBar() {
 *     return Pair.of(theFoo(), theBar());
 *   }
 *   ...
 *   private void sampleClientCode() {
 *     Pair<Foo, Bar> fooAndBar = getFooAndBar();
 *     doSomethingWithTheBar(fooAndBar.getSecond());
 *   }
 * }
 *
 * <p>do this:
 *
 * {@snippet :
 *   record FooAndBar(Foo foo, Bar bar) {}
 *
 *   FooAndBar getFooAndBar() {
 *     return new FooAndBar(theFoo(), theBar());
 *   }
 *   ...
 *   private void sampleClientCode() {
 *     FooAndBar fooAndBar = getFooAndBar();
 *     doSomethingWithTheBar(fooAndBar.bar());
 *   }
 * }
 *
 * <p>You may also be able to add helpful methods to {@code FooAndBar} and give it a more meaningful
 * name.
 *
 * <h3>If you do use this class</h3>
 *
 * {@code Pair} is subclassable and also has public fields, neither of which is disastrous, but
 * neither of which was a good decision either. Avoid subclassing it or accessing its fields
 * directly if you can.
 *
 * @author kevinb@google.com (Kevin Bourrillion)
 */
public class Pair<A extends @Nullable Object, B extends @Nullable Object> implements Serializable {

  /** Creates a new pair containing the given elements in order. */
  public static <A extends @Nullable Object, B extends @Nullable Object> Pair<A, B> of(
      @ParametricNullness A first, @ParametricNullness B second) {
    return new Pair<>(first, second);
  }

  /** The first element of the pair. */
  @ParametricNullness public final A first;

  /** The second element of the pair. */
  @ParametricNullness public final B second;

  /** For subclass usage only. To create a new pair, use {@code Pair.of(first, second)}. */
  protected Pair(@ParametricNullness A first, @ParametricNullness B second) {
    this.first = first;
    this.second = second;
  }

  /** Returns the first element of this pair. */
  @ParametricNullness
  public A getFirst() {
    return first;
  }

  /** Returns the second element of this pair. */
  @ParametricNullness
  public B getSecond() {
    return second;
  }

  /** Returns a function that yields {@link #first}. */
  @SuppressWarnings("unchecked") // implementation is "fully variant"
  public static <A extends @Nullable Object, B extends @Nullable Object>
      Function<Pair<A, B>, A> firstFunction() {
    return (Function) PairFirstFunction.INSTANCE;
  }

  /** Returns a function that yields {@link #second}. */
  @SuppressWarnings("unchecked") // implementation is "fully variant"
  public static <A extends @Nullable Object, B extends @Nullable Object>
      Function<Pair<A, B>, B> secondFunction() {
    return (Function) PairSecondFunction.INSTANCE;
  }

  /*
   * If we use the enum singleton pattern for these functions, Flume's type
   * inference chokes: http://b/4863010
   */

  /*
   * Note that this implementation doesn't involve B, and A's are only "passed
   * through", so it has become "fully variant" in both parameters.
   */
  private static final class PairFirstFunction<
          A extends @Nullable Object, B extends @Nullable Object>
      implements Function<Pair<A, B>, A>, Serializable {
    static final Function<Pair<Object, Object>, Object> INSTANCE = new PairFirstFunction<>();

    @Override
    @ParametricNullness
    public A apply(Pair<A, B> from) {
      return from.getFirst();
    }

    private Object readResolve() {
      return INSTANCE;
    }
  }

  /*
   * Note that this implementation doesn't involve A, and B's are only "passed
   * through", so it has become "fully variant" in both parameters.
   */
  private static final class PairSecondFunction<
          A extends @Nullable Object, B extends @Nullable Object>
      implements Function<Pair<A, B>, B>, Serializable {
    static final Function<Pair<Object, Object>, Object> INSTANCE = new PairSecondFunction<>();

    @Override
    @ParametricNullness
    public B apply(Pair<A, B> from) {
      return from.getSecond();
    }

    private Object readResolve() {
      return INSTANCE;
    }
  }

  /**
   * Returns a comparator that compares two Pair objects by comparing the result of {@link
   * #getFirst()} for each.
   */
  @SuppressWarnings("unchecked") // safe contravariant cast
  public static <A extends Comparable<? super A>, B extends @Nullable Object>
      Comparator<Pair<A, B>> compareByFirst() {
    return (Comparator) FirstComparator.FIRST_COMPARATOR;
  }

  /**
   * Returns a comparator that compares two Pair objects by comparing the result of {@link
   * #getSecond()} for each.
   */
  @SuppressWarnings("unchecked") // safe contravariant cast
  public static <A extends @Nullable Object, B extends Comparable<? super B>>
      Comparator<Pair<A, B>> compareBySecond() {
    return (Comparator) SecondComparator.SECOND_COMPARATOR;
  }

  private enum FirstComparator implements Comparator<Pair<Comparable<?>, @Nullable Object>> {
    FIRST_COMPARATOR;

    @Override
    public int compare(
        Pair<Comparable<?>, @Nullable Object> pair1, Pair<Comparable<?>, @Nullable Object> pair2) {
      @SuppressWarnings("unchecked")
      Comparable<Object> left = (Comparable<Object>) pair1.getFirst();
      Comparable<?> right = pair2.getFirst();

      /*
       * Technically unsafe, but tolerable. If the comparables are badly
       * behaved, this comparator will be equally badly behaved.
       */
      int result = left.compareTo(right);
      return result;
    }
  }

  private enum SecondComparator implements Comparator<Pair<@Nullable Object, Comparable<?>>> {
    SECOND_COMPARATOR;

    @Override
    public int compare(
        Pair<@Nullable Object, Comparable<?>> pair1, Pair<@Nullable Object, Comparable<?>> pair2) {
      @SuppressWarnings("unchecked")
      Comparable<Object> left = (Comparable<Object>) pair1.getSecond();
      Comparable<?> right = pair2.getSecond();

      /*
       * Technically unsafe, but tolerable. If the comparables are badly
       * behaved, this comparator will be equally badly behaved.
       */
      int result = left.compareTo(right);
      return result;
    }
  }

  // TODO(kevinb): decide what level of commitment to make to this impl
  @Override
  public boolean equals(@Nullable Object object) {
    // TODO(kevinb): it is possible we want to change this to
    // if (object != null && object.getClass() == getClass()) {
    if (object instanceof Pair) {
      Pair<?, ?> that = (Pair<?, ?>) object;
      return Objects.equal(this.getFirst(), that.getFirst())
          && Objects.equal(this.getSecond(), that.getSecond());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash1 = first == null ? 0 : first.hashCode();
    int hash2 = second == null ? 0 : second.hashCode();
    return 31 * hash1 + hash2;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation returns a string in the form {@code (first, second)}, where {@code
   * first} and {@code second} are the String representations of the first and second elements of
   * this pair, as given by {@link String#valueOf(Object)}. Subclasses are free to override this
   * behavior.
   */
  @Override
  public String toString() {
    // GWT doesn't support String.format().
    return "(" + getFirst() + ", " + getSecond() + ")";
  }

  @Serial private static final long serialVersionUID = 747826592375603043L;
}
