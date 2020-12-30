// An Interface is an abstract class with all its method abstracts
// There s nothing concrete in an interface...

// Contract Authenticable 
	// Who sing this contract NEEDS to implement:
		// setPassword method
		// authenticate method
public abstract interface Authenticable {
	
//	The great advantage of using interfaces is that it is super generic an we can use it as a type for variables, objects and parameters
	
	public abstract void setPassword(int password);
	
	public abstract boolean authenticated(int password);

}
