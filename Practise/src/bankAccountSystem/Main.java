package bankAccountSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	private SavingsAccount savingAccount;
	private CurrentAcount currentAccount;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Main main = new Main(); //instance to access fields
		
		//BANK ACOUNT IMPLEMENTATION
		
		boolean exit = false;
		IO.println("++++++++++++++++++++++++++++++");
		IO.println("WELCOME TO BANK ACCOUNT SYSTEM");
		IO.println("++++++++++++++++++++++++++++++");
		
		while(!exit) {
			//do the bank implementation
			
			try {
			
			IO.println("\nMENU.");
			IO.println("1. Create Account.");
			IO.println("2. Exit.");
			System.out.print("Choose option (1 or 2): ");
			
			
			int option = scanner.nextInt();
			
				if ( option != 1 && option != 2) {
					IO.println("\nINVALID INPUT, PLEASE ENTER 1 or 2: ");
				}else {
					scanner.nextLine();
					
					IO.println("1. Create Savings Account.");
					IO.println("2. Create Current Account.");
					IO.print("Enter Option 1 or 2: ");
				}
			
			} catch(InputMismatchException e) {
				IO.println("INVALID INPUT, PLEASE ENTER AN INTEGER (0 or 1)");
			}
			
					
					if(scanner.nextInt() == 1) {
							scanner.nextLine();
							main.createSavingsAccount(scanner);

							IO.println("1. Withdraw.");
							IO.println("2. Apply Interest.");
							IO.println("3. Display Acount details");
							IO.println("4. exit.");
							
							System.out.println("Choose Option (1 - 4): ");
							
							int menuOption = scanner.nextInt();
							
							switch(menuOption) {
									case 1 -> {
										IO.println("Enter Amount to withdraw : ");
										double amount;
										
										try {
										
											amount = scanner.nextDouble();
											scanner.nextLine();
											
											main.savingAccount.withdraw(amount);
											
										}catch (InputMismatchException e){
											IO.println("Invalid Amount");
											scanner.nextLine();
											
										}
										
										
									}
									
									case 2 -> {
										main.savingAccount.applyInterest();
									}
									
									case 3 -> {
										main.savingAccount.displayDetails();
									}
									
									case 4 -> {
										exit = true;
									}
									
									default -> IO.println("INVALID OPTION");
							}
				
						} else if(scanner.nextInt() == 2) {
							
							scanner.nextLine();
							main.CreateCurrentAccount(scanner);
							
							IO.println("\nCURRENT ACCOUNT MENU:");
		                    IO.println("1. Withdraw");
		                    IO.println("2. Display Account Details");
		                    IO.println("3. Exit to Main Menu");
		                    IO.print("Choose Option (1-3): ");
		                    
		                    int menuOption;
		                    
		                    try {
		                    	menuOption = scanner.nextInt();
		                    	scanner.nextLine();
		                    	
		                    }catch(InputMismatchException e) {
		                    	IO.println("INVALID INPUT");
		                    	scanner.nextLine();
		                    	continue;
		                    }
		                    
		                    switch(menuOption) {
				                    case 1 -> {
				                    	
				                    try {
				                    	double amount = scanner.nextDouble();
				                    	scanner.nextLine();
				                    	main.currentAccount.withdraw(amount);
				                    } catch(InputMismatchException e) {
				                    	IO.println("Invalid Amount. Please enter a number");
				                    	scanner.nextLine();
				                    }
				                    
				                    }
				                    
				                    case 2 -> {
				                    	main.currentAccount.displayDetails();
				                    }
				                    
				                    case 3 -> {
				                    	exit = true;
				                    }
				                    
				                    default -> IO.println("INVALID INPUT");
		                    }
							
						}else {
							IO.print("Invalid Input");
						}
			
		exit = true;
		}

	scanner.close();
	}
	
	private void createSavingsAccount(Scanner scanner) {
		
		boolean isInValid = true;
		String name = null;
		double balance;
		
		while(isInValid) {
			//IO.println(isInValid);
			IO.println("\nSAVINGS ACCOUNT CREATION MENU.");
			System.out.print("Enter Your full Names:");
			
			if(scanner.hasNextLine()) {
				isInValid = false;
				name = scanner.nextLine();

			}else {
				IO.println("Please Enter a valid Name");	
		}
			

			IO.println("Deposit initial balance: $");
			balance = scanner.nextDouble();
			
			if(balance <= 0 ) {
				balance = 0;
			}
			
			this.savingAccount = new SavingsAccount(name, balance);
			
			IO.println("ACCOUNT CREATED SUCCESSFULLY.");
			savingAccount.displayDetails();
			IO.println();
			
		}
		
		
	}
	
	private void CreateCurrentAccount(Scanner scanner) {
		
		boolean isInValid = true;
		String name = null;
		double balance;
		
		while(isInValid) {
			//IO.println(isInValid);
			IO.println("\nCURRENT ACCOUNT CREATION MENU.");
			System.out.print("Enter Your full Names:");
			
			if(scanner.hasNextLine()) {
				isInValid = false;
				name = scanner.nextLine();

			}else {
				IO.println("Please Enter a valid Name");	
		}
			

			IO.println("Deposit initial balance: $");
			balance = scanner.nextDouble();
			
			if(balance <= 0 ) {
				balance = 0;
			}
			
			this.currentAccount = new CurrentAcount(name, balance);
			
			IO.println("ACCOUNT CREATED SUCCESSFULLY.");
			savingAccount.displayDetails();
			IO.println();
			
		}
	}

}
