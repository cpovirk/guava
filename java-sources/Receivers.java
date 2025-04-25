/*
 * Copyright (C) 2008 The Guava Authors
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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Contains various {@link Receiver} utility methods.
 *
 * @author micapolos@google.com (Michal Pociecha-Los)
 */
public final class Receivers {
  // Prevents instantiation
  private Receivers() {}

  /** Shared and thread-safe instance of ignoring {@code Receiver} */
  private static final Receiver<@Nullable Object> IGNORING_RECEIVER =
      new Receiver<@Nullable Object>() {
        @Override
        public void accept(@Nullable Object object) {}

        @Override
        public String toString() {
          return "Receivers.ignore()";
        }
      };

  /** Returns a receiver which ignores the accepted object. */
  @SuppressWarnings("unchecked") // safe contravariant cast
  public static <T extends @Nullable Object> Receiver<T> ignore() {
    return (Receiver<T>) IGNORING_RECEIVER;
  }

  /**
   * Returns a receiver that adds the accepted object into the underlying collection. This method
   * does not catch unchecked exceptions thrown by the underlying collection.
   *
   * @param collection the collection to add accepted objects to
   */
  public static <T extends @Nullable Object> Receiver<T> collect(Collection<? super T> collection) {
    return new CollectingReceiver<>(collection);
  }

  /**
   * Returns a new receiver that offers the accepted object to each of the provided receivers. The
   * receivers will be called in the order they were provided. This method does not catch unchecked
   * exceptions thrown by the underlying receivers, which means that in case of an exception the
   * remaining receivers (the ones which haven't yet accepted the offered object) are ignored.
   *
   * @param receivers underlying receivers to offer accepted object
   */
  @SafeVarargs
  public static <T extends @Nullable Object> Receiver<T> compose(Receiver<? super T>... receivers) {
    return new CompositeReceiver<T>(Arrays.asList(receivers));
  }

  /**
   * Returns a new receiver that offers the accepted object to each of the provided receivers. The
   * receivers will be called in the order they were provided. This method does not catch unchecked
   * exceptions thrown by the underlying receivers, which means that in case of an exception the
   * remaining receivers (the ones which haven't yet accepted the offered object) are ignored.
   *
   * @param receivers underlying receivers to offer accepted object
   */
  public static <T extends @Nullable Object> Receiver<T> compose(Iterable<Receiver<T>> receivers) {
    return new CompositeReceiver<>(receivers);
  }

  private static final class CompositeReceiver<T extends @Nullable Object> implements Receiver<T> {
    private final List<Receiver<? super T>> receivers;

    CompositeReceiver(Iterable<? extends Receiver<? super T>> receivers) {
      this.receivers = copy(receivers);
    }

    @Override
    public void accept(@ParametricNullness T object) {
      for (Receiver<? super T> receiver : receivers) {
        receiver.accept(object);
      }
    }

    @Override
    public boolean equals(@Nullable Object obj) {
      if (obj instanceof CompositeReceiver) {
        CompositeReceiver<?> that = (CompositeReceiver<?>) obj;
        return receivers.equals(that.receivers);
      }
      return false;
    }

    @Override
    public int hashCode() {
      return receivers.hashCode();
    }

    @Override
    public String toString() {
      return "Receivers.compose(" + Joiner.on(", ").join(receivers) + ")";
    }

    private static <E> List<E> copy(Iterable<? extends E> elements) {
      List<E> list = new ArrayList<>();
      for (E element : elements) {
        list.add(checkNotNull(element));
      }
      return list;
    }
  }

  private static final class CollectingReceiver<T extends @Nullable Object> implements Receiver<T> {
    private final Collection<? super T> collection;

    CollectingReceiver(Collection<? super T> collection) {
      this.collection = checkNotNull(collection);
    }

    @Override
    public void accept(@ParametricNullness T object) {
      collection.add(object);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
      if (obj instanceof CollectingReceiver) {
        CollectingReceiver<?> that = (CollectingReceiver<?>) obj;
        return collection == that.collection;
      }
      return false;
    }

    @Override
    public int hashCode() {
      return System.identityHashCode(collection);
    }
  }
}
