package week3.day2.assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestNumber {

	public static void main(String[] args) {
		
		Integer[] number = {3, 2, 11, 4, 6, 7};
		
		List<Integer> list = Arrays.asList(number);
		Collections.sort(list);
		
		int listSize = list.size();
		System.out.println("The Second Largest Number : " + list.get(listSize-2));
	}
}
