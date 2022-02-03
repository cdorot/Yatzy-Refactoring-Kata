package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The player chooses to place dice on [yatzi]")
class YatziTest {

  @Test
  @DisplayName(
      "The player scores 0 when he chooses to place dice on [yatzi] and at least one dice has a different number")
  public void
      should_score_0_When_dice_placed_on_yatzi_and_at_least_one_dice_has_a_different_number() {
    assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6})
  @DisplayName(
      "The player scores 50 when he chooses to place dice on [yatzi] and all dice have same number")
  public void should_score_50_When_dice_placed_on_yatzi_and_all_dice_have_same_numbers(int dice) {
    assertEquals(50, Yatzy.yatzy(dice, dice, dice, dice, dice));
  }
}
