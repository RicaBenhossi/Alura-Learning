
public class CreateAccount {

	public static void main(String[] args) {
		BankAccount firstAccount = new BankAccount();
		firstAccount.balance = 200;
		System.out.println(firstAccount.balance);
		
		firstAccount.balance += 100;
		System.out.println(firstAccount.balance);
		
		BankAccount secondAccount = new BankAccount();
		secondAccount.balance = 50;
	
		System.out.println("The fisrt account has " + firstAccount.balance);
		System.out.println("The second account has " + secondAccount.balance);
		
		firstAccount.agency = 146;
		System.out.println("FitstAccount agency: " + firstAccount.agency);
		System.out.println("SecondAccount account number: " + firstAccount.accountNumber);
		
		System.out.println("SecondAccount agency: " + secondAccount.agency);
		System.out.println("SecondAccount balance: " + secondAccount.balance);

		secondAccount.agency = 146;
		
		System.out.println("Now the second account is in the agency " + secondAccount.agency);
		
		
//		these variables are pointing to 2 different BankAccount objects.  
		if (firstAccount == secondAccount) {
			System.out.println("They are the same.");
		} else {
			System.out.println("They are not the same.");
		}
		
//		Here we can check that the memory address is not the same.
		System.out.println(firstAccount);
		System.out.println(secondAccount);
	}

}
