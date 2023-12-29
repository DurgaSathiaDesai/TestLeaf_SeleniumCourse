package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindMobilePrices {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus Mobiles",Keys.ENTER);
		
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        List<String> priceList = new ArrayList<String>();
               
        for (WebElement priceElement : priceElements) {
            String price = priceElement.getText();
            priceList.add(price);
        }
        Collections.sort(priceList);
        System.out.print("Lowest price of OnePlus Mobiles : ");
        System.out.println(priceList.get(0));
	}

}
