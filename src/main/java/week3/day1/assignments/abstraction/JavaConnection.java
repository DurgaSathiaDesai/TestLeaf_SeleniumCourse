package week3.day1.assignments.abstraction;

public class JavaConnection extends MySqlConnection{

	public void connect() {
		System.out.println("Database connected !!");
	}

	public void disconnect() {
		System.out.println("Database disconnected !!");
	}

	public void executeUpdate() {
		System.out.println("Updation done !!");
	}

	public static void main(String[] args) {
		
		JavaConnection javaConn = new JavaConnection();
		javaConn.connect();
		javaConn.executeQuery();
		javaConn.executeUpdate();
		javaConn.disconnect();
		System.out.println("\n");
		
		DatabaseConnection dbConnection = new JavaConnection();
		dbConnection.connect();
		dbConnection.executeUpdate();
		dbConnection.disconnect();

	}
}
