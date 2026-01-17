package week5.day3.HW;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class bigBasket {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		FirefoxDriver driver = new FirefoxDriver();
		//1. Navigate to https://www.bigbasket.com/.
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Click on "Shop by Category".
		driver.findElement(By.xpath("(//span[text()='Shop by']/parent::div)[2]")).click();
		
		//3. Mouse over "Foodgrains, Oil & Masala".
		WebElement Mousehover1 = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(Mousehover1).perform();
		
		//4. Mouse over "Rice & Rice Products".
		WebElement Mousehover2 = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		//Actions act2 = new Actions(driver);
		act.moveToElement(Mousehover2);
		Thread.sleep(1000);
		
		//5. Click on "Boiled & Steam Rice"
		driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		
		//6. Filter the results by selecting the brand "bb Royal".
		driver.findElement(By.xpath("//label[text()='bb Royal']")).click();
		
		//7. Click on "Tamil Ponni Boiled Rice".
		driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']/parent::div")).click();
		
		//window handle
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> win = new ArrayList<>(windowHandles);
		driver.switchTo().window(win.get(1));
		
		//8. Select the 5 Kg bag.
		driver.findElement(By.xpath("//span[text()='5 kg']")).click();
		//9. Check and note the price of the rice.
		String price = driver.findElement(By.xpath("(//span[@class='Label-sc-15v1nk5-0 sc-eulNck jnBJRV jdJBSX'])[1]")).getText();
		System.out.println("Price of the rice: "+price);
		
		//10. Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
		Thread.sleep(100);
		
		//11. Verify the success message that confirms the item was added to your cart.
		String text = driver.findElement(By.xpath("//p[contains(text(),'An item has been added')]")).getText();
		System.out.println("cart message: "+text);
		
		//12. Take a snapshot of the current page
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/bigbasket.png");
		
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot captured sucessfully");
		
/*
13. Close the current window.
14. Close the main window
		 */
		
		

	}

}
