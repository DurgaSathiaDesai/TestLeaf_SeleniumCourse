package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
//		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.get("http://www.facebook.com/");
//		driver.get("www.google.com");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();
//		EdgeDriver edgeDriver = new EdgeDriver();
	}

}
