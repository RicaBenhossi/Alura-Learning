// To set heritage  use the word 'extends'. It means that the class  MANAGER will extend the class Employee
public class Manager extends Employee{
	
	private int password;
	
	
	public boolean authenticate(int password) {
		if (this.password != password) {
			return false;
		}
		return true;
	}
	
	public void setPassword(int password) {
		this.password = password;
	}
	
//	public double getBonification() {
//		return this.salary;
//	}
	
}
