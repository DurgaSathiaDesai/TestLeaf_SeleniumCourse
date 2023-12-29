package week3.day1;

public class BMW extends Car{

	public void autoPilotMode() {
		System.out.println("Auto Pilot Mode on ---> From BMW class");
	}
	
	public static void main(String[] args) {
		
		BMW bmw = new BMW();
		bmw.applyBreak();
		bmw.applyGear();
		bmw.autoPilotMode();
		bmw.soundHorn();
	}
}
