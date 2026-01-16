package week4.day4.HW;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MissingElementList {

	public static void main(String[] args) {
		
		Integer[] arr = {1, 2, 3, 4, 10, 6, 8};
		
		List<Integer> n = new ArrayList<>(Arrays.asList(arr));
		Collections.sort(n);
		
		System.out.println(n);
		
		for(int i=0;i<n.size()-1;i++) {

			int current = n.get(i);
			int next = n.get(i+1);
			
			if(current+1 !=next) {
				for(int j=current+1;j<next;j++) {
					System.out.println(j);
				}
				
			}
		}

		

	}

}
