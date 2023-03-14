package Puzzle8.Heuristics;

import Puzzle8.Puzzle8;

import java.util.Arrays;
import java.util.List;

import static Puzzle8.Puzzle8.BLANK;

public class PermutationInversion implements IHeuristic
{
  // Blank is not counted in heuristic, remove it from the list
  static final String[] horizontalEnd = { "1", "2", "3", "8", "4", "7", "6", "5" };

  /**
   * For each numbered tile, count how many tiles on its right
   * should be on its left in the goal state
   */
  @Override
  public int calculate( Puzzle8 puzzle8 )
  {
    int permutationInversionSum = 0;

    String[] horizontalBoard = puzzle8.convertToHorizontalBoard();

    // `1` never has any tiles on its left in its final position
    // permutationInversionSum += PermutationInversion.inversionsForValue(horizontalBoard, "1");
    permutationInversionSum += PermutationInversion.inversionsForValue( horizontalBoard, "2" );
    permutationInversionSum += PermutationInversion.inversionsForValue( horizontalBoard, "3" );
    permutationInversionSum += PermutationInversion.inversionsForValue( horizontalBoard, "4" );
    permutationInversionSum += PermutationInversion.inversionsForValue( horizontalBoard, "5" );
    permutationInversionSum += PermutationInversion.inversionsForValue( horizontalBoard, "6" );
    permutationInversionSum += PermutationInversion.inversionsForValue( horizontalBoard, "7" );
    permutationInversionSum += PermutationInversion.inversionsForValue( horizontalBoard, "8" );

    return permutationInversionSum;
  }

  private static int inversionsForValue( String[] horizontalBoard, String value )
  {
    int permutationCounter = 0;

    int indexOfFinalPositionValue = findIndexOfValue( horizontalEnd, value );
    List<String> leftElementsOfFinalPosition = Arrays.asList( horizontalEnd ).subList( 0, indexOfFinalPositionValue );

    int indexOfValue = findIndexOfValue( horizontalBoard, value );

    // Iterate from current index to end of the array
    for ( int i = indexOfValue + 1; i < horizontalBoard.length; i++ )
    {
      if ( leftElementsOfFinalPosition.contains( horizontalBoard[ i ] ) )
      {
        permutationCounter++;
      }
    }

    return permutationCounter;
  }

  private static int findIndexOfValue( String[] horizontalBoard, String value )
  {
    for ( int i = 0; i < horizontalBoard.length; i++ )
    {
      if ( horizontalBoard[ i ].equals( value ) )
      {
        return i;
      }
    }
    return -1;
  }
}
