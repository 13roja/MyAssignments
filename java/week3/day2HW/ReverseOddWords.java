package week3.day2HW;

public class ReverseOddWords {
	
	public static void main(String[] args) {
		
		String test = "I am a software tester";
		
		//covert string to string array using split
		String strArray[] = test.split(" ");
		
		for(int i=0;i<strArray.length;i++) {
			
			if(i%2!=0) {
				for(int j=strArray[i].length()-1;j>0;j--) {
					
					strArray[i] = strArray[j];
				}
			}
		}
		
		for(int i=0;i<strArray.length;i++) {
			
			System.out.print(strArray[i]);
		}
		

		}
		
	}


