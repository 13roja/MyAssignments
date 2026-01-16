package week4.day4.HW;

public class JavaConnection implements DatabaseConnection{

	@Override
	public void connect() {
		System.out.println("connect ---from interface");
		
	}

	@Override
	public void disconnect() {
		System.out.println("disconnect ---from interface");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("executeUpdate  -----from interface");
		
	}
	
	public static void main(String[] args) {
		
		JavaConnection obj = new JavaConnection();
		obj.connect();
		obj.disconnect();
		obj.executeUpdate();
	}
}
