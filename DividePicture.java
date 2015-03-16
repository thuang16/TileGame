import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;

public class DividePicture extends SimplePicture
{
   public DividePicture(String fileName)
  {
    super(fileName);
  }
   public void divide(DividePicture fromPic, 
                 int startRow, int startCol, int endRow,int endCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < endRow &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < endCol &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  public void divide1()
  {
    DividePicture beach = new DividePicture("beach.jpg");
    Pixel[][] pixels = beach.getPixels2D();
    this.divide(beach,0,0,pixels.length/3,pixels[0].length/3);
    this.write("tile 1.jpg");
}
   
}