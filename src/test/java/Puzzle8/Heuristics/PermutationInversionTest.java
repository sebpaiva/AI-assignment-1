package Puzzle8.Heuristics;

import Puzzle8.Puzzle8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInversionTest {
    @Test
    void calculateFinishedPuzzle() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 8 B 4 7 6 5");

        int permutations = PermutationInversion.calculate(puzzle8);

        assertEquals(0, permutations);
    }

    @Test
    void calculateClassExample() {
        Puzzle8 puzzle8 = new Puzzle8("5 B 8 4 2 1 7 3 6");

        // 1+0+3+7+0+1+3
        int permutations = PermutationInversion.calculate(puzzle8);

        assertEquals(15, permutations);
    }

    @Test
    void calculateStartSwapExample() {
        Puzzle8 puzzle8 = new Puzzle8("8 5 4 1 3 B 2 6 7");

        // 3+6+3+0+1+0+1+0
        int permutations = PermutationInversion.calculate(puzzle8);

        assertEquals(14, permutations);
    }
}