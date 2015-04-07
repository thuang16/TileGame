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
  public Tiles(BufferedImage image, int index,boolean setBlank)
  {
   tile = new ImageIcon(image);
   setIcon(tile);
   tileIndex = index;
   solution = index;
   blank = setBlank;
}
  public void tileSwap(Tiles white)
  {
    ImageIcon temp = white.getTile();
    white.setTile(this.getTile());
    this.setTile(temp);
    this.setBlankTile();
    white.unSetBlankTile();
    white.setIndex(this.getIndex());
    this.setIndex(9);
    
       }
  
  public ImageIcon getTile()
  {
    return tile;
  }
  
  public void setTile(ImageIcon newTile)
  {
    tile = newTile;
    setIcon(tile);
  }
  public boolean blankTile()
  {
    return blank;
  }
  public void setBlankTile()
  {
    blank = true;
  }
  public void unSetBlankTile()
  {
    blank = false;
  }
  public int getIndex()
  {
    return tileIndex;
  }
  public void setIndex(int newIndex)
  {
    tileIndex = newIndex;
  }
  public int getSolution()
  {
    return solution;
  }
}