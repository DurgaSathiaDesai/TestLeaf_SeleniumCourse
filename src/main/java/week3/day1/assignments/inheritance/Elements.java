package week3.day1.assignments.inheritance;

public class Elements extends Button{

	public static void main(String[] args) {
		
		RadioButton radioButton = new RadioButton();
		radioButton.click();
		radioButton.selectRadioButton();
		radioButton.setText("RadioButton");
		radioButton.submit();
		System.out.println("\n");
		
		CheckBoxButton chkBoxButton = new CheckBoxButton();
		chkBoxButton.click();
		chkBoxButton.clickCheckButton();
		chkBoxButton.setText("CheckBox");
		chkBoxButton.submit();
		System.out.println("\n");
		
		Elements element = new Elements();
		element.click();
		element.setText("Elements");
		element.submit();
		System.out.println("\n");
		
		Button button = new Button();
		button.click();
		button.setText("Button");
		button.submit();
		System.out.println("\n");
		
		Button rButton = new RadioButton();
		rButton.click();
		rButton.setText("RadioButton");
		rButton.submit();
		System.out.println("\n");
	}

}
