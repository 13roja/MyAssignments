package week5.day3.HW;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amzonAction {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		WebElement price = driver.findElement(By.className("a-price-whole"));
		System.out.println(price.getText());
		
		WebElement rating = driver.findElement(By.className("a-size-small a-color-base"));
		System.out.println(rating.getText());

	}

}
