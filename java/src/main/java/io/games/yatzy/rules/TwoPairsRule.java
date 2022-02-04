package io.games.yatzy.rules;

import static io.games.yatzy.utils.ArrayUtils.cloneArrayByEliminatingValue;
import static io.games.yatzy.utils.DiceCounter.highestMatchingDice;

public class TwoPairsRule implements Rule {

  @Override
  public int score(int[] dice) {
    final int firstHighestMatchingDice = highestMatchingDice(dice).orElse(0);
    final int[] diceWithoutFirstHighestMatching =
        cloneArrayByEliminatingValue(dice, firstHighestMatchingDice);
    final int secondHighestMatchingDice =
        highestMatchingDice(diceWithoutFirstHighestMatching).orElse(0);

    return firstHighestMatchingDice != 0 && secondHighestMatchingDice != 0
        ? firstHighestMatchingDice * 2 + secondHighestMatchingDice * 2
        : 0;
  }
}
