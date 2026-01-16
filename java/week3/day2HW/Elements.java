package week3.day2HW;

public class Elements extends Button{

	public static void main(String[] args) {
		
		Elements obj = new Elements();
		//calling method from WebElement baseclass
		obj.click();
		obj.setText("Learning Inheritance");
		
		//calling method from Button baseclass
		obj.submit();

	}

}
