package week2.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		
		String accountNameEntered = "SeleniumTester";
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		System.out.println("\n");
		System.out.println("Test Results");
		System.out.println("------------");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		WebElement link = driver.findElement(By.partialLinkText("CRM"));
		link.click();
		
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		
		driver.findElement(By.id("accountName")).sendKeys(accountNameEntered);
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
		
		WebElement industryDD = driver.findElement(By.name("industryEnumId"));
		Select indSelect = new Select(industryDD);
		indSelect.selectByVisibleText("Computer Software");
		
		WebElement ownershipDD = driver.findElement(By.name("ownershipEnumId"));
		Select ownerSelect = new Select(ownershipDD);
		ownerSelect.selectByVisibleText("S-Corporation");
		
		WebElement sourceDD = driver.findElement(By.id("dataSourceId"));
		Select sourceSelect = new Select(sourceDD);
		sourceSelect.selectByValue("LEAD_EMPLOYEE");
		
		WebElement marketingCampaignDD = driver.findElement(By.id("marketingCampaignId"));
		Select campaignSelect = new Select(marketingCampaignDD);
		campaignSelect.selectByIndex(6);
		
		WebElement stateDD = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select stateSelect = new Select(stateDD);
		stateSelect.selectByValue("TX");
		
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		
		String accountNameDisplayed = driver.findElement(By.xpath("//span[text()='Account Name']/following::span")).getText();
		
		if(!accountNameDisplayed.isEmpty() && accountNameDisplayed.contains(accountNameEntered)) {
			
			System.out.println("New account is successfully created.");
			System.out.println("Account Name " + accountNameDisplayed + " is being displayed correctly.");
		} else {
			
			System.out.println("No new account created or Account Name is not being displayed correctly !");
		}
		
		driver.close();
	}
}
