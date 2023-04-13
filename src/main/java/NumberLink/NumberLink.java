package NumberLink;

import Puzzle8.Puzzle8.Direction;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class NumberLink
{
  private final String[][] board;
  private int rows;
  private int cols;
  private Hashtable<String, List<GridCoordinate>> endpoints = new Hashtable<>();

  public NumberLink( String input, int rows, int cols)
  {
    this.rows = rows;
    this.cols = cols;
    String[] inputs = input.split( " " );
    board = new String[ rows ][ cols ];
    int inputCounter = 0;
    for ( int i = 0; i < rows; i++ )
    {
      for ( int j = 0; j < cols; j++ )
      {
        board[ i ][ j ] = inputs[ inputCounter ];
        inputCounter++;

        if(endpoints.get( inputs[ inputCounter ] ) == null){
          endpoints.putIfAbsent( inputs[inputCounter], List.of(new GridCoordinate( i, j ) ) );
        } else {
          endpoints.get( inputs[ inputCounter ] ).add( new GridCoordinate( i, j ) );
        }
      }
    }
  }

  public NumberLink( NumberLink original ){
    this.rows = original.rows;
    this.cols = original.cols;
    board = new String[rows][cols];
    for ( int i = 0; i < original.board.length; i++ )
    {
      System.arraycopy( original.board[ i ], 0, this.board[ i ], 0, original.board[ 0 ].length );
    }
    this.endpoints = original.endpoints;
  }

  private boolean canMove( Direction direction, GridCoordinate origin )
  {
    GridCoordinate newCoordinates = getMoveCoordinates( direction, origin);
    return isWithinBounds( direction, origin ) && board[newCoordinates.getRow()][ newCoordinates.getColumn()].equals( "--" );
  }

  private boolean isWithinBounds( Direction direction, GridCoordinate origin )
  {
    GridCoordinate newCoordinate = getMoveCoordinates( direction, origin );
    return !isOutOfBounds( newCoordinate );
  }

  private GridCoordinate getMoveCoordinates( Direction direction, GridCoordinate currentCoordinate )
  {
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

  public List<NumberLink> getSuccessorStates(GridCoordinate gridCoordinate){
    List<NumberLink> possibleMoves = new ArrayList<>();

    if ( canMove( Direction.UP, gridCoordinate ))
    {
      NumberLink nextUp = new NumberLink( this );
      nextUp.draw( getMoveCoordinates( Direction.UP, gridCoordinate), board[ gridCoordinate.getRow()][gridCoordinate.getColumn()] );
      possibleMoves.add( nextUp );
    }
    if ( canMove( Direction.LEFT, gridCoordinate ))
    {
      NumberLink nextLeft = new NumberLink( this );
      nextLeft.draw( getMoveCoordinates( Direction.LEFT, gridCoordinate), board[ gridCoordinate.getRow()][gridCoordinate.getColumn()] );
      possibleMoves.add( nextLeft );
    }
    if ( canMove( Direction.RIGHT, gridCoordinate ))
    {
      NumberLink nextRight = new NumberLink( this );
      nextRight.draw( getMoveCoordinates( Direction.RIGHT, gridCoordinate), board[ gridCoordinate.getRow()][gridCoordinate.getColumn()] );
      possibleMoves.add( nextRight );
    }
    if ( canMove( Direction.DOWN, gridCoordinate ))
    {
      NumberLink nextDown = new NumberLink( this );
      nextDown.draw( getMoveCoordinates( Direction.DOWN, gridCoordinate), board[ gridCoordinate.getRow()][gridCoordinate.getColumn()] );
      possibleMoves.add( nextDown );
    }

    return possibleMoves;
  }

  private void draw( NumberLink.GridCoordinate moveCoordinates, String s )
  {
    board[ moveCoordinates.getRow()][ moveCoordinates.getColumn()] = s;
  }

  private boolean isOutOfBounds( GridCoordinate coordinate )
  {
    return !rowExists( coordinate.getRow() ) || !columnExists( coordinate.getColumn() );
  }

  private boolean rowExists( int rowNumber )
  {
    return rowNumber <= rows - 1
      && rowNumber >= 0;
  }

  private boolean columnExists( int colNumber )
  {
    return colNumber <= cols - 1
      && colNumber >= 0;
  }

  public void print()
  {
    System.out.println( "__________________________" );
    System.out.println( "The current puzzle is:" );
    System.out.println( "\t┌────┬────┬────┬────┐" );
    for ( int i = 0; i < rows; i++ )
    {
      printLine( board[ i ] );

      if ( i + 1 < rows )
      {

        System.out.println( "\t├────┼────┼────┼────┤" );
      }
    }
    System.out.println( "\t└────┴────┴────┴────┘" );
    System.out.println( "__________________________\n" );
  }

  private void printLine( String[] row )
  {
    StringBuilder builder = new StringBuilder();
    builder.append( "\t| " );
    for ( String item : row )
    {
      builder.append( item );
      builder.append( " | " );
    }
    System.out.println( builder );
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
