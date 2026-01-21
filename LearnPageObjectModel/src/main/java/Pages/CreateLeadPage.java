package Pages;

import org.openqa.selenium.By;

import Base.baseClass;

public class CreateLeadPage extends baseClass{
	
	
	public CreateLeadPage EnterCompanyName() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		return this;
	}
	public CreateLeadPage EnterFirstName() {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Priya");
		return this;
	}
	public CreateLeadPage EnterLastName() {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sharma");
		return this;
	}
	public ViewLeadPage ClickOnSubmit() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage();
	}
}
