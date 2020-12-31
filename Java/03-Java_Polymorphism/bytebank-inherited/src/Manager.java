// To set heritage  use the word 'extends'. It means that the class  MANAGER will extend the class Employee
// Employee is the mother class or base class or SUPER Class

// Now, manager will sing the contract (interface) Authenticable. We can implements more than one interface (implements Auth, Bonus, ...)
public class Manager extends Employee implements Authenticable{
	
//	As we extended Manager from Employee, salary can not be accessed with "this" because "this" is to Employee class
//	To use this field, we must change its visibility on the super class (Employee).
//	private int password;
	
	public double getBonus() {
//		When the attribute belongs to the super class, exchange THIS for SUPER 
//		return super.salary;
		
//		Now, the manager bonus has changed: it will receive its own salary plus the default employee bonus (defined on class Employee)
//		To do that, we access the getBonus method of the super class. So we can guarantee that, if someone 
//		changes the % of the default bonus, this method here will follow the new rules. 
//		return super.getBonus() + super.salary;
		
//		BUT, the use of super.salary is not recommended. Although "protected" is a valid visibility, is recommended that you 
//		always use the PRIVATE visibility to be sure that your attribute is safe. To access the salary attribute, use the
//		GET and SUPER
		return super.getSalary();
	}
	
	
// All this code has been transfered to AuthenticationTool. This avoid duplicate code along the classes.
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
	
	public Manager() {
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
