
public class TestReferences {

	public static void main(String[] args) {
		Manager manager01 = new Manager();
		manager01.setSalary(5000);
//		Class employee became abstract. So it is impossible to create an object of this class.
//		We can have a reference of this type, but not an object.		
//		Employee employee01 = new Employee();
		Employee designer01 = new Designer();
		designer01.setSalary(2000);
		
		VideoEditor videoEditor01 = new VideoEditor();
		videoEditor01.setSalary(2500);
//		Polymorphism means that, even we have 3 different types here (employee, manager and video editor), all of them is an 
//		extension of employee. So, as the registerEmployee receives an employee as a parameter, every child of it is accepted.
		BonusControl bonusControl = new BonusControl();
		bonusControl.registerEmployee(designer01);
		bonusControl.registerEmployee(manager01);
		bonusControl.registerEmployee(videoEditor01);

		
		System.out.println(bonusControl.getTotalBonus());
	}

}
