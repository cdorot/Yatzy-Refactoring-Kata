package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The player chooses to place dice on [three of a kind | four of a kind]")
class MultipleOfAKindTest {

  @ParameterizedTest
  @CsvSource({" 9, 3, 3, 3, 4, 5", "15, 5, 3, 5, 4, 5", " 9, 3, 3, 3, 3, 5"})
  @DisplayName(
      "If there are [three] dice with the same number, the player scores the sum of these dice when he chooses to place dice on [three of a kind]")
  public void
      should_score_sum_of_dice_with_the_same_number_When_three_dice_with_same_number_and_dice_placed_on_three_of_a_kind(
          int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
    assertEquals(expectedScore, Yatzy.three_of_a_kind(dice1, dice2, dice3, dice4, dice5));
  }

  @ParameterizedTest
  @CsvSource({"12, 3, 3, 3, 3, 5", "20, 5, 5, 5, 4, 5"})
  @DisplayName(
      "If there are [four] dice with the same number, the player scores the sum of these dice when he chooses to place dice on [four of a kind]")
  public void
      should_score_sum_of_dice_with_the_same_number_When_four_dice_with_same_number_and_dice_placed_on_four_of_a_kind(
          int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
    assertEquals(expectedScore, Yatzy.four_of_a_kind(dice1, dice2, dice3, dice4, dice5));
  }
}
