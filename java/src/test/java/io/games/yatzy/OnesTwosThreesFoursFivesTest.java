package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The player chooses to place dice on [ones | twos | threes | fours | fives]")
class OnesTwosThreesFoursFivesTest extends AbstractRuleTest {

  @Nested
  class OnesTest {

    @ParameterizedTest
    @CsvSource({
      "0, 2, 3, 4, 5, 5",
      "1, 1, 6, 6, 6, 6",
      "2, 1, 6, 1, 6, 6",
      "3, 6, 6, 1, 1, 1",
      "4, 1, 6, 1, 1, 1",
      "5, 1, 1, 1, 1, 1"
    })
    @DisplayName(
        "The player scores the sum of the dice that reads [one] when he chooses to place dice on [ones]")
    public void should_score_sum_of_all_dice_that_reads_1_When_dice_placed_on_ones(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      placeDiceOnOnesRoll(expectedScore, dice1, dice2, dice3, dice4, dice5);
    }

    @Test
    @DisplayName(
        "The player scores 0 when there is no dice that reads 1 and he chooses to place dice on [ones]")
    public void should_score_0_When_no_dice_that_read_1_and_dice_placed_on_ones() {
      placeDiceOnOnesRoll(0, 2, 3, 4, 5, 6);
    }

    private void placeDiceOnOnesRoll(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(
          expectedScore,
          new YatzyGame(dice1, dice2, dice3, dice4, dice5).ones(),
          assertionMessage("ones", expectedScore, dice1, dice2, dice3, dice4, dice5));
    }
  }

  @Nested
  class TwosTest {

    @ParameterizedTest
    @CsvSource({
      " 0, 1, 3, 4, 5, 5",
      " 2, 2, 6, 6, 6, 6",
      " 4, 2, 6, 2, 6, 6",
      " 6, 6, 6, 2, 2, 2",
      " 8, 2, 6, 2, 2, 2",
      "10, 2, 2, 2, 2, 2"
    })
    @DisplayName(
        "The player scores the sum of the dice that reads [two] when he chooses to place dice on [twos]")
    public void should_score_sum_of_all_dice_that_reads_2_When_dice_placed_on_twos(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      placeDiceOnTwosRoll(expectedScore, dice1, dice2, dice3, dice4, dice5);
    }

    @Test
    @DisplayName(
        "The player scores 0 when there is no dice that reads 2 and he chooses to place dice on [twos]")
    public void should_score_0_When_no_dice_that_read_2_and_dice_placed_on_twos() {
      placeDiceOnTwosRoll(0, 1, 3, 4, 5, 6);
    }

    private void placeDiceOnTwosRoll(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(
          expectedScore,
          new YatzyGame(dice1, dice2, dice3, dice4, dice5).twos(),
          assertionMessage("twos", expectedScore, dice1, dice2, dice3, dice4, dice5));
    }
  }

  @Nested
  class ThreesTest {

    @ParameterizedTest
    @CsvSource({
      " 0, 1, 2, 4, 5, 5",
      " 3, 3, 6, 6, 6, 6",
      " 6, 3, 6, 3, 6, 6",
      " 9, 6, 6, 3, 3, 3",
      "12, 3, 6, 3, 3, 3",
      "15, 3, 3, 3, 3, 3"
    })
    @DisplayName(
        "The player scores the sum of the dice that reads [three] when he chooses to place dice on [threes]")
    public void should_score_sum_of_all_dice_that_reads_3_When_dice_placed_on_threes(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      placeDiceOnThreesRoll(expectedScore, dice1, dice2, dice3, dice4, dice5);
    }

    @Test
    @DisplayName(
        "The player scores 0 when there is no dice that reads 3 and he chooses to place dice on [threes]")
    public void should_score_0_When_no_dice_that_read_3_and_dice_placed_on_threes() {
      placeDiceOnThreesRoll(0, 1, 2, 4, 5, 6);
    }

    private void placeDiceOnThreesRoll(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(
          expectedScore,
          new YatzyGame(dice1, dice2, dice3, dice4, dice5).threes(),
          assertionMessage("threes", expectedScore, dice1, dice2, dice3, dice4, dice5));
    }
  }

