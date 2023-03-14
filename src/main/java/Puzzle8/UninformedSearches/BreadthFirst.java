package Puzzle8.UninformedSearches;

import Puzzle8.Puzzle8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirst
{
  private final Queue<Puzzle8> open = new LinkedList<>();
  private final Queue<Puzzle8> closed = new LinkedList<>();

  private final Puzzle8 initial;
  private boolean foundSolution = false;
  private long totalTime;
  private int totalMoves;
  private List<Puzzle8.Direction> moveHistory = new ArrayList<>();

  public BreadthFirst( Puzzle8 initial )
  {
    this.initial = initial;
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
      Puzzle8 current = open.remove();
      closed.add( current );

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
    return "BreadthFirst{" +
      "foundSolution=" + foundSolution +
      ", secondsTaken=" + ( ( double ) Math.round( ( ( double ) totalTime ) / 10 ) ) / 100 +
      ", totalMoves=" + totalMoves +
      ", openListSize=" + open.size() +
      ", closedListSize(states processed)=" + closed.size() +
      '}';
  }

  public void printSolutionSteps()
  {
    UninformedSearchHelper.printSolutionSteps( initial, moveHistory );
  }

  public Queue<Puzzle8> getOpen()
  {
    return open;
  }

  public Queue<Puzzle8> getClosed()
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
