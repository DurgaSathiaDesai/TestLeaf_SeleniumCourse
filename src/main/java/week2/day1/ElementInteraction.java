package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ElementInteraction {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		WebElement link = driver.findElement(By.partialLinkText("CRM/SFA"));
		link.click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		WebElement sourceDD = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select = new Select(sourceDD);
		
		select.selectByIndex(1);

		WebElement industryDD = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select indSelect = new Select(industryDD);
		
		indSelect.selectByVisibleText("Media");
		
		WebElement marketDD = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select mSelect = new Select(marketDD);
		mSelect.selectByValue("9002");
		
	}

}
