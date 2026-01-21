package Pages;

import org.testng.Assert;

import Base.baseClass;

public class ViewAccountPage extends baseClass{
	
	public void VerifyAccountPage() throws InterruptedException {
		
		Thread.sleep(2000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Account Details | opentaps CRM");
	}
}
