package week1.day1.assignments;

public class Mobile {
	
	void makeCall() {
		
		String mobileModel = "Galaxy S6 Edge";
		float mobileWeight = 200.0f;
		
		System.out.println("Model : " + mobileModel);
		System.out.println("Weight : " + mobileWeight + "g");
	}
	
	void sendMsg() {
		
		boolean isFullCharged = true;
		int mobileCost = 10000;
		
		System.out.println("IsFullCharged : " + isFullCharged + "\nCost : Rs." + mobileCost);
	}

	public static void main(String[] args) {
		
		Mobile mobile = new Mobile();
		
		System.out.println("This is my Mobile !!\n");
		mobile.makeCall();
		mobile.sendMsg();

	}

}
