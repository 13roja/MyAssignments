package MarathonPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonShopping {

	public static void main(String[] args) throws InterruptedException {
		//01) Launch Chrome  
		ChromeDriver driver = new ChromeDriver();
		
		/*02) Load https://www.amazon.in/ add  implicitlyWait driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));*/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//03) Type "Bags for boys" in the Search box & 04) Choose the item in the result (bags for boys)
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys",Keys.ENTER);
		
		/*05) Print the total number of results (like 50000) example like this-----> 1-48 of over 50,000 results for "bags for boys"*/
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'1-48 of over')]"));
		String str = element.getText();
		String[] strsplit = str.split(" ");
		System.out.println("total number of results: "+strsplit[3]);
		
		/*06) Select the first 2 brands in the left menu (like American Tourister, Generic)*/
		driver.findElement(By.xpath("(//input[@type='checkbox']/following::i)[3]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox']/following::i)[4]")).click();
		
		Thread.sleep(1000);
		
		//07) Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[text()='Featured']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		Thread.sleep(1000);
		
		//08) Print the first resulting bag info (name, discounted price)
		WebElement bagName = driver.findElement(By.xpath("(//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']/parent::a)[1]"));
		System.out.println("Bag Name : "+bagName.getText());
		
		WebElement bagPrice = driver.findElement(By.xpath("(//span[@class='a-price'])[1]"));
		System.out.println("Bag discounted price : "+bagPrice.getText());
		
		//09) Get the page title and close the browser(driver.close())
		System.out.println(driver.getTitle());
		
		driver.close();		

	}

}
