package io.games.yatzy.rules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.games.yatzy.utils.DiceCounter.matchingDiceWithNOccurrence;

public class SmallStraightRule implements Rule {

  private static final int SCORE_SMALL_STRAIGHT = 15;

  @Override
  public int score(int[] dice) {
    if (new LargeStraightRule().score(dice) > 0) {
      return SCORE_SMALL_STRAIGHT;
    }

    int[] pairs = matchingDiceWithNOccurrence(dice, 2);

    if (pairs.length != 1) {
      return 0;
    }

    final String strCurrentRollWithoutAPairValue =
        convertRollToString(dice).replaceFirst(String.valueOf(pairs[0]), "");

    return List.of("1234", "2345", "3456").contains(strCurrentRollWithoutAPairValue)
        ? SCORE_SMALL_STRAIGHT
        : 0;
  }

  private String convertRollToString(int[] dice) {
    return Arrays.stream(dice).sorted().mapToObj(String::valueOf).collect(Collectors.joining());
  }
}
