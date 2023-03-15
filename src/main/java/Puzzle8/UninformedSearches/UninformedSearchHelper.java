package Puzzle8.UninformedSearches;

import Puzzle8.Puzzle8;
import Puzzle8.Puzzle8.Direction;

import java.util.List;

public class UninformedSearchHelper
{
  public static void printSolutionSteps( Puzzle8 initial, List<Direction> moveHistory )
  {
    Puzzle8 puzzle = new Puzzle8( initial );
    System.out.println( "Initial state:" );
    puzzle.printPuzzle();
    for ( Puzzle8.Direction direction : moveHistory )
    {
      System.out.println( "Move: " + direction );
      puzzle.moveBlank( direction );
      puzzle.printPuzzle();
    }
    System.out.println( "Solved in " + moveHistory.size() + " steps" );
  }

  public static String toStringFormat(String className, boolean foundSolution, float totalTime, int totalMoves, int openSize, int closedSize)
  {
    return className + "{" +
      "foundSolution=" + foundSolution +
      ", secondsTaken=" + ( ( double ) Math.round( ( ( double ) totalTime ) / 10 ) ) / 100 +
      ", totalMoves=" + totalMoves +
      ", openListSize=" + openSize +
      ", closedListSize(states processed)=" + closedSize +
      '}';
  }
}
