package Puzzle8.UninformedSearches;

import Puzzle8.Puzzle8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstTest {

    @Test
    void calculate_completedPuzzle() {
        Puzzle8 puzzle = new Puzzle8();
        BreadthFirst breadthFirst = new BreadthFirst(puzzle);

        breadthFirst.calculate();

        breadthFirst.printSolutionSteps();
        System.out.println(breadthFirst);
        assertEquals(0, breadthFirst.getTotalMoves());
    }
    @Test
    void calculate_oneMoveToSolution() {
        Puzzle8 puzzle = new Puzzle8("1 2 3 B 8 4 7 6 5");
        BreadthFirst breadthFirst = new BreadthFirst(puzzle);

        breadthFirst.calculate();

        breadthFirst.printSolutionSteps();
        System.out.println(breadthFirst);
        assertEquals(1, breadthFirst.getTotalMoves());
    }

    @Test
    void calculate_7MovesToSolution() {
        Puzzle8 puzzle = new Puzzle8("1 2 3 B 5 6 8 7 4");
        BreadthFirst breadthFirst = new BreadthFirst(puzzle);

        breadthFirst.calculate();

        breadthFirst.printSolutionSteps();
        System.out.println(breadthFirst);
        assertEquals(7, breadthFirst.getTotalMoves());
    }

    @Test
    void calculate_10MovesToSolution() {
        Puzzle8 puzzle = new Puzzle8("7 1 2 8 B 3 6 5 4");
        BreadthFirst breadthFirst = new BreadthFirst(puzzle);

        breadthFirst.calculate();

        breadthFirst.printSolutionSteps();
        System.out.println(breadthFirst);
        assertEquals(10, breadthFirst.getTotalMoves());
    }

    @Test
    void calculate_16MoveToSolution() {
        Puzzle8 puzzle = new Puzzle8("2 4 5 3 B 1 8 7 6");
        BreadthFirst breadthFirst = new BreadthFirst(puzzle);

        breadthFirst.calculate();

        breadthFirst.printSolutionSteps();
        System.out.println(breadthFirst);
        assertEquals(16, breadthFirst.getTotalMoves());
    }

//    @Test
//    void challengeInput() {
//        Puzzle8 puzzle = new Puzzle8("2 4 5 3 B 1 8 7 6");
//        BreadthFirst breadthFirst = new BreadthFirst(puzzle);
//
//        breadthFirst.calculate();
//
//        breadthFirst.printSolutionSteps();
//        System.out.println(breadthFirst);
//        assertEquals(16, breadthFirst.getTotalMoves());
//    }

    // Takes too long, can't run it
//    @Test
//    void calculate_scrambled() {
//        Puzzle8 puzzle = new Puzzle8("8 6 4 2 3 7 1 5 B");
//
//        BreadthFirst breadthFirst = new BreadthFirst(puzzle);
//        breadthFirst.calculate();
//
//        System.out.println(breadthFirst);
//    }
}