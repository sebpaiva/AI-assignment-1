package Puzzle8.Heuristics;

import Puzzle8.Puzzle8;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammingDistanceTest {
    private static HammingDistance hammingDistance;

    @BeforeAll
    static void setup(){
        hammingDistance = new HammingDistance();
    }

    @Test
    void calculateFinishedPuzzle() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 8 B 4 7 6 5");

        int distance = hammingDistance.calculate(puzzle8);

        assertEquals(0, distance);
    }

    @Test
    void calculateOnePieceOff() {
        Puzzle8 puzzle8 = new Puzzle8("1 2 3 B 8 4 7 6 5");

        int distance = hammingDistance.calculate(puzzle8);

        assertEquals(1, distance);
    }

    @Test
    void calculateAllPiecesOff() {
        Puzzle8 puzzle8 = new Puzzle8("4 1 B 7 8 5 2 3 6");

        int distance = hammingDistance.calculate(puzzle8);

        assertEquals(8, distance);
    }

    @Test
    void calculateSomePiecesOff() {
        Puzzle8 puzzle8 = new Puzzle8("1 5 3 8 B 4 7 6 2");

        int distance = hammingDistance.calculate(puzzle8);

        assertEquals(2, distance);
    }

//    @Test
//    void calculateChallengeInput() {
//        Puzzle8 puzzle8 = new Puzzle8("(4 1 3 7 B 5 8 2 6)");
//
//        int distance = hammingDistance.calculate(puzzle8);
//
//        assertEquals(7, distance);
//    }


}