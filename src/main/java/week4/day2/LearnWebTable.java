package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebTable {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://leafground.com/table.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Table location
		WebElement tableElement = driver.findElement(By.xpath("//span[text()='Customer Analytics Table']/following::table[2]/tbody"));
		
		List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
		
		int rowCount = rows.size();
		System.out.println("Number of rows : " + rowCount);
		
		List<WebElement> columns = driver.findElements(By.xpath("//span[text()='Customer Analytics Table']/following::table[2]//th"));
	
		
		int colCount = columns.size();
		System.out.println("Number of columns : " + colCount);
		
		String country = driver.findElement(By.xpath("//span[text()='Customer Analytics Table']/following::table[2]/tbody/tr[3]/td[2]")).getText();
		
		System.out.println("The country in 3rd row and 2nd column : " + country);
		
		List<WebElement> secRows = driver.findElements(By.xpath("//span[text()='Customer Analytics Table']/following::table[2]/tbody/tr[2]"));
		
		for(WebElement element : secRows) {
			System.out.println(element.getText());
			
		}
		
		List<WebElement> columnElements = driver.findElements(By.xpath("//span[text()='Customer Analytics Table']/following::table[2]/tbody/tr/td[3]"));
		for(WebElement element : columnElements) {
			System.out.println(element.getText());
			
		}
		
		System.out.println(" All Data in Table");
		System.out.println("-------------------");
		List<WebElement> allDatas = driver.findElements(By.xpath("//span[text()='Customer Analytics Table']/following::table[2]/tbody/tr/td"));
		for(WebElement element : allDatas) {
			System.out.println(element.getText());
			
		}
		System.out.println("-------------------");

		
		//Dynamically changing WebTable
		for(int i = 1; i <= rowCount; i++) {
			WebElement row = driver.findElement(By.xpath("//span[text()='Customer Analytics Table']/following::table[2]/tbody/tr[" + i + "]"));
			for(int j = 1; j <= colCount; j++) {
				WebElement allDataElement = row.findElement(By.xpath("//span[text()='Customer Analytics Table']/following::table[2]/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.println(allDataElement.getText());
			}
		}

	}

}
