package io.games.yatzy.rules;

import static io.games.yatzy.utils.DiceCounter.countDiceThatReadNumber;

public class OnesTwosThreesFoursFivesSixesRule implements Rule {

  private final int number;

  public OnesTwosThreesFoursFivesSixesRule(int number) {
    this.number = number;
  }

  @Override
  public int score(int[] dice) {
    return countDiceThatReadNumber(dice, number) * number;
  }
}
