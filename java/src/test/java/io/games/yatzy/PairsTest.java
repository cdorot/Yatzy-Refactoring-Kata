package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The player chooses to place dice on [pairs | two pairs]")
class PairsTest extends AbstractRuleTest {

  @Nested
  class OnePairTest {

    @ParameterizedTest
    @CsvSource({
      " 8, 3, 3, 3, 4, 4",
      "12, 1, 1, 6, 2, 6",
      " 6, 3, 3, 3, 4, 1",
      " 6, 3, 4, 3, 5, 6",
      "10, 5, 3, 3, 3, 5",
      "12, 5, 3, 6, 6, 5"
    })
    @DisplayName(
        "The player scores the sum of the two highest matching dice when he chooses to place dice on [pairs]")
    public void should_score_sum_the_two_highest_matching_dice_When_dice_placed_on_pairs(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      placeDiceOnPairsRoll(expectedScore, dice1, dice2, dice3, dice4, dice5);
    }

    @Test
    @DisplayName(
        "The player scores 0 when there is no matching dice and he chooses to place dice on [pairs]")
    public void should_score_0_When_no_dice_that_read_6_and_dice_placed_on_pairs() {
      placeDiceOnPairsRoll(0, 1, 2, 3, 4, 5);
    }

    private void placeDiceOnPairsRoll(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(
          expectedScore,
          new Yatzy(dice1, dice2, dice3, dice4, dice5).score_pair(),
          assertionMessage("pairs", expectedScore, dice1, dice2, dice3, dice4, dice5));
    }
  }

  @Nested
  class TwoPairsTest {

    @ParameterizedTest
    @CsvSource({"16, 3, 3, 5, 4, 5", "16, 3, 3, 5, 4, 5"})
    @DisplayName(
        "If there are two pairs of dice with the same number, the player scores the sum these dice when he chooses to place dice on [two pairs]")
    public void
        should_score_sum_the_two_highest_matching_dice_When_there_are_two_pairs_and_dice_placed_on_two_pairs(
            int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      placeDiceOnTwoPairsRoll(expectedScore, dice1, dice2, dice3, dice4, dice5);
    }

    @Test
    @DisplayName(
        "The player scores 0 when there is not two pairs and he chooses to place dice on [two pairs]")
    public void should_score_0_When_no_dice_that_read_6_and_dice_placed_on_two_pairs() {
      placeDiceOnTwoPairsRoll(0, 1, 2, 2, 4, 5);
    }

    private void placeDiceOnTwoPairsRoll(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(
          expectedScore,
          new Yatzy(dice1, dice2, dice3, dice4, dice5).two_pair(),
          assertionMessage("two pairs", expectedScore, dice1, dice2, dice3, dice4, dice5));
    }
  }
}
