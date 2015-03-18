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
    for (int fromRow = startRow, toRow = startRow; 
         fromRow < endRow &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = endRow, toCol = endRow; 
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
  public void divideTile(int tile)
  {
    DividePicture beach = new DividePicture("beach.jpg");
    Pixel[][] pixels = beach.getPixels2D();
    if (tile == 1){
    this.divide(beach,0,0,pixels.length/3,pixels[0].length/3);
    this.write("tile 1.jpg");
    }
    if (tile == 2){
    this.divide(beach,0,pixels[0].length/3,pixels.length/3,pixels[0].length/3*2);
    this.write("tile 2.jpg");
    }
    if (tile == 3){
    this.divide(beach,0,pixels[0].length/3*2,pixels.length/3,pixels[0].length);
    this.write("tile 3.jpg");
    }
     if (tile == 4){
    this.divide(beach,pixels.length/3,0,pixels.length/3*2,pixels[0].length/3);
    this.write("tile 4.jpg");
    }
     if (tile == 5){
    this.divide(beach,pixels.length/3,pixels[0].length/3,pixels.length*2/3,pixels[0].length*2/3);
    this.write("tile 5.jpg");
    }
     if (tile == 6){
    this.divide(beach,pixels.length/3,pixels[0].length/3*2,pixels.length/3*2,pixels[0].length);
    this.write("tile 6.jpg");
    }
     if (tile == 7){
    this.divide(beach,pixels.length/3*2,0,pixels.length,pixels[0].length/3);
    this.write("tile 7.jpg");
    }
      if (tile == 8){
    this.divide(beach,pixels.length*2/3,pixels[0].length/3,pixels.length,pixels[0].length*2/3);
    this.write("tile 8.jpg");
    }
    
}
   
}