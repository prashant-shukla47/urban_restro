import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class resizing { 
	
      public void resizeImage(BufferedImage originalImage, int type,
            Integer img_width, Integer img_height)
	{
		try {
			BufferedImage resizedImage = new BufferedImage(img_width, img_height, type);
		    Graphics2D temp = resizedImage.createGraphics();
		    temp.drawImage(originalImage, 0, 0, img_width, img_height, null);
		    temp.dispose();
		    File outputfile = new File("c:/workspace/urban_restro_tech_intern_sol/src/resized/india gate_resize.jpg");
        
			ImageIO.write(resizedImage, "jpg",outputfile);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
}
