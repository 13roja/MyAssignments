package week3.day2HW;

public class RadioButton extends Button{
	
	void  selectRadioButton(){
		System.out.println("selectRadioButton() ---from subclass  RadioButton");
	}
	
	public static void main(String[] args) {
		RadioButton r = new RadioButton();
		r.selectRadioButton();
		r.setText("roja");
		r.submit();
	}

}
