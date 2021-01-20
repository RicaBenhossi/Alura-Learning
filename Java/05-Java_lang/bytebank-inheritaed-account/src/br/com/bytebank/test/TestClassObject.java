package br.com.bytebank.test;

import br.com.bytebank.model.BankAccount;
import br.com.bytebank.model.CurrentAccount;
import br.com.bytebank.model.SavingAccount;

public class TestClassObject {

	public static void main(String[] args) {

		CurrentAccount currentAccount1 = new CurrentAccount(1234, 223344);
		BankAccount currentAccount2 = new CurrentAccount(1234, 998877);
		int testInt = 3;
		double testDouble = 5.99;
		boolean testBool= true; 
		String testStr = "Test String";
		Object currentAccount3 = new SavingAccount(1234, 5567772);
		
//		Every method println should have an overload to the right parameter type. But we can set a personal type.
//		How System.out.PRINTLN works for any type?
		println(testStr);
		println(testInt);
		println(testDouble);
		println(testBool);
		println(currentAccount1);
		println(currentAccount2);
		println(currentAccount3);
		
//		toString is a method of class OBJECT.
//		System.out.println(currentAccount1.toString());
//		System.out.println(currentAccount2.toString());
//		System.out.println(currentAccount3.toString());
		System.out.println(currentAccount1);
		System.out.println(currentAccount2);
		System.out.println(currentAccount3);
		
	}
	
//	static void println(String value) {};
//	static void println(int value) {};
//	static void println(double value) {};
//	static void println(boolean value) {};
//	static void println(BankAccount value) {};
	
//	All types and classes extends by default from OBJECT.
//	So, using polymorphism here, we can receive any reference type. See that it compile without warnings.
//	OBJECT is the most generic type reference we can have.
	static void println(Object value) {}

}
