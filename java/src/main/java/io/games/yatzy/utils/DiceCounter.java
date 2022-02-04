package io.games.yatzy.utils;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public final class DiceCounter {

  private DiceCounter() {}

  public static int countDiceThatReadNumber(int[] dice, int number) {
    return (int) IntStream.of(dice).filter(d -> d == number).count();
  }

  public static boolean hasAMinimumOfOccurrence(int[] dice, int value, int minOccurrence) {
    return countDiceThatReadNumber(dice, value) > minOccurrence;
  }

  public static boolean hasMultipleOccurrence(int[] dice, int value) {
    return hasAMinimumOfOccurrence(dice, value, 1);
  }

  public static boolean hasANOccurrence(int[] dice, int value, int minOccurrence) {
    return countDiceThatReadNumber(dice, value) == minOccurrence;
  }

  public static OptionalInt highestMatchingDice(int[] dice) {
    return IntStream.rangeClosed(1, 6).filter(i -> hasMultipleOccurrence(dice, i)).max();
  }

  public static OptionalInt highestMatchingDiceWithMinOccurrence(int[] dice, int minOccurrence) {
    return IntStream.rangeClosed(1, 6)
        .filter(i -> hasAMinimumOfOccurrence(dice, i, minOccurrence))
        .max();
  }

  public static int[] matchingDiceWithNOccurrence(int[] dice, int occurrence) {
    return IntStream.rangeClosed(1, 6).filter(i -> hasANOccurrence(dice, i, occurrence)).toArray();
  }
}
