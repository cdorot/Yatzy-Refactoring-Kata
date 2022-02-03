package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The player chooses to place dice on [pairs | two pairs]")
class PairsTest {

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
    assertEquals(expectedScore, Yatzy.score_pair(dice1, dice2, dice3, dice4, dice5));
  }

  @ParameterizedTest
  @CsvSource({"16, 3, 3, 5, 4, 5", "16, 3, 3, 5, 4, 5"})
  @DisplayName(
      "If there are two pairs of dice with the same number, the player scores the sum these dice when he chooses to place dice on [two pairs]")
  public void
      should_score_sum_the_two_highest_matching_dice_When_there_are_two_pairs_and_dice_placed_on_two_pairs(
          int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
    assertEquals(expectedScore, Yatzy.two_pair(dice1, dice2, dice3, dice4, dice5));
  }
}
