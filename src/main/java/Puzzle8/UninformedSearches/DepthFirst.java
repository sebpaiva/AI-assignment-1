package Puzzle8.UninformedSearches;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Puzzle8.Puzzle8;

public class DepthFirst
{
  private final Stack<Puzzle8> open = new Stack<>();
  private final Stack<Puzzle8> closed = new Stack<>();

  private final Puzzle8 initial;
  private boolean foundSolution = false;
  private long totalTime;
  private int totalMoves;
  private List<Puzzle8.Direction> moveHistory = new ArrayList<>();

  public DepthFirst( Puzzle8 puzzle8 )
  {
    this.initial = puzzle8;
  }

  public void calculate()
  {
    Puzzle8 initialCopy = new Puzzle8( initial );
    initialCopy.clearMoveHistory();
    initialCopy.setMoveCounter( 0 );
    open.add( initialCopy );

    long startTimer = System.currentTimeMillis();
    while ( !open.isEmpty() )
    {
      Puzzle8 current = open.pop();
      closed.push( current );

      if ( current.isPuzzleSolved() )
      {
        foundSolution = true;
        totalTime = System.currentTimeMillis() - startTimer;
        totalMoves = current.getMoveCounter();
        moveHistory = current.getMoveHistory();
        return;
      }

      // Filter out states which are already in open or closed lists
      List<Puzzle8> unseenSuccessorsOfCurrent = current.getSuccessorStates().stream()
        .filter( successor -> !open.contains( successor ) )
        .filter( successor -> !closed.contains( successor ) )
        .toList();

      open.addAll( unseenSuccessorsOfCurrent );
    }

    System.out.println( "A solution could not be found. Can the puzzle be solved?" );
    totalTime = System.currentTimeMillis() - startTimer;
  }

  @Override
  public String toString()
  {
    return UninformedSearchHelper.toStringFormat( "DepthFirst",
                                                  foundSolution,
                                                  totalTime,
                                                  totalMoves,
                                                  open.size(),
                                                  closed.size() );
  }

  public void printSolutionSteps()
  {
    UninformedSearchHelper.printSolutionSteps( initial, moveHistory );
  }

  public Stack<Puzzle8> getOpen()
  {
    return open;
  }

  public Stack<Puzzle8> getClosed()
  {
    return closed;
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
