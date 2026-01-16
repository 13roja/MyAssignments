package week4.day4.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingCollectionString {

	public static void main(String[] args) {
		
		
		List<String> str = new ArrayList<>(Arrays.asList("HCL", "Wipro", "Aspire Systems", "CTS"));
		
		Collections.sort(str);
		System.out.println("sorted list is :"+str);
		
		Collections.reverse(str);
		System.out.println("Reverse list is :"+str);

	}

}
