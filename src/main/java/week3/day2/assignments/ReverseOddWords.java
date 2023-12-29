package week3.day2.assignments;

public class ReverseOddWords {

	public static void main(String[] args) {
		
		String test = "I am a software tester";
		String[] testArray = test.split(" ");

		
		System.out.print("Reversed String : ");
		for(int i = 0 ; i < testArray.length ; i++) {
			if((i%2) != 0) {
				String temp = testArray[i];
				char[] charArray = temp.toCharArray();
				for(int j = charArray.length-1 ; j >= 0 ; j--) {
					System.out.print(charArray[j]);
				}
			} else {
				System.out.print(testArray[i]);
			}
			System.out.print(" ");
		}
	}
}
