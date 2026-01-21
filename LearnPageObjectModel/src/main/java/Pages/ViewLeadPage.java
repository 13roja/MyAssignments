package Pages;

import org.testng.Assert;

import Base.baseClass;

public class ViewLeadPage extends baseClass{
	
	public void VerifyViewLead() throws InterruptedException {
		
		Thread.sleep(2000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "View Lead | opentaps CRM");
	}
}
