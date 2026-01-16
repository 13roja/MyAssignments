package week3.day2;

public class Chrome extends Browser {

	void openIncognito() {
		System.out.println("openIncognito() method from Chrome Subclass");
	}
	
	void clearCache() {
		System.out.println("clearCache() method from Chrome Subclass");
	}
	
	public static void main(String[] args) {
		
		Chrome c = new Chrome();
		c.openIncognito();
		c.clearCache();
		c.navigateBack();
		c.openURL();
	}
}
