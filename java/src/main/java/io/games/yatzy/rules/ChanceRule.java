package io.games.yatzy.rules;

import java.util.stream.IntStream;

public class ChanceRule implements Rule {

  @Override
  public int score(int[] dice) {
    return sumOfAllDice(dice);
  }

  private static int sumOfAllDice(int[] dice) {
    return IntStream.of(dice).sum();
  }
}
