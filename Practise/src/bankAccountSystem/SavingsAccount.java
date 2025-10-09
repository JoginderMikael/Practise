package bankAccountSystem;

class SavingsAccount extends BankAccount implements InterestBearing{
	
	private double interestRate;
	private double minimumBalance;

	SavingsAccount(String accountHolderName, double balance) {
		super(accountHolderName, balance);
		this.interestRate = 0.05;
		this.minimumBalance = 500;
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyInterest() {
			this.balance += (this.interestRate * this.balance);
			System.out.printf("Savings Account balance: $%-10.2f\n",this.balance);
		
	}
	
	@Override
	void withdraw(double amount) {
		if (this.balance < this.minimumBalance) {
            System.out.println("ERROR: Minimum withdrawal amount for Savings Account is $500.");
            System.out.printf("Your current account balance is :$%-10.2f", this.balance);
        } else {
            super.withdraw(amount); 
        }
	}

}
