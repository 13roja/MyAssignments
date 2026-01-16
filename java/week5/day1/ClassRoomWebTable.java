package week5.day1;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassRoomWebTable {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement TopMenu = driver.findElement(By.id("tableTopMenu"));
		
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MAS", Keys.ENTER);
		
		WebElement To = driver.findElement(By.id("txtStationTo"));
		To.clear();
		To.sendKeys("MDU",Keys.ENTER);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		
		List<WebElement> TrainNames = driver.findElements(
				By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody/tr/td[2]"));
		
		System.out.println("Total no.of Trains: "+TrainNames.size());
		System.out.println("Train name are: ");
		for(WebElement name:TrainNames) {
			System.out.println(name.getText());
		}		

	}

}
