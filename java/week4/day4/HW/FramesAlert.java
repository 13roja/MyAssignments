package week4.day4.HW;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAlert {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Roja");
		alert.accept();
		
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
		driver.close();
		
	}

}
