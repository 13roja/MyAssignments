package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{

	@Test(dataProvider="fetchData")
	public void runCL(String cName,String fName,String lName) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
   }
	
	@DataProvider(name="fetchData")
	public String[][] sendData(){
		
		//declare a 2D Array
		//fIRST[]--->represents row,2nnd[] represents column size
		String[][] data = new String[2][3];
		//assign the data
		data[0][0] = "Testleaf";
		data[0][1] = "Roja";
		data[0][2] = "P";
		
		data[1][0] = "TCS";
		data[1][1] = "Simran";
		data[1][2] = "S";
		
		return data;		
	}	
}






