package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepdefinition extends BaseClass{

	@Given("Launch the browser and load the url")
	public void launch_the_browser_and_load_the_url() {
	    
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
	    
	}

	@Given("Enter the username as {string}")
	public void enter_the_username(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
	}

	@Given("Enter the password as {string}")
	public void enter_the_password(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@Given("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Given("Homepage is displayed")
	public void homepage_is_displayed() {
		
		String title = driver.getTitle();		
		if (title.contains("Leaftaps")) {
			System.out.println("text matched");
		} else {
			System.out.println("text not matched");
		}   
	}
	
	@Given("Error message displayed")
	public void error_message_displayed() {
	    String text = driver.findElement(By.id("errorDiv")).getText();
	    if(text.contains("error")) {
	    	System.out.println("text matched");
	    }
	    else {
	    	System.out.println("text not matched");
	    }
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    driver.close();
	}

}
