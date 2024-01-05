package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptAlert {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//h5[contains(text(),'Prompt Dialog')]/following::span")).click();
		Alert promptAlert = driver.switchTo().alert();
		String text = promptAlert.getText();
		System.out.println("Alert Message : " + text);

		promptAlert.dismiss();
		String message = driver.findElement(By.id("confirm_result")).getText();
		System.out.println("The message displayed :" + message);
		
		driver.findElement(By.xpath("//h5[contains(text(),'Prompt Dialog')]/following::span")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Durga SathiaDesai");
		prompt.accept();
		String userName = driver.findElement(By.id("confirm_result")).getText();
		String[] name = userName.split(":");
		System.out.println("The Text entered :" + name[1]);

	}

}
