package ExcelIntegration;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData() throws IOException {
		
		//open the excel 
		XSSFWorkbook wb = new XSSFWorkbook("./data/Data.xlsx");
		//Identify the Worksheet
		XSSFSheet ws = wb.getSheetAt(0);	
		//get row count
		int rowCount = ws.getLastRowNum();
		System.out.println("Total no. of Row: " +rowCount);
		
		//get column count
		short columnCount = ws.getRow(1).getLastCellNum();
		System.out.println("Total no. of Column: " +columnCount);
		System.out.println("");
		
		String[][] data = new String[rowCount][columnCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				String value = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = value;
			}
		}
		
		wb.close();
		return data;		
	}
}
