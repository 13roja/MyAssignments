package Pages;

import org.openqa.selenium.By;

import Base.baseClass;

public class MyLeadPage extends baseClass{

	public CreateLeadPage ClickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage();
	}
}
