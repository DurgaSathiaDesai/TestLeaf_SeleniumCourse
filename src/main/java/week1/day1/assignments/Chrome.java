package week1.day1.assignments;

import java.util.Scanner;

public class Chrome {
	
	private String browserName;
	
		
	public void getName() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Browser name :");
		browserName = scanner.nextLine();
		scanner.close();
	}
	
	public void printName() {
		
		System.out.println("This is " + browserName);
		
	}

}
