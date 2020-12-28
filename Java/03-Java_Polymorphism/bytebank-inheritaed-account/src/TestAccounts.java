
public class TestAccounts {

	public static void main(String[] args) {
//		Here we have heritage
		CurrentAccount ca = new CurrentAccount(111, 1111);
		ca.deposit(100);
//		Here we have heritage
		SavingAccount sa = new SavingAccount(111, 2111);
		sa.deposit(200);
//		Here we have polymorphism because transfer receive an object type BankAccount
		ca.transfer(10, sa);
		
		System.out.println("ca -> " + ca.getBalance());
		System.out.println("sa -> " + sa.getBalance());
		
		
	}

}
