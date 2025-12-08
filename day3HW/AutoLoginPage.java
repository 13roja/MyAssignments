package week1.day3HW;

import org.openqa.selenium.chrome.ChromeDriver;

public class AutoLoginPage {

	public static void main(String[] args) {
		
		ChromeDriver obj = new ChromeDriver();
		obj.get("http://leaftaps.com/opentaps/control/main");		
	}
}
