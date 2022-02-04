package io.games.yatzy;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractRuleTest {

  protected static String assertionMessage(
      String rule, int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
    return "If dice rolls [ "
        + Stream.of(dice1, dice2, dice3, dice4, dice5)
            .map(String::valueOf)
            .collect(Collectors.joining(", "))
        + " ] and players placed dice on [ "
        + rule
        + " ], then the expected score is [ "
        + expectedScore
        + " ]";
  }
}
