package week3.day1.assignments.polymorphism;

public class LoginPage extends BasePage{

	@Override
	public void performCommonTasks() {
		System.out.println("Common Tasks --> Login Page");
	}
	
	public static void main(String[] args) {
		
		LoginPage login = new LoginPage();
		login.performCommonTasks();
		
		BasePage base = new LoginPage();
		base.performCommonTasks();
	}

}
