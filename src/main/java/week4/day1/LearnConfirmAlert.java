package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnConfirmAlert {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("http://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//h5[contains(text(),'Confirm Dialog')]/following::span")).click();
		Alert confirmAlert = driver.switchTo().alert();
		String text = confirmAlert.getText();
		System.out.println(text);
		confirmAlert.dismiss();
		
		String successMsg = driver.findElement(By.id("result")).getText();
		System.out.println(successMsg);
		
	}

}