  @Nested
  class FoursTest {

    @ParameterizedTest
    @CsvSource({
      " 0, 1, 2, 3, 5, 5",
      " 4, 4, 6, 6, 6, 6",
      " 8, 4, 6, 4, 6, 6",
      "12, 6, 6, 4, 4, 4",
      "16, 4, 6, 4, 4, 4",
      "20, 4, 4, 4, 4, 4"
    })
    @DisplayName(
        "The player scores the sum of the dice that reads [four] when he chooses to place dice on [fours]")
    public void should_score_sum_of_all_dice_that_reads_4_When_dice_placed_on_fours(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      placeDiceOnFoursRoll(expectedScore, dice1, dice2, dice3, dice4, dice5);
    }

    @Test
    @DisplayName(
        "The player scores 0 when there is no dice that reads 4 and he chooses to place dice on [fours]")
    public void should_score_0_When_no_dice_that_read_4_and_dice_placed_on_fours() {
      placeDiceOnFoursRoll(0, 1, 2, 3, 5, 6);
    }

    private void placeDiceOnFoursRoll(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(
          expectedScore,
          new YatzyGame(dice1, dice2, dice3, dice4, dice5).fours(),
          assertionMessage("fours", expectedScore, dice1, dice2, dice3, dice4, dice5));
    }
  }

  @Nested
  class FivesTest {

    @ParameterizedTest
    @CsvSource({
      " 0, 1, 2, 3, 4, 4",
      " 5, 5, 6, 6, 6, 6",
      "10, 5, 6, 5, 6, 6",
      "15, 6, 6, 5, 5, 5",
      "20, 5, 6, 5, 5, 5",
      "25, 5, 5, 5, 5, 5"
    })
    @DisplayName(
        "The player scores the sum of the dice that reads [five] when he chooses to place dice on [fives]")
    public void should_score_sum_of_all_dice_that_reads_5_When_dice_placed_on_fives(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      placeDiceOnFivesRoll(expectedScore, dice1, dice2, dice3, dice4, dice5);
    }

    @Test
    @DisplayName(
        "The player scores 0 when there is no dice that reads 5 and he chooses to place dice on [fives]")
    public void should_score_0_When_no_dice_that_read_5_and_dice_placed_on_fives() {
      placeDiceOnFivesRoll(0, 1, 2, 3, 4, 6);
    }

    private void placeDiceOnFivesRoll(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(
          expectedScore,
          new YatzyGame(dice1, dice2, dice3, dice4, dice5).fives(),
          assertionMessage("fives", expectedScore, dice1, dice2, dice3, dice4, dice5));
    }
  }

  @Nested
  class SixesTest {

    @ParameterizedTest
    @CsvSource({
      " 0, 1, 2, 3, 4, 4",
      " 6, 6, 1, 1, 1, 1",
      "12, 6, 1, 6, 1, 1",
      "18, 1, 1, 6, 6, 6",
      "24, 6, 1, 6, 6, 6",
      "30, 6, 6, 6, 6, 6"
    })
    @DisplayName(
        "The player scores the sum of the dice that reads [six] when he chooses to place dice on [sixes]")
    public void should_score_sum_of_all_dice_that_reads_6_When_dice_placed_on_sixes(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      placeDiceOnSixesRoll(expectedScore, dice1, dice2, dice3, dice4, dice5);
    }

    @Test
    @DisplayName(
        "The player scores 0 when there is no dice that reads 6 and he chooses to place dice on [sixes]")
    public void should_score_0_When_no_dice_that_read_6_and_dice_placed_on_sixes() {
      placeDiceOnSixesRoll(0, 1, 2, 3, 4, 5);
    }

    private void placeDiceOnSixesRoll(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(
          expectedScore,
          new YatzyGame(dice1, dice2, dice3, dice4, dice5).sixes(),
          assertionMessage("sixes", expectedScore, dice1, dice2, dice3, dice4, dice5));
    }
  }
}
