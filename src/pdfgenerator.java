/*import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class pdfgenerator {
	
	public class Stationery extends PdfPageEventHelper
	{
	    [...]

	    public void createPdf(String filename) throws Exception
	    {
	        // step 1
	        Document document = new Document(PageSize.A4, 36, 36, 72, 36);
	        // step 2
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
	        useStationary(writer);
	        // step 3
	        document.open();
	        // step 4
	        [... add content to PDF ...]
	        // step 5
	        document.close();
	    }

	    [...]

	    public void useStationary(PdfWriter writer) throws IOException
	    {
	        writer.setPageEvent(this);
	        PdfReader reader = new PdfReader(STATIONERY);
	        page = writer.getImportedPage(reader, 1);
	    }

	    public void onEndPage(PdfWriter writer, Document document)
	    {
	        writer.getDirectContentUnder().addTemplate(page, 0, 0);
	    }

	    [...]
	}
	

}





**/























/**

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class GeneratePDF {
 
    public static void main(String[] args) {
        try {
            OutputStream file = new FileOutputStream(new File("D:\\Test.pdf"));
 
            Document document = new Document();
            PdfWriter.getInstance(document, file);
 
            document.open();
            document.add(new Paragraph("Hello World, iText"));
            document.add(new Paragraph(new Date().toString()));
 
            document.close();
            file.close();
 
        } catch (Exception e) {
 
            e.printStackTrace();
        }
    }
}
/**/




import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

public class pdfgenerator {
  private static String INPUTFILE = "C:/workspace/urban_restro_tech_intern_sol/src/locate.txt";
  private static String OUTPUTFILE = "C:/workspace/urban_restro_tech_intern_sol/src/readpdf.pdf";

  public static void main(String[] args) throws DocumentException,
      IOException {
    Document document = new Document();

    PdfWriter writer = PdfWriter.getInstance(document,
        new FileOutputStream(OUTPUTFILE));
    document.open();
    java.io.InputStream reader = new java.io.InputStream(INPUTFILE);
    /*int n = ((PdfReader) reader).getNumberOfPages();
    PdfImportedPage page;
    // Go through all pages
    for (int i = 1; i <= n; i++) {
      // Only page number 2 will be included
      if (i == 2) {**/
    PdfImportedPage page = writer.getImportedPage(reader, 1);
        Image instance = Image.getInstance(page);
        document.add(instance);
      }
    }
    document.close();

  }

} 