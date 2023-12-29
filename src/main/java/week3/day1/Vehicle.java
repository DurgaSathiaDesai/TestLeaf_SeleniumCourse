package week3.day1;

public class Vehicle {

	public void applyBreak() {
		System.out.println("Break Applied --> From Vehicle class");
	}
	
	public void soundHorn() {
		System.out.println("Move Aside --> From Vehicle class");
	}
	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.applyBreak();
		vehicle.soundHorn();
	}

}
