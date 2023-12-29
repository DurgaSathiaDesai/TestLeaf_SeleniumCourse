package week3.day2.assignments;

public class UpperCaseStringOddIndex {

	public static void main(String[] args) {
		
		String test = "changeme";
		
		char[] testArray = test.toCharArray();
		
		for(int i = 0 ; i < testArray.length ; i++) {
			if((i%2) != 0) {
				testArray[i] = Character.toUpperCase(testArray[i]);
			}
		}

		String result = String.valueOf(testArray);
		System.out.println("The Modified String value : " + result);
	}
}
