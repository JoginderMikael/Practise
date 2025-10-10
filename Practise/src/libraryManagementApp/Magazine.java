package libraryManagementApp;

public class Magazine extends LibraryItem implements Borrowable{
	
	Magazine(String itemID, String title, String authorOrEditor) {
		super(itemID, title, authorOrEditor);
		// TODO Auto-generated constructor stub
	}

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
