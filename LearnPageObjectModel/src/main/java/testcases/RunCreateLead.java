package testcases;

import org.testng.annotations.Test;

import Base.baseClass;
import Pages.LoginPage;

public class RunCreateLead extends baseClass{

	@Test
	public void runCL() throws InterruptedException {
		System.out.println(driver);
		LoginPage lp = new LoginPage();
		lp.EnterUserName().EnterPassword().ClickLogin()
		.ClickCRMSFA()
		.ClickLead()
		.ClickCreateLead()
		.EnterCompanyName().EnterFirstName().EnterLastName().ClickOnSubmit()
		.VerifyViewLead();
	}
}
