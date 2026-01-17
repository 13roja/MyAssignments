package week5.day3.HW;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		
		//1. Launch (https://www.snapdeal.com/)
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//2. Go to "Men's Fashion".
		driver.findElement(By.xpath("(//div[@class='sc-98d0cbe0-3 dXWLks'])[1]")).click();
		
		//3. Go to "Sports Shoes".
		driver.findElement(By.xpath("//div[text()='Sports Shoes']")).click();
		
		//4. Get the count of sports shoes.
		String shoeCount = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span")).getText();
		String count = shoeCount.replaceAll(" Items", "").trim();
		System.out.println("Total sports shoe count: "+count);
		
		//5. Click on "Training Shoes".
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//6. Sort the products by "Low to High".
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("(//span[@class='arrow hidden']/parent::li)[1]")).click();
		
		Thread.sleep(2000);
		
		//7. Check if the displayed items are sorted correctly.
		List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> list = new ArrayList<>();
		for(WebElement p:priceList) {
			String value = p.getText().replaceAll("[^0-9]", "");
			list.add(Integer.parseInt(value));
		}
		List<Integer> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList);
		
		System.out.println("Is sorted correctly: "+sortedList.equals(list));
		
		//8. Select any price range ex:(500-700).
		WebElement from = driver.findElement(By.name("fromVal"));
		from.clear();
		from.sendKeys("500",Keys.ENTER);
		WebElement To = driver.findElement(By.name("toVal"));
		To.clear();
		To.sendKeys("700",Keys.ENTER);
		
		Thread.sleep(3000);
		
		//9. Filter by any colour.
		driver.findElement(By.xpath("//label[@for='Color_s-White%20%26%20Blue']")).click();
		
		//10. Verify all the applied filters.
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='filters']//a"));
		System.out.println("Applied Filters: ");
		for(WebElement p:elements) {
			System.out.println(p.getText());
		}
		
		Thread.sleep(3000);
		//11. Mouse hover on the first resulting "Training Shoes".
		WebElement product = driver.findElement(By.xpath("//img[@title='JQR RUMBA Blue Training Shoes']"));
		Actions act = new Actions(driver);
		act.moveToElement(product).perform();
		
		//12. Click the "Quick View" button.
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		
		Thread.sleep(1000);
		
		//13. Print the cost and the discount percentage.
		WebElement cost = driver.findElement(By.className("payBlkBig"));
		System.out.println("Cost of the shoe is Rs." +cost.getText());
		
		WebElement discount = driver.findElement(By.className("percent-desc"));
		System.out.println("The discount percentage is " +discount.getText());
		
		//14. Take a snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/snapdealShow.png");
		
		FileUtils.copyFile(source, destination);
		
		driver.close();
	}

}
