import java.util.Random;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Board 
{
   int[][] theBoard =  {{1,2,3},
                       {4,5,6},
                       {7,8,0}};
   
  public int[][] getBoard()
  {
    return theBoard;
  }
 

  public String direction(int row, int col)
  {
      if (Math.random()<(1/2))
      {
        if (Math.random()<(1/2))
          return "up";
        else
          return "down";
      }
      else
      {
        if (Math.random()<(1/2))
          return "left";
        else
          return "right";
      }
  }    
  public void shuffle()
  {
    int temp = 0;
    for(int row= 0; row<3; row++){
      for(int col=0; col<3; col++){
        if(theBoard[row][col] == 0)
        {
           temp = theBoard[row][col];
          if(direction(row, col).equals("up"))
          {
            if(row+1>2)
            {
              theBoard[row][col] = theBoard[row-1][col];
              theBoard[row-1][col]= temp;
            }
            else
            {
              theBoard[row][col] = theBoard[row+1][col];
              theBoard[row+1][col]= temp;
            }
             if(direction(row, col).equals("down"))
          {
            if(row-1<0)
            {
              theBoard[row][col] = theBoard[row+1][col];
              theBoard[row+1][col]= temp;
            }
            else
            {
              theBoard[row][col] = theBoard[row-1][col];
              theBoard[row-1][col]= temp;
            }
             if(direction(row, col).equals("left"))
          {
            if(row-1<0)
            {
              theBoard[row][col] = theBoard[row][col+1];
              theBoard[row][col+1]= temp;
            }
            else
            {
              theBoard[row][col] = theBoard[row][col-1];
              theBoard[row][col-1]= temp;
            }
          }
             if(direction(row, col).equals("right"))
          {
            if(row+1<2)
            {
              theBoard[row][col] = theBoard[row][col-1];
              theBoard[row][col-1]= temp;
            }
            else
            {
              theBoard[row][col] = theBoard[row][col+1];
              theBoard[row][col+1]= temp;
            }
          }
          }
          }
        }
      }
    }
  }
  
              
              
             
           

}
  
