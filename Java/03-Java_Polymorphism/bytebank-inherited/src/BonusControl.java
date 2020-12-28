
public class BonusControl {

	private double totalBonus;
	
//	All employee has its own getBonus method. Here its assume always the most specific type
//	If it receives a manager, it will use the getBonus method of Manager. 
	public void registerEmployee(Employee employee) {
		
		totalBonus += employee.getBonus();
	}

	public double getTotalBonus() {
		return this.totalBonus;
	}
	
	
}
