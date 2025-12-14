package week1.day3HW;
import java.util.*;

public class FiboSeries {

	public static void main(String[] args) {
		
		int firstNum = 0;
		int secNum = 1;
		
		System.out.println("Enter the input: ");

		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		
		System.out.print(firstNum+" "+secNum+" ");
		
		for(int i=3;i<=input;i++) {
			
			int temp;
			temp = firstNum + secNum;
			firstNum = secNum;
			secNum = temp;
			
			System.out.print(temp+" ");
		}
	}
}
