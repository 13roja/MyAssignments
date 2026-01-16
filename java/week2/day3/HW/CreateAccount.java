package week2.day3.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		//Enter username & password 
		driver.findElement(By.id("username")).sendKeys("democsr2");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click on Login
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click on CRM?SFA
		driver.findElement(By.partialLinkText("CRM")).click();
		//Click on Accounts
		driver.findElement(By.partialLinkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("Akshar1");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
		
		//Select "ComputerSoftware" as the industry.
		WebElement DD = driver.findElement(By.name("industryEnumId"));
		Select sel = new Select(DD);
		sel.selectByIndex(4);
		
		//Select "S-Corporation" as ownership using SelectByVisibleText
		WebElement DD1 = driver.findElement(By.name("ownershipEnumId"));
		Select sel1 = new Select(DD1);
		sel1.selectByVisibleText("S-Corporation");
		
		//Select "Employee" as the source using SelectByValue.
		WebElement DD2 = driver.findElement(By.id("dataSourceId"));
		Select sel2 = new Select(DD2);
		sel2.selectByValue("LEAD_EMPLOYEE");
		
		//Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex.
		WebElement DD3 = driver.findElement(By.id("marketingCampaignId"));
		Select sel3 = new Select(DD3);
		sel3.selectByIndex(7);
		
		//Select "Texas" as the state/province using SelectByValue.
		WebElement DD4 = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select sel4 = new Select(DD4);
		sel4.selectByValue("TX");
		
		//Click the "Create Account" button.
		driver.findElement(By.className("smallSubmit")).click();
		
		//Print the account name.
		WebElement name = driver.findElement(By.xpath("(//span[@class=\"tabletext\"])[3]"));
		System.out.println(name.getText());
		
		//Close the browser window.
		driver.close();
				
	}

}
