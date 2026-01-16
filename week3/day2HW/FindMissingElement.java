package week3.day2HW;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		
		int[] arr = {1,4,3,2,8,6,7};
		
		Arrays.sort(arr);
		
		for(int i=arr[0];i<=arr.length;i++) {
			
			if(i!=arr[i-1]) {
				System.out.println(i);
				break;
			}
		}
	
	}

}
