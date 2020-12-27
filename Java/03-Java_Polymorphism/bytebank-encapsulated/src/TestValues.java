
public class TestValues {

	public static void main(String[] args) {
//		BankAccount account = new BankAccount();
		
		
//		Here there is an inconsistency with the business rules.
//		account.setAgency(-50);
//		account.setAccountNumber(-2223);

//		Now I have a constructor that receives the agency and account number by default.
		BankAccount account1 = new BankAccount(1337, 24226);
		System.out.println(account1.getAgency());
		
		BankAccount account2 = new BankAccount(1337, 78237);
		System.out.println(account2.getAgency());
		
		BankAccount account3 = new BankAccount(2466, 14332);
		System.out.println(account3.getAgency());
		
		BankAccount account4 = new BankAccount(3567, 11235);
		System.out.println(account4.getAgency());
		
//		Here the totalAccount doesn't belongs to any one instance of the class BankAccount.
//		So we can not access it through the account1, or account2. We must access it through te CLASS NAME.
		System.out.println("The total of accounts is " + BankAccount.getTotalAccounts());	

	}

}
