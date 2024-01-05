package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NykaaAutomation {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.nykaa.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		WebElement element = driver.findElement(By.xpath("//a[text()='brands']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		String brand = "L'Oreal Paris";
		driver.findElement(By.id("brandSearchBox")).sendKeys(brand);
		
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='list_L']/following::a")))));
		String title = driver.findElement(By.xpath("//div[@id='list_L']/following::a")).getText();
		System.out.println(title);
		if(title.equals(brand)) {
			driver.findElement(By.xpath("//div[@id='list_L']/following::a")).click();
		}
		
	}

}
