package week4.javachallenge;

import java.util.HashSet;
import java.util.Set;

public class FindHappyNumber {

	public static void main(String[] args) {
		int number = 82;
		int remainder = 0;
		int sum = 0;
		
		Set<Integer> tmpSet = new HashSet<Integer>();
		
		System.out.println("Is the number : " + number + " happy ? ");
		while(number > 0) {
				
			while(number != 0) {
				remainder = number % 10;
				sum = sum + (remainder * remainder);
				number = number / 10;
			}
			number = sum;
			sum = 0;
			if(number == 1) {
				System.out.println("Yes");
				break;
			} else {
				boolean present = tmpSet.add(number);
				if(!present) {
					System.out.println("No");
					break;
				} 
			}
		}	
	}
}
