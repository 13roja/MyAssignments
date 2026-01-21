package Pages;

import org.openqa.selenium.By;

import Base.baseClass;

public class MyAccountPage extends baseClass{

	public CreateAccountPage ClickCreateAccount() {
		driver.findElement(By.linkText("Create Account")).click();
		return new CreateAccountPage();
	}
}
