package week3.day1.assignments.inheritance;

public class WebElement {

	private String webElementText;
	public void click() {
		System.out.println("Element is clicked !!");
	}
	
	public void setText(String text) {
		this.webElementText = text;
		System.out.println("Inner Text '" + this.webElementText + "' for the element is set !!");
	}
}
 