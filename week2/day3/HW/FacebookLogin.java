package week2.day3.HW;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookLogin {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		//Click on the Create new account button
		driver.findElement(By.linkText("Create new account")).click();
		
		//Enter the First name, Surname
		driver.findElement(By.name("firstname")).sendKeys("Rajita");
		driver.findElement(By.name("lastname")).sendKeys("Roy");
		
		//Enter the Mobile number or email address
		driver.findElement(By.name("reg_email__")).sendKeys("rajitarr@gmail.com");
		
		//Enter the New password.
		driver.findElement(By.id("password_step_input")).sendKeys("Welcome2025@");
		
		//Handle all three dropdowns in Date of birth
		WebElement DD = driver.findElement(By.name("birthday_day"));
		Select DOB = new Select(DD);
		DOB.selectByIndex(10);
		
		WebElement DD1 = driver.findElement(By.name("birthday_month"));
		Select Month = new Select(DD1);
		Month.selectByValue("7");
		
		WebElement DD2 = driver.findElement(By.name("birthday_year"));
		Select year = new Select(DD2);
		year.selectByVisibleText("2009");
		
		//Select the radio button in Gender.
		driver.findElement(By.xpath("(//input[@id=\"sex\"])[1]")).click();
		
	}

}
