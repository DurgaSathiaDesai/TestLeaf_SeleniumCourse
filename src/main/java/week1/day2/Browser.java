package week1.day2;

public class Browser {

	String launchBrowser(String browserName) {
		
		System.out.println("Browser launched successfully");
		return browserName;
	}
	
	void loadUrl() {
		
		System.out.println("Application url loaded successfully");
	}
	
	public static void main(String[] args) {
		
		Browser browser = new Browser();
		String name = browser.launchBrowser("Chrome");
		System.out.println("Brower Name :" + name);
		browser.loadUrl();	
	}

}
