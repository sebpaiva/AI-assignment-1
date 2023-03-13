import Puzzle8.Heuristics.HammingDistance;
import Puzzle8.Heuristics.ManhattanDistance;
import Puzzle8.Heuristics.PermutationInversion;
import Puzzle8.Puzzle8;
import Puzzle8.SolvablePuzzleGenerator;
import Puzzle8.UninformedSearches.BreadthFirst;
import Puzzle8.UninformedSearches.DepthFirst;

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
        // General methods
        case "print" -> puzzle8.printPuzzle();
        case "down" -> {
          puzzle8.moveBlank(Puzzle8.Direction.DOWN);
          puzzle8.printPuzzle();
        }
        case "up" -> {
          puzzle8.moveBlank(Puzzle8.Direction.UP);
          puzzle8.printPuzzle();
        }
        case "left" -> {
          puzzle8.moveBlank(Puzzle8.Direction.LEFT);
          puzzle8.printPuzzle();
        }
        case "right" -> {
          puzzle8.moveBlank(Puzzle8.Direction.RIGHT);
          puzzle8.printPuzzle();
        }
        case "generate" -> {
          puzzle8 = SolvablePuzzleGenerator.generate();
          puzzle8.printPuzzle();
        }
        case "solved" -> System.out.println(puzzle8.isPuzzleSolved());
        case "successors" -> puzzle8.getSuccessorStates().forEach(Puzzle8::printPuzzle);
        // Heuristics
        case "hamming" -> System.out.println("Hamming distance is: " + HammingDistance.calculate(puzzle8));
        case "permutation" -> System.out.println("Permutation inversion is: " + PermutationInversion.calculate(puzzle8));
        case "manhattan" -> System.out.println("Manhattan distance is: " + ManhattanDistance.calculate(puzzle8));
        // Uninformed Searches
        case "bfs" -> {
          BreadthFirst bf = new BreadthFirst(puzzle8);
          bf.calculate();
        }
        case "dfs" -> {
          DepthFirst df = new DepthFirst(puzzle8);
          df.calculate();
        }
      }
    }
  }
}
