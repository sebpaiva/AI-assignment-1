package NumberLink;

public class Main
{
  public static void main(String[] args){
    NumberLink link = new NumberLink("*1 *2 -- -- -- *1 *3 -- *2 *3 -- -- -- -- -- --", 4, 4 );
    link.print();
  }
}
