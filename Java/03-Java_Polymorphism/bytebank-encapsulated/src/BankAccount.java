
public class BankAccount {
//	double balance;
//	The attributes of a class should be PRIVATE. So, it can not be accessed or changed outside the class that it belongs to.
//	If another class have to access it, it should do trough a method (getters and setters)
//	It calls ENCAPSULATION
	private double balance;
	private int accountNumber;
	private int agency;
	private Client holder;
//	When we use STATIC, it means that this attribute belongs to the class it self, not the instance of the class (object).
//	When we does't use static, the attribute belongs to the object that we have instanced.
//	So the use of THIS, always refers to the INSTANCE of the class.
	private static int totalAccounts;
	
//	This is a constructor. It is a initialization routine that is responsible to build the object.
//	This bellow is the default constructor java creates when you don't have any other constructor. By default it is hide.
	public BankAccount() {
		
	}
//	When you create a new constructor, the default one bellow is not available anymore. 
//	So we can validate fields and receive data by default to build this object with certain obligated fields. 
	public BankAccount(int agency, int accountNumber) {
//		As the totalAccounts is static, we can't use this to refer to this attribute. Instead we use the class name. 
		BankAccount.totalAccounts++; 
		this.accountNumber = accountNumber;
		this.agency = agency;
		
		System.out.println("Creating an account.");
	}
//	We can have more than one constructor. 
	
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
//		As we see, the THIS makes a reference to the instantiation of a class and is not available on a static method because
//		it belong to the class and not the instances of it.
//		System.out.println(this.balance);
		return totalAccounts;
	}
}
