
public class TestTaxable {

	public static void main(String[] args) {
		
		CurrentAccount ac = new CurrentAccount(2222, 233323);
		ac.deposit(100);
		
		LifeEnsurance ensurance = new LifeEnsurance();

		TaxCalculator calc = new TaxCalculator();
		calc.register(ac);
		calc.register(ensurance);
		
		System.out.println(calc.getTaxTotal());
		
	}

}
