package week4.day2;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Sample {

	public static void main(String[] args) {
		
		String text = "Selenium WebDriver";
		char letter = 'e';
		int count = 0;
		char[] textArray = text.toCharArray();
		
		for(int i = 0; i < textArray.length; i++) {
			if(Character.compare(textArray[i], letter) == 0) {
				count++;
			}
		}
		System.out.println("Number of occurences of char" + letter + " in text " + text + " : " + count);
		
		String name = "RACECARE";
		char[] nameArray = name.toCharArray();
		String reversed = "";
		for(int i = nameArray.length - 1; i >= 0; i--) {
			reversed = reversed + nameArray[i];
		}
		
		if(name.equals(reversed)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		 
	}
}
