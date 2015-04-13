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
  private int picNum = (int)(Math.random() * 4) + 1; // picNum is set to a random number between 1 and 4
  
  
  public Board() //creates panel, adds text and buttons
  {
   panel = new JPanel();
    getContentPane().add(panel);    
    panel.setLayout(null);
    
        if(picNum == 1)
     {
        try {
    toast = ImageIO.read(new File("toast1.jpg")); //loads toast image 1
} catch (IOException e) {
}
     }
     if(picNum == 2)
     {
        try {
    toast = ImageIO.read(new File("toast2.jpg")); //loads toast image 2
} catch (IOException e) {
}
     }
     if(picNum == 3)
     {
        try {
    toast = ImageIO.read(new File("toast3.jpg")); //loads toast image 3
} catch (IOException e) {
}
     }
     if(picNum == 4)
     {
        try {
    toast = ImageIO.read(new File("toast4.jpg")); //loads toast image 4
} catch (IOException e) {
}
     }

try {
    white = ImageIO.read(new File("White.jpg")); // loads blank image
} catch (IOException e) {
}

    shuffle = new JButton("Click to Shuffle");
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
     win.setBounds (50, 10, 500, 20);
     
    setBoard();
    
     setTitle("Tile Game");
    setSize(800,700);
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
   
  }

public void setBoard() //makes the board by creating a 2d array of Tiles which are JButtons
{
  theBoard = new Tiles[3][3];
  int index = 1;
  for(int row = 0; row < 3; row++)
{
  for(int col = 0; col < 3; col++)
  {
   
    if(row == 2 && col == 2) // sets the bottom corner as a white tile
    {
    theBoard[row][col] = new Tiles(white.getSubimage(500/3*row,500/3*col,500/3,500/3), 9,true);
    theBoard[row][col].setBounds(((row+1)*500/3) -50, (col+1)*500/3 -50 , 500/3, 500/3); 
    panel.add(theBoard[row][col]);  
    
    }
    else //sets all the other as parts of the toast image
    {
        theBoard[row][col] = new Tiles(toast.getSubimage(500/3*row,500/3*col,500/3,500/3), index,false);
    theBoard[row][col].setBounds(((row+1)*500/3) -50, (col+1)*500/3 -50 , 500/3, 500/3);
    panel.add(theBoard[row][col]);
    }
    index++;
  }
  }
}

public void addTileListener() //adds mouse listener to all the tiles
{
  for(int row = 0; row < 3; row++)
  {
    for(int col = 0; col < 3; col++)
    {
          theBoard[row][col].addActionListener(this);
    }
  }
}


  public String direction() // returns random direction, used to shuffle board
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
  
  public void shuffleTiles() // shuffles tiles around 500 times by moving the blank tile around.
  {                          // if it the blank tile can't go in a direction, it goes to th opposite
    int shuffleCount = 0;    // for example, if it's supposed to move right, but it can't, it moves left
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

  
  
 
  public boolean winCheck() // checks the winning condition by comparing the index of each tile with the correct index
  {
  for(int row = 0; row < 3; row++)
{
  for(int col = 0; col < 3; col++)
  {
    if (theBoard[row][col].getIndex() != theBoard[row][col].getSolution())
    {
      return false;
    }
  }
  }
    return true;
  }
  
  public boolean checkNextTo(int row, int col) //checks if a tile is next to the blank tile, if it is, it swaps the two
  {
   if(row != 0)
   {
     if(theBoard[row-1][col].blankTile())
     {
       theBoard[row][col].tileSwap(theBoard[row-1][col]);
       return true;
     }
   }
   if(row != 2)
   {
     if(theBoard[row+1][col].blankTile())
     {
       theBoard[row][col].tileSwap(theBoard[row+1][col]);
       return true;
     }
   }
   if(col != 0)
   {
     if(theBoard[row][col-1].blankTile())
     {
       theBoard[row][col].tileSwap(theBoard[row][col-1]);
       return true;
     }
   }
   if(col != 2)
   {
     if(theBoard[row][col+1].blankTile())
     {
       theBoard[row][col].tileSwap(theBoard[row][col+1]);
       return true;
     }
   }
  
   return false;
  }
    
    
  public void actionPerformed(ActionEvent event)
  { 
   if (event.getSource() == shuffle) // if shuffle is clicked, it shuffles the tile, adds listeners, and removes itself
   {
     shuffleTiles();
     addTileListener();
     panel.add(instruction);
     panel.remove(win);
     shuffle.setText("Restart");
     panel.repaint();
     countNum = 0;
     count.setText("Number of Moves: " + countNum);
     
   }

     
              
   for(int row = 0; row < 3; row++)
{
  for(int col = 0; col < 3; col++)
  {
    if(event.getSource() == theBoard[row][col])// checks each tile to see if it's clicked and swaps if possible.
    {
     if(checkNextTo(row,col)==true)
     {
      countNum++;
      count.setText("Number of Moves: " + countNum);
     }
      if (winCheck() == true && countNum > 0) // checks win condition each time
      {
        win.setText("Congratulations! You have reconstructed the toast");//winning statement
        panel.add(win);
        panel.remove(instruction);
        shuffle.setText("New Game"); // renames shuffle button to new game
        panel.add(shuffle);
        panel.repaint();
        
        for(int row1 = 0; row1 < 3; row1++)
{
  for(int col1 = 0; col1 < 3; col1++)
  {
   theBoard[row1][col1].removeActionListener(this); // takes away listener if won, so tiles can't be moved.
  }
 }
        
        
      }
    }
  }
   }
  }
}


              
             

  
  
