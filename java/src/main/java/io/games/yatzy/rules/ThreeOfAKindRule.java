package io.games.yatzy.rules;

import static io.games.yatzy.utils.DiceCounter.highestMatchingDiceWithMinOccurrence;

public class ThreeOfAKindRule implements Rule {

  @Override
  public int score(int[] dice) {
    return highestMatchingDiceWithMinOccurrence(dice, 2).orElse(0) * 3;
  }
}
