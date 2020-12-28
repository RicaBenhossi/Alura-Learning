
public class TestReferences {

	public static void main(String[] args) {
		Manager manager01 = new Manager();
		manager01.setSalary(5000);
		
		Employee employee01 = new Employee();
		employee01.setSalary(2000);
		
		VideoEditor videoEditor01 = new VideoEditor();
		videoEditor01.setSalary(2500);
//		Polymorphism means that, even we have 3 different types here (employee, manager and video editor), all of them is an 
//		extension of employee. So, as the registerEmployee receives an employee as a parameter, every child of it is accepted.
		BonusControl bonusControl = new BonusControl();
		bonusControl.registerEmployee(employee01);
		bonusControl.registerEmployee(manager01);
		bonusControl.registerEmployee(videoEditor01);

		
		System.out.println(bonusControl.getTotalBonus());
	}

}
