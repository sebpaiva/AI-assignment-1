package Puzzle8;

import java.util.Objects;

public class HeuristicPuzzle
  implements Comparable<HeuristicPuzzle>
{
  Puzzle8 puzzle8;

  Integer hScore;
  Integer gScore;
  Integer fScore;

  public Puzzle8 getPuzzle8()
  {
    return puzzle8;
  }

  public int getF()
  {
    return fScore;
  }

  public int getH()
  {
    return hScore;
  }

  public void setH( int hScore )
  {
    this.hScore = hScore;
  }

  public HeuristicPuzzle( Puzzle8 puzzle8, int h, int g )
  {
    this.puzzle8 = puzzle8;
    this.hScore = h;
    this.gScore = g;
    this.fScore = hScore + gScore;
  }

  @Override
  public int compareTo( HeuristicPuzzle puzzle )
  {
    return this.fScore.compareTo( puzzle.fScore );
  }
}
