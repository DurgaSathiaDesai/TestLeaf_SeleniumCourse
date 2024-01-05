package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();

		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentTitle = driver.getTitle();
		System.out.println("Parent Title : " + parentTitle);

		String parentHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("(//label[text()='FLIGHTS'])[2]/parent::a")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> winHandlesList = new ArrayList<String>(windowHandles);
		String childWinHandle = winHandlesList.get(1);
		driver.switchTo().window(childWinHandle);
		
		String childTitle = driver.getTitle();
		System.out.println("Child Window Title : " + childTitle);
		
		driver.switchTo().window(parentHandle);
		driver.close();
	}

}
