package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMissingElement {

	public static void main(String[] args) {
		
		Integer[] number = {1, 2, 3, 4, 10, 6, 8};
		
		List<Integer> list = Arrays.asList(number);
		Collections.sort(list);
		
		int listSize = list.size();
		int missedNumber = 0;
		
		for(int i = 0 ; i < listSize ; i++) {
			Integer index = i + 1;
			if(list.get(i) != index) {
				missedNumber = index;
				break;
			}
		}

		System.out.print("The missing element : ");
		System.out.print(missedNumber);
		
		int low = list.get(0);
		int high = list.get(listSize - 1);
		
		System.out.print("\n");
		System.out.print("The missing elements in sequence : ");
		for (int i = low; i <= high; i++) {
			boolean found = false;
           
            for (int j = 0; j < listSize; j++) {
                if (list.get(j) == i) {
                    found = true;
                    break;
                }
            }
 
            // If i is not found in the array, print it
            if (!found) {
                System.out.print(i + " ");
            }
        }
	}
}
