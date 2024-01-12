package week5.day2.javachallenge;

public class FindMaxNumberOfWords {

	public static void main(String[] args) {
		
//		String[] sentences = {"alice and bob love leetcode","i think so too","this is great thanks very much"};
		String[] sentences = {"please wait","continue to fight","continue to win"};
		
		int size = sentences.length;
		int count = 0;
		int maxCount = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < size; i++) {
			String sentence = sentences[i];
			String[] words = sentence.split("\\s");
			count = words.length;
			if(count > maxCount) {
				maxCount = count;
			}
		}

		System.out.println(maxCount);
	}

}
