package testcases;

import org.testng.annotations.Test;

import Base.baseClass;
import Pages.LoginPage;

public class RunLogin extends baseClass{

	@Test
	public void runLogin() {
		System.out.println(driver);
		LoginPage lp = new LoginPage();
		lp.EnterUserName().EnterPassword().ClickLogin().ClickCRMSFA();		
	}
}
