package week2.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookAccount {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
//		driver.findElement(By.xpath("//a[contains(@data-testid,'open-registration-form')]")).click();
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Durga");
		driver.findElement(By.name("lastname")).sendKeys("Desai");
		
//		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("DurgaDesai@gmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("DurgaDesai@gmail.com");
		
		driver.findElement(By.xpath("//input[contains(@name,'email_confirmation')]")).sendKeys("DurgaDesai@gmail.com");
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("Hello@Selenium");
		
		WebElement dayDD = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDD);
		daySelect.selectByVisibleText("24");
		
		WebElement monthDD = driver.findElement(By.id("month"));
		Select monthSelect = new Select(monthDD);
		monthSelect.selectByValue("3");
		
		WebElement yearDD = driver.findElement(By.id("year"));
		Select yearSelect = new Select(yearDD);
		yearSelect.selectByValue("1991");
		
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
//		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();	
	}
}
