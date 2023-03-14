package Puzzle8.Heuristics;

import Puzzle8.Puzzle8;

public class ManhattanDistance implements IHeuristic
{
  @Override
  public int calculate( Puzzle8 puzzle8 )
  {
    int manhattanDistanceSum = 0;

    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "1" );
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "2" );
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "3" );
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "4" );
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "5" );
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "6" );
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "7" );
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "8" );

    return manhattanDistanceSum;
  }

  private static int shortestDistanceToEnd( Puzzle8 puzzle, String value )
  {
    Puzzle8.GridCoordinate origin = puzzle.findGridPositionOf( value );
    Puzzle8.GridCoordinate dest = puzzle.getFinalPositionOf( value );

    return Math.abs( origin.getRow() - dest.getRow() ) + Math.abs( origin.getColumn() - dest.getColumn() );
  }
}
