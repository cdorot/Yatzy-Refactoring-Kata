package io.games.yatzy.rules;

import static io.games.yatzy.utils.ArrayUtils.cloneArrayByEliminatingValue;
import static io.games.yatzy.utils.DiceCounter.matchingDiceWithNOccurrence;

public class FullHouseRule implements Rule {

  @Override
  public int score(int[] dice) {
    int[] triplet = matchingDiceWithNOccurrence(dice, 3);

    if (triplet.length == 0) {
      return 0;
    }

    final int[] diceWithoutTripletValue = cloneArrayByEliminatingValue(dice, triplet[0]);
    int scorePair = new PairsRule().score(diceWithoutTripletValue);

    return scorePair > 0 ? triplet[0] * 3 + scorePair : 0;
  }
}
