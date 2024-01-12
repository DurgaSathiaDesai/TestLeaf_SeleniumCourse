package week5.day2.javachallenge;

public class JewelStoneProblem {

	public static void main(String[] args) {
		
		String jewels = "z";
		String stones = "ZZ";
		int count = 0;
		
		char[] jewelArray = jewels.toCharArray();
		char[] stoneArray = stones.toCharArray();
	
		int jewelSize = jewels.length();
		int stoneSize = stones.length();
		
		for(int i = 0; i < jewelSize; i++) {
			for(int j = 0; j < stoneSize; j++) {
				if(stoneArray[j] == jewelArray[i]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
