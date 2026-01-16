package week4.day4.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargest {

	public static void main(String[] args) {
		
		List<Integer> num = new ArrayList<>(Arrays.asList(3, 2, 11, 4, 6, 7));
		Collections.sort(num);
		System.out.println("Sorted List:"+num);
		int size = num.size();
		System.out.println("Second Largest num is :"+ num.get(size-2));
	}

}
