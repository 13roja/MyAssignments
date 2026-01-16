package week5.day3.HW;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTable {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		WebElement more = driver.findElement(By.xpath("//span[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(more).perform();
		
		driver.findElement(By.xpath("//a[@href='https://finance.yahoo.com/crypto/']")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='yf-1uayyp1 bd']/tbody/tr/td[2]"));
		System.out.println("Total Cryptocurrency Names:"+rows.size());
		System.out.println("Cryptocurrency Names:");
        
        
		for(int i=1;i<=rows.size();i++) {
			 WebElement names = driver.findElement(By.xpath("//table[@class='yf-1uayyp1 bd']/tbody/tr["+i+"]/td[2]"));
			System.out.println(names.getText());
		}
	}

}
