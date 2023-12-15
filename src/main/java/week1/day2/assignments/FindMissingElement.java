package week1.day2.assignments;

import java.util.Arrays;

public class FindMissingElement {

	private static int getMissingNumber(int[] number) {
        
		int missed = 0;
		
		for (int i = 0; i < number.length; i++) {  
			int index = i + 1; 
			if (number[i] != index) { 
				missed = index; 
				break; 
			} 
		}
				 
        return missed;
    }
	
	public static void main(String[] args) {
		
		int[] number = {1, 4, 8, 2, 5, 6, 7};
        Arrays.sort(number);
        System.out.println("Missing Number is : " + getMissingNumber(number));
	}

}
