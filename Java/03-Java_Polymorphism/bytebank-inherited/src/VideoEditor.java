// To set heritage  use the word 'extends'. It means that the class  MANAGER will extend the class Employee
// Employee is teh mother class or base class or SUPER Class
public class VideoEditor extends Employee{
	
	
	public double getBonus() {
		return super.getBonus() + 100;
	}
	
}
