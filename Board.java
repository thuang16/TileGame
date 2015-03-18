public class Board 
{
  public static void board()
  {
    DividePicture canvas = new DividePicture("640x480.jpg");
    for(int k=1;k<9;k++)
    canvas.divideTile(k);
    canvas.explore();
  }
  public static void main(String[] args)
  {

     board();
  }
}