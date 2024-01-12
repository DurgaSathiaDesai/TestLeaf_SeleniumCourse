package week5.day2.javachallenge;

import java.util.HashSet;
import java.util.Set;

public class FindNonRepeatingCharacterIndex {

	public static void main(String[] args) {
		
		String input = "aabb";
		boolean flag = true;
		char[] inputArray = input.toCharArray();
		
		int size = inputArray.length;
		
		for(char letter : inputArray) {
			if(input.indexOf(letter) == input.lastIndexOf(letter)) {
				System.out.println("The first non-repeating character '" + letter + "' index : " + input.indexOf(letter));
				flag = false;
				break;
			}
		}

		if(flag) {
			System.out.println("-1");
		}
	}

}
