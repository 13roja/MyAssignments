package week2.day1;

import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoLogin {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");	
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
	}
}

