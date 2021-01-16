
public class TestConnectionAutoCloseable {

	public static void main(String[] args) {
		
//		Now that connection class implements AutoCloseable, we don't need to be worried about closing the connection.
//		It will automatically close it self at the end. If the reference connection is null, it won't throw NPE on us.
		try (ConnectionAutoClosable connection = new ConnectionAutoClosable()) {
			connection.readData();
		} catch(IllegalStateException ex) {
			System.out.println("Connection error.");
		}
	}
	
// The code bellow is the old way we do this and its problems is explained on TestConnection.java
//	public static void main(String[] args) {
//		
//		Connection connection = null;
//		try {
//			connection = new Connection();
//			connection.readData();
//			} catch (IllegalStateException ex) {
//				System.out.println("Connection error");
//		} finally {
//			if (connection != null) {
//				connection.close();
//			}
//		}
//	}

}
