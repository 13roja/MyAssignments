package week1.day2;

public class Browser {
	
	public void launchBrowser(String browserName) {
		System.out.println("launchBrowser: "+browserName);
	}
	public String loadUrl() {
		return  "Url loaded successfully";
	}
	public static void main(String[] args) {
		
		Browser obj = new Browser();
		obj.launchBrowser("Chrome");
		String a = obj.loadUrl();
		System.out.println(a);
	}
}
