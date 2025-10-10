package libraryManagementApp;

public abstract class LibraryItem {
	
	String title;
	String authorOrEditor;
	String itemID;
	boolean isAvailable;
	
	LibraryItem(String itemID, String title, String authorOrEditor){
		this.itemID = itemID;
		this.title = title;
		this.authorOrEditor = authorOrEditor;
		this.isAvailable = true;
	}
	
	
	abstract String getItemType();
	
	
	@Override
	public String toString() {
		return "==============================="+ 
				"\nItem ID: " + this.itemID + 
				"\nTitle: " + this.title +
				"\nItem Type: " + this.getItemType() +
				"\nAuthor/Editor: " + this.authorOrEditor +
				"\nAvailability: " + (this.isAvailable ? "Available" : "Borrowed");
	}
	
}
