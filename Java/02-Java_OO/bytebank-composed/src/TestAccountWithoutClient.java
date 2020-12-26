
public class TestAccountWithoutClient {

	public static void main(String[] args) {
		BankAccount ameliaAccount = new BankAccount();
//		System.out.println(ameliaAccount.balance);
		System.out.println(ameliaAccount.getBalance());
		
//		create a new object client to be referenced o ameliaAccount;		
		ameliaAccount.holder = new Client();
		System.out.println(ameliaAccount.holder);
		
		ameliaAccount.holder.name = "Amelia Erhart";
		System.out.println(ameliaAccount.holder.name);
	}

}
