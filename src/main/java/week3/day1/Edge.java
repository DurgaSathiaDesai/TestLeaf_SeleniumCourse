package week3.day1;

import org.openqa.selenium.safari.SafariDriver;

public class Edge extends Browser{

	public void takeSnap() {
		System.out.println("Take a snapshot !!");
	}
	
	public void clearCookies() {
		System.out.println("Cookies cleared !!");
	}
	
	public static void main(String[] args) {
//		SafariDriver s = new SafariDriver();
		Edge edge = new Edge();
		
		edge.openURL("Edge","120.0.2210.91");
		edge.takeSnap();
		edge.navigateBack();
		edge.clearCookies();
		edge.closeBrowser();
	}

}
