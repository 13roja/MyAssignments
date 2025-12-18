package week2.day3.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		//Login by entering username and password
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on the CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM")).click();
		
		//Click on the Leads Button
		driver.findElement(By.linkText("Leads")).click();
		
		//Click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter the CompanyName Field Using Xpath
		driver.findElement(By.xpath("//input[@id=\"createLeadForm_companyName\"]")).sendKeys("CapitalLand");
		
		//Enter the FirstName Field Using Xpath
		driver.findElement(By.xpath("(//input[@name=\"firstName\"])[3]")).sendKeys("Sheetal");
		
		//Enter the LastName Field Using Xpath
		driver.findElement(By.xpath("(//input[@name=\"lastName\"])[3]")).sendKeys("Agarwal");
		
		//Enter the FirstName (Local) Field Using Xpath
		driver.findElement(By.xpath("//input[@name=\"firstNameLocal\"]")).sendKeys("Sheetu");
		
		//Enter the Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Administrative");
		
		//Enter the Description Field Using any Locator of your choice
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Software Department");
		
		//Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sheetalag@gmail.com");
		
		//Select State/Province as NewYork Using Visible Text
		WebElement DD = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select city = new Select(DD);
		city.selectByVisibleText("New York");
		
		//Click on the Create Button
		driver.findElement(By.className("smallSubmit")).click();
		
		//Click on the edit button
		driver.findElement(By.linkText("Edit")).click();
		
		//Clear the Description Field
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		//Fill the Important Note Field with Any text
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Updated the profile");
		
		//Click on the update button
		driver.findElement(By.xpath("(//input[@class=\"smallSubmit\"])[1]")).click();
		
		//Get the Title of the Resulting Page
		System.out.println(driver.getTitle());
		
		//Close the browser window
		driver.close();
				
	}

}
