package Puzzle8.Heuristics;

import Puzzle8.Heuristics.Interface.IHeuristic;
import Puzzle8.Puzzle8;

public class LastTile
  implements IHeuristic
{
  @Override
  public int calculate( Puzzle8 puzzle8 )
  {
    int manhattanDistanceSum = 0;

    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "1" );
    if ( lastTileApplies( puzzle8, "2" ) )
    {
      manhattanDistanceSum += shortestDistanceToCentre( puzzle8, "2" );
    }
    else
    {
      manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "2" );
    }
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "3" );
    if ( lastTileApplies( puzzle8, "4" ) )
    {
      manhattanDistanceSum += shortestDistanceToCentre( puzzle8, "4" );
    }
    else
    {
      manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "4" );
    }
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "5" );
    if ( lastTileApplies( puzzle8, "6" ) )
    {
      manhattanDistanceSum += shortestDistanceToCentre( puzzle8, "6" );
    }
    else
    {
      manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "6" );
    }
    manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "7" );
    if ( lastTileApplies( puzzle8, "8" ) )
    {
      manhattanDistanceSum += shortestDistanceToCentre( puzzle8, "8" );
    }
    else
    {
      manhattanDistanceSum += ManhattanDistance.shortestDistanceToEnd( puzzle8, "8" );
    }

    return manhattanDistanceSum;
  }

  private boolean lastTileApplies( Puzzle8 puzzle8, String value )
  {
    return shortestDistanceToCentre( puzzle8, value ) < ManhattanDistance.shortestDistanceToEnd( puzzle8, value );
  }

  private static int shortestDistanceToCentre( Puzzle8 puzzle, String value )
  {
    Puzzle8.GridCoordinate origin = puzzle.findGridPositionOf( value );
    Puzzle8.GridCoordinate dest = new Puzzle8.GridCoordinate( 1, 1 );

    return Math.abs( origin.getRow() - dest.getRow() ) + Math.abs( origin.getColumn() - dest.getColumn() );
  }
}
