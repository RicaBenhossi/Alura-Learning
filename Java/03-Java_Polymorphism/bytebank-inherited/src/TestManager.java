
public class TestManager {

	public static void main(String[] args) {
		Manager manager01 = new Manager();
		
		manager01.setName("Mariele Franco");
		manager01.setCpf("12312312323");
		manager01.setSalary(5000);
		
		System.out.println(manager01.getName());
		System.out.println(manager01.getCpf());
		System.out.println(manager01.getSalary());
		
		manager01.setPassword(222);
		boolean authenticated = manager01.authenticate(222);
		System.out.println(authenticated);
		
	}

}
