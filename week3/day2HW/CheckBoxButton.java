package week3.day2HW;

public class CheckBoxButton extends Button{
	
	void  clickCheckButton(){
		System.out.println("clickCheckButton() -- from subclass  clickCheckButton");
	}
	
	public static void main(String[] args) {
		CheckBoxButton ch = new CheckBoxButton();
		ch.click();
		ch.clickCheckButton();
		ch.submit();
	}

}
