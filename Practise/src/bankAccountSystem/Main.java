package bankAccountSystem;

public class Main {

	public static void main(String[] args) {
		

		
		SavingsAccount savingAccount = new SavingsAccount("Jackline Boss", 2000);
		CurrentAcount currentAccount = new CurrentAcount("Joginder Mikael", 1500);
		
	
		//Showing account details
		IO.println("Current Account Details");
		currentAccount.displayDetails();
		IO.println("Saving Account Details");
		savingAccount.displayDetails();
		
		//Depositing money
		currentAccount.deposit(1000);
		currentAccount.displayDetails();
		savingAccount.deposit(200);
		savingAccount.displayDetails();
		
		
		// withdrawing
		currentAccount.withdraw(1500);
		currentAccount.displayDetails();
		savingAccount.withdraw(1000);
		savingAccount.displayDetails();
		
		//applying interest
		savingAccount.applyInterest();
		savingAccount.displayDetails();
		
		
		
		
		
	}

}
