package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow); //Parent window Address
		
		System.out.println(driver.getTitle()); //Parent window title
		
		driver.findElement(By.xpath("//button[text()=\"    click   \"]")).click();
		
		Set<String> listWindows = driver.getWindowHandles();
		List<String> list = new ArrayList<>(listWindows);
		
		driver.switchTo().window(list.get(1));
		String Childwindow = driver.getWindowHandle();
		
		System.out.println(Childwindow);
		System.out.println(driver.getTitle());
		
		driver.close();
		//driver.switchTo().window(list.get(1));

	}

}
