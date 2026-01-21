package Pages;

import org.openqa.selenium.By;

import Base.baseClass;

public class LoginPage extends baseClass{
	
	public LoginPage EnterUserName() {
		driver.findElement(By.id("username")).sendKeys("democsr2");
		return this;
	}
	public LoginPage EnterPassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}
	public WelcomePage ClickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage();
	}
}
