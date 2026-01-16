package week2.day3.HW;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//Enter the phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("9191");
		//Click the "Find leads" button
		driver.findElement(By.xpath("(//button[@class=\"x-btn-text\"])[6]")).click();
		Thread.sleep(5000);
		//Capture the lead ID of the first resulting lead
		WebElement obj = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String text = obj.getText();
		obj.click();
		//Click the "Delete" button
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		//Click "Find leads" again
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(5000);
		//Enter the captured lead ID.
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9191");
		//Click the "Find leads" button.
		driver.findElement(By.xpath("(//button[@class=\"x-btn-text\"])[6]")).click();
		/*Verify the presence of the message "No records to display" in the Lead List. This
		message confirms the successful deletion.*/
		WebElement obj1 = driver.findElement(By.xpath("//div[text()='No records to display']"));
		System.out.println(obj1.getText());
		
		//driver.close();
		
	}

}
