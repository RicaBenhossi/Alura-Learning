

public class BankAccount {
	double balance;
	int accountNumber;
	int agency;
	Client holder;
	
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
}
