package week3.day1;

public class Browser {

	private String browserName;
	private String browserVersion;
	
	public void openURL(String name,String version) {
		this.browserName = name;
		this.browserVersion = version;
		System.out.println("Open the URL in " + browserName + " browser of version " + browserVersion + " !!");
	}
	
	public void closeBrowser() {
		System.out.println("Close the " + browserName + " browser!!");
	}
	
	public void navigateBack() {
		System.out.println("Navigated Back !!");
	}
}
