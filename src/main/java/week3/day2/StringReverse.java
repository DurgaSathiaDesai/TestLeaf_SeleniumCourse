package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class StringReverse {

	public static void main(String[] args) {
		
		String orgName = "Testleaf";
		char[] nameArray = orgName.toCharArray();
		
		System.out.print("Reverse of String " + orgName + " : ");
		for(int i = nameArray.length - 1 ; i >= 0 ; i--) {
			System.out.print(nameArray[i]);
		}
		
		System.out.println("\t");
		String input = "TestLeaf";
		char[] inputArray = input.toCharArray();
 		char[] outputArray = new char[inputArray.length];
 		int j = 0;
		for(int i = inputArray.length - 1; i >= 0 ; i--) {
			outputArray[j] = inputArray[i];
 			j++;
		}
 		String output = String.valueOf(outputArray);
      	System.out.println(output);
	}
}
