package week3.day1;

public class Safari extends Browser{

	public void readerMode() {
		System.out.println("Switched to Reader Mode !!");
	}
	
	public void fullScreenMode() {
		System.out.println("Switched to Full Screen Mode !!");
	}
	
	public static void main(String[] args) {
		
		Safari safari = new Safari();
		safari.openURL("Safari","17.1");
		safari.fullScreenMode();
		safari.navigateBack();
		safari.readerMode();
		safari.closeBrowser();
	}

}
