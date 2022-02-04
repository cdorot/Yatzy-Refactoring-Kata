package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The player chooses to place dice on [chance]")
class ChanceTest extends AbstractRuleTest {

  @ParameterizedTest
  @CsvSource({"15, 2, 3, 4, 5, 1", "16, 3, 3, 4, 5, 1"})
  @DisplayName("The player scores the sum of all dice when he chooses to place dice on [chance]")
  public void should_score_sum_of_all_dice_When_dice_placed_on_chance(
      int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
    assertEquals(
        expectedScore,
        new Yatzy(dice1, dice2, dice3, dice4, dice5).chance(),
        assertionMessage("chance", expectedScore, dice1, dice2, dice3, dice4, dice5));
  }
}
