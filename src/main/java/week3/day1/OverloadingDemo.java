package week3.day1;

public class OverloadingDemo {

	public void reportStep(String msg , String status) {
		System.out.println("Message : " + msg + " --> " + "Status : " + status);
	}
	
	public void reportStep(String msg , String status , boolean snap) {
		System.out.println("Message : " + msg + " --> " + "Status : " + status);
		if(snap) {
			System.out.println("Snapshot taken !!");
		} else {
			System.out.println("No Snapshot taken !!");
		}
	}
	public static void main(String[] args) {
		
		OverloadingDemo overloadDemo = new OverloadingDemo();
		overloadDemo.reportStep("Welcome Email to Guests !!", "Delivered");
		overloadDemo.reportStep("Payment receipt sent via Email", "Pending", true);
	}

}
