package Puzzle8.InformedSearches;

import Puzzle8.Heuristics.Interface.IHeuristic;
import Puzzle8.Puzzle8;
import Puzzle8.HeuristicPuzzle;
import Puzzle8.UninformedSearches.UninformedSearchHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar
{
  private final Queue<HeuristicPuzzle> open = new PriorityQueue<>();
  private final Queue<HeuristicPuzzle> closed = new PriorityQueue<>();

  private final Puzzle8 initial;
  private boolean foundSolution = false;
  private long totalTime;
  private int totalMoves;
  private List<Puzzle8.Direction> moveHistory = new ArrayList<>();

  public AStar( Puzzle8 initial )
  {
    this.initial = initial;
  }

  public void calculate( IHeuristic heuristic )
  {
    Puzzle8 initialCopy = new Puzzle8( initial );
    initialCopy.clearMoveHistory();
    initialCopy.setMoveCounter( 0 );
    HeuristicPuzzle heuristicPuzzleInitial = new HeuristicPuzzle( initialCopy, heuristic.calculate( initialCopy ), 0 );
    open.add( heuristicPuzzleInitial );

    long startTimer = System.currentTimeMillis();
    while ( !open.isEmpty() )
    {
      HeuristicPuzzle current = open.remove();
      closed.add( current );

      if ( current.getPuzzle8().isPuzzleSolved() )
      {
        foundSolution = true;
        totalTime = System.currentTimeMillis() - startTimer;
        totalMoves = current.getPuzzle8().getMoveCounter();
        moveHistory = current.getPuzzle8().getMoveHistory();
        return;
      }

      // Filter out states which are already in open or closed lists
      List<HeuristicPuzzle> unseenSuccessorsOfCurrent = current.getPuzzle8().getSuccessorStates().stream()
        .filter( successor -> !open.stream().map( HeuristicPuzzle::getPuzzle8 ).toList().contains( successor ) )
        .filter( successor -> !closed.stream().map( HeuristicPuzzle::getPuzzle8 ).toList().contains( successor ) )
        // Compared to BestFirst, this one adds the move counter to the equation for f(n)
        .map( puzzle -> new HeuristicPuzzle( puzzle, heuristic.calculate( puzzle ), puzzle.getMoveCounter() ) )
        .toList();

      open.addAll( unseenSuccessorsOfCurrent );
    }

    System.out.println( "A solution could not be found. Can the puzzle be solved?" );
    totalTime = System.currentTimeMillis() - startTimer;
  }

  public void printSolutionSteps()
  {
    UninformedSearchHelper.printSolutionSteps( initial, moveHistory );
  }

  @Override
  public String toString()
  {
    return UninformedSearchHelper.toStringFormat( "BestFirst",
                                                  foundSolution,
                                                  totalTime,
                                                  totalMoves,
                                                  open.size(),
                                                  closed.size() );
  }

  public Puzzle8 getInitial()
  {
    return initial;
  }

  public boolean isFoundSolution()
  {
    return foundSolution;
  }

  public long getTotalTime()
  {
    return totalTime;
  }

  public int getTotalMoves()
  {
    return totalMoves;
  }
}
