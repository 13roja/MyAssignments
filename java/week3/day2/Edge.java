package week3.day2;

public class Edge extends Browser{
		
	void takeSnap() {
		System.out.println("takeSnap() method from Edge subclass");
	}
	void clearCookies() {
		System.out.println("clearCookies() method from Edge Subclass");
	}
	
	public static void main(String[] args) {
		
		Edge e = new Edge();
		e.clearCookies();
		e.takeSnap();
		System.out.println(e.browserName = "browserName is Edge");
		e.navigateBack();
		
	}

}
