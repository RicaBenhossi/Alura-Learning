package br.com.alura.bytebank;

import br.com.bytebank.model.BankAccount;
import br.com.bytebank.model.CurrentAccount;

public class TestLibrary {

	public static void main(String[] args) {
		
		BankAccount account = new CurrentAccount(1233, 334332);
		account.deposit(200);
		System.out.println(account.getBalance());
		
	}

}
