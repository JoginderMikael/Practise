package bankAccountSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	private SavingsAccount savingAccount;
	private CurrentAcount currentAccount;
	
	
	//CREATE SAVINGS ACCOUNT METHOD
	private void createSavingsAccount(Scanner scanner) {
		
		boolean isInValid = true;
		String name = null;
		double balance;
		
		while(isInValid) {
			//IO.println(isInValid);
			IO.println("\nSAVINGS ACCOUNT CREATION MENU.");
			System.out.print("Enter Your full Names: ");
			
			if(scanner.hasNextLine()) {
				isInValid = false;
				name = scanner.nextLine();

			}else {
				System.out.print("Please Enter a valid Name");	
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
	
	//SAVINGS MENU
	private void savingsMenu(Scanner scanner) {
	
	boolean exit = false;
	while(!exit) {
		IO.println("1. Withdraw.");
		IO.println("2. Apply Interest.");
		IO.println("3. Display Acount details");
		IO.println("4. Exit to Main Menu");
		
		System.out.print("Choose Option (1 - 4): ");
		
		int menuOption = 0; 
		
		try {
		menuOption = scanner.nextInt();
		scanner.nextLine();
		}catch(InputMismatchException e) {
			IO.println("INVALID INPUT");
		}
		
		switch(menuOption) {
		case 1 -> {
			System.out.print("Enter Amount to withdraw : ");
			double amount = 0;
			
			try {
				amount = scanner.nextDouble();
				scanner.nextLine();
			}catch (InputMismatchException e){
				IO.println("Invalid Amount");
				scanner.nextLine();
				continue;
			}
			
			savingAccount.withdraw(amount);
		}
		
		case 2 -> {
			savingAccount.applyInterest();
		}
		
		case 3 -> {
			savingAccount.displayDetails();
		}
		
		case 4 -> {
			exit = true;
		}
		
		default -> IO.println("INVALID INPUT");
		}
	}
	}
	
	//CREATE CURRENT ACCOUNT METHOD
	private void CreateCurrentAccount(Scanner scanner) {
		
		boolean isInValid = true;
		String name;
		double balance;
		
		while(isInValid) {
			
			IO.println("\nCURRENT ACCOUNT CREATION MENU.");
			System.out.print("Enter Your full Names: ");
			
			try {
				name = scanner.nextLine();
				scanner.nextLine();
			}catch(InputMismatchException e) {
				IO.println("Please Enter a valid Name");
				scanner.nextLine();
				break;
			}
			

			System.out.print("Deposit initial balance: $");
			balance = scanner.nextDouble();
			
			if(balance <= 0 ) {
				balance = 0;
			}
			
			this.currentAccount = new CurrentAcount(name, balance);
			
			IO.println("ACCOUNT CREATED SUCCESSFULLY.");
			this.currentAccount.displayDetails();
			IO.println();
			
		}
	}
	
	//CURRENT MENU
	
	private void currentMenu(Scanner scanner) {
		boolean exit = false;
		
		while(!exit) {
		
			IO.println("\nCURRENT ACCOUNT MENU:");
            IO.println("1. Withdraw");
            IO.println("2. Display Account Details");
            IO.println("3. Exit to Main Menu");
            IO.print("Choose Option (1-3): ");
            
            int menuOption = 0;
            
            try {
            	menuOption = scanner.nextInt();
            	scanner.nextLine();
            	
            }catch(InputMismatchException e) {
            	IO.println("INVALID INPUT");
            	scanner.nextLine();
            }
            
            switch(menuOption) {
                    case 1 -> {
                    	System.out.print("Enter Amount to withdraw : ");
						double amount = 0;
                    try {
                    	amount = scanner.nextDouble();
                    	scanner.nextLine();
                    } catch(InputMismatchException e) {
                    	IO.println("Invalid Amount. Please enter a number");
                    	scanner.nextLine();
                    	continue;
                    }
                    
                    currentAccount.withdraw(amount);
                    
                    }
                    
                    case 2 -> {
                    	currentAccount.displayDetails();
                    }
                    
                    case 3 -> {
                    	exit = true;
                    }
                    
                    default -> IO.println("INVALID INPUT");
            }
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Main main = new Main(); //instance to access fields
		
		//BANK ACOUNT IMPLEMENTATION
		
		boolean exit = false;
		
		IO.println("++++++++++++++++++++++++++++++");
		IO.println("WELCOME TO BANK ACCOUNT SYSTEM");
		IO.println("++++++++++++++++++++++++++++++");
		
		while(!exit) {
			
			IO.println("\nMENU.");
			IO.println("1. Create Account.");
			IO.println("2. Exit.");
			System.out.print("Choose option (1 or 2): ");
			
				int option = 0;
			
				try {
				option = scanner.nextInt();
				scanner.nextLine();
				
			} catch(InputMismatchException e) {
				IO.println("\nINVALID INPUT, PLEASE ENTER AN INTEGER (0 or 1)");
				scanner.nextLine();
				continue;
				
			}
			
				switch(option){
					case 1 -> {
						IO.println("1. Savings Account.");
						IO.println("2. Current Account.");
						IO.print("Enter Option 1 or 2: ");
						
						int accountOption = 0;
						
						try {
							accountOption = scanner.nextInt();
							scanner.nextLine();
						}catch(InputMismatchException e) {
							IO.println("INVALID INPUT, PLEASE ENTER AN INTEGER (0 or 1)");
							scanner.nextLine();
							continue;
						}
						
						if (accountOption == 1) {
							main.createSavingsAccount(scanner);
							main.savingsMenu(scanner);
						}else if(accountOption == 2) {
							main.CreateCurrentAccount(scanner);
							main.currentMenu(scanner);
						}else {
							IO.println("INVALID CHOICE");
						}
					}
					
					case 2 -> {
						exit = true;
						break;
					}
					
					default -> IO.println("INVALID INPUT");
				
				}
			
		
		}

	scanner.close();
	IO.println("Thank You for Using the System");
	}

}
