package libraryManagementApp;

public class Magazine extends LibraryItem implements Borrowable{
	
	int issueNumber;
	String publicationMonth;

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
	public String toString() {
		return null;
		
	}

	@Override
	String getItemType() {
		// TODO Auto-generated method stub
		return null;
	}

}
