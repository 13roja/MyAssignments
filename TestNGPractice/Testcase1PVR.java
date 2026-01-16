package TestNGPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testcase1PVR {

	@Test
	public void runPVR() throws InterruptedException {
		//1) Launch the Browser
		ChromeDriver driver = new ChromeDriver();
		
		//2) Load the Url "https://www.pvrcinemas.com/"
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//3) Choose Your location as "Chennai" (sometimes it will be located automatically)
		driver.findElement(By.xpath("(//span[@class='cities-placed'])[2]")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Chennai", Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.className("p-autocomplete-item")).click();
		
		//4) Click on Cinema under Quick Book
		driver.findElement(By.className("cinemas-inactive")).click();
		
		//5) Select Your Cinema
		driver.findElement(By.xpath("//img[@alt='DHURANDHAR']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Book Now']")).click();
		
		//6) Select Your Date as Tomorrow
		driver.findElement(By.xpath("//span[text()='Tomorrow']")).click();
		Thread.sleep(1000);
		
		//7) Select Your Movie
		WebElement Movie = driver.findElement(By.xpath("//h2[contains(text(),'INOX The Marina Mall')]"));
		Movie.click();
		Thread.sleep(1000);
		
		//8) Select Your Show Time
		driver.findElement(By.xpath("//div[@class='show-times']/h5")).click();
		Thread.sleep(500);
		
		//9) Click on Book Button
		//driver.findElement(By.className("class=\"sc-kCuUfV iBvycX reject-terms\"")).click();
		
		//10) Click Accept on Term and Condition
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		//11) Click any one available seat
		driver.findElement(By.id("CL.CLUB|D:12")).click();
		
		//12) Click Proceed Button
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		//13) Print the Seat info under book summary
		WebElement text = driver.findElement(By.xpath("//div[@class='seat-number']/p"));
		System.out.println("Seat info: "+text.getText());
		
		//14) Print the grand total under book summary
		WebElement text2 = driver.findElement(By.xpath("//div[@class='grand-prices']"));
		System.out.println("Grand Total: "+text2.getText());
		
		//15) Click Proceed and Continue Button
		driver.findElement(By.className("fb-added-btndesk")).click();
		Thread.sleep(2000);
		
		//16) Close the popup
		driver.findElement(By.xpath(("(//i[@class='pi pi-times'])[2]"))).click();
		
		//17) Print Your Current Page title
		System.out.println(driver.getTitle());
		
		//18) Close Browser
		driver.close();
	}

}
