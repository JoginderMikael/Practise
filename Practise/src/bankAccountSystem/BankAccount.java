package bankAccountSystem;

class BankAccount {
	
	protected double balance;
	protected int accountNumber;
	protected String accountHolderName;
	static int nextAccountNumber = 1000;
	
	
	BankAccount(String accountHolderName, double startingBalance){
		this.accountHolderName = accountHolderName;
		this.balance = startingBalance;
		this.accountNumber = nextAccountNumber++;
	}
	
	
	void deposit(double amount) {
		
		if (amount <= 0) {
			System.out.println("Amount is not valid");
		}else {
			this.balance += amount;
			System.out.println("Deposit of " + amount + " sucessful.");
			System.out.println("Your balance now is $" + (this.balance));
		}
		
	}
	
	void withdraw(double amount) {
		if(this.balance < amount) {
			System.out.println("INSUFFICIENT FUNDS IN YOUR ACCOUNT.");
		}else {
			this.balance -= amount;
			System.out.println("You have sucessfully withdrawn $" + amount + " from your account.");
			System.out.println("Your balance now is $" + (this.balance));
		}
		
	}
	
	void displayDetails() {
		System.out.println("*******************************");
		System.out.printf("ACCOUNT DETAILS\n");
		System.out.printf("Account Holder: %-10s\n", this.accountHolderName);
		System.out.printf("Account Number: %-10d\n", this.accountNumber);
		System.out.printf("Account Balance: $%-10.2f\n", this.balance);
		System.out.println("*******************************");
		
	}
	
	
	double getBalance() {
		return this.balance;
	}
	

}
