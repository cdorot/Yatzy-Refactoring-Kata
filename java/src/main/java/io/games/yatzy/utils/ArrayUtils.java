package io.games.yatzy.utils;

import java.util.stream.IntStream;

public final class ArrayUtils {

  private ArrayUtils() {}

  public static int[] cloneArrayByEliminatingValue(int[] dice, int value) {
    return IntStream.of(dice).filter(i -> i != value).toArray();
  }
}
