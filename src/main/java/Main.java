import Puzzle8.Puzzle8;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main
{
  public static void main(String[] args)
  {
    playTest8Puzzle();
//    testPuzzle8();
  }

  static void testPuzzle8()
  {
//    puzzle8.printPuzzle();
  }

  static void playTest8Puzzle()
  {
    Puzzle8 puzzle8 = new Puzzle8( "(1 2 3 B 8 4 7 6 5)" );
    String command;

    while ( true )
    {
      System.out.print( "Please enter a command: " );
      Scanner reader = new Scanner( System.in );
      command = reader.nextLine();

      switch ( command )
      {
        case "exit" -> exit(0 );
        case "print" -> puzzle8.printPuzzle();
        case "down" -> {
          puzzle8.moveBlankDown();
          puzzle8.printPuzzle();
        }
        case "up" -> {
          puzzle8.moveBlankUp();
          puzzle8.printPuzzle();
        }
        case "left" -> {
          puzzle8.moveBlankLeft();
          puzzle8.printPuzzle();
        }
        case "right" -> {
          puzzle8.moveBlankRight();
          puzzle8.printPuzzle();
        }
        case "solved" -> System.out.println(puzzle8.isPuzzleSolved());
      }
    }
  }
}
