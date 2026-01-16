package week1.day3HW;

import org.openqa.selenium.chrome.ChromeDriver;

public class AutoLoginPage {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");	
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
	}
}
