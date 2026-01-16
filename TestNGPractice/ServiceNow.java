package TestNGPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import io.github.sukgu.Shadow;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ServiceNow {
	
	@Test
	public void runService() throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		
		//1. Launch ServiceNow application  URL: https://dev181504.service-now.com/
		driver.get("https://dev181504.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Login with valid credentials username as admin and password (admin/F/*jyM6Q6pHh)
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("F/*jyM6Q6pHh");
		driver.findElement(By.id("sysverb_login")).click();
		
		//3. Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow sh = new Shadow(driver);
		sh.setImplicitWait(10);
		sh.findElementByXPath("//div[@id='d6e462a5c3533010cbd77096e940dd8c']").click();
		sh.findElementByXPath("//span[text()='Service Catalog']").click();
		
		//4. Click on  mobiles
		WebElement frame1 = sh.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		
		//5. Select Apple iphone13pro
		driver.findElement(By.xpath("//strong[contains(text(),'Apple iPhone 13 pro')]")).click();
		
		//6. Choose yes option in lost or broken iPhone
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		
		//7. Enter phonenumber as 99 in original phonenumber field
		driver.findElement(By.xpath("//input[@id='IO:4afecf4e9747011021983d1e6253af34']")).sendKeys("99");
		
		//8. Select Unlimited from the dropdown in Monthly data allowance
		WebElement DD = driver.findElement(By.id("IO:ff1f478e9747011021983d1e6253af68"));
		Select sel = new Select(DD);
		sel.selectByValue("unlimited");
		
		//9. Update color field to SierraBlue and storage field to 512GB
		driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'512 GB')]")).click();
		
		//10. Click on Order now option
		driver.findElement(By.xpath("//button[contains(text(),'Order Now')]")).click();
		
		Thread.sleep(1000);
		//11. Verify order is placed and copy the request number
		String text2 = driver.findElement(By.xpath("//span[contains(text(),'Thank you,')]")).getText();
		System.out.println("The order placed message: "+text2);
		
		String text = driver.findElement(By.id("requesturl")).getText();
		System.out.println("Order request num: "+text);
		
		//12.Take a Snapshot of order placed page 
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/servicenowImage.png");
		
		FileUtils.copyFile(source, destination);
		
	}

}
