package week3.day2HW;

public class APIClient {
	
	public void sendRequest(String endpoint) {
		System.out.println(endpoint);
	}
	
	public void sendRequest(String endpoint,String requestBody, String requestStatus) {
		System.out.println(endpoint + requestBody + requestStatus);
	}
	
	public static void main(String[] args) {
		
		APIClient obj = new APIClient();
		obj.sendRequest("Program has many subpoints");
		obj.sendRequest("Roja ", "Pooja ", "Nitin");
	}

}
