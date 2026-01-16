package week3.day1;

public class Pallindrome {

	public static void main(String[] args) {
		
		String companyName= "WOW";
		String reverse ="";
		
		char[] charArray = companyName.toCharArray();
		
		for(int i=charArray.length-1;i>=0;i--) {
			
			reverse = reverse + charArray[i];
		}
		
		if(companyName.equals(reverse)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not Palindrome");
		}
	}

}
