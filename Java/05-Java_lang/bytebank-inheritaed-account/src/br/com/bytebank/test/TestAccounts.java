package br.com.bytebank.test;

import br.com.bytebank.model.CurrentAccount;
import br.com.bytebank.model.SavingAccount;

public class TestAccounts {

	public static void main(String[] args) {
//		Full Qualified Name (FQN)
		CurrentAccount ca = new CurrentAccount(111, 1111);
		ca.deposit(100);
		SavingAccount sa = new SavingAccount(111, 2111);
		sa.deposit(200);
		ca.transfer(10, sa);
		
		System.out.println("ca -> " + ca.getBalance());
		System.out.println("sa -> " + sa.getBalance());
		
		
	}

}
