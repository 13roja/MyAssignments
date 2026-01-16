package week4.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetInterface {

	public static void main(String[] args) {
		
		String companyName = "google";
		char[] charArray = companyName.toCharArray();
		
		Set<Character> uniqueValue = new LinkedHashSet<Character>();
		
		for(int i=0;i<charArray.length;i++) {
			
			uniqueValue.add(charArray[i]);
		}
		
		//System.out.println(uniqueValue);
		
		for(char ch:uniqueValue) {
		
			System.out.print(ch);
		}
		
		
	}

}
