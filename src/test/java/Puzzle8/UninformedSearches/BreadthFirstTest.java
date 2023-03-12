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

        System.out.println(breadthFirst);
        assertEquals(0, breadthFirst.getMoveCounter());
    }
    @Test
    void calculate_oneMoveToSolution() {
        Puzzle8 puzzle = new Puzzle8("1 2 3 B 8 4 7 6 5");
        BreadthFirst breadthFirst = new BreadthFirst(puzzle);

        breadthFirst.calculate();

        System.out.println(breadthFirst);
        assertEquals(1, breadthFirst.getMoveCounter());
    }

    @Test
    void calculate_dozenMovesToSolution() {
        Puzzle8 puzzle = new Puzzle8("1 2 3 B 8 4 7 6 5");
        BreadthFirst breadthFirst = new BreadthFirst(puzzle);

        breadthFirst.calculate();

        System.out.println(breadthFirst);
        assertEquals(1, breadthFirst.getMoveCounter());
    }

    @Test
    void calculate_scrambled() {
        Puzzle8 puzzle = new Puzzle8("8 6 4 2 3 7 1 5 B");

        BreadthFirst breadthFirst = new BreadthFirst(puzzle);
        breadthFirst.calculate();

        System.out.println(breadthFirst);
    }
}