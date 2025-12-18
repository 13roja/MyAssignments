package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Tesla");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Roja");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("P");
		//select source
		WebElement sourceDD = driver.findElement(By.id("createLeadForm_dataSourceId"));
		//instantiate the select class
		Select sel = new Select(sourceDD);
		sel.selectByIndex(5);
		
		//select markerting campaign
		WebElement marketCampDD = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select sel1 = new Select(marketCampDD);
		sel1.selectByVisibleText("Automobile");
		
		//select ownership
		WebElement ownershipDD = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select sel2 = new Select(ownershipDD);
		sel2.selectByValue("OWN_SCORP");
		
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());
		driver.close();
		
		
	}
}
