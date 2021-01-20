package br.com.bytebank.model;

public class SavingAccount extends BankAccount {

	public SavingAccount(int agency, int accountNumber) {
		super(agency, accountNumber);
	}

	@Override
	public void deposit(double value) {
		super.balance += value;
	}
	
//	toString was override here and in the mother class (BanAccount)
	@Override
	public String toString() {
		return "Saving Account" + super.toString();
	}
}
