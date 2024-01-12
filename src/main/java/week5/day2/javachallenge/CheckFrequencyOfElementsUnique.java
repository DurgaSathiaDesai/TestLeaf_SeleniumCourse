package week5.day2.javachallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckFrequencyOfElementsUnique {

	public static void main(String[] args) {
		
		int[] inputArray = {-3,0,1,-3,1,1,1,-3,10,0};
		
		int size = inputArray.length;
		Map<Integer,Integer> inputMap = new HashMap<Integer,Integer>();
		Set<Integer> valueSet = new HashSet<Integer>();
		boolean flag = true;
		
		for(int num = 0; num < size; num++) {
			if(inputMap.containsKey(inputArray[num])) {
				int count = inputMap.get(inputArray[num]);
				inputMap.put(inputArray[num], count + 1);
			} else {
				inputMap.put(inputArray[num], 1);
			}
		}
		
		for (Integer value : inputMap.values()) {
			boolean isDuplicate = valueSet.add(value);
			if(!isDuplicate) {
				System.out.println("false");
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("true");
		}
	}
	
	

}
