package week4.marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TataCliqAutomation {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.tatacliq.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		WebElement brandElement = driver.findElement(By.xpath("//div[text()='Brands']"));
		Actions action = new Actions(driver);
		action.moveToElement(brandElement).perform();

		WebElement watchElement = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		action.moveToElement(watchElement).perform();
		
		driver.findElement(By.xpath("//div[text()='Featured brands']/following-sibling::div")).click();
		
		WebElement sortElement = driver.findElement(By.xpath("//select[contains(@class,'SelectBoxDesktop')]"));
		Select indSelect = new Select(sortElement);
		
		indSelect.selectByVisibleText("New Arrivals");
		
		String parentHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[text()='Men']/preceding::div[@class='CheckBox__base']")).click();
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[text()='Men']/preceding::div[@class='CheckBox__base']"))));
		List<WebElement> priceElements = driver.findElements(By.xpath("//div[contains(@class,'priceHolder')]/h3"));
        List<Integer> priceList = new ArrayList<Integer>();
       
        
        for (WebElement priceElement : priceElements) {
        		String price = priceElement.getText();
        		String modPrice = price.replaceAll("[^0-9]", "");
                Integer mobilePrice = Integer.parseInt(modPrice);
                priceList.add(mobilePrice);
        }
        
        System.out.print("The price of Watches :");
        for(Integer price : priceList) {
        	System.out.print("\s");
        	System.out.print(price);
        }
		
 //       driver.findElement(By.xpath("//div[contains(@class,'content')]/h2")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[contains(@class,'content')]/h2")));
        
        Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> winHandlesList = new ArrayList<String>(windowHandles);
		String childWinHandle = winHandlesList.get(1);
		driver.switchTo().window(childWinHandle);
		
		String childTitle = driver.getTitle();
		System.out.print("\n");
		System.out.println("Child Window Title : " + childTitle);
		
		String prodPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText(); 
//		System.out.println(prodPrice);
	}

}
