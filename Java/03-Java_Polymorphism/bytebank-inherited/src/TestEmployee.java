
public class TestEmployee {

	public static void main(String[] args) {
//		Class employee became abstract. So it is impossible to create an object of this class.
//		We can have a reference of this type, but not an object. 
//		Employee employee = new Employee();
		Manager employee = new Manager();
		
		employee.setName("Gloria Steinem");
		employee.setSalary(3000);
		employee.setCpf("23423423419");
		
		System.out.println(employee.getName());
		System.out.println(employee.getBonus());
	}

}
