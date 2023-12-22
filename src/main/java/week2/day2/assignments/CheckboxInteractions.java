package week2.day2.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxInteractions {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://leafground.com/checkbox.xhtml");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		System.out.println("\n");
		System.out.println("Test Results");
		System.out.println("------------");

		driver.findElement(By.xpath("(//span[contains(text(),'Basic')]/preceding-sibling::div)[2]")).click();
		
		driver.findElement(By.xpath("(//span[contains(text(),'Ajax')]/preceding-sibling::div)[2]")).click();
		
		String expectedMsg = "Checked";
		String notificationMsg = driver.findElement(By.className("ui-growl-title")).getText();

		if(notificationMsg.equals(expectedMsg)) {
			
			System.out.println("Checked Message for Notification checkbox is displayed !!");
		} 
		
		driver.findElement(By.xpath("//label[text()='Java']/preceding::div[1]")).click();
		driver.findElement(By.xpath("//label[text()='Javascript']/preceding::div[1]")).click();
		
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("ui-growl-title"))));
		
		driver.findElement(By.xpath("(//div[contains(@id,'ajaxTriState')]/div)[2]")).click();
//		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("ui-growl-title")),"Checked")));
		boolean isVisible = true;
		while(isVisible) {
			try {
				if(driver.findElement(By.className("ui-growl-title")).isDisplayed()) {
					isVisible = false;
				}
			} catch(StaleElementReferenceException e) {
				if(driver.findElement(By.className("ui-growl-title")).isDisplayed()) {
					isVisible = false;
				}
			}
		}

		String state = driver.findElement(By.xpath("//div[contains(@class,'ui-growl-message')]/p")).getText();
		System.out.println("Tri-state option chosen : " + state);
		
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("ui-growl-title"))));
		
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		String toggleMsg = driver.findElement(By.className("ui-growl-title")).getText();
		
		if(toggleMsg.equals(expectedMsg)) {
			System.out.println("Checked Message for Toggle-switch slider is displayed !!");
		} 

		Boolean isDisabled = driver.findElement(By.xpath("(//span[text()='Disabled']/preceding-sibling::div)[2]")).isEnabled();
		
		if(isDisabled) {
			System.out.println("The Checkbox is disabled !!");
		} else {
			System.out.println("The Checkbox is not disabled !!");
		}
		
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		
		driver.findElement(By.xpath("//li[@data-item-value='Berlin']/div")).click();
		driver.findElement(By.xpath("//li[@data-item-value='Rome']/div")).click();
		driver.findElement(By.xpath("//li[@data-item-value='London']/div")).click();
		
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		
		Boolean isBasicSelected = driver.findElement(By.xpath("//input[@aria-label='Basic']")).isSelected();
		if(isBasicSelected) {
			System.out.println("Basic checkbox is selected");
		}
		
		driver.close();
	}
}
