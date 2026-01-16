package week3.day2HW;

public class OddIndexUppercase {
	
	public static void main(String[] args) {
		
		String test = "changeme";
		char[] charArray = test.toCharArray();
		
		for(int i=0;i< charArray.length;i++) {
			
			if(i%2!=0) {
				charArray[i] = (char) (charArray[i] - 32);
			}
		}
		for(int i=0;i<charArray.length;i++) {
			
			System.out.print(charArray[i]);
		}
	}
}
