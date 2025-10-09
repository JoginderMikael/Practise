package bankAccountSystem;

class CurrentAcount extends BankAccount {

	private double minimumBalance;
	
	CurrentAcount(String accountHolderName, double startingBalance) {
		super(accountHolderName, startingBalance);
		this.minimumBalance = 500;
	}
	

	@Override
	void withdraw(double amount) {
		if (this.balance < this.minimumBalance) {
			IO.println("----------------------------------------------------------------");
            System.out.println("ERROR: Minimum withdrawal amount for Current Account is $500.");
            System.out.printf("Your current account balance is :$%-10.2f\n", this.balance);
            IO.println("----------------------------------------------------------------");
        } else {
            super.withdraw(amount); 
        }
	}
}
