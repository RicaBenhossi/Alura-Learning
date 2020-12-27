
public class TestEmployee {

	public static void main(String[] args) {
		Employee employee = new Employee();
		
		employee.setName("Gloria Steinem");
		employee.setSalary(3000);
		employee.setCpf("23423423419");
		
		System.out.println(employee.getName());
		System.out.println(employee.getBonification());
	}

}
