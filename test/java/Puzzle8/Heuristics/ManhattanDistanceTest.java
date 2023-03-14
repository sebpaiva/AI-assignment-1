package Puzzle8.Heuristics;

import Puzzle8.Puzzle8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanDistanceTest {

    @Test
    void calculateFinishedPuzzle() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 8 B 4 7 6 5");

        int manhattanDistance = ManhattanDistance.calculate(puzzle8);

        assertEquals(0, manhattanDistance);
    }

    @Test
    void calculateOnePieceOffByOneSpace() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 B 8 4 7 6 5");

        int manhattanDistance = ManhattanDistance.calculate(puzzle8);

        assertEquals(1, manhattanDistance);
    }

    @Test
    void calculateTwoPiecesOffByOneSpace() {
        Puzzle8 puzzle8 = new Puzzle8("2 1 3 8 B 4 7 6 5");

        int manhattanDistance = ManhattanDistance.calculate(puzzle8);

        assertEquals(2, manhattanDistance);
    }

    @Test
    void calculateAllPiecesOff() {
        Puzzle8 puzzle8 = new Puzzle8("4 1 B 7 8 5 2 3 6");

        // puzzle8.printPuzzle(); // 1 + 3 + 3 + 3 + 1 + 1 + 1 + 1 = 14
        int manhattanDistance = ManhattanDistance.calculate(puzzle8);

        assertEquals(14, manhattanDistance);
    }

    @Test
    void calculateSomePiecesOff() {
        Puzzle8 puzzle8 = new Puzzle8("1 5 3 8 B 4 7 6 2");

        // puzzle8.printPuzzle(); // 0 + 3 + 0 + 0 + 3 + 0 + 0 + 0 = 6
        int manhattanDistance = ManhattanDistance.calculate(puzzle8);

        assertEquals(6, manhattanDistance);
    }

    @Test
    void calculateClassExample() {
        Puzzle8 puzzle8 = new Puzzle8("5 B 8 4 2 1 7 3 6");

        // puzzle8.printPuzzle(); // 3+1+3+2+4+1+0+3 =
        int manhattanDistance = ManhattanDistance.calculate(puzzle8);

        assertEquals(17, manhattanDistance);
    }
}