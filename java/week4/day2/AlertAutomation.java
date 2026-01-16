package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAutomation {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("(//span[text()=\"Show\"])[5]")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Roja");
		alert.dismiss();
		WebElement element = driver.findElement(By.id("confirm_result"));
		System.out.println(element.getText());
		driver.close();

	}

}
