//The class Employee is a concept, a "mold" to build another classes. 
//You should have a Manager, a Video Editor, a Coder, not just a Employee... Is too generic.
//When you set a class as ABSTRACT, you can't perform NEW using this class. 
//public class Employee {
public abstract class Employee {
	
	private String name;
	private String cpf;
//	Visibilities:
//	Private means that only instances of this class can change/sees this attribute.
//	Public means that everyone can change/sees this attribute directly.
//  Protected. It does the same as PRIVATE, but allows classes that extends from this class to use it.
//	protected double salary;
	
//	Although PROTECTED make this attribute visible on the heirs, is recommended that we keep the attribute as PRIVATE.
//	if the heir needs to access these attribute, use the method GET with SUPER.
	private double salary; 
	 
//	public double getBonus() {
//		return this.salary * 0.05;
//	}
//	When we set a method as abstract, it force the children of the class to implements this method. 
	public abstract double getBonus();
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalary() {
		return this.salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	
}
