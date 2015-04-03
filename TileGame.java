import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;


public class TileGame
{
    public static void main(String args [])
    {
     TileGameStart newGame = new TileGameStart();
     while (newGame.getStart() == false){
      try {
        Thread.sleep(200);
      }
      catch(InterruptedException e){
      }
    }
     newGame.dispose();
     Board newBoard = new Board();
    }
}