import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class location {
	
	
	public void long_lat(String location){
            File file = new File("c:/workspace/urban_restro_tech_intern_sol/src/locate.txt");
            System.out.println(new File("c:/workspace/urban_restro_tech_intern_sol/src/locate.txt").exists());
	        Scanner s= null;
			try {
				s = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	        while (s.hasNextLine()) {
	            String line = s.nextLine();
				if (line.startsWith(location));
				boolean found=true;
				System.out.println(found);
				
	            int longitude = s.nextInt();
	            int lattitude= s.nextInt();
	            System.out.println(longitude);
	            System.out.println(lattitude);
	         
	            
	        }    buildexcel(location,45,475);
	}
	public void buildexcel(String location,int longitude,int lattitude){
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Sample sheet");
	System.out.println("was here");
	 
	Map<String, Object[]> data = new HashMap<String, Object[]>();
	data.put(location, new Object[] {"location", "longitude", "lattitude"});
	data.put(location, new Object[] {1d, longitude, lattitude});

	Set<String> keyset = data.keySet();
	int rownum = 0;
	for (String key : keyset) {
	    Row row = sheet.createRow(rownum++);
	    Object [] objArr = data.get(key);
	    int cellnum = 0;
	    for (Object obj : objArr) {
	        Cell cell = row.createCell(cellnum++);
	        if(obj instanceof Date) 
	            cell.setCellValue((Date)obj);
	        else if(obj instanceof Boolean)
	            cell.setCellValue((Boolean)obj);
	        else if(obj instanceof String)
	            cell.setCellValue((String)obj);
	        else if(obj instanceof Double)
	            cell.setCellValue((Double)obj);
	    }
	}
	 
	try {
	    FileOutputStream out = 
	            new FileOutputStream(new File("C:/workspace/urban_restro_tech_intern_sol/src/newsletter/new.xls"));
	    workbook.write(out);
	    out.close();
	    System.out.println("Excel written successfully..");
	     
	} catch (FileNotFoundException e1) {
	    e1.printStackTrace();
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
}
}