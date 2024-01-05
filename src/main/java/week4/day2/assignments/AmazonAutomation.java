package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAutomation {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		WebElement priceElement = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String price = priceElement.getText();
		String prodPrice = price.replaceAll(",", "");
		Float productPrice = Float.parseFloat(prodPrice);
		System.out.println("The price of first product : " + productPrice);
		
		WebElement starElement = driver.findElement(By.xpath("(//i[contains(@class,'a-icon-star-small')]/parent::a)[1]"));
				
		
		Actions action = new Actions(driver);
		action.click(starElement).perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("a-popover-content-2"))));
		WebElement ratingElement = driver.findElement(By.xpath("//span[contains(@data-hook,'stars-rating-text')]"));
		String ratings = ratingElement.getText();
		System.out.println("The Customer ratings for first displayed product : " + ratings);
		
		String parentHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("(//div[@data-cy='title-recipe']/descendant::a)[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> winHandlesList = new ArrayList<String>(windowHandles);
		String childWinHandle = winHandlesList.get(1);
		driver.switchTo().window(childWinHandle);
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile=new File("./snaps/product.png");
		FileUtils.copyFile(srcFile, destFile);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("attach-accessory-cart-subtotal"))));
		String total = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		System.out.println(total);
	
		String totalPrice = total.replaceAll("[^0-9.]", "");
		Float totPrice = Float.parseFloat(totalPrice);
		System.out.println(totPrice);
		
		if(totPrice.compareTo(productPrice) == 0) {
			System.out.println("Total amount : " + totPrice + " displayed is precise !!");
		} else {
			System.out.println("Total amount : " + totPrice + " displayed is imprecise !!");
		}
		
		driver.quit();
	}

}
