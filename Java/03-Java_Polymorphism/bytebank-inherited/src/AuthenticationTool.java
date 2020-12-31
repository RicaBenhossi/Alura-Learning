// This class is used to make COMPOSITION 
// The class that will need these methods, should instance this object in the class constructor.
public class AuthenticationTool {

	private int password;
	
	public void setPasswod(int password) {
		this.password = password;
	}
	
	public boolean authenticated(int password) {
		return this.password == password;
	}
}
