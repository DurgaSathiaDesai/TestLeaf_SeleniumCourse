package week4.javachallenge;

public class FindDuplicatesWithIndices {

	public static void main(String[] args) {
		// contains nearby Duplicates
		int[] numArray = {1,2,3,1,2,3};
		int k = 2;
		int size = numArray.length;
		boolean found = false;
		
		for(int i=0;i<size;i++) {
			for(int j=i+1; j<size && j<=i+k; j++) {
				if((numArray[i]==numArray[j])) { 
					System.out.println("true");
		            found = true;
		        }
		    }
		 }
		 if(!found) {
			 System.out.println("false");
		 }
	}

}
