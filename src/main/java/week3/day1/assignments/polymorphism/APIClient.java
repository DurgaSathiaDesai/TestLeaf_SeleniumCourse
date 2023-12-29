package week3.day1.assignments.polymorphism;

public class APIClient {

	public void sendRequest(String endpoint) {
		System.out.println("Send request to endpoint " + endpoint);
	}
	
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("Send request to endpoint " + endpoint + " with RequestBody : " + requestBody);
		if(requestStatus) {
			System.out.println("Request to endpoint " + endpoint + " is sent successfully !!");
		} else {
			System.out.println("Error in sending the request to endpoint " + endpoint);
		}
	}
	
	public static void main(String[] args) {
		APIClient apiClient = new APIClient();
		apiClient.sendRequest("https://api.example.com");
		apiClient.sendRequest("https://api.example.com/users/123", "Method Overloading Demo", true);
	}
}
