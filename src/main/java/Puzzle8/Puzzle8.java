package Puzzle8;

public class Puzzle8
{
  private final String[][] board = new String[BOARD_ROWS][BOARD_COLS];
  public static final String BLANK = "B";
  private static final int BOARD_COLS = 3;
  private static final int BOARD_ROWS = 3;
  public Puzzle8(String start)
  {
    String[] splitInputs = start.replace( "(", "" )
      .replace( ")", "" )
      .split(" ");

    board[0][0] = splitInputs[0];
    board[0][1] = splitInputs[1];
    board[0][2] = splitInputs[2];
    board[1][0] = splitInputs[3];
    board[1][1] = splitInputs[4];
    board[1][2] = splitInputs[5];
    board[2][0] = splitInputs[6];
    board[2][1] = splitInputs[7];
    board[2][2] = splitInputs[8];
  }

  public boolean isValueAt(String value, int row, int col)
  {
    return board[row][col].equals(value);
  }

  public void moveBlankDown(){
    GridCoordinate coordinate = findGridPositionOf(BLANK);
    int newRow = coordinate.getRow()+1;
    int newColumn = coordinate.getColumn();

    if (!isInBounds(newRow, newColumn))
    {
      System.out.println("Cannot move in that direction.");
      return;
    }

    swapBoardValues(coordinate.getRow(), coordinate.getColumn(), newRow, newColumn);
  }

  private void swapBoardValues(int row1, int col1, int row2, int col2){
    String temp = board[row1][col1];
    board[row1][col1] = board[row2][col2];
    board[row2][col2] = temp;
  }

  private boolean isInBounds(int row, int column)
  {
    return rowExists(row) && columnExists(column);
  }
  private boolean rowExists(int rowNumber){
    return rowNumber <= BOARD_ROWS-1
      && rowNumber >= 0;
  }

  private boolean columnExists(int colNumber){
    return colNumber <= BOARD_COLS-1
      && colNumber >= 0;
  }

  public GridCoordinate findGridPositionOf(String value) {
    for(int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        if (board[i][j].equals(value)) {
          return new GridCoordinate(i, j);
        }
      }
    }

    throw new IllegalArgumentException("Could not find position of " + value + " on the board, is it valid?");
  }

  public void moveBlankUp(){
    GridCoordinate coordinate = findGridPositionOf(BLANK);
    int newRow = coordinate.getRow()-1;
    int newColumn = coordinate.getColumn();

    if (!isInBounds(newRow, newColumn))
    {
      System.out.println("Cannot move in that direction.");
      return;
    }

    swapBoardValues(coordinate.getRow(), coordinate.getColumn(), newRow, newColumn);
  }

  public void moveBlankLeft(){
    GridCoordinate coordinate = findGridPositionOf(BLANK);
    int newRow = coordinate.getRow();
    int newColumn = coordinate.getColumn()-1;

    if (!isInBounds(newRow, newColumn))
    {
      System.out.println("Cannot move in that direction.");
      return;
    }

    swapBoardValues(coordinate.getRow(), coordinate.getColumn(), newRow, newColumn);
  }

  public void moveBlankRight(){
    GridCoordinate coordinate = findGridPositionOf(BLANK);
    int newRow = coordinate.getRow();
    int newColumn = coordinate.getColumn()+1;

    if (!isInBounds(newRow, newColumn))
    {
      System.out.println("Cannot move in that direction.");
      return;
    }

    swapBoardValues(coordinate.getRow(), coordinate.getColumn(), newRow, newColumn);
  }

  public GridCoordinate getFinalPositionOf(String value){
    switch (value) {
      case "1" -> {
        return new GridCoordinate(0, 0);
      }
      case "2" -> {
        return new GridCoordinate(0, 1);
      }
      case "3" -> {
        return new GridCoordinate(0, 2);
      }
      case "4" -> {
        return new GridCoordinate(1, 2);
      }
      case "5" -> {
        return new GridCoordinate(2, 2);
      }
      case "6" -> {
        return new GridCoordinate(2, 1);
      }
      case "7" -> {
        return new GridCoordinate(2, 0);
      }
      case "8" -> {
        return new GridCoordinate(1, 0);
      }
    }
    return null;
  }

  public String[] convertToHorizontalBoard(){
    String[] horizontalBoard = new String[BOARD_ROWS*BOARD_COLS];
    int horizontalBoardCounter = 0;

    for(int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        horizontalBoard[horizontalBoardCounter] = board[i][j];
        horizontalBoardCounter++;
        System.out.print(board[i][j]);
      }
    }

    return horizontalBoard;
  }

  public boolean isPuzzleSolved()
  {
    return board[0][0].equals("1")
      && board[0][1].equals("2")
      && board[0][2].equals("3")
      && board[1][0].equals("8")
      && board[1][1].equals(BLANK)
      && board[1][2].equals("4")
      && board[2][0].equals("7")
      && board[2][1].equals("6")
      && board[2][2].equals("5");
  }

  public void printPuzzle(){
    String firstLine = preparePrintLine(board[0][0], board[0][1], board[0][2]);
    String secondLine = preparePrintLine(board[1][0], board[1][1], board[1][2]);
    String thirdLine = preparePrintLine(board[2][0], board[2][1], board[2][2]);

    System.out.println("__________________________");
    System.out.println("The current puzzle is:");
    System.out.println("\t\t\t┌───┬───┬───┐");
    System.out.println(firstLine);
    System.out.println("\t\t\t├───┼───┼───┤");
    System.out.println(secondLine);
    System.out.println("\t\t\t├───┼───┼───┤");
    System.out.println(thirdLine);
    System.out.println("\t\t\t└───┴───┴───┘");
    System.out.println("__________________________\n");
  }

  String preparePrintLine(String a, String b, String c){
    return "\t\t\t│ " + a + " | " + b + " | " + c + " │";
  }

  public record GridCoordinate(int x, int y) {

      // Column
      public int getRow() {
        return x;
      }

      // Row
      public int getColumn() {
        return y;
      }

      @Override
      public String toString() {
        return "GridCoordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
      }
    }
}
