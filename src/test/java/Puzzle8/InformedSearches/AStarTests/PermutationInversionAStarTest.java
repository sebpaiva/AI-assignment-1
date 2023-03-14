package Puzzle8.InformedSearches.AStarTests;

import Puzzle8.Heuristics.PermutationInversion;
import Puzzle8.InformedSearches.AStar;
import Puzzle8.Puzzle8;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationInversionAStarTest
{
  @Test
  void calculate_completedPuzzle()
  {
    Puzzle8 puzzle = new Puzzle8();
    AStar aStar = new AStar( puzzle );

    aStar.calculate( new PermutationInversion() );

    aStar.printSolutionSteps();
    System.out.println( aStar );
    assertEquals( 0, aStar.getTotalMoves() );
  }

  @Test
  void calculate_oneMoveToSolution()
  {
    Puzzle8 puzzle = new Puzzle8( "1 2 3 B 8 4 7 6 5" );
    AStar aStar = new AStar( puzzle );

    aStar.calculate( new PermutationInversion() );

    aStar.printSolutionSteps();
    System.out.println( aStar );
    assertEquals( 1, aStar.getTotalMoves() );
  }

  @Test
  void calculate_7MovesToSolution()
  {
    Puzzle8 puzzle = new Puzzle8( "1 2 3 B 5 6 8 7 4" );
    AStar aStar = new AStar( puzzle );

    aStar.calculate( new PermutationInversion() );

    aStar.printSolutionSteps();
    System.out.println( aStar );
    assertEquals( 7, aStar.getTotalMoves() );
  }

  @Test
  void calculate_10MovesToSolution()
  {
    Puzzle8 puzzle = new Puzzle8( "7 1 2 8 B 3 6 5 4" );
    AStar aStar = new AStar( puzzle );

    aStar.calculate( new PermutationInversion() );

    aStar.printSolutionSteps();
    System.out.println( aStar );
    assertEquals( 10, aStar.getTotalMoves() );
  }

  @Test
  void calculate_16MoveToSolution()
  {
    Puzzle8 puzzle = new Puzzle8( "2 4 5 3 B 1 8 7 6" );
    AStar aStar = new AStar( puzzle );

    aStar.calculate( new PermutationInversion() );

    aStar.printSolutionSteps();
    System.out.println( aStar );
    assertEquals( 16, aStar.getTotalMoves() );
  }

//  @Test
//  void calculate_scrambled()
//  {
//    Puzzle8 puzzle = new Puzzle8( "8 6 4 2 3 7 1 5 B" );
//    AStar aStar = new AStar( puzzle );
//
//    aStar.calculate( new PermutationInversion() );
//
//    aStar.printSolutionSteps();
//    System.out.println( aStar );
//    assertEquals( 22, aStar.getTotalMoves() );
//  }
}