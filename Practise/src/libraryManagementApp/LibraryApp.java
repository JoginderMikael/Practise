package libraryManagementApp;

public class LibraryApp {

	public static void main(String[] args) {
		System.out.println("LIBRARY MANAGEMENT SYSTEM");
		
	//	LibraryItem libraryItem = new Book("17872", "Sexorcised", "Jacob", "Fiction", 350);
		
		Book book = new Book("17872", "Sexorcised", "Jacob", "Fiction", 350);
		Magazine magazine = new Magazine("17872", "Sexorcised", "Jacob", "JUNE", 90993);
		ReferenceBook referenceBook = new ReferenceBook("17872", "Sexorcised", "Jacob", "SEX");
	
		//	IO.println(libraryItem.toString());
	//	IO.println(libraryItem.getItemType());
	//	book.borrow("Joginder Mikael");
	//IO.println(book.toString());
		//book.returnItem();
		//IO.println(libraryItem.toString());
		//IO.println(book.toString());
	//	IO.println(magazine.toString());
	//	magazine.returnItem();
	//	magazine.borrow("Joginder Mikael");
	//	IO.println(magazine.toString());
		magazine.borrow("Joginder Mikael");
	
		IO.println(referenceBook.toString());
		
		

	}

}
