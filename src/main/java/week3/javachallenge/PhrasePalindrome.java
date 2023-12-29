package week3.javachallenge;

public class PhrasePalindrome {

	public static boolean checkPalindrome(String text) {
		if(text.isEmpty()) {
			return true;
		}
		
		String modText = text.toLowerCase();
		
		modText = modText.replaceAll("[^a-zA-Z0-9]", "");
		
		StringBuilder revTextBuild = new StringBuilder(modText); 
		revTextBuild.reverse(); 
	    String reverseText = revTextBuild.toString();
	    
	    if(reverseText.equals(modText)) {  	
	    	return true;
	    } else {
	    	return false;
	    }
	}
	public static void main(String[] args) {
		
		String text = "race a car"; 
        if(checkPalindrome(text)) {
        	System.out.println("The Phrase '" + text + "' is a Palindrome");
        } else {
        	System.out.println("The Phrase '" + text + "' is not a Palindrome");
        }
	}
}
