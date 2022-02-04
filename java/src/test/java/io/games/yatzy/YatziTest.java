package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The player chooses to place dice on [yatzi]")
class YatziTest extends AbstractRuleTest {

  @Test
  @DisplayName(
      "The player scores 0 when he chooses to place dice on [yatzi] and at least one dice has a different number")
  public void
      should_score_0_When_dice_placed_on_yatzi_and_at_least_one_dice_has_a_different_number() {
    placeDiceOnYatziRoll(0, 6, 6, 6, 6, 3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6})
  @DisplayName(
      "The player scores 50 when he chooses to place dice on [yatzi] and all dice have same number")
  public void should_score_50_When_dice_placed_on_yatzi_and_all_dice_have_same_numbers(int dice) {
    placeDiceOnYatziRoll(50, dice, dice, dice, dice, dice);
  }

  private void placeDiceOnYatziRoll(
      int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
    assertEquals(
        expectedScore,
        new YatzyGame(dice1, dice2, dice3, dice4, dice5).yatzy(),
        assertionMessage("yatzi", expectedScore, dice1, dice2, dice3, dice4, dice5));
  }
}
