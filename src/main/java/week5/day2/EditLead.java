package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditLead {

	@Test
	public void EditLeadTestCase() {
ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		WebElement link = driver.findElement(By.partialLinkText("CRM/SFA"));
		link.click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[contains(@id,'firstName')]")).sendKeys("Durga");
		driver.findElement(By.xpath("//input[contains(@id,'lastName')]")).sendKeys("Sathia Desai");
		driver.findElement(By.xpath("//input[contains(@id,'firstNameLocal')]")).sendKeys("Durga");
		
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("DurgaDesai@gmail.com");
		
		WebElement stateDD = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select stateSelect = new Select(stateDD);
		stateSelect.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Upskill to Success");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		String pageTitle = driver.getTitle();
		System.out.println("Title of the resulting page : " + pageTitle);
		
		driver.close();

	}
}
