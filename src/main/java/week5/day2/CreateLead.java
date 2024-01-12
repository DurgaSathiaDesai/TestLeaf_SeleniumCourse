package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLead {

	@Test
	public void CreateLeadTestCase() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("democsr");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();

		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'CRM')]"));
		link.click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[contains(@id,'firstName')]")).sendKeys("Durga");
		driver.findElement(By.xpath("//input[contains(@id,'lastName')]")).sendKeys("S");
		  
		WebElement sourceDD = driver.findElement(By.xpath("//select[contains(@id,'dataSourceId')]"));
		Select select = new Select(sourceDD);
		select.selectByIndex(1);
		WebElement industryDD = driver.findElement(By.xpath("//select[contains(@id,'industryEnumId')]"));
		Select indSelect = new Select(industryDD);
		indSelect.selectByVisibleText("Media");
		WebElement marketDD = driver.findElement(By.xpath("//select[contains(@id,'marketingCampaignId')]"));
		Select mSelect = new Select(marketDD);
		mSelect.selectByValue("9002");

		driver.findElement(By.name("submitButton")).click();
	}

}
