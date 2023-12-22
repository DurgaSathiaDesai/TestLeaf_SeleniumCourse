package week2.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonInteractions {

	public static void main(String[] args) {
		
		boolean isSelected;
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		System.out.println("\n");
		System.out.println("Test Results");
		System.out.println("------------");
		
		driver.findElement(By.xpath("//label[text()='Chrome']/preceding-sibling::div/div[2]")).click();
		
		driver.findElement(By.xpath("//label[text()='Hyderabad']/preceding-sibling::div/div[2]")).click();
		
		isSelected = driver.findElement(By.xpath("//input[@value='Hyderabad']")).isSelected();
		if(isSelected) {
			System.out.println("Unselectable radio button is selected on click");
		}
		
		driver.findElement(By.xpath("//label[text()='Hyderabad']/preceding-sibling::div/div[2]")).click();
		
		isSelected = driver.findElement(By.xpath("//input[@value='Hyderabad']")).isSelected();
		if(!isSelected) {
			System.out.println("Unselectable radio button is unselected on click");
		}
		
		List<WebElement> radio_options = driver.findElements(By.xpath("//input[contains(@id,'console2')]"));
		for(WebElement option:radio_options)
        {
            if(option.isSelected())
            {
            	String selectedOption = option.getAttribute("value");
               
                String path = "(//input[@value='" + selectedOption + "']/ancestor::div)/following-sibling::label";
                String selectedValue = driver.findElement(By.xpath(path)).getText();
                System.out.println("Default select radiobutton : " + selectedValue);
                break;
            }
        }
		
//		String isChecked = driver.findElement(By.xpath("//input[@value='21-40 Years']")).getAttribute("checked");
		boolean isChecked = driver.findElement(By.xpath("//input[@value='21-40 Years']")).isSelected();
		if(isChecked) {
			System.out.println("Age group (21-40 Years) is already selected");
		}
		
		
	}
}
