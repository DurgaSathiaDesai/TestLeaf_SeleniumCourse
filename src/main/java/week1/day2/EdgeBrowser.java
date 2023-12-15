package week1.day2;

public class EdgeBrowser {

	public static void main(String[] args) {
		
		Browser browser = new Browser();
		
		String name = browser.launchBrowser("Firefox");
		System.out.println("Brower Name :" + name);
		browser.loadUrl();	
	}

}
