package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class SortCollection {
	
	public List<String> reverseList(List<String> orgNameList) {
		Collections.reverse(orgNameList);
		return orgNameList;
	}
	
	public List<String> reverseListWithIterator(List<String> orgNameList) {
		List<String> revOrgNameList = new ArrayList<String>();
		ListIterator<String> iterator=orgNameList.listIterator(orgNameList.size());
	       
	    while(iterator.hasPrevious()) {
	    	  revOrgNameList.add(iterator.previous().toString());
	    } 
	    return revOrgNameList;
	}
	
	public List<String> reverseListWithForLoop(List<String> orgNameList) {
		List<String> revOrgNameList = new ArrayList<String>();
		for (int i = orgNameList.size() - 1; i >= 0; i--) {
			revOrgNameList.add(orgNameList.get(i));
        }
        return revOrgNameList;
	}
	
	public void printList(List<String> orgNameList) {
		for(String orgName : orgNameList) {
			System.out.println(orgName);
		}
	}
	
	public static void main(String[] args) {
		
		SortCollection sortCollection = new SortCollection();
		String[] orgNames = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		List<String> orgNameList = Arrays.asList(orgNames);
		
		System.out.println("Before Reversing : ");
		sortCollection.printList(orgNameList);
		
		Collections.sort(orgNameList);
		
		List<String> revOrgNameList = sortCollection.reverseListWithIterator(orgNameList);
		System.out.println("\n");
		System.out.println("After Reversing with List Iterator : ");		
		sortCollection.printList(revOrgNameList);
		
		List<String> revOrgList = sortCollection.reverseListWithForLoop(orgNameList);
		System.out.println("\n");
		System.out.println("After Reversing with For Loop : ");	
		sortCollection.printList(revOrgList);
		
		List<String> revNameList = sortCollection.reverseList(orgNameList);
		System.out.println("\n");
		System.out.println("After Reversing with InBuilt Reverse() method : ");	
		sortCollection.printList(revNameList);
	}
}
