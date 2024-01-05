package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnDoubleClick {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame("iframeResult");
		WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Double-click')]"));
		
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
	}
	
}
