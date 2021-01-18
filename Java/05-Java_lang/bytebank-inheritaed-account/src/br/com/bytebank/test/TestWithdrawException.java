package br.com.bytebank.test;

import br.com.bytebank.model.CurrentAccount;
import br.com.bytebank.model.InsufficientFundsCheckedException;
import br.com.bytebank.model.InsufficientFundsUncheckedException;

public class TestWithdrawException {

	public static void main(String[] args) {
		CurrentAccount currentAccount = new CurrentAccount(1123, 223321);
		System.out.println("Testing InsufficientFundsUncheckedException");
		try {
			System.out.println("1 - " + currentAccount.getBalance());
			currentAccount.deposit(200);
			System.out.println("2 - " + currentAccount.getBalance());
			currentAccount.withdraw(100);
			System.out.println("3 - " + currentAccount.getBalance());
			currentAccount.withdraw(200);
			System.out.println("4 - " + currentAccount.getBalance());
		} catch (InsufficientFundsUncheckedException e) {
			System.out.println("Operation Unchecked aborted! \n" + e.getMessage());
		}
		
		System.out.println("Your current balance is: " + currentAccount.getBalance());
		
		System.out.println("Testing InsufficientFundsCheckedException");
		CurrentAccount currentAccount2 = new CurrentAccount(1123, 221122);
		try {
			System.out.println("1 - " + currentAccount2.getBalance());
			currentAccount2.deposit(100);
			System.out.println("2 - " + currentAccount2.getBalance());
			currentAccount2.withdrawChecked(90);
			System.out.println("3 - " + currentAccount2.getBalance());
			currentAccount2.withdrawChecked(90);
			System.out.println("4 - " + currentAccount2.getBalance());
		} catch (InsufficientFundsCheckedException e) {
			System.out.println("Operation Checked aborted.\n" + e.getMessage());
		}
		
	}

}
