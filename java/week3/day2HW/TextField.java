package week3.day2HW;

public class TextField extends WebElement{
	
	void getText() {
		System.out.println("getText() ---from subclass Textfiled");
	}
	
	public static void main(String[] args) {
		
		TextField t = new TextField();
		t.setText("New class");
		t.click();
		t.getText();
	}

}
