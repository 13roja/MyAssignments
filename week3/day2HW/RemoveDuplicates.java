package week3.day2HW;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		String text = "We learn Java basics as part of java sessions in java week1";
		String[] strArr = text.split(" ");
		int count =0;
		
		for(int i=0;i<strArr.length;i++) {
						
			for(int j=i+1;j<strArr.length;j++) {
				
				if(strArr[i]==strArr[j]) {
					
					count ++;
					if(count>1) {
						strArr[j] = " ";
					}
				}
				
			}
			
			
		}
		
		for(int i=0;i<strArr.length;i++) {
			System.out.print(strArr[i]);
		}
	}

}
