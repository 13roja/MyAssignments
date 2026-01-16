package testcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		//open the excel 
		XSSFWorkbook wb = new XSSFWorkbook("./data/Data.xlsx");
		//Identify the Worksheet
		XSSFSheet ws = wb.getSheetAt(0);
		//identify the row
		String stringCellValue = ws.getRow(1).getCell(1).getStringCellValue();
		System.out.println("First name: " +stringCellValue);
		
		//get row count with header
		System.out.println("Total no. of rows including header: "+ws.getPhysicalNumberOfRows());
		
		//get row count
		int rowCount = ws.getLastRowNum();
		System.out.println("Total no. of Row: " +rowCount);
		
		//get column count
		short columnCount = ws.getRow(1).getLastCellNum();
		System.out.println("Total no. of Column: " +columnCount);
		System.out.println("");
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				String value = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+" | ");
			}
			System.out.println();
			System.out.println("----------------------------");
		}
		
		wb.close();
		
	}

}
