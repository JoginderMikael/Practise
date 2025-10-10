package libraryManagementApp;

public class LibraryApp {

	public static void main(String[] args) {
		System.out.println("LIBRARY MANAGEMENT SYSTEM");
		
	//	LibraryItem libraryItem = new Book("17872", "Sexorcised", "Jacob", "Fiction", 350);
		
		Book book = new Book("17872", "Sexorcised", "Jacob", "Fiction", 350);
		
	//	IO.println(libraryItem.toString());
	//	IO.println(libraryItem.getItemType());
		book.borrow("Joginder Mikael");
		IO.println(book.toString());
		book.returnItem();
	//	IO.println(libraryItem.toString());
		IO.println(book.toString());

	}

}
