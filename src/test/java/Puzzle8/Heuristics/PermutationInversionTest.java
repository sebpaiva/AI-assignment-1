package Puzzle8.Heuristics;

import Puzzle8.Puzzle8;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInversionTest {
    static PermutationInversion permutationInversion;

    @BeforeAll
    static void setup(){
        permutationInversion = new PermutationInversion();
    }

    @Test
    void calculateFinishedPuzzle() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 8 B 4 7 6 5");

        int permutations = permutationInversion.calculate(puzzle8);

        assertEquals(0, permutations);
    }

    @Test
    void calculateScrambled1() {
        Puzzle8 puzzle8 = new Puzzle8("4 1 B 7 8 5 2 3 6");

        int permutations = permutationInversion.calculate(puzzle8);

        assertEquals(12, permutations);
    }

    @Test
    void calculateScrambled2() {
        Puzzle8 puzzle8 = new Puzzle8("1 5 3 8 B 4 7 6 2");

        int permutations = permutationInversion.calculate(puzzle8);

        assertEquals(11, permutations);
    }

    @Test
    void calculateOneOff() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 B 8 4 7 6 5");

        int permutations = permutationInversion.calculate(puzzle8);

        assertEquals(0, permutations);
    }

    @Test
    void calculateChallengeInput() {
        Puzzle8 puzzle8 = new Puzzle8("4 1 3 7 B 5 8 2 6");

        int permutations = permutationInversion.calculate(puzzle8);

        assertEquals(11, permutations);
    }

    @Test
    void calculateClassExample() {
        Puzzle8 puzzle8 = new Puzzle8("5 B 8 4 2 1 7 3 6");

        // 1+0+3+7+0+1+3
        int permutations = permutationInversion.calculate(puzzle8);

        assertEquals(15, permutations);
    }

    @Test
    void calculateStartSwapExample() {
        Puzzle8 puzzle8 = new Puzzle8("8 5 4 1 3 B 2 6 7");

        // 3+6+3+0+1+0+1+0
        int permutations = permutationInversion.calculate(puzzle8);

        assertEquals(14, permutations);
    }
}