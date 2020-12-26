
public class BankAccount {
//	double balance;
//	The attributes of a class should be PRIVATE. So, it can not be accessed or changed outside the class that it belongs to.
//	If another class have to access it, it should do trough a method (getters and setters)
//	It calls ENCAPSULATION
	private double balance;
	private int accountNumber;
	private int agency;
	private Client holder;
	
	public void deposit(double value) {
//		Keyword THIS is to make explicit that the attribute BALANCE we are working is referenced 
//		to the same object that is calling the method.  
		this.balance += value;
	}
	
	public boolean withdraw(double value) {
		if (this.balance >= value) {			
			this.balance -= value;
			return true; 
		}
		
		return false; 
	}
	
//	RETURN ends the execution of the method. Every instruction after RETURN won't be executed.
	public boolean transfer(double value, BankAccount destinyAccount) {
		boolean canTransfer = this.withdraw(value);
		if (canTransfer) {
			destinyAccount.deposit(value);
		}
			
		return canTransfer;
	}
//	There is no need to have a SET for balance because it will only be changed throughout the methods WITHDRAW, TRANSFER and DEPOSIT.
	public double getBalance() {
		return this.balance;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAgency(int agency) {
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
}
