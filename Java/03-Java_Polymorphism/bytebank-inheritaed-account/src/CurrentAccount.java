
public class CurrentAccount extends BankAccount implements Taxable{

//	When you extends, you desn't heir the constructor. As the class BankAccount has a specific constructor and doesn'thave the default,
//	we have to create the constructor of this class and then, access the super constructor.  
	public CurrentAccount(int agency, int accountNumber) {
		super(agency, accountNumber);
	}
	
//	Here we build an specific method withdraw for this class. @Override means that here, we will rewrite about the super method.
//	The signature, return type, arguments must be the same as the super method.
//	Without the notation, the compiler will think that it is another method, without relation to the super method.
	@Override
	public boolean withdraw(double value) {
		double valueToWithdraw = value + 0.2;
		return super.withdraw(valueToWithdraw);
	}

	@Override
	public void deposit(double value) {
		super.balance += value;
		
	}

	@Override
	public double getTaxValue() {
		return super.balance * 0.01;
	}
	
	
}
