package Puzzle8;

public class SolvablePuzzleGenerator
{
  public static Puzzle8 generate()
  {
    Puzzle8 puzzle8 = new Puzzle8();
    int randomNum;

    int min = 1;
    int range = 4;

    // Scramble the board by doing many randomly decided moves
    for ( int i = 0; i < 50; i++ )
    {
      randomNum = ( int ) ( Math.random() * range ) + min;

      switch ( randomNum )
      {
        case 1 -> puzzle8.moveBlank( Puzzle8.Direction.DOWN );
        case 2 -> puzzle8.moveBlank( Puzzle8.Direction.UP );
        case 3 -> puzzle8.moveBlank( Puzzle8.Direction.LEFT );
        case 4 -> puzzle8.moveBlank( Puzzle8.Direction.RIGHT );
      }
    }

    return puzzle8;
  }
}
