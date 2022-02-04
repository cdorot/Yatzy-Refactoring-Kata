package io.games.yatzy;

import java.util.stream.IntStream;

public class Yatzy {

  private final int[] dice;

  public Yatzy(int d1, int d2, int d3, int d4, int d5) {
    dice = new int[5];
    dice[0] = d1;
    dice[1] = d2;
    dice[2] = d3;
    dice[3] = d4;
    dice[4] = d5;
  }

  public int chance() {
    return dice[0] + dice[1] + dice[2] + dice[3] + dice[4];
  }

  public int ones() {
    return countDieThatReadNumber(1);
  }

  public int twos() {
    return 2 * countDieThatReadNumber(2);
  }

  public int threes() {
    return 3 * countDieThatReadNumber(3);
  }

  public int fours() {
    return 4 * countDieThatReadNumber(4);
  }

  public int fives() {
    return 5 * countDieThatReadNumber(5);
  }

  public int sixes() {
    return 6 * countDieThatReadNumber(6);
  }

  public int yatzy() {
    int[] counts = new int[6];
    for (int die : dice) {
      counts[die - 1]++;
    }
    for (int i = 0; i != 6; i++) {
      if (counts[i] == 5) {
        return 50;
      }
    }
    return 0;
  }

  public int score_pair() {
    int[] counts = new int[6];
    counts[dice[0] - 1]++;
    counts[dice[1] - 1]++;
    counts[dice[2] - 1]++;
    counts[dice[3] - 1]++;
    counts[dice[4] - 1]++;

    for (int at = 0; at != 6; at++) {
      if (counts[6 - at - 1] >= 2) {
        return (6 - at) * 2;
      }
    }

    return 0;
  }

  public int two_pair() {
    int[] counts = new int[6];
    counts[dice[0] - 1]++;
    counts[dice[1] - 1]++;
    counts[dice[2] - 1]++;
    counts[dice[3] - 1]++;
    counts[dice[4] - 1]++;
    int n = 0;
    int score = 0;
    for (int i = 0; i < 6; i += 1) {
      if (counts[6 - i - 1] >= 2) {
        n++;
        score += (6 - i);
      }
    }
    if (n == 2) {
      return score * 2;
    } else {
      return 0;
    }
  }

  public int four_of_a_kind() {
    int[] tallies;
    tallies = new int[6];
    tallies[dice[0] - 1]++;
    tallies[dice[1] - 1]++;
    tallies[dice[2] - 1]++;
    tallies[dice[3] - 1]++;
    tallies[dice[4] - 1]++;
    for (int i = 0; i < 6; i++) {
      if (tallies[i] >= 4) {
        return (i + 1) * 4;
      }
    }
    return 0;
  }

  public int three_of_a_kind() {
    int[] t;
    t = new int[6];
    t[dice[0] - 1]++;
    t[dice[1] - 1]++;
    t[dice[2] - 1]++;
    t[dice[3] - 1]++;
    t[dice[4] - 1]++;
    for (int i = 0; i < 6; i++) {
      if (t[i] >= 3) {
        return (i + 1) * 3;
      }
    }
    return 0;
  }

  public int smallStraight() {
    int[] tallies;
    tallies = new int[6];
    tallies[dice[0] - 1] += 1;
    tallies[dice[1] - 1] += 1;
    tallies[dice[2] - 1] += 1;
    tallies[dice[3] - 1] += 1;
    tallies[dice[4] - 1] += 1;
    if (tallies[0] == 1
        && tallies[1] == 1
        && tallies[2] == 1
        && tallies[3] == 1
        && tallies[4] == 1) {
      return 15;
    }
    return 0;
  }

  public int largeStraight() {
    int[] tallies;
    tallies = new int[6];
    tallies[dice[0] - 1] += 1;
    tallies[dice[1] - 1] += 1;
    tallies[dice[2] - 1] += 1;
    tallies[dice[3] - 1] += 1;
    tallies[dice[4] - 1] += 1;
    if (tallies[1] == 1
        && tallies[2] == 1
        && tallies[3] == 1
        && tallies[4] == 1
        && tallies[5] == 1) {
      return 20;
    }
    return 0;
  }

  public int fullHouse() {
    int[] tallies;
    boolean _2 = false;
    int i;
    int _2_at = 0;
    boolean _3 = false;
    int _3_at = 0;

    tallies = new int[6];
    tallies[dice[0] - 1] += 1;
    tallies[dice[1] - 1] += 1;
    tallies[dice[2] - 1] += 1;
    tallies[dice[3] - 1] += 1;
    tallies[dice[4] - 1] += 1;

    for (i = 0; i != 6; i += 1) {
      if (tallies[i] == 2) {
        _2 = true;
        _2_at = i + 1;
      }
    }

    for (i = 0; i != 6; i += 1) {
      if (tallies[i] == 3) {
        _3 = true;
        _3_at = i + 1;
      }
    }

    if (_2 && _3) {
      return _2_at * 2 + _3_at * 3;
    } else {
      return 0;
    }
  }

  private int countDieThatReadNumber(int number) {
    return (int) IntStream.of(dice).filter(d -> d == number).count();
  }
}
