package week4.day4.HW;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class InterSectionList {

	public static void main(String[] args) {
		
		Integer[] a = {3, 2, 11, 4, 6, 7};
		Integer[] b = {1, 2, 8, 4, 9, 7};
		
		List<Integer> a1 = new ArrayList<>(Arrays.asList(a));
		List<Integer> b1 = new ArrayList<>(Arrays.asList(b));
		
		for(int i=0;i<a1.size();i++) {
			for(int j=0;j<b1.size();j++) {
				
				if(a1.get(i)==b1.get(j)) {
					System.out.println(a1.get(i));
				}
			}
		}

	}

}
