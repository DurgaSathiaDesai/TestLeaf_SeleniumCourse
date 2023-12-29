package week3.javachallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindUniqueElement {
	
	public void logLinear(int[] numArray, int size) {
		System.out.print("Elements that occurred only once: ");
		if(size == 1) {
			System.out.println(numArray[0]);
			return;
		}
		Arrays.sort(numArray);
		
		for(int i = 0; i < size ; i++) {
			if(numArray[i] == numArray[i+1]) {
				i++;
				break;
			} else {
				System.out.println(numArray[i]);

			}	
		}
		
		if (numArray[size - 1] != numArray[0] && 
				numArray[size - 1] != numArray[size - 2])
		        System.out.print(numArray[size - 1]);

	}
	
	public void exponential(int[] numArray, int size) {
		System.out.print("Elements that occurred only once: ");
		if(size == 1) {
			System.out.println(numArray[0]);
			return;
		}
		boolean flag = false;
		Arrays.sort(numArray);
		
		for(int i = 0; i < size - 1 ; i++) {
			flag = false;
			for(int j = i + 1; j < size; j++) {
				if(numArray[i] == numArray[i+1]) {
					flag = true;
					i++;
					break;
				} 
			}
					
			if(!flag) {
				System.out.println(numArray[i]);
			}
		}
		
		if (numArray[size - 1] != numArray[0] && 
				numArray[size - 1] != numArray[size - 2])
		        System.out.print(numArray[size - 1]);
	}
	
	public void logLinearComplexity(int[] numArray, int size) {
		
		int temp = 1;
		int len = size;
		
		Arrays.sort(numArray);
		
		if (numArray[0] == numArray[len - 1]) 
	    {
	        temp = 2;
	        len--;
	    }
		
		for (; temp < size; temp++)
			if (numArray[temp] == numArray[temp - 1])
				temp++;
			else
	            System.out.print(numArray[temp - 1] + " ");
		
		if (numArray[size - 1] != numArray[0] && 
				numArray[size - 1] != numArray[size - 2])
		        System.out.print(numArray[size - 1]);
	}
	
	
	public static void linear(int[] numArray) {
        Map<Integer, Integer> countMap = new HashMap<Integer,Integer>();

        // Count the occurrences of each element
        for (int num : numArray) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Print the elements that occurred only once
        System.out.print("Elements that occurred only once: ");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }

	public static void main(String[] args) {
		
		FindUniqueElement unique = new FindUniqueElement();
		int[] numArray = {4,2,1,2,1};
		int size = numArray.length;
		
		System.out.println("LogLinear O(nlogn) Time Complexity");
		System.out.println("-------------------------");
		unique.logLinear(numArray, size);
		System.out.println("\n");
		System.out.println("Exponential O(n^2) Time Complexity");
		System.out.println("-------------------------");
		unique.exponential(numArray, size);
		System.out.println("\n");
//		unique.logLinearComplexity(numArray, size);
		System.out.println("Linear O(n) Time Complexity");
		System.out.println("-------------------------");
		linear(numArray);
	}
}
