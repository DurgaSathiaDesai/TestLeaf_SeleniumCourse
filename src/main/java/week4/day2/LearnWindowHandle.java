package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Load the website
		driver.get("http://leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentTitle = driver.getTitle();
		System.out.println("Parent Title : " + parentTitle);
		
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Window Handle : " + parentHandle);
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> winHandlesList = new ArrayList<String>(windowHandles);
		String childWinHandle = winHandlesList.get(1);
		driver.switchTo().window(childWinHandle);
		
		String childTitle = driver.getTitle();
		System.out.println("Child Window Title : " + childTitle);
		
		driver.close();
		driver.switchTo().window(parentHandle);
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
