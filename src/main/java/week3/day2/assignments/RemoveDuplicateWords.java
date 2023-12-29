package week3.day2.assignments;

public class RemoveDuplicateWords {

	public static void main(String[] args) {
		
		String text = "We learn Java basics as part of java sessions in java week1";
		int count = 0;
		String[] textArray = text.split("\\s");
		
		for(int i = 0 ; i < textArray.length; i++) {
			for(int j = i+1 ; j < textArray.length; j++) {
				if(textArray[i].equalsIgnoreCase(textArray[j])) {
					count++;
					textArray[j] = "";
				}
			}
		}
		
		String result = String.join(" ", textArray);
		
		if(count > 1) {
			System.out.println("The String '" + text + "' has duplicates !!");
			System.out.println("The modified String after removing duplicates : " + result);
		} else {
			System.out.println("No duplicates in String '" + text + "' !!");
		}
	}
}
