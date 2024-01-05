package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateWindowHandling {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		WebElement link = driver.findElement(By.partialLinkText("CRM"));
		link.click();

		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Window Title : " + driver.getTitle());
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		driver.findElement(By.xpath("(//form[@name='MergePartyForm']/descendant::a)[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> winHandlesList = new ArrayList<String>(windowHandles);
		String childWinHandle = winHandlesList.get(1);
		driver.switchTo().window(childWinHandle);
		
		String childTitle = driver.getTitle();
		System.out.println("Child Window Title : " + childTitle);
		
		driver.findElement(By.xpath("(//span[text()='Contact List']/following::table)[2]/tbody/tr[1]/td[1]/descendant::a")).click();
		
		driver.switchTo().window(parentHandle);
		System.out.println("Switched to Parent Window : " + driver.getTitle());
		driver.findElement(By.xpath("(//form[@name='MergePartyForm']/descendant::a)[2]")).click();
		
		windowHandles.clear();
		windowHandles = driver.getWindowHandles();
		winHandlesList.clear();
		winHandlesList = new ArrayList<String>(windowHandles);
		String childWindowHandle = winHandlesList.get(1);
		driver.switchTo().window(childWindowHandle);
		
		System.out.println("Switched to Child Window : " + driver.getTitle());
		driver.findElement(By.xpath("(//span[text()='Contact List']/following::table)[3]/tbody/tr[1]/td[1]/descendant::a")).click();
		
		driver.switchTo().window(parentHandle);
		System.out.println("Switched to Window : " + driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		Alert confirmAlert = driver.switchTo().alert();
		String text = confirmAlert.getText();
		System.out.println("Text displayed in Alert : " + text);
		confirmAlert.accept();
		
		String pageTitle = driver.getTitle();
		if(pageTitle.contains("View Contact")) {
			System.out.println("Contacts are merged successfully !!");
		} else {
			System.out.println("Contacts not merged !!");
		}
		
		
	}

}
