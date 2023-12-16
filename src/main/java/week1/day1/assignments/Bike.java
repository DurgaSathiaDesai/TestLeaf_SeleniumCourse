package week1.day1.assignments;

public class Bike {
	
	void callCarOperations() {
		
		Car car = new Car();
		car.applyBreak();
		car.soundHorn();
	}

	public static void main(String[] args) {
		
		Bike bike = new Bike();
		bike.callCarOperations();	
	}

}
