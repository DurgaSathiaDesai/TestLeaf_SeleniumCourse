package week1.day1.assignments;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int flag = 0;
		int range = 0;
		
		Scanner scanner = new Scanner(System.in);

		while(flag == 0) {
			
			 System.out.print("Enter the range for Fibonacci series: ");
		     range = scanner.nextInt();
		     if (range>0) {
		    	 flag = 1;
		     } else {
		    	 System.out.println("Range has to be greater than 0 !!");
		     }
		}
       
        int[] fibonacciArray = new int[range + 2];

        // First two elements of the Fibonacci series
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;

        // Generate Fibonacci series using a for loop
        for (int i = 2; i < range; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }

        if (range != 0) {
        	
        	 // Print the Fibonacci series
            System.out.print("Fibonacci series for the given range - " + range + ":  ");
            for (int i = 0; i < range; i++) {
                System.out.print(fibonacciArray[i] + " ");
            }
        }
       
        scanner.close();
	}

}
