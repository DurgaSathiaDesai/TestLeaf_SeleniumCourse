package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteLead {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		System.out.println("\n");
		System.out.println("Test Results");
		System.out.println("------------");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		WebElement link = driver.findElement(By.partialLinkText("CRM/SFA"));
		link.click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Phone']/ancestor::a")).click();
		
		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneCountryCode")).sendKeys("91");
		driver.findElement(By.name("phoneAreaCode")).sendKeys("44");
		driver.findElement(By.name("phoneNumber")).sendKeys("23459876");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String firstLeadId;
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a")))));
		try {
			firstLeadId = driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a")).getText();
			System.out.println("Lead ID of the first resulted Lead : " + firstLeadId);
		} catch(StaleElementReferenceException e) {
			firstLeadId = driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a")).getText();
			System.out.println("Lead ID of the first resulted Lead : " + firstLeadId);
		}
		
		try {
			driver.findElement(By.linkText(firstLeadId)).click();
		} catch(StaleElementReferenceException e) {
			driver.findElement(By.linkText(firstLeadId)).click();
		}
		
		driver.findElement(By.linkText("Delete")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.name("id")).sendKeys(firstLeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a")))));	
		String expectedMsg = "No records to display";
		
		String recordDisplayMsg = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();

		if(recordDisplayMsg.equals(expectedMsg)) {
			System.out.println("Lead has been deleted successfully!!");
		} else {
			System.out.println("Error in deleting the Lead !!");
		}
		
		driver.close();
	}
}
