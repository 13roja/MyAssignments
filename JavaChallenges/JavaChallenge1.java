/*Given a string s consisting of words and spaces, return the length of the last word in the string.
		A word is a maximal substring consisting of non-space characters only.

		Example 1:
		Input: s = "Hello World"
		Output: 5
		Explanation: The last word is "World" with length 5. */
package JavaChallenges;
import java.util.*;

public class JavaChallenge1 {

	public static void main(String[] args) {
		
		System.out.println("Enter any string: ");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		//converting String to string array by using split() method
		String[] strArray = str.split(" ");
		
		//finding the last word from string using length
		int length = strArray.length;
		String lastWord= strArray[length-1];
		
		//printing the length of last word
		System.out.println(lastWord.length());
	}

}
