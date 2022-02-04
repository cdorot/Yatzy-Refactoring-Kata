package io.games.yatzy.rules;

import java.util.stream.IntStream;

public class YatziRule implements Rule {

  private static final int SCORE_YATZI = 50;

  @Override
  public int score(int[] dice) {
    return allDiceHaveSameValue(dice) ? SCORE_YATZI : 0;
  }

  private static boolean allDiceHaveSameValue(int[] dice) {
    return IntStream.of(dice).allMatch(i -> i == dice[0]);
  }
}
