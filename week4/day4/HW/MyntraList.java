package week4.day4.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraList {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.className("desktop-searchBar")).sendKeys("bags",Keys.ENTER);
		
		driver.findElement(By.xpath("//label[text()='Men']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//label[text()='Laptop Bag']")).click();
		
		Thread.sleep(1000);
		String text = driver.findElement(By.className("title-count")).getText();
		System.out.println(text);

	}

}
