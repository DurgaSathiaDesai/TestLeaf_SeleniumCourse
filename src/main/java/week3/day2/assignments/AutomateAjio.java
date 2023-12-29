package week3.day2.assignments;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateAjio {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.ajio.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.name("searchVal")).sendKeys("bags");
		driver.findElement(By.xpath("//button[@aria-label='search']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='D2C Fashion']"))));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.id("Men")));
		boolean genderSelected = false;
		try {
			wait.until(ExpectedConditions.elementSelectionStateToBe(driver.findElement(By.id("Men")),true));
			genderSelected = driver.findElement(By.id("Men")).isSelected();
		} catch(StaleElementReferenceException e) {
			genderSelected = driver.findElement(By.id("Men")).isSelected();
		}
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[contains(@id,'Fashion Bags')]")));
		boolean catSelected = false;
		try {
			wait.until(ExpectedConditions.elementSelectionStateToBe(driver.findElement(By.xpath("//input[contains(@id,'Fashion Bags')]")),true));
			catSelected = driver.findElement(By.xpath("//input[contains(@id,'Fashion Bags')]")).isSelected();
		} catch(StaleElementReferenceException e) {
			catSelected = driver.findElement(By.xpath("//input[contains(@id,'Fashion Bags')]")).isSelected();
		}

		if(genderSelected && catSelected) {
			String itemsCount = driver.findElement(By.xpath("//div[contains(@aria-label,'Items Found')]/strong")).getText();
			System.out.println(itemsCount);
		} else {
			System.out.println("Could not get the items count !!");
		}
		
		List<WebElement> brandElements = driver.findElements(By.xpath("//div[@class='brand']/strong"));
		
		Set<String> brandSet = new HashSet<String>();
		for (WebElement brandElement : brandElements) {
            String brand = brandElement.getText();
            brandSet.add(brand);
        }
		
		System.out.println("List of Brands available in the current page : ");
		for(String brand : brandSet) {
			System.out.println(brand);
		}
		
		List<WebElement> productNameElements = driver.findElements(By.xpath("//div[@class='nameCls']"));
		
		Set<String> nameSet = new HashSet<String>();
		for (WebElement productNameElement : productNameElements) {
            String name = productNameElement.getText();
            nameSet.add(name);
        }
		
		System.out.println("\n");
		System.out.println("List of Products available in the current page : ");
		for(String name : nameSet) {
			System.out.println(name);
		}

//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(By.id("Men"))).click().build().perform();
	}
}
