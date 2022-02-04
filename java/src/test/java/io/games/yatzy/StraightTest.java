package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The player chooses to place dice on [small straight | large straight]")
class StraightTest {

  @ParameterizedTest
  @CsvSource({"15, 1, 2, 3, 4, 5", "15, 2, 3, 4, 5, 1"})
  @DisplayName(
      "The player scores 15 when he chooses to place dice on [small straight] and there is a straight combination with four of the five dice")
  public void
      should_score_15_When_there_is_sequential_with_4_dice_and_dice_placed_on_small_straight(
          int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
    assertEquals(expectedScore, new Yatzy(dice1, dice2, dice3, dice4, dice5).smallStraight());
  }

  @Test
  @DisplayName(
      "The player scores 0 when he chooses to place dice on [small straight] there is no small straight combination")
  public void should_score_0_When_there_isnt_sequential_dice_and_dice_placed_on_small_straight() {
    assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
  }

  @ParameterizedTest
  @CsvSource({"20, 6, 2, 3, 4, 5", "20, 2, 3, 4, 5, 6"})
  @DisplayName(
      "The player scores 20 when he chooses to place dice on [large straight] and there is a straight combination with all dice")
  public void
      should_score_20_When_there_is_sequential_with_all_dice_and_dice_placed_on_large_straight(
          int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
    assertEquals(expectedScore, new Yatzy(dice1, dice2, dice3, dice4, dice5).largeStraight());
  }

  @Test
  @DisplayName(
      "The player scores 0 when he chooses to place dice on [large straight] and there is no large straight combination")
  public void should_score_0_When_there_isnt_sequential_dice_and_dice_placed_onlarge_straight() {
    assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
  }
}
