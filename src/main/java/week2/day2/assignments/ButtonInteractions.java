package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonInteractions {

	public static void main(String[] args) {
		
		String expectedPageTitle = "Dashboard";
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		System.out.println("\n");
		System.out.println("Test Results");
		System.out.println("------------");
		
		driver.findElement(By.xpath("//span[text()='Click']/parent::button")).click();
		
		String actualPageTitle = driver.getTitle();

		if(actualPageTitle.equals(expectedPageTitle)) {
			System.out.println("On click, successfully navigated to Page with title : " + actualPageTitle);
		} else {
			System.out.println("On click, navigated to Page with title :" + actualPageTitle);
		}	
		
		driver.navigate().back();	
		
		boolean isButtonDisabled = driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']/following-sibling::button")).isEnabled();
		if(isButtonDisabled == false) {
			System.out.println("Button with text 'Disabled' is disabled!!");
		} else {
			System.out.println("Button with text 'Disabled' is enabled!!");
		}
		
		Point point = driver.findElement(By.xpath("//h5[text()='Find the position of the Submit button']/following-sibling::button")).getLocation();
		System.out.println("Submit button is located in ");
		System.out.println("x location: " + point.getX());
        System.out.println("y location: " + point.getY());
        
        String bgColor = driver.findElement(By.xpath("//span[text()='Save']/parent::button")).getCssValue("background-color");
        System.out.println("The background-color of Save button : " + bgColor);
        
        Dimension size = driver.findElement(By.xpath("//h5[contains(text(),'height and width of this button')]/following-sibling::button")).getSize();
        int width = size.getWidth();
        int height = size.getHeight();
        
        System.out.print("The Dimensions of Submit button - ");
        System.out.print("Width : " + width + " , ");
        System.out.print("Height : " + height);
        
        driver.close();
	}
}
