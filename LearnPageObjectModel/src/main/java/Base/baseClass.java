package Base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseClass {
	public static ChromeDriver driver;

	@BeforeMethod
	public void preCondition() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		driver = new ChromeDriver(options);
		System.out.println("BaseClass"+driver);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}
