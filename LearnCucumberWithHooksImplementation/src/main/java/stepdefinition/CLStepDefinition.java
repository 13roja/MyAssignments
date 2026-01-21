package stepdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CLStepDefinition extends BaseClass{

	@When("click on Login")
	public void click_on_login() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@When("Click on crmsfa link")
	public void click_on_crmsfa_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@When("click on Leads")
	public void click_on_leads() {
		driver.findElement(By.linkText("Leads")).click();
	}
	@When("Click on CreateLeads link")
	public void click_on_create_leads_link() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@When("Enter the company Name (.*)$")
	public void enter_the_company_name(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	}
	@When("enter the firstName (.*)$")
	public void enter_the_first_name(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}
	@When("enter the LastName (.*)$")
	public void enter_the_last_name(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}
	@When("click on Submit button")
	public void click_on_submit_button() {
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("viewLeads page is displayed")
	public void view_leads_page_is_displayed() {
		String text = driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
	    if (text.contains("View Lead")) {
			System.out.println("title is verified");
		} else {
			System.out.println("title is not verified");
		}
	}
}
