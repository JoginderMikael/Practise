package personalFinanceTracker;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinanceApp {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		TransactionManager manager = new TransactionManager();
		
		
		IO.println("===================================");
		IO.println("Welcome to Personal Finance Tracker");
		IO.println("====================================");
		
		//loading the saved data for the program start up
		
		
        
		manager.loadFromFile();
		System.out.println("Loaded " + manager.getTransactionCount() + " transactions.\n");
	
		boolean exit = false;

	
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
	           
			try {
		
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
	            
			} catch(NumberFormatException e) {
				IO.println("\n++++++++++++++++++++++++++++++++++");
	            IO.println("Invalid number format: " + e.getMessage());
	            IO.println("++++++++++++++++++++++++++++++++++\n");
	            continue;
			} catch (DateTimeParseException e) {
				IO.println("\n++++++++++++++++++++++++++++++++++");
	            IO.println("Invalid date format. Please use YYYY-MM-DD.");
	            IO.println("++++++++++++++++++++++++++++++++++\n");
	            continue;
				} catch(IllegalArgumentException e) {
	            IO.println("\n++++++++++++++++++++++++++++++++++");
	            IO.println("Invalid category. Please enter one of the following: FOOD, BILLS, SALARY, OTHER.");
	            IO.println("++++++++++++++++++++++++++++++++++\n");
	            continue;
			} catch (IndexOutOfBoundsException e) {
				IO.println("\n++++++++++++++++++++++++++++++++++");
				IO.println("Transaction ID not found: " + e.getMessage());
				IO.println("++++++++++++++++++++++++++++++++++\n");
				continue;
			} catch (InputMismatchException e) {
				IO.println("\n++++++++++++++++++++++++++++++++++");
				IO.println("Input type mismatch. Please enter the correct data type.");
				IO.println("++++++++++++++++++++++++++++++++++\n");
				scanner.nextLine(); // Clear the invalid input
				continue;
			} catch (Exception e) {
				IO.println("\n++++++++++++++++++++++++++++++++++");
	            IO.println("An error occurred: " + e.getMessage());
	            IO.println("++++++++++++++++++++++++++++++++++\n");
	            continue;
			}
	            
		
		}
		
		scanner.close();
		}
		
		}




