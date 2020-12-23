
public class TestBank {

	public static void main(String[] args) {
		Client frida = new Client();
		frida.name = "Frida Khalo";
		frida.cpf = "222.222.222-22";
		frida.profession = "Artist";
		
		BankAccount fridaAccount = new BankAccount();
		fridaAccount.deposit(100);
		
		fridaAccount.holder = frida;
		System.out.println(fridaAccount.holder.name);
//		this both references the same object Client. So the memory address will be the same.
		System.out.println(fridaAccount.holder);
		System.out.println(frida);
		System.out.println(fridaAccount);

	}

}
