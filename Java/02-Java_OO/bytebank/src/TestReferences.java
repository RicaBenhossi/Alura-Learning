

public class TestReferences {

	public static void main(String[] args) {
		BankAccount firstAccount = new BankAccount();
		firstAccount.balance = 300;
		
		System.out.println("FirstAccount balance: " + firstAccount.balance);
		
		BankAccount secondAccount = firstAccount;
		System.out.println("SecondAccount balance: " + secondAccount.balance);
		
		secondAccount.balance = 300;
		System.out.println("FirstAccount balance: " + firstAccount.balance);
		System.out.println("SecondAccount balance: " + secondAccount.balance);
		
//		As we attribute the firstAccount into the secondAccount, java does not "copy" the object that firstAccount is pointing to 
//		to the secondAccount. It just copy the reference to that object, So, these 2 variables are pointing to the same object
//		and they will store the same memory address.
		if (firstAccount == secondAccount) {
			System.out.println("They are the same.");
		} else {
			System.out.println("They are not the same.");
		}
		
		System.out.println(firstAccount);
		System.out.println(secondAccount);
	}

}
