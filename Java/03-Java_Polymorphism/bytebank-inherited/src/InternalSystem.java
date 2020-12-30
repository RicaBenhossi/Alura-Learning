
public class InternalSystem {
	private int password = 2222;
	
// Here we receive a Authenticable as a parameters. That means that every class that implements Authenticable, 
//	can be passed to this method as a parameter.
	public void authenticate(Authenticable authEmployee) {
		if (authEmployee.authenticated(this.password)) {
			System.out.println("You can login the Internal System.");
		} else {
			System.out.println("You can not enter the Intenrla System.");
		}
	}
}
