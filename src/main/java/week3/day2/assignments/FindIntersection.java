package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		
		Integer[] numArray1 = {3, 2, 11, 4, 6, 7};
		Integer[] numArray2 = {1, 2, 8, 4, 9, 7};

		List<Integer> numList1 = Arrays.asList(numArray1);
		List<Integer> numList2 = Arrays.asList(numArray2);
		
		int listSize1 = numList1.size();
		int listSize2 = numList2.size();
		
		List<Integer> result = new ArrayList<Integer>();
		
		System.out.print("The elements in both arrays : ");
		for(int i = 0; i < listSize1; i++) {
        	for(int j = 0; j < listSize2; j++) {
        		
        		if (numList1.get(i) == numList2.get(j)) {
        			if(!result.contains(numList1.get(i))) {
        				result.add(numList1.get(i));
        			}
        		}
        	}
        }
		
		for(Integer number : result) {
			System.out.print(number + " ");
		}
		
	}

}
