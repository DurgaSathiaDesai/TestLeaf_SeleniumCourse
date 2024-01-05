package week4.javachallenge;

public class FindMajorityElement {

	public static void main(String[] args) {
		int[] numArray = {2,2,1,1,1,2,2};
		int size = numArray.length;
		int count = 0;
		int num = size/2;
		boolean found = false;

		for(int i = 0; i < size; i++) {
			count = 1;
			for(int j = i + 1; j < size; j++) {
				if(numArray[i] == numArray[j]) {
					count++;
				}
			}

			if(count>num) {
				System.out.println("The majority element : " + numArray[i]);
				found = true;
			} 
		}
		
		if(!found) {
			System.out.println("No majority elements in array !!");
		}
	}

}
