import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Tiles extends JButton
{
  private ImageIcon tile;
  private boolean blank = false;
  private int tileIndex;
  private int solution;
  
  public Tiles(BufferedImage image, int index,boolean setBlank) //sets the image, gives the correct index and indicates if it's blank
  {
   tile = new ImageIcon(image);
   setIcon(tile);
   tileIndex = index;
   solution = index;
   blank = setBlank;
}
  public void tileSwap(Tiles white) //exchanges the image, index and blank indicator of the tile with the blank one
  {
    ImageIcon temp = white.getTile();
    white.setTile(this.getTile());
    this.setTile(temp);
    this.setBlankTile();
    white.unSetBlankTile();
    white.setIndex(this.getIndex());
    this.setIndex(9);
    
       }
  
  public ImageIcon getTile()// gets the image
  {
    return tile;
  }
  
  public void setTile(ImageIcon newTile) // sets a new image
  {
    tile = newTile;
    setIcon(tile);
  }
  public boolean blankTile()// returns if the tile is blank or not
  {
    return blank;
  }
  public void setBlankTile()//sets a tile as blank
  {
    blank = true;
  }
  public void unSetBlankTile()//sets a tile as not blank
  {
    blank = false;
  }
  public int getIndex()// gets the index
  {
    return tileIndex;
  }
  public void setIndex(int newIndex)// sets a new index
  {
    tileIndex = newIndex;
  }
  public int getSolution()// gets the solution to the tile
  {
    return solution;
  }
}