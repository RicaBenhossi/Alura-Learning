// Now the class auto close it self. If the reference is null, close method won't be called
public class ConnectionAutoClosable implements AutoCloseable{
	
	public ConnectionAutoClosable() {
		System.out.println("Openning connection.");
//		throw new IllegalStateException();
	}
	
	public void readData() {
		System.out.println("Receiving data");
		throw new IllegalStateException();
	}
	
//	public void close() {
//		System.out.println("Closing connection");
//	}
	
	@Override
	public void close() {
		System.out.println("Closing connection");
	}
}
