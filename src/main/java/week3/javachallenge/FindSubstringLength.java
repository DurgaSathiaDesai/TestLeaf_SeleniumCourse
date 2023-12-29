package week3.javachallenge;

public class FindSubstringLength {

	public static void main(String[] args) {
		
		String message = "Welcome to TestLeaf Selenium Course";
		
		System.out.println("Message String : " + message);
		
		String[] msgSubstrings = message.split(" ");
		
		int length = msgSubstrings.length;
		
		String lastSubstr = msgSubstrings[length-1];
		
		System.out.println("Last substring in the Message : " + lastSubstr);
		System.out.println("Length of Last substring : " + lastSubstr.length());
	}
}
