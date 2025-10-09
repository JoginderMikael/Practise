package libraryManagementApp;

public class Book extends LibraryItem implements  Borrowable{
	
	int pageCount;
	String genre;
	

	@Override
	public void borrow(String borrowName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	String getItemType() {
		// TODO Auto-generated method stub
		return null;
	}

}
