package Puzzle8.Heuristics;

import Puzzle8.Heuristics.Interface.IHeuristic;
import Puzzle8.Puzzle8;

public class HammingDistance implements IHeuristic
{
  @Override
  public int calculate( Puzzle8 puzzle8 )
  {
    if ( puzzle8.isPuzzleSolved() )
    {
      return 0;
    }

    int hammingCounter = 0;

      if ( !puzzle8.isValueAt( "1", 0, 0 ) )
      {
          hammingCounter++;
      }

      if ( !puzzle8.isValueAt( "2", 0, 1 ) )
      {
          hammingCounter++;
      }

      if ( !puzzle8.isValueAt( "3", 0, 2 ) )
      {
          hammingCounter++;
      }

      if ( !puzzle8.isValueAt( "8", 1, 0 ) )
      {
          hammingCounter++;
      }

      if ( !puzzle8.isValueAt( "4", 1, 2 ) )
      {
          hammingCounter++;
      }

      if ( !puzzle8.isValueAt( "7", 2, 0 ) )
      {
          hammingCounter++;
      }

      if ( !puzzle8.isValueAt( "6", 2, 1 ) )
      {
          hammingCounter++;
      }

      if ( !puzzle8.isValueAt( "5", 2, 2 ) )
      {
          hammingCounter++;
      }

    return hammingCounter;
  }
}
