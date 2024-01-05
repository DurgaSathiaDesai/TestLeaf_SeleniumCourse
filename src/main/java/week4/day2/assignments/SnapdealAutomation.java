package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapdealAutomation {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		WebElement menFashionElement = driver.findElement(By.xpath("//span[contains(text(),'Men') and contains(text(),'Fashion')]/parent::a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(menFashionElement).perform();
		
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		String shoeCount = driver.findElement(By.xpath("//h1[contains(text(),'Sports Shoes for Men')]/following-sibling::span")).getText();
		
		String sportsShoeCount = shoeCount.replaceAll("[^0-9]", "");
		System.out.println("The count of Sports shoes : " + sportsShoeCount);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']/parent::a")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Sort by')]/parent::div")).click();
		
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		List<WebElement> priceElements = driver.findElements(By.xpath("//span[contains(@id,'display-price')]"));
		
		List<Integer> priceList = new ArrayList<Integer>();
        
        for (WebElement priceElement : priceElements) {
            String price = priceElement.getText();
            String modPrice = price.replaceAll("[^0-9]", "");
            Integer mobilePrice = Integer.parseInt(modPrice);
            priceList.add(mobilePrice);
        }
        
//        for(Integer price : priceList) {
//        	System.out.println(price);
//        }
        List<Integer> tmp = new ArrayList<Integer>(priceList);
//        System.out.println("-------------------------");
//        for(Integer price : tmp) {
//        	System.out.println(price);
//        }
        Collections.sort(tmp);
        boolean sorted = tmp.equals(priceList);
        
//        System.out.println(sorted);
        
        if(sorted) {
        	System.out.println("The displayed are sorted correctly from low price to high price !!");
        } else {
        	System.out.println("Sorting not done properly !!");
        }
        
        driver.findElement(By.name("fromVal")).clear();
        driver.findElement(By.name("fromVal")).sendKeys("500");
        driver.findElement(By.name("toVal")).clear();
        driver.findElement(By.name("toVal")).sendKeys("700");
        driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
        
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[contains(text(),'White & Blue')]")));

        String fromPrice = driver.findElement(By.xpath("//div[@class='clear']/span[@class='from-price-text']")).getText();
        String modFromPrice = fromPrice.replaceAll("[^0-9]", "");
        
        String toPrice = driver.findElement(By.xpath("//div[@class='clear']/span[@class='to-price-text']")).getText();
        String modToPrice = toPrice.replaceAll("[^0-9]", "");

        if((modFromPrice.equals("500"))&&(modToPrice.equals("700"))) {
        	System.out.println("Price range filter is selected correctly !!");
        }
        
        String colorCheck = driver.findElement(By.xpath("//input[contains(@id,'Color_s-White') and contains(@id,'Blue')]")).getAttribute("checked");
        if(colorCheck.equals("true")) {
        	System.out.println("Color is selected correctly !!");
        }
        
        WebElement gridElement = driver.findElement(By.xpath("(//picture[@class='picture-elem'])[1]/img"));
        Actions newAction = new Actions(driver);
        newAction.moveToElement(gridElement).perform();
        
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")));
        
        String prodPrice = driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::span[@class='payBlkBig']")).getText(); 
        System.out.println("The cost of the shoe : Rs." + prodPrice);
        
        String prodDiscount = driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::span[@class='percent-desc ']")).getText();
        System.out.println("The discount for the shoe : " + prodDiscount);
        
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile=new File("./snaps/shoes.png");
		FileUtils.copyFile(srcFile, destFile);
        //      priceList.stream().sorted().collect(Collectors.toList()).equals(priceList);
	}

}
