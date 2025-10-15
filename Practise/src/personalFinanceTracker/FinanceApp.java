package personalFinanceTracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FinanceApp {

	public static void main(String[] args) {
		
	//	Transaction t1 = new Expense(1, LocalDate.now(), 50.0, "Grocery shopping", Category.FOOD);
	//	IO.println(t1.toString());
	//	Income i1 = new Income(2, LocalDate.now(), 2000.0, "Salary for June", Category.SALARY, "Company XYZ");
	//	IO.println(i1.toString());
	//	Expense e1 = new Expense(3, LocalDate.now(), 100.0, "Electricity bill", Category.BILLS, "Credit Card");
	//	IO.println(e1.toString());
		
	//	ArrayList<Transaction> transactions = new ArrayList<>();
	//	transactions.add(new Expense(1, LocalDate.now(), 50.0, "Grocery shopping", Category.FOOD, "Cash"));
	//	transactions.add(new Income(2, LocalDate.now(), 2000.0, "Salary for June", Category.SALARY, "Company XYZ"));
	//	transactions.add(new Expense(3, LocalDate.now(), 100.0, "Electricity bill", Category.BILLS, "Credit Card"));
	//	transactions.add(new Income(4, LocalDate.now(), 150.0, "Freelance project", Category.OTHER, "Client ABC"));
		
	// FileHandler fileHandler = new FileHandler();
	// fileHandler.writeToFile("transactions.csv", transactions);
		
		
	TransactionManager manager = new TransactionManager();
	Scanner scanner = new Scanner(System.in);
	

	manager.loadFromFile();
	
	boolean exit = false;
	IO.println("===================================");
	IO.println("Welcome to Personal Finance Tracker");
	IO.println("====================================");
	
	while(!exit) {
	
		IO.println("Personal Finance Tracker");
		IO.println("1. Add Income");
		IO.println("2. Add Expense");
		IO.println("3. View Transactions");
		IO.println("4. Search Transaction by Category");
		IO.println("5. Search Transactions by Date");
		IO.println("6. Delete Transaction.");
		IO.println("7. View Summary");
		IO.println("8. Save and Exit");

		
		int choice = 0;
		try {
			IO.print("Enter your choice: ");
			
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline
			
		} catch (Exception e) {
            IO.println("Invalid input. Please enter a number between 1 and 8.");
            continue;
            }
           
		
	
            switch (choice) {
            case 1 -> {
            	IO.println("\n+++++++++++++++++++++++++++++++++++");
				IO.println("Adding a new Income");
                IO.print("Enter date (YYYY-MM-DD): ");
                String dateStr = scanner.nextLine();
                LocalDate date = LocalDate.parse(dateStr);

                IO.print("Enter amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                IO.print("Enter description: ");
                String description = scanner.nextLine();

                IO.print("Enter category (FOOD, BILLS, SALARY, OTHER): ");
                String categoryStr = scanner.nextLine();
                Category category = Category.valueOf(categoryStr.toUpperCase());

                IO.print("Enter source: ");
                String source = scanner.nextLine();

                int id = manager.transactions.size();
                Income income = new Income(id, date, amount, description, category, source);
                manager.addTransaction(income);
                
            	IO.println("\n******************************************");
                IO.println("Income added successfully.");
            	IO.println("******************************************\n");
            
            }
            
            case 2 -> {
            	IO.println("\n+++++++++++++++++++++++++++++++++++");
				IO.println("Adding a new Expense");
				IO.print("Enter date (YYYY-MM-DD): ");
				String dateStr = scanner.nextLine();
				LocalDate date = LocalDate.parse(dateStr);

				IO.print("Enter amount: ");
				double amount = scanner.nextDouble();
				scanner.nextLine(); // Consume newline

				IO.print("Enter description: ");
				String description = scanner.nextLine();

				IO.print("Enter category (FOOD, BILLS, SALARY, OTHER): ");
				String categoryStr = scanner.nextLine();
				Category category = Category.valueOf(categoryStr.toUpperCase());

				IO.print("Enter payment method: ");
				String paymentMethod = scanner.nextLine();

				int id = manager.transactions.size();
				Expense expense = new Expense(id, date, amount, description, category, paymentMethod);
				manager.addTransaction(expense);
				
				IO.println("\n******************************************");
				IO.println("Expense added successfully.");
				IO.println("******************************************\n");
            }
            
            case 3 -> {
            	IO.println("\n******************************************");
            	manager.viewTransactions();
            	IO.println("******************************************\n");
            }
            
            case 4 -> {
            	IO.println("\n+++++++++++++++++++++++++++++++++++");
				IO.println("Searching by Category.");
            	IO.print("Enter Category to search (FOOD, BILLS, SALARY, OTHER): ");
            	String categoryStr = scanner.nextLine();
            	Category category = Category.valueOf(categoryStr.toUpperCase());
            	
            	IO.println("\n******************************************");
            	manager.searchByCategory(category);
            	IO.println("******************************************\n");
    
            }
            
            case 5 -> {
            	IO.println("\n+++++++++++++++++++++++++++++++++++");
				IO.println("Searching by Date.");
            	IO.print("Enter date to search (YYYY-MM-DD): ");
            	String dateStr = scanner.nextLine();
            	IO.println("\n******************************************");
            	manager.searchByDate(dateStr);
            	IO.println("******************************************\n");
            }
            
            case 6 -> {
            	IO.println("\n+++++++++++++++++++++++++++++++++++");
				IO.println("Deleting by Transaction ID.");
            	IO.print("Enter Transaction ID to delete: ");
            	int id = scanner.nextInt();
            	scanner.nextLine(); // Consume newline
            	manager.deleteTransaction(id);
            	
            	IO.println("\n******************************************");
            	IO.println("Transaction deleted successfully.");
            	IO.println("******************************************\n");
            	
            }
            
            case 7 ->{
            	IO.println("\n******************************************");
            	IO.println("Total Income: " + manager.getTotalIncome());
            	IO.println("Total Expense: " + manager.getTotalExpense());
            	IO.println("Current Balance: " + manager.getBalance());
            	IO.println("******************************************\n");
            }
            
            case 8 -> {
            	manager.saveToFile();
            	IO.println("\n******************************************");
            	IO.println("Data saved. Exiting application.");
            	IO.println("******************************************\n");
            	exit = true;
            }
            
            default -> {
            	IO.println("\n++++++++++++++++++++++++++++++++++");
                IO.println("Invalid choice. Please try again.");
                IO.println("*++++++++++++++++++++++++++++++++++\n");

            }
		

            }
            
	
	}
	
	scanner.close();
	}
	
	}




