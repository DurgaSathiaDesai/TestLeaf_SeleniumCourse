package week3.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Child extends Parent{

	public void show() {
		System.out.println("Display from Child class");
	}
	
	public void check() {
		
	}
	public static void main(String[] args) {
		Child child = new Child();
		child.show();
		Parent p = new Parent();
		p.show();
		Parent parent = new Child();
		parent.show();
		RemoteWebDriver driver = new ChromeDriver();
		WebDriver dr = new ChromeDriver();
		ChromeDriver c = new ChromeDriver();
		
	}
	
	
}
