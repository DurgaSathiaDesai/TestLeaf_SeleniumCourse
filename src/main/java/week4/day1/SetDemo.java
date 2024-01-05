package week4.day1;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		
		String companyName = "google";
		
		char[] nameArray = companyName.toCharArray();
		
		Set<Character> unique = new LinkedHashSet<Character>();
		
		for(int i = 0; i < nameArray.length; i++) {
			unique.add(nameArray[i]);
		}

		System.out.print("The unique characters are : ");
		for(Character letter : unique) {
		  System.out.print(letter);
		}
	}

}
