
public class BankAccount {
	private double balance;
	private int accountNumber;
	private int agency;
	private Client holder;
	private static int totalAccounts = 0;
	
	public BankAccount(int agency, int accountNumber) {
		BankAccount.totalAccounts++; 
		this.accountNumber = accountNumber;
		this.agency = agency;
		
		System.out.println("Creating an account.");
	}

	public void deposit(double value) {
		this.balance += value;
	}
	
	public boolean withdraw(double value) {
		if (this.balance >= value) {			
			this.balance -= value;
			return true; 
		}
		
		return false; 
	}
	
		public boolean transfer(double value, BankAccount destinyAccount) {
		boolean canTransfer = this.withdraw(value);
		if (canTransfer) {
			destinyAccount.deposit(value);
		}
			
		return canTransfer;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void setAccountNumber(int accountNumber) {
		if (accountNumber <= 0) {
			System.out.println("The Account Number msut be higher than 0.");
			return;
		}
		this.accountNumber = accountNumber;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAgency(int agency) {
		if (agency <= 0) {
			System.out.println("The Agency msut be higher than 0.");
			return;
		}
		this.agency = agency;
	}
	
	public int getAgency() {
		return this.agency;
	}

	public Client getHolder() {
		return this.holder;
	}

	public void setHolder(Client holder) {
		this.holder = holder;
	}
	

	public static int getTotalAccounts() {
		return totalAccounts;
	}
}
