package week1.day2;

public class FindOddNumbers {

	public static void main(String[] args) {
		
		int maxRange = 10;
		
		for(int num = 1;num <= maxRange ; num++) {
			
			if(num%2 == 1) {
				System.out.println(num);
			}
		}
	}
}
