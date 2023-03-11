import Puzzle8.Heuristics.HammingDistance;
import Puzzle8.Heuristics.ManhattanDistance;
import Puzzle8.Heuristics.PermutationInversion;
import Puzzle8.Puzzle8;
import Puzzle8.SolvablePuzzleGenerator;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main
{
  public static void main(String[] args)
  {
    playTest8Puzzle();
  }

  static void playTest8Puzzle()
  {
    Puzzle8 puzzle8 = new Puzzle8();
    puzzle8.printPuzzle();
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
        case "generate" -> {
          puzzle8 = SolvablePuzzleGenerator.generate();
          puzzle8.printPuzzle();
        }
        case "hamming" -> System.out.println("Hamming distance is: " + HammingDistance.calculate(puzzle8));
        case "permutation" -> System.out.println("Permutation inversion is: " + PermutationInversion.calculate(puzzle8));
        case "manhattan" -> System.out.println("Manhattan distance is: " + ManhattanDistance.calculate(puzzle8));
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
