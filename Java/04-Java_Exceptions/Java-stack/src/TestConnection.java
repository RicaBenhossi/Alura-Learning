
public class TestConnection {

	public static void main(String[] args) {
		
		Connection connection = null;
//		Every try MUST have, at least, 1 finally OR 1 or more catch.
		try {
			connection = new Connection();
			connection.readData();
			} catch (IllegalStateException ex) {
				System.out.println("Connection error");
		} finally {
//			The problem here is: if there is an error while opening the connection, the variable connection will be still null.
//			Then we will get an Null Point Exception Error when try to close it.
//			So we have to check if the variable is not null before closing it. BAD SMELL CODE.
//			A solution to this is on the class ConnectionAutoCloseable and TestConnectionAutoCloseable
			if (connection != null) {
				connection.close();
			}
		}
	}

}
