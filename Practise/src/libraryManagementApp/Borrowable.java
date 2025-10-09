package libraryManagementApp;

public interface Borrowable {

	void borrow(String borrowName);
	
	void returnItem();
	
	boolean isAvailable();
	
}
