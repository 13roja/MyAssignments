package Pages;

import org.openqa.selenium.By;

import Base.baseClass;

public class CreateAccountPage extends baseClass{
	
	public CreateAccountPage EnterAccountName() {
		driver.findElement(By.id("accountName")).sendKeys("Test123");
		return this;
	}
	
	public ViewAccountPage ClickOnSubmit() {
		driver.findElement(By.className("smallSubmit")).click();
		return new ViewAccountPage();
	}
}
