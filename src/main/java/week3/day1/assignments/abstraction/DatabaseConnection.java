package week3.day1.assignments.abstraction;

public interface DatabaseConnection {

	public void connect();
	public void disconnect();
	public void executeUpdate();
}
