package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateFrames {

	public static void main(String[] args) {
		
ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//Cancelling the alert
		Alert promptAlert = driver.switchTo().alert();
		String text = promptAlert.getText();
		System.out.println("Alert Message : " + text);

		promptAlert.dismiss();
		String message = driver.findElement(By.id("demo")).getText();
		if(message.contains("cancelled")) {
			System.out.println("Alert is dismissed !!");
		}
		System.out.println("The message displayed :" + message);
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//Accepting the alert
		Alert pAlert = driver.switchTo().alert();
		pAlert.sendKeys("Durga SathiaDesai");
		pAlert.accept();
		String msg = driver.findElement(By.id("demo")).getText();
		if(msg.contains("Hello")) {
			System.out.println("Alert is accepted !!");
		}
		System.out.println("The message displayed :" + msg);
	}
}
