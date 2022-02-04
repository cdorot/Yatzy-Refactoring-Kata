package io.games.yatzy;

import io.games.yatzy.rules.ChanceRule;
import io.games.yatzy.rules.FourOfAKindRule;
import io.games.yatzy.rules.FullHouseRule;
import io.games.yatzy.rules.LargeStraightRule;
import io.games.yatzy.rules.OnesTwosThreesFoursFivesSixesRule;
import io.games.yatzy.rules.PairsRule;
import io.games.yatzy.rules.SmallStraightRule;
import io.games.yatzy.rules.ThreeOfAKindRule;
import io.games.yatzy.rules.TwoPairsRule;
import io.games.yatzy.rules.YatziRule;

public class YatzyGame {

  private final int[] dice;

  public YatzyGame(int d1, int d2, int d3, int d4, int d5) {
    dice = new int[] {d1, d2, d3, d4, d5};
  }

  public int chance() {
    return new ChanceRule().score(dice);
  }

  public int ones() {
    return new OnesTwosThreesFoursFivesSixesRule(1).score(dice);
  }

  public int twos() {
    return new OnesTwosThreesFoursFivesSixesRule(2).score(dice);
  }

  public int threes() {
    return new OnesTwosThreesFoursFivesSixesRule(3).score(dice);
  }

  public int fours() {
    return new OnesTwosThreesFoursFivesSixesRule(4).score(dice);
  }

  public int fives() {
    return new OnesTwosThreesFoursFivesSixesRule(5).score(dice);
  }

  public int sixes() {
    return new OnesTwosThreesFoursFivesSixesRule(6).score(dice);
  }

  public int yatzy() {
    return new YatziRule().score(dice);
  }

  public int pairs() {
    return new PairsRule().score(dice);
  }

  public int twoPairs() {
    return new TwoPairsRule().score(dice);
  }

  public int threeOfAKind() {
    return new ThreeOfAKindRule().score(dice);
  }

  public int fourOfAKind() {
    return new FourOfAKindRule().score(dice);
  }

  public int smallStraight() {
    return new SmallStraightRule().score(dice);
  }

  public int largeStraight() {
    return new LargeStraightRule().score(dice);
  }

  public int fullHouse() {
    return new FullHouseRule().score(dice);
  }
}
