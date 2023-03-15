package Puzzle8.UninformedSearches;

import Puzzle8.Puzzle8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepthFirstTest
{
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
    void calculate_7MovesToSolution() {
        Puzzle8 puzzle = new Puzzle8("1 2 3 B 5 6 8 7 4");
        DepthFirst depthFirst = new DepthFirst(puzzle);

        depthFirst.calculate();

        depthFirst.printSolutionSteps();
        System.out.println(depthFirst);
        assertEquals(9, depthFirst.getTotalMoves());
    }

//    @Test
//    void calculate_10MovesToSolution() {
//        Puzzle8 puzzle = new Puzzle8("7 1 2 8 B 3 6 5 4");
//        DepthFirst depthFirst = new DepthFirst(puzzle);
//
//        depthFirst.calculate();
//
//        depthFirst.printSolutionSteps();
//        System.out.println(depthFirst);
//        assertEquals(10, depthFirst.getTotalMoves());
//    }

//    @Test
//    void challengeInput() {
//        Puzzle8 puzzle = new Puzzle8("2 4 5 3 B 1 8 7 6");
//        DepthFirst depthFirst = new DepthFirst(puzzle);
//
//        depthFirst.calculate();
//
//        depthFirst.printSolutionSteps();
//        System.out.println(depthFirst);
//        assertEquals(16, depthFirst.getTotalMoves());
//    }
}