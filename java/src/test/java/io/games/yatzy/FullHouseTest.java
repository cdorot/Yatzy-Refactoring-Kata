package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The player chooses to place dice on [full house]")
class FullHouseTest {

  @ParameterizedTest
  @CsvSource({"18, 6, 2, 2, 2, 6", "11, 4, 4, 1, 1, 1"})
  @DisplayName(
      "The player scores the sum of all the dice when he chooses to place dice on [full house] and the dice are two of a kind and three of a kind")
  public void
      should_score_the_sum_of_all_the_dice_When_dice_are_two_and_three_of_a_kind_and_dice_placed_on_full_house(
          int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
    assertEquals(expectedScore, new Yatzy(dice1, dice2, dice3, dice4, dice5).fullHouse());
  }

  @Test
  @DisplayName(
      "The player scores 0 when he chooses to place dice on [full house] and the dice are not two of a kind and three of a kind")
  public void should_score_0_When_there_isnt_sequential_dice_and_dice_placed_onlarge_straight() {
    assertEquals(0, new Yatzy(2, 3, 4, 5, 6).fullHouse());
  }
}
