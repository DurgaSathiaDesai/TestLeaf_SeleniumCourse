package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomateActions {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Use & Sale')]"));
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
		String text = element.getText();
		System.out.println("The Text Displayed : " + text);
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File destFile=new File("D://screenshot.png");
		File destFile=new File("./snaps/screenshot.png");

        try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
