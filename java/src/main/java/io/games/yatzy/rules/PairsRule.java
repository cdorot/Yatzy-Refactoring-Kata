package io.games.yatzy.rules;

import static io.games.yatzy.utils.DiceCounter.highestMatchingDice;

public class PairsRule implements Rule {

  @Override
  public int score(int[] dice) {
    return highestMatchingDice(dice).orElse(0) * 2;
  }
}
