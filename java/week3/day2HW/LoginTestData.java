package week3.day2HW;

public class LoginTestData extends TestData{
	
	void enterUsername() {
		System.out.println("Enter username--------from subclass");
	}

	void enterPassword() {
		System.out.println("Enter password--------from subclass");
	}
	
	public static void main(String[] args) {
		
		LoginTestData obj = new LoginTestData();
		obj.enterCredentials();
		obj.navigateToHomePage();
		obj.enterUsername();
		obj.enterPassword();
	}

}
