package bankAccountSystem;

public class Main {

	public static void main(String[] args) {
		
		BankAccount bankAccount = new BankAccount("Joginder Mikaael", 1000);
		SavingsAccount savingAccount = new SavingsAccount("Joginder Mikaael", 1000);
		CurrentAcount currentAccount = new CurrentAcount("Joginder Mikaael", 1500);
		
		
		bankAccount.deposit(2100);
		//bankAccount.withdraw(100);
		bankAccount.displayDetails();
		IO.println(bankAccount.getBalance());
		
		savingAccount.applyInterest();
		currentAccount.withdraw(400);
		
		
		
	}

}
