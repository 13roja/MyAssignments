package week6.day1.HW;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class ParamterTestNG {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		

	}

}
