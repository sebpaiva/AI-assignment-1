package Puzzle8.InformedSearches.BestFirstTests;

import Puzzle8.Heuristics.ManhattanDistance;
import Puzzle8.InformedSearches.BestFirst;
import Puzzle8.Puzzle8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanBestFirstTest
{
  @Test
  void calculate_completedPuzzle()
  {
    Puzzle8 puzzle = new Puzzle8();
    BestFirst bestFirst = new BestFirst( puzzle );

    bestFirst.calculate( new ManhattanDistance() );

    bestFirst.printSolutionSteps();
    System.out.println( bestFirst );
    assertEquals( 0, bestFirst.getTotalMoves() );
  }

  @Test
  void calculate_oneMoveToSolution()
  {
    Puzzle8 puzzle = new Puzzle8( "1 2 3 B 8 4 7 6 5" );
    BestFirst bestFirst = new BestFirst( puzzle );

    bestFirst.calculate( new ManhattanDistance() );

    bestFirst.printSolutionSteps();
    System.out.println( bestFirst );
    assertEquals( 1, bestFirst.getTotalMoves() );
  }

  @Test
  void calculate_7MovesToSolution()
  {
    Puzzle8 puzzle = new Puzzle8( "1 2 3 B 5 6 8 7 4" );
    BestFirst bestFirst = new BestFirst( puzzle );

    bestFirst.calculate( new ManhattanDistance() );

    bestFirst.printSolutionSteps();
    System.out.println( bestFirst );
    assertEquals( 7, bestFirst.getTotalMoves() );
  }

  @Test
  void calculate_10MovesToSolution()
  {
    Puzzle8 puzzle = new Puzzle8( "7 1 2 8 B 3 6 5 4" );
    BestFirst bestFirst = new BestFirst( puzzle );

    bestFirst.calculate( new ManhattanDistance() );

    bestFirst.printSolutionSteps();
    System.out.println( bestFirst );
    assertEquals( 38, bestFirst.getTotalMoves() );
  }

  @Test
  void calculate_16MoveToSolution()
  {
    Puzzle8 puzzle = new Puzzle8( "2 4 5 3 B 1 8 7 6" );
    BestFirst bestFirst = new BestFirst( puzzle );

    bestFirst.calculate( new ManhattanDistance() );

    bestFirst.printSolutionSteps();
    System.out.println( bestFirst );
    assertEquals( 78, bestFirst.getTotalMoves() );
  }

  @Test
  void calculate_scrambled()
  {
    Puzzle8 puzzle = new Puzzle8( "8 6 4 2 3 7 1 5 B" );
    BestFirst bestFirst = new BestFirst( puzzle );

    bestFirst.calculate( new ManhattanDistance() );

    bestFirst.printSolutionSteps();
    System.out.println( bestFirst );
    assertEquals( 72, bestFirst.getTotalMoves() );
  }
}