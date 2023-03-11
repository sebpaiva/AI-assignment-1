package Puzzle8.Heuristics;

import Puzzle8.Puzzle8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInversionTest {
    @Test
    void calculateFinishedPuzzle() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 8 B 4 7 6 5");

        int hammingDistance = PermutationInversion.calculate(puzzle8);

        assertEquals(0, hammingDistance);
    }

    @Test
    void calculateClassExample() {
        Puzzle8 puzzle8 = new Puzzle8("5 B 8 4 2 1 7 3 6");
        // "1", "2", "3", "8", "4", "7", "6", "5"
        // 0 +
        int hammingDistance = PermutationInversion.calculate(puzzle8);

        assertEquals(16, hammingDistance);
    }
}