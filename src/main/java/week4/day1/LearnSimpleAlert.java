package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class LearnSimpleAlert {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("http://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//span[text()='Show']")).click();
		Alert simpleAlert = driver.switchTo().alert();
		String text = simpleAlert.getText();
		System.out.println(text);
		simpleAlert.accept();
		
		String successMsg = driver.findElement(By.id("simple_result")).getText();
		System.out.println(successMsg);
	}

}
