package Puzzle8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle8
{
  public enum Direction
  {
    UP, DOWN, LEFT, RIGHT, NONE;
  }

  private final String[][] board = new String[ BOARD_ROWS ][ BOARD_COLS ];
  private static final int BOARD_ROWS = 3;
  private static final int BOARD_COLS = 3;
  public static final String BLANK = "B";

  private List<Direction> moveHistory = new ArrayList<>();

  public void setMoveCounter( int moveCounter )
  {
    this.moveCounter = moveCounter;
  }

  private int moveCounter = 0;

  /**
   * Default constructor creates a solved puzzle
   */
  public Puzzle8()
  {
    this( "1 2 3 8 B 4 7 6 5" );
  }

  public Puzzle8( String start )
  {
    String[] splitInputs = start.replace( "(", "" )
      .replace( ")", "" )
      .split( " " );

    board[ 0 ][ 0 ] = splitInputs[ 0 ];
    board[ 0 ][ 1 ] = splitInputs[ 1 ];
    board[ 0 ][ 2 ] = splitInputs[ 2 ];
    board[ 1 ][ 0 ] = splitInputs[ 3 ];
    board[ 1 ][ 1 ] = splitInputs[ 4 ];
    board[ 1 ][ 2 ] = splitInputs[ 5 ];
    board[ 2 ][ 0 ] = splitInputs[ 6 ];
    board[ 2 ][ 1 ] = splitInputs[ 7 ];
    board[ 2 ][ 2 ] = splitInputs[ 8 ];
  }

  public Puzzle8( Puzzle8 original )
  {
    for ( int i = 0; i < original.board.length; i++ )
    {
      System.arraycopy( original.board[ i ], 0, this.board[ i ], 0, original.board[ 0 ].length );
    }
    this.moveHistory = new ArrayList<>( original.moveHistory );
    this.moveCounter = original.moveCounter;
  }

  private Direction getLastMove()
  {
    if ( moveHistory.isEmpty() )
    {
      return Direction.NONE;
    }
    return moveHistory.get( moveHistory.size() - 1 );
  }

  public List<Puzzle8> getSuccessorStates()
  {
    List<Puzzle8> possibleMoves = new ArrayList<>();

    if ( canMove( Direction.UP ) && getLastMove() != Direction.DOWN )
    {
      Puzzle8 nextUp = new Puzzle8( this );
      nextUp.moveBlank( Direction.UP );
      possibleMoves.add( nextUp );
    }
    if ( canMove( Direction.LEFT ) && getLastMove() != Direction.RIGHT )
    {
      Puzzle8 nextLeft = new Puzzle8( this );
      nextLeft.moveBlank( Direction.LEFT );
      possibleMoves.add( nextLeft );
    }
    if ( canMove( Direction.RIGHT ) && getLastMove() != Direction.LEFT )
    {
      Puzzle8 nextRight = new Puzzle8( this );
      nextRight.moveBlank( Direction.RIGHT );
      possibleMoves.add( nextRight );
    }
    if ( canMove( Direction.DOWN ) && getLastMove() != Direction.UP )
    {
      Puzzle8 nextDown = new Puzzle8( this );
      nextDown.moveBlank( Direction.DOWN );
      possibleMoves.add( nextDown );
    }

    return possibleMoves;
  }

  public boolean isValueAt( String value, int row, int col )
  {
    return board[ row ][ col ].equals( value );
  }

  private boolean canMove( Direction direction )
  {
    GridCoordinate coordinate = getPostMoveBlankCoordinates( direction );
    return !isOutOfBounds( coordinate );
  }

  public void moveBlank( Direction direction )
  {
    GridCoordinate coordinate = findGridPositionOf( BLANK );

    GridCoordinate newCoordinate = getPostMoveBlankCoordinates( direction );

    if ( isOutOfBounds( newCoordinate ) )
    {
      return;
    }

    moveCounter++;
    moveHistory.add( direction );
    swapBoardValues( coordinate.getRow(), coordinate.getColumn(), newCoordinate.getRow(), newCoordinate.getColumn() );
  }

  private GridCoordinate getPostMoveBlankCoordinates( Direction direction )
  {
    GridCoordinate currentCoordinate = findGridPositionOf( BLANK );

    switch ( direction )
    {
      case UP -> {
        return new GridCoordinate( currentCoordinate.getRow() - 1, currentCoordinate.getColumn() );
      }
      case DOWN -> {
        return new GridCoordinate( currentCoordinate.getRow() + 1, currentCoordinate.getColumn() );
      }
      case LEFT -> {
        return new GridCoordinate( currentCoordinate.getRow(), currentCoordinate.getColumn() - 1 );
      }
      case RIGHT -> {
        return new GridCoordinate( currentCoordinate.getRow(), currentCoordinate.getColumn() + 1 );
      }
    }
    return new GridCoordinate( -1, -1 );
  }

  private void swapBoardValues( int row1, int col1, int row2, int col2 )
  {
    String temp = board[ row1 ][ col1 ];
    board[ row1 ][ col1 ] = board[ row2 ][ col2 ];
    board[ row2 ][ col2 ] = temp;
  }

  private boolean isOutOfBounds( GridCoordinate coordinate )
  {
    return !rowExists( coordinate.getRow() ) || !columnExists( coordinate.getColumn() );
  }

  private boolean rowExists( int rowNumber )
  {
    return rowNumber <= BOARD_ROWS - 1
      && rowNumber >= 0;
  }

  private boolean columnExists( int colNumber )
  {
    return colNumber <= BOARD_COLS - 1
      && colNumber >= 0;
  }

  public GridCoordinate findGridPositionOf( String value )
  {
    for ( int i = 0; i < 3; i++ )
    {
      for ( int j = 0; j < 3; j++ )
      {
        if ( board[ i ][ j ].equals( value ) )
        {
          return new GridCoordinate( i, j );
        }
      }
    }

    throw new IllegalArgumentException( "Could not find position of " + value + " on the board, is it valid?" );
  }

  public GridCoordinate getFinalPositionOf( String value )
  {
    switch ( value )
    {
      case "1" -> {
        return new GridCoordinate( 0, 0 );
      }
      case "2" -> {
        return new GridCoordinate( 0, 1 );
      }
      case "3" -> {
        return new GridCoordinate( 0, 2 );
      }
      case "4" -> {
        return new GridCoordinate( 1, 2 );
      }
      case "5" -> {
        return new GridCoordinate( 2, 2 );
      }
      case "6" -> {
        return new GridCoordinate( 2, 1 );
      }
      case "7" -> {
        return new GridCoordinate( 2, 0 );
      }
      case "8" -> {
        return new GridCoordinate( 1, 0 );
      }
    }
    return null;
  }

  public String[] convertToHorizontalBoard()
  {
    String[] horizontalBoard = new String[ BOARD_ROWS * BOARD_COLS ];
    int horizontalBoardCounter = 0;

    for ( int i = 0; i < 3; i++ )
    {
      for ( int j = 0; j < 3; j++ )
      {
        horizontalBoard[ horizontalBoardCounter ] = board[ i ][ j ];
        horizontalBoardCounter++;
      }
    }

    return horizontalBoard;
  }

  public boolean isPuzzleSolved()
  {
    return board[ 0 ][ 0 ].equals( "1" )
      && board[ 0 ][ 1 ].equals( "2" )
      && board[ 0 ][ 2 ].equals( "3" )
      && board[ 1 ][ 0 ].equals( "8" )
      && board[ 1 ][ 1 ].equals( BLANK )
      && board[ 1 ][ 2 ].equals( "4" )
      && board[ 2 ][ 0 ].equals( "7" )
      && board[ 2 ][ 1 ].equals( "6" )
      && board[ 2 ][ 2 ].equals( "5" );
  }

  @Override
  public boolean equals( Object other )
  {
    // Compare references
    if ( other == this )
    {
      return true;
    }

    // Check if is an instance of Puzzle8
    if ( !( other instanceof Puzzle8 otherPuzzle ) )
    {
      return false;
    }

    return Arrays.toString( this.convertToHorizontalBoard() )
      .equals( Arrays.toString( otherPuzzle.convertToHorizontalBoard() ) );
  }

  public void printPuzzle()
  {
    String firstLine = preparePrintLine( board[ 0 ][ 0 ], board[ 0 ][ 1 ], board[ 0 ][ 2 ] );
    String secondLine = preparePrintLine( board[ 1 ][ 0 ], board[ 1 ][ 1 ], board[ 1 ][ 2 ] );
    String thirdLine = preparePrintLine( board[ 2 ][ 0 ], board[ 2 ][ 1 ], board[ 2 ][ 2 ] );

    System.out.println( "__________________________" );
    System.out.println( "The current puzzle is:" );
    System.out.println( "\t┌───┬───┬───┐" );
    System.out.println( firstLine );
    System.out.println( "\t├───┼───┼───┤" );
    System.out.println( secondLine );
    System.out.println( "\t├───┼───┼───┤" );
    System.out.println( thirdLine );
    System.out.println( "\t└───┴───┴───┘" );
    System.out.println( "__________________________\n" );
  }

  private String preparePrintLine( String a, String b, String c )
  {
    return "\t│ " + a + " | " + b + " | " + c + " │";
  }

  public List<Direction> getMoveHistory()
  {
    return new ArrayList<>( moveHistory );
  }

  public int getMoveCounter()
  {
    return moveCounter;
  }

  public void clearMoveHistory()
  {
    this.moveHistory = new ArrayList<>();
  }

  public record GridCoordinate(int x, int y)
  {
    // Column
    public int getRow()
    {
      return x;
    }

    // Row
    public int getColumn()
    {
      return y;
    }

    @Override
    public String toString()
    {
      return "GridCoordinate{" +
        "x=" + x +
        ", y=" + y +
        '}';
    }
  }
}
