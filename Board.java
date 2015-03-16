public class Board 
{
  public static void board()
  {
    DividePicture canvas = new DividePicture("640x480.jpg");
    canvas.divide1();
    canvas.explore();
  }
  public static void main(String[] args)
  {
   board();
  }
}