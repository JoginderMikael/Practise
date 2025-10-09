package bankAccountSystem;

public class Main {

	public static void main(String[] args) {
		
		BankAccount bankAccount = new BankAccount("Joginder Mikaael", 1000);
		
		bankAccount.deposit(2100);
		bankAccount.withdraw(100);
		bankAccount.displayDetails();
		IO.println(bankAccount.getBalance());
		
		//System.out.println("This is a Bank Account System");
	}

}
