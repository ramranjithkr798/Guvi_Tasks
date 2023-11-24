import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelCreation {

	public static void main(String[] args) {
		String fileName="C:\\Users\\ramra\\Desktop\\GUVI\\Task_13\\EmployeeDetail.xlsx";
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Employee Data");
		//Prepare data to be written as an Object[]
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] {"NAME", "AGE", "EMAIL"});
		data.put("2", new Object[] {"John Doe", 30, "john@test.com"});
		data.put("3", new Object[] {"John Doe",28 , "john@test.com"});
		data.put("4", new Object[] {"Bob Smith", 25, "jackey@example.com"});
		data.put("5", new Object[] {"Swapnil", 37, "joe@example.com"});
		//Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
		  Row row = sheet.createRow(rownum++);
		  Object [] objArr = data.get(key);
		  int cellnum = 0;
		  for (Object obj : objArr)
		  {
		     Cell cell = row.createCell(cellnum++);
		     if(obj instanceof String)
		          cell.setCellValue((String)obj);
		      else if(obj instanceof Integer)
		          cell.setCellValue((Integer)obj);
		  }
		}
		//Write the workbook in file system
		try {
		  FileOutputStream out = new FileOutputStream(new File(fileName));
		  workbook.write(out);
		  out.close();
		  System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
		  XSSFSheet sheet1 = workbook.getSheetAt(0);
		//Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet1.iterator();
		while (rowIterator.hasNext()) {
		  Row row = rowIterator.next();
		  //For each row, iterate through all the columns
		  Iterator<Cell> cellIterator = row.cellIterator();
		  while (cellIterator.hasNext()) {
		    Cell cell = cellIterator.next();
		    //Check the cell type and format accordingly
		    switch (cell.getCellType()) {
		      case NUMERIC:
		        System.out.print((int)cell.getNumericCellValue() + " ");
		        break;
		      case STRING:
		        System.out.print(cell.getStringCellValue() + " ");
		        break;
		    }
		  }
		  System.out.println("");
		}
		  workbook.close();
		} 
		catch (Exception e) {
		  e.printStackTrace();
		}
	}
}
