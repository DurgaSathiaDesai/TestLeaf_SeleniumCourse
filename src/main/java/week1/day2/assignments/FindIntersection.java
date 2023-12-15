package week1.day2.assignments;

import java.util.Scanner;

public class FindIntersection {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the array size : ");
        int size = scanner.nextInt();
        
        int[] firstArray = new int[size];
        int[] secondArray = new int[size];
        
        System.out.println("Enter the elements of the first array : ");  
        for(int i=0; i<size; i++) {   
        	firstArray[i] = scanner.nextInt();  
        }  
        
        System.out.println("Enter the elements of the second array : ");  
        for(int i=0; i<size; i++) {   
        	secondArray[i] = scanner.nextInt();  
        }  
        
        int[] result = new int[size];
        
        for(int i=0; i<size; i++) {
        	
        	for(int j=0; j<size; j++) {
        		
        		if (firstArray[i] == secondArray[j]) {
        			System.out.println(firstArray[i]);
        		}
        	}
        }
	}

}
