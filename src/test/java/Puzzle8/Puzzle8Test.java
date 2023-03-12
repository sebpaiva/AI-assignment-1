package Puzzle8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle8Test {

    @Test
    void getSuccessorStatesFromMiddleBlank() {
        Puzzle8 puzzle = new Puzzle8();
        List<Puzzle8> successors = puzzle.getSuccessorStates();
        assertEquals(4, successors.size());
    }

    @Test
    void getSuccessorStatesAfterMoving_shouldNotGiveUndoStep() {
        Puzzle8 puzzle = new Puzzle8();
        puzzle.moveBlank(Puzzle8.Direction.DOWN);
        List<Puzzle8> successors = puzzle.getSuccessorStates();
        assertEquals(2, successors.size());
    }

    @Test
    void moveBlank_down() {
        Puzzle8 puzzle = new Puzzle8();

        puzzle.moveBlank(Puzzle8.Direction.DOWN);
        puzzle.moveBlank(Puzzle8.Direction.DOWN);

        assertEquals(Arrays.asList("1", "2", "3", "8", "6", "4", "7", "B", "5").toString(),
                Arrays.toString(puzzle.convertToHorizontalBoard()));
    }

    @Test
    void moveBlank_square() {
        Puzzle8 puzzle = new Puzzle8();

        puzzle.moveBlank(Puzzle8.Direction.DOWN);
        puzzle.moveBlank(Puzzle8.Direction.DOWN); // Extra
        puzzle.moveBlank(Puzzle8.Direction.RIGHT);
        puzzle.moveBlank(Puzzle8.Direction.RIGHT); // Extra
        puzzle.moveBlank(Puzzle8.Direction.UP);
        puzzle.moveBlank(Puzzle8.Direction.UP);
        puzzle.moveBlank(Puzzle8.Direction.UP); // Extra
        puzzle.moveBlank(Puzzle8.Direction.LEFT);
        puzzle.moveBlank(Puzzle8.Direction.LEFT);

        puzzle.printPuzzle();
        assertTrue(puzzle.isValueAt(Puzzle8.BLANK, 0, 0));
    }

    @Test
    void equals_bothEndPositions(){
        Puzzle8 puzzle1 = new Puzzle8();
        Puzzle8 puzzle2 = new Puzzle8();

        assertEquals(puzzle1, puzzle2);
    }

    @Test
    void equals_notEqualBoards(){
        Puzzle8 puzzle1 = new Puzzle8();
        Puzzle8 puzzle2 = new Puzzle8();
        puzzle2.moveBlank(Puzzle8.Direction.DOWN);

        assertNotEquals(puzzle1, puzzle2);
    }
}