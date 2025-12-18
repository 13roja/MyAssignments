package week2.day3.HW;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Enter username & password 
		driver.findElement(By.id("username")).sendKeys("democsr2");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click on Login
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click on CRM?SFA
		driver.findElement(By.partialLinkText("CRM")).click();
		//Click the "Leads" link
		driver.findElement(By.linkText("Leads")).click();
		//Click "Find leads."
		driver.findElement(By.linkText("Find Leads")).click();
		//Click on the "Phone" tab
		driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[1]/div[1]/ul/li[2]")).click();
		//Enter the phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("222333");
		//Click the "Find leads" button
		driver.findElement(By.xpath("(//button[@class=\"x-btn-text\"])[6]")).click();
		
		//Capture the lead ID of the first resulting lead
		driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		WebElement obj = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/a[1]"));
		//Click the "Delete" button
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		//Click "Find leads" again
		driver.findElement(By.linkText("Find Leads")).click();
		//Enter the captured lead ID.
		driver.findElement(By.name("id")).sendKeys(obj.getText());
		//Click the "Find leads" button.
		driver.findElement(By.className("x-btn-text")).click();
		/*Verify the presence of the message "No records to display" in the Lead List. This
		message confirms the successful deletion.*/
		WebElement obj1 = driver.findElement(By.className("x-paging-info"));
		System.out.println(obj1.getText());
		
		driver.close();
		
	}

}
