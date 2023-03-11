package Puzzle8.Heuristics;

import Puzzle8.Heuristics.HammingDistance;
import Puzzle8.Puzzle8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammingDistanceTest {

    @Test
    void calculateFinishedPuzzle() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 8 B 4 7 6 5");

        int hammingDistance = HammingDistance.calculate(puzzle8);

        assertEquals(0, hammingDistance);
    }

    @Test
    void calculateOnePieceOff() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 B 8 4 7 6 5");

        int hammingDistance = HammingDistance.calculate(puzzle8);

        assertEquals(1, hammingDistance);
    }

    @Test
    void calculateAllPiecesOff() {
        Puzzle8 puzzle8 = new Puzzle8("4 1 B 7 8 5 2 3 6");

        int hammingDistance = HammingDistance.calculate(puzzle8);

        assertEquals(8, hammingDistance);
    }

    @Test
    void calculateSomePiecesOff() {
        Puzzle8 puzzle8 = new Puzzle8("1 5 3 8 B 4 7 6 2");

        int hammingDistance = HammingDistance.calculate(puzzle8);

        assertEquals(2, hammingDistance);
    }
}