package week3.javachallenge;

public class FindSquareRoot {

	public int calculateSquareRoot(int number) {
		int temp;
		int sqrt;
		
		if(number == 0 || number == 1) {
			return number;
		}
		sqrt = number/2;
		do {
			temp = sqrt;
			sqrt = (temp + (number/temp)) / 2;
			if(temp < sqrt) {
				sqrt = temp;
				break;
			}
		} while((temp-sqrt) != 0);
		return sqrt;
	}
	
	public int calcSquareRoot(int number) {
		int temp = 1;
		int sqRoot = 1;
		if(number == 0 || number == 1) {
			return number;
		}
		
		while (sqRoot <= number) {
			temp++;
			sqRoot = temp * temp;
        }
        return temp - 1;
	}
	public static void main(String[] args) {
		
		FindSquareRoot findSqrt = new FindSquareRoot();
		
		//Finding Square Root By Method 1
		int number = 101;
		int squareRoot;
		
		squareRoot = findSqrt.calculateSquareRoot(number);
		System.out.println("SquareRoot of number " + number + " : " + squareRoot);
		
		//Finding Square Root By Method 2
		int input = 125;
		int sqRoot;
		
		sqRoot = findSqrt.calculateSquareRoot(input);
		System.out.println("SquareRoot of number " + input + " : " + sqRoot);		
	}

}
