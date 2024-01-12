package week5.day2.javachallenge;

import java.util.HashSet;
import java.util.Set;

public class FirstLetterAppearTwice {

	public static void main(String[] args) {
	
		String input = "geeksforgeeks";
		
		char[] inputArray = input.toCharArray();
		
		int size = inputArray.length;
		
		Set<Character> inputSet = new HashSet<Character>();
		
		for(int i = 0; i < size; i++) {
			boolean isPresent = inputSet.add(inputArray[i]);
			if(!isPresent) {
				System.out.println("The first letter appearing twice : " + inputArray[i]);
				break;
			}
		}

	}

}
