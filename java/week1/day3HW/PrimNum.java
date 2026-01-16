package week1.day3HW;

import java.util.Scanner;

public class PrimNum {
	
	public void IsPrime(int n) {
		int count =0;
		
		for(int i=2;i<n-1;i++) {

			if(n%i==0) {
				count ++;
			}
		}
		if(count==0) {
			System.out.println("Prime Number");
		}
		else {
			System.out.println("NonPrime Number");
		}
	}
	
	public static void main(String[] args) {
		
		PrimNum obj = new PrimNum();		
		System.out.println("Enter the input: ");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		obj.IsPrime(num);
	}

}
