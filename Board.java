import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Board extends JFrame implements ActionListener
{
  private JPanel panel;
  private Tiles[][] theBoard;
  private BufferedImage toast = null;
  private BufferedImage white = null;
  private JButton shuffle;
  private JLabel instruction;
  private JLabel count;
  private int countNum = 0;
  private JLabel win;
  
  
  public Board()
  {
   panel = new JPanel();
    getContentPane().add(panel);    
    panel.setLayout(null);
    
        try {
    toast = ImageIO.read(new File("toast.jpg"));
} catch (IOException e) {
}

try {
    white = ImageIO.read(new File("White.jpg"));
} catch (IOException e) {
}

    shuffle = new JButton("Shuffle");
    shuffle.setBounds(50,50,150,30);
    shuffle.addActionListener(this);
    panel.add(shuffle);
    
 instruction = new JLabel("Click on a tile to shift it to the empty space. Reconstruct the toast to win!");
    instruction.setBounds(50,80,500,20);
    panel.add(instruction);
    
  count = new JLabel("Number of Moves: " + countNum);
    count.setBounds(50,630,200,20);
    panel.add(count);
    
     win = new JLabel();
     win.setBounds (20, 80, 250, 20);
    
    setBoard();

    
     setTitle("Tile Game");
    setSize(800,800);
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
   
  }

public void setBoard()
{
  theBoard = new Tiles[3][3];
  int index = 1;
  for(int row = 0; row < 3; row++)
{
  for(int col = 0; col < 3; col++)
  {
   
    if(row == 2 && col == 2)
    {
    theBoard[row][col] = new Tiles(white.getSubimage(500/3*row,500/3*col,500/3,500/3), 9,true);
    theBoard[row][col].setBounds(((row+1)*500/3) -50, (col+1)*500/3 -50 , 500/3, 500/3); 
    panel.add(theBoard[row][col]);  
    
    }
    else
    {
        theBoard[row][col] = new Tiles(toast.getSubimage(500/3*row,500/3*col,500/3,500/3), index,false);
    theBoard[row][col].setBounds(((row+1)*500/3) -50, (col+1)*500/3 -50 , 500/3, 500/3);
    panel.add(theBoard[row][col]);
    }
    index++;
  }
  }
}

public void addTileListener()
{
  for(int row = 0; row < 3; row++)
  {
    for(int col = 0; col < 3; col++)
    {
          theBoard[row][col].addActionListener(this);
    }
  }
}


  public String direction()
  {
      if (Math.random()< .5)
      {
        if (Math.random()< .5)
          return "up";
        else
          return "down";
      }
      else
      {
        if (Math.random()<.5)
          return "left";
        else
          return "right";
      }
  }
  
  public void shuffleTiles()
  {
    int shuffleCount = 0;
    while(shuffleCount < 500)
    {
    for(int row= 0; row<3; row++){
      for(int col=0; col<3; col++){
        if(theBoard[row][col].blankTile() == true)
        {
          String direc = direction();
          if(direc.equals("up"))
          {
            if(row==0)
            {
             theBoard[row+1][col].tileSwap(theBoard[row][col]);

            }
            else
            {
             theBoard[row-1][col].tileSwap(theBoard[row][col]);
            }
          }
             else if (direc.equals("down"))
          {
            if(row==2)
            {
              theBoard[row-1][col].tileSwap(theBoard[row][col]);
            }
            else
            {
             theBoard[row+1][col].tileSwap(theBoard[row][col]);
            }
             }
             else if(direc.equals("left"))
          {
            if(col==0)
            {
              theBoard[row][col+1].tileSwap(theBoard[row][col]);
            }
            else
            {
             theBoard[row][col-1].tileSwap(theBoard[row][col]);
            }
          }
            else
          {
            if(col==2)
            {
             theBoard[row][col-1].tileSwap(theBoard[row][col]);
            }
            else
            {
             theBoard[row][col+1].tileSwap(theBoard[row][col]);
            }
          }
          }
          }
        }
          shuffleCount++;
    }
    }

  
  
 
  public boolean winCheck()
  {
    boolean won = true;
  for(int row = 0; row < 3; row++)
{
  for(int col = 0; col < 3; col++)
  {
    if (theBoard[row][col].getIndex() != theBoard[row][col].getSolution())
    {
      won = false;
    }
  }
  }
    return won;
  }
  
  public boolean checkNextTo(int row, int col)
  {
   if(row != 0)
   {
     if(theBoard[row-1][col].blankTile())
     {
       theBoard[row-1][col].tileSwap(theBoard[row][col]);
       return true;
     }
   }
   if(row != 2)
   {
     if(theBoard[row+1][col].blankTile())
     {
       theBoard[row+1][col].tileSwap(theBoard[row][col]);
       return true;
     }
   }
   if(col != 0)
   {
     if(theBoard[row][col-1].blankTile())
     {
       theBoard[row][col-1].tileSwap(theBoard[row][col]);
       return true;
     }
   }
   if(col != 2)
   {
     if(theBoard[row][col+1].blankTile())
     {
       theBoard[row][col+1].tileSwap(theBoard[row][col]);
       return true;
     }
   }
   return false;
  }
    
    
  public void actionPerformed(ActionEvent e)
  { 
   if (e.getSource() == shuffle)
   {
     shuffleTiles();
     addTileListener();
   }
              
   for(int row = 0; row < 3; row++)
{
  for(int col = 0; col < 3; col++)
  {
    if(e.getSource() == theBoard[row][col])
    {
     if(checkNextTo(row,col)==true)
     {
      countNum++;
      count.setText("Number of Moves: " + countNum);
     }
      if (winCheck() == true)
      {
        win.setText("Congratulations! You have reconstructed the toast");
        panel.add(win);
        
      }
    }
  }
     }
    }
  }
   
              
             

  
  
