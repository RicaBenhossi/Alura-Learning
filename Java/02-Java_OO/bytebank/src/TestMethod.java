
public class TestMethod {

	public static void main(String[] args) {
		BankAccount marieAccount = new BankAccount();
		
		marieAccount.balance = 100;
		System.out.println(marieAccount.balance);
		marieAccount.deposit(50);
		System.out.println(marieAccount.balance);
		
		boolean whitdrawSuccess = marieAccount.withdraw(20);
		System.out.println(marieAccount.balance);
		System.out.println(whitdrawSuccess);
		
		BankAccount adaAccount = new BankAccount();
		adaAccount.deposit(1000);
		System.out.println("Ada's account balance: " + adaAccount.balance);
		
		if (adaAccount.transfer(300, marieAccount)) {
			System.out.println("Transfer completed successfully.");
		} else {
			System.out.println("There is not enough balance.");
		}
		
		
		System.out.println("Ada's account balance: " + adaAccount.balance);
		System.out.println("Marie's account balance: " + marieAccount.balance);
	}

}
