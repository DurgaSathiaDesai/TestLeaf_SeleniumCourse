package week4.javachallenge;

public class FindNotUniqueArray {

	public static void main(String[] args) {
		int[] numArray = {1,1,1,3,3,4,3,2,4,2};
		int size = numArray.length;
		int count = 0;
		for(int i = 0; i < size; i++) {
			count = 0;
			for(int j = i + 1; j < size; j++) {
				if(numArray[i] == numArray[j]) {
					count++;
					break;
				}
			}
			if(count==1) {
				System.out.println("true");
				break;
			}
		}
		if(count==0) {
			System.out.println("false");
		}

	}
}
