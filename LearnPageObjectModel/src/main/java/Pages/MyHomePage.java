package Pages;

import org.openqa.selenium.By;

import Base.baseClass;

public class MyHomePage extends baseClass{
	
	public MyLeadPage ClickLead() {
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeadPage();
	}

	public MyAccountPage ClickAccounts() {
		driver.findElement(By.linkText("Accounts")).click();
		return new MyAccountPage();
	}
}
