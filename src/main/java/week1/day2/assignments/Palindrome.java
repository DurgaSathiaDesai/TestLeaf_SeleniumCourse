package week1.day2.assignments;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		int number;
		int remainder;
		int reverse = 0;
		
		Scanner scanner = new Scanner(System.in);
		
	    System.out.print("Enter a number to check for Palindrome : ");
        number = scanner.nextInt();
        
        for(int i = number; i > 0; i /= 10) {
        	
        	remainder = i % 10;
        	reverse = (reverse * 10) + remainder;
        }
        
        if(number != 0 && number == reverse) {
        	
        	System.out.println(number + " is a palindrome number ");
        } else {
        	
        	System.out.println(number + " is not a palindrome number ");
        }
	}
}
