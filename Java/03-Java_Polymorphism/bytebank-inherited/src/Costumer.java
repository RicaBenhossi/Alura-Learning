// To sign a contract (interface) we use IMPLEMENTS  instead of extends
public class Costumer implements Authenticable {

// All this code has been transfered to AuthenticationTool. This avoid duplicate code along the classes.
//	private int password; 
//	
//	@Override
//	public void setPassword(int password) {
//		this.password = password;
//	}
//	
//	@Override
//	public boolean authenticated(int password) {
//		return this.password == password;
//	}

// To use composition we instance AuthenticationTool in the constructor. It will be responsable to manage, store and validate password.
	
	private AuthenticationTool authenticator;

	public Costumer() {
		this.authenticator = new AuthenticationTool();
	}

	@Override
	public void setPassword(int password) {
		this.authenticator.setPasswod(password);
		
	}

	@Override
	public boolean authenticated(int password) {
		return this.authenticator.authenticated(password);
		

	}
	
	
	
}
