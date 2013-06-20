import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class watermark
{
public void overlap()
{
try
{
File _file = new File("C:/workspace/urban_restro_tech_intern_sol/src/resized/india gate_resize.jpg");
Image src = ImageIO.read(_file);
int width = src.getWidth(null);
int height = src.getHeight(null);
System.out.println("X = "+width+" and Y = "+height);
BufferedImage image = new BufferedImage(width, height
, BufferedImage.TYPE_INT_RGB);
Graphics g = image.createGraphics();
g.drawImage(src, 0, 0, width, height, null);
//    g.setBackground(Color.white);
g.setColor(Color.red);
g.setFont(new Font("Verdana", Font.BOLD, 20));

g.drawString("fellome advertising",  5, height - (new
Font("Arial", Font.BOLD, 20)).getSize() / 2 - 5);
g.dispose();

FileOutputStream out = new FileOutputStream("C:/workspace/urban_restro_tech_intern_sol/src/resized/india gate_watermark.jpg");
JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
encoder.encode(image);
out.close();
} catch (Exception ee)
{
System.out.println("Error Occurred : "+ee);
}
}
}