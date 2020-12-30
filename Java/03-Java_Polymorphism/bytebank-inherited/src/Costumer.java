// To sign a contract (interface) we use IMPLEMENTS  instead of extends
public class Costumer implements Authenticable {

	private int password; 
	
	@Override
	public void setPassword(int password) {
		this.password = password;
	}
	
	@Override
	public boolean authenticated(int password) {
		return this.password == password;
	}

}
