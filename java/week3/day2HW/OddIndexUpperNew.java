package week3.day2HW;

public class OddIndexUpperNew {

	public static void main(String[] args) {
		
		String str = "changeme";
		
		//convert string to string array by using split() method
		String strArray[] = str.split("");
		for(int i=0;i<str.toCharArray().length;i++) {
			
			if(i%2!=0) {
				strArray[i] = strArray[i].toUpperCase();
			}
		}
		
		//Printing the String Array
		for(int i=0;i<strArray.length;i++) {
			System.out.print(strArray[i]);
		}

	}

}
