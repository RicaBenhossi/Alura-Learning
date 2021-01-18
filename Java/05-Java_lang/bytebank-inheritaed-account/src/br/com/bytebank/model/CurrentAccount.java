package br.com.bytebank.model;

public class CurrentAccount extends BankAccount implements Taxable{

	public CurrentAccount(int agency, int accountNumber) {
		super(agency, accountNumber);
	}

	@Override
	public void withdraw(double value) {
		
		double valueToWithdraw = value + 0.2;
		super.withdraw(valueToWithdraw);
	}
	
	@Override
	public void withdrawChecked(double value) throws InsufficientFundsCheckedException {
		
		double taxes = 0.2;
		super.withdrawChecked(value + taxes);
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
