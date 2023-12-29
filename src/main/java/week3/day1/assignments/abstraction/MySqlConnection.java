package week3.day1.assignments.abstraction;

public abstract class MySqlConnection implements DatabaseConnection {

	public void executeQuery() {
		System.out.println("Query Executed !!");
	}
}
