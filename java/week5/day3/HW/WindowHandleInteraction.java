package week5.day3.HW;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandleInteraction {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		driver.findElement(By.id("username")).sendKeys("democsr2");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		//Merge contact From window handle
		Set<String> windowList = driver.getWindowHandles();
		List<String> fromWindow = new ArrayList<>(windowList);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);
		driver.switchTo().window(fromWindow.get(1));
		driver.manage().window().minimize();
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
		driver.switchTo().window(fromWindow.get(0));
		

		//Merge contact To window handle
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> window = driver.getWindowHandles();
		List<String> ToWindow = new ArrayList<>(window);
		
		Thread.sleep(5000);
		driver.switchTo().window(ToWindow.get(1));
		driver.manage().window().minimize();
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		
		driver.switchTo().window(fromWindow.get(0));
		
		driver.findElement(By.className("buttonDangerous")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		System.out.println(driver.getTitle());				
		
	}

}
