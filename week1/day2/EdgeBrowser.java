package week1.day2;

public class EdgeBrowser {

	public static void main(String[] args) {
		
		Browser obj1 = new Browser();
		obj1.launchBrowser("Safari");
		System.out.println(obj1.loadUrl());
	}
}
