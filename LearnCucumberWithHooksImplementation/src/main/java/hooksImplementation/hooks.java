package hooksImplementation;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import stepdefinition.BaseClass;

public class hooks extends BaseClass {

	@Before
	public void preCondition() {
		
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@After
	public void postCondition() {
		driver.close();
	}
}
