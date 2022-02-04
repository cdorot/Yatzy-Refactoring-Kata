package io.games.yatzy.rules;

import static io.games.yatzy.utils.DiceCounter.highestMatchingDiceWithMinOccurrence;

public class FourOfAKindRule implements Rule {

  @Override
  public int score(int[] dice) {
    return highestMatchingDiceWithMinOccurrence(dice, 3).orElse(0) * 4;
  }
}
