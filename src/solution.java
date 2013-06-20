import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class solution {


	public static void main(String[] args) {
		
		BufferedImage originalImage = null;
		int type = 0;
		String filename ="c:/workspace/urban_restro_tech_intern_sol/src/original/india gate_13_1.jpg";
		String location = filename.substring(filename.indexOf("original/")+9,filename.lastIndexOf("_")-3); 
		
		 try{
		    	System.out.println(new File(filename).exists());
		        originalImage = ImageIO.read(new File(filename));
		        type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB
		                                               : originalImage.getType();

		 } catch(IOException e) {
	           System.out.println(e.getMessage());
	       }
		 
		resizing tuna = new resizing();
		tuna.resizeImage(originalImage,type,400,400);
		System.out.println(location);
		watermark iii = new watermark();
		iii.overlap();
		location apple = new location();
		apple.long_lat(location);
		
	}

}
