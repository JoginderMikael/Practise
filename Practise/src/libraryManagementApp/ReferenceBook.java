package libraryManagementApp;
//NON BORROWABLE ITEMS
public class ReferenceBook extends LibraryItem {

	
	String subjectArea;
	
	ReferenceBook(String itemID, String title, String authorOrEditor, String subjectArea) {
		super(itemID, title, authorOrEditor);
		this.subjectArea = subjectArea;
	}

	@Override
	String getItemType() {
		return "Reference Book";
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\nSubject: " + this.subjectArea +
				"\nItem Type: " + this.getItemType() +
				"\nNOTE: Refernce material Only - Not for Borrowing. "
				+ "\n===============================";
		
	}
}
