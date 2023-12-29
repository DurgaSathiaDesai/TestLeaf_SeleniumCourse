package week3.day1.assignments.singleinheritance;

public class LoginTestData extends TestData{

	public void enterUsername() {
		System.out.println("Username entered !!");
	}
	
	public void enterPassword() {
		System.out.println("Password entered !!");
	}
	public static void main(String[] args) {
		
		System.out.println("Object type : LoginTestData , Reference type : LoginTestData ");
		LoginTestData loginData = new LoginTestData();
		loginData.enterUsername();
		loginData.enterPassword();
		loginData.enterCredentials();
		loginData.navigateToHomePage();
		System.out.println("\n");
		
		System.out.println("Object type : TestData , Reference type : TestData ");
		TestData testData = new TestData();
		testData.enterCredentials();
		testData.navigateToHomePage();
		System.out.println("\n");
		
		System.out.println("Object type : LoginTestData , Reference type : TestData ");
		TestData loginTestData = new LoginTestData();
		loginTestData.enterCredentials();
		loginTestData.navigateToHomePage();
		System.out.println("\n");
	}

}
