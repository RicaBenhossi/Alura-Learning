
public abstract class BankAccount {
//	Here is better to change the attribute balance to protected than create a setBalance to children access it to implements deposit.
//  If we create a setBalance, it could be accessed by every instance of this class. 	
//	public double balance;
	protected double balance;
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
	
	public abstract void deposit(double value);
	
	public void withdraw(double value) {
		
		if (this.balance < value) {			
			throw new InsufficientFundsUncheckedException("You have no fund to conclude this operation.\n" + "Balance: "+ this.balance + " Requested withdraw value: " + value);
		}
		
		this.balance -= value;
	
	}
	
	public void withdrawChecked(double value) throws InsufficientFundsCheckedException{
		
		if (this.balance < value) {			
			throw new InsufficientFundsCheckedException("You have no fund to conclude this operation.\n" + "Balance: "+ this.balance + " Requested withdraw value: " + value);
		}
		
		this.balance -= value;
	
	}
	
	public void transfer(double value, BankAccount destinyAccount) {
		
		this.withdraw(value);
		destinyAccount.deposit(value);
		
	}

}
