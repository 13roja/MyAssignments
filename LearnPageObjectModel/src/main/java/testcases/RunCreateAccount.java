
package testcases;

import org.testng.annotations.Test;

import Base.baseClass;
import Pages.CreateAccountPage;
import Pages.LoginPage;

public class RunCreateAccount extends baseClass{

	@Test
	public void runCA() throws InterruptedException {
		System.out.println(driver);
		LoginPage lp = new LoginPage();
		lp.EnterUserName().EnterPassword().ClickLogin()
		.ClickCRMSFA()
		.ClickAccounts()
		.ClickCreateAccount()
		.EnterAccountName().ClickOnSubmit()
		.VerifyAccountPage();
			
	}
}
