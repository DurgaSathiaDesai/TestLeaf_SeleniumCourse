package week3.day1;

public class Chrome extends Browser{

	public void openIncognito() {
		System.out.println("Open the browser in Incognito mode !!");
	}
	
	public void clearCache() {
		System.out.println("Cache cleared !!");
	}
	public static void main(String[] args) {
		
		Chrome chrome = new Chrome();
		chrome.openURL("Chrome","120.0.6099.109");
		chrome.openIncognito();
		chrome.clearCache();
		chrome.navigateBack();
		chrome.closeBrowser();
	}
}
