package week3.day2;

public class Safari extends Browser{

	void readerMode() {
		System.out.println("readerMode() method from Safari subclass");
	}
	void fullScreenMode() {
		System.out.println("fullScreenMode() method from Safari Subclass");
	}
	
	public static void main(String[] args) {
		
		Safari s = new Safari();
		System.out.println(s.browserVersion = 4.27);
		s.readerMode();
		s.closeBrowser();
	}
}
