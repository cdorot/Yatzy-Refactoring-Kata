package io.games.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

  @Nested
  @DisplayName("The player chooses to place dice on [chance]")
  class ChanceTest {

    @ParameterizedTest
    @CsvSource({"15, 2, 3, 4, 5, 1", "16, 3, 3, 4, 5, 1"})
    @DisplayName("The player scores the sum of all dice when he chooses to place dice on [chance]")
    public void should_score_sum_of_all_dice_When_dice_placed_on_chance(
        int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(expectedScore, Yatzy.chance(dice1, dice2, dice3, dice4, dice5));
    }
  }

  @Nested
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

  @Nested
  @DisplayName("The player chooses to place dice on [ones | twos | threes | fours | fives]")
  class OnesTwosThreesFoursFivesTest {

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
      assertEquals(expectedScore, Yatzy.ones(dice1, dice2, dice3, dice4, dice5));
    }

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
      assertEquals(expectedScore, Yatzy.twos(dice1, dice2, dice3, dice4, dice5));
    }

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
      assertEquals(expectedScore, Yatzy.threes(dice1, dice2, dice3, dice4, dice5));
    }

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
      assertEquals(expectedScore, new Yatzy(dice1, dice2, dice3, dice4, dice5).fours());
    }

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
      assertEquals(expectedScore, new Yatzy(dice1, dice2, dice3, dice4, dice5).fives());
    }

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
      assertEquals(expectedScore, new Yatzy(dice1, dice2, dice3, dice4, dice5).sixes());
    }
  }

  @Nested
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

  @Nested
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

  @Nested
  @DisplayName("The player chooses to place dice on [small straight | large straight]")
  class StraightTest {

    @ParameterizedTest
    @CsvSource({"15, 1, 2, 3, 4, 5", "15, 2, 3, 4, 5, 1"})
    @DisplayName(
        "The player scores 15 when he chooses to place dice on [small straight] and there is a straight combination with four of the five dice")
    public void
        should_score_15_When_there_is_sequential_with_4_dice_and_dice_placed_on_small_straight(
            int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(expectedScore, Yatzy.smallStraight(dice1, dice2, dice3, dice4, dice5));
    }

    @Test
    @DisplayName(
        "The player scores 0 when he chooses to place dice on [small straight] there is no small straight combination")
    public void should_score_0_When_there_isnt_sequential_dice_and_dice_placed_on_small_straight() {
      assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @ParameterizedTest
    @CsvSource({"20, 6, 2, 3, 4, 5", "20, 2, 3, 4, 5, 6"})
    @DisplayName(
        "The player scores 20 when he chooses to place dice on [large straight] and there is a straight combination with all dice")
    public void
        should_score_20_When_there_is_sequential_with_all_dice_and_dice_placed_on_large_straight(
            int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(expectedScore, Yatzy.largeStraight(dice1, dice2, dice3, dice4, dice5));
    }

    @Test
    @DisplayName(
        "The player scores 0 when he chooses to place dice on [large straight] and there is no large straight combination")
    public void should_score_0_When_there_isnt_sequential_dice_and_dice_placed_onlarge_straight() {
      assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }
  }

  @Nested
  @DisplayName("The player chooses to place dice on [full house]")
  class FullHouseTest {

    @ParameterizedTest
    @CsvSource({"18, 6, 2, 2, 2, 6", "11, 4, 4, 1, 1, 1"})
    @DisplayName(
        "The player scores the sum of all the dice when he chooses to place dice on [full house] and the dice are two of a kind and three of a kind")
    public void
        should_score_the_sum_of_all_the_dice_When_dice_are_two_and_three_of_a_kind_and_dice_placed_on_full_house(
            int expectedScore, int dice1, int dice2, int dice3, int dice4, int dice5) {
      assertEquals(expectedScore, Yatzy.fullHouse(dice1, dice2, dice3, dice4, dice5));
    }

    @Test
    @DisplayName(
        "The player scores 0 when he chooses to place dice on [full house] and the dice are not two of a kind and three of a kind")
    public void should_score_0_When_there_isnt_sequential_dice_and_dice_placed_onlarge_straight() {
      assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
  }
}
