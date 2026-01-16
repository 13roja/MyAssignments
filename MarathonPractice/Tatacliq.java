package MarathonPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tatacliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		
		//1. Load the url as https://www.tatacliq.com/
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("moe-dontallow_button")).click();
		
		//2. MouseHover on 'Brands'
		WebElement brands = driver.findElement(By.xpath("//div[contains(text(),'Brands')]"));
		Actions act = new Actions(driver);
		act.moveToElement(brands).perform();
		
		Thread.sleep(500);
		
		//3. MouseHover on 'Watches & Accessories'
		driver.findElement(By.xpath("//div[contains(text(),'Watches & Accessories')]")).click();
		
		//4. Choose the first option from the 'Featured brands'.
		WebElement brandType = driver.findElement(By.xpath("//div[text()='Featured brands']/following-sibling::div[1]"));
		System.out.println("first selected brand is: "+brandType.getText());
		brandType.click();
		
		Thread.sleep(1000);
		
		//5. Select sortby: New Arrivals
		WebElement sort = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select DD = new Select(sort);
		DD.selectByValue("isProductNew");
		
		Thread.sleep(500);
		
		//6. choose men from catagories filter.
		driver.findElement(By.xpath("//div[text()='Men']")).click();
		
		Thread.sleep(2000);
		
		//7. print all price of watches 
		List<WebElement> PriceList = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		List<String> price = new ArrayList<>();
		
		for(WebElement prc:PriceList) {
			String p = prc.getText();
			price.add(p); 
		}
		System.out.println("List of all prices: "+price);
		
		//8. click on the first resulting watch.
		driver.findElements(By.xpath("(//a[@class='ProductModule__base'])")).get(0).click(); 
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> win = new ArrayList<>(windowHandles);
		driver.switchTo().window(win.get(1));
		
		//9. compare two price are similar 
		String FirstProductPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
		String str = FirstProductPrice.replaceAll("MRP: ", "").trim();
		
		System.out.println(str);
		String FirstPriceFromList = price.get(0);
		System.out.println(FirstPriceFromList);
		if(str.equals(FirstPriceFromList)) {
			System.out.println("Both prices are same");
		}
		else {
			System.out.println("Both prices are not same");
		}
		
		//10. click Add to cart and get count from the cart icon.
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		WebElement cart = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']"));
		System.out.println("cart count is: "+cart.getText());
		
		//11. Click on the cart
		cart.click();
		
		Thread.sleep(1000);
		
		//12. Take a snap of the resulting page. 
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/TATAcliqScreenshot.png");
		
		FileUtils.copyFile(source, destination);
		
		//13. Close All the opened windows one by one.
		driver.quit();
	}

}
