
public class TestGetttersAndSetters {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
//		account.number = 1337
		account.setAccountNumber(1337);
		System.out.println(account.getAccountNumber());
		
		Client ruth = new Client();
//		ruth.name = "Notorious Ruth"
		ruth.setName("Notorious Ruth");
		
		account.setHolder(ruth);
		System.out.println(account.getHolder());
		System.out.println(account.getHolder().getName());
		
		account.getHolder().setName("Ruth Bader-Ginsburg");
		System.out.println(account.getHolder().getName());
		account.getHolder().setProfession("Judge");

	}

}
