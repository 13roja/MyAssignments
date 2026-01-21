package Pages;

import org.openqa.selenium.By;

import Base.baseClass;

public class WelcomePage extends baseClass{

	public MyHomePage ClickCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();
	}
}
