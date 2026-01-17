package week4.day4.HW;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
		
		List<WebElement> productbrand = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		List<String> brandNames = new ArrayList<String>();
		for (WebElement value : productbrand) {
			String brand = value.getText();
			brandNames.add(brand);			
		}
		System.out.println("Brand List: " +brandNames);
		
		List<WebElement> productNamelist = driver.findElements(By.xpath("//h4[@class='product-product']"));
		List<String> pname = new ArrayList<>();
		for(WebElement p:productNamelist) {
			String name = p.getText();
			pname.add(name);
		}
		System.out.println("Product names: "+pname);
	}

}
