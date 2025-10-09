package libraryManagementApp;

public abstract class LibraryItem {
	String title;
	String authorOrEditor;
	String itemID;
	boolean isAvailable;
	
	
	abstract String getItemType();
	
	
	@Override
	public String toString() {
		return null;
	}
	
}
