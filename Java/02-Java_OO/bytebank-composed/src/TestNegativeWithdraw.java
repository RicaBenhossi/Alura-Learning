
public class TestNegativeWithdraw {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		account.deposit(100);
//		When use the withdraw method we couldn't make the balance be negative because the method withdraw has a treatment
//		to avoid this behavior.
		System.out.println(account.withdraw(101));
		account.withdraw(101);
		
//		BUT we can make the balance be negative accessing it directly like bellow. So we can deceive the validation.  
//		account.balance -= 101;
		
//		System.out.println(account.balance);
		System.out.println(account.getBalance());
	}

}
