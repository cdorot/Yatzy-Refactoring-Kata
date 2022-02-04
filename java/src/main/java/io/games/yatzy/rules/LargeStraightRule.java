package io.games.yatzy.rules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargeStraightRule implements Rule {

  private static final int SCORE_LARGE_STRAIGHT = 20;

  @Override
  public int score(int[] dice) {
    final String strCurrentRoll = convertRollToString(dice);
    return List.of("12345", "23456").contains(strCurrentRoll) ? SCORE_LARGE_STRAIGHT : 0;
  }

  private String convertRollToString(int[] dice) {
    return Arrays.stream(dice).sorted().mapToObj(String::valueOf).collect(Collectors.joining());
  }
}
