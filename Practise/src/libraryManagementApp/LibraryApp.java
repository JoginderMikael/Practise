package libraryManagementApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) {
		System.out.println("LIBRARY MANAGEMENT SYSTEM");
		
		Scanner scanner = new Scanner(System.in);
		
		Library library = new Library();
		
		Book book = new Book("17872", "Sexorcised", "Jacob", "Fiction", 350);
		Magazine magazine = new Magazine("17875", "Language of Computer", "Susan", "JUNE", 90993);
		ReferenceBook referenceBook = new ReferenceBook("17876", "Atlas", "Joes", "Geography");
		
		
		library.addItem(book);
		library.addItem(magazine);
		library.addItem(referenceBook);
		
		boolean exit = false;
		
		while(!exit) {
			System.out.println("OPTIONS "
					+ "\n1. Show all items."
					+ "\n2. Borrow an item."
					+ "\n3. Return an item."
					+ "\n4. Show Available items."
					+ "\n5. Exit"
					+ "\n");
			System.out.print("Choose option (1 - 5): ");
			int option = 0;
			try {
				option = scanner.nextInt();
				scanner.nextLine();
			}catch(InputMismatchException e) {
				IO.println("INVALID INPUT, PLEASE ENTER A NUMBER (1 - 5)");
				scanner.nextLine();
			}
			
			switch(option) {
					case 1 -> library.displayAllItems();
					case 2 -> {
						System.out.print("Enter a Valid Item ID: ");
						
						String itemIdd = scanner.nextLine().trim();
						
						System.out.print("Enter Your borrower Name: ");
						
						String borrowerName = scanner.nextLine();

						library.borrowItem(itemIdd, borrowerName);
	
					}
					case 3 -> {
						System.out.print("Enter a Valid Item ID: ");
						
						String itemIdd = scanner.nextLine().trim();
						library.returnItem(itemIdd);
					}
					case 4 -> library.displayAvailableItems();
					case 5 -> {
						IO.println("GOOD BYE");
						exit = true;
					}
					default -> IO.println("INVALID OPTION, Please Enter valid option.");
				}
			
		
		}

	scanner.close();
	
	}

}
