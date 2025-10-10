package libraryManagementApp;

public class Book extends LibraryItem implements  Borrowable{
	

	int pageCount;
	String genre;
	String borrowerName;
	
	Book(String itemID, String title, String authorOrEditor, String genre, int pageCount) {
		super(itemID, title, authorOrEditor);
		this.genre = genre;
		this.pageCount = pageCount;
		this.borrowerName = null;
		
	}

	

	@Override
	public void borrow(String borrowerName) {
		if(this.isAvailable == true) {
			this.isAvailable = false;
			this.borrowerName = borrowerName;
			IO.println("Book Borrowed Successfully.");
			//IO.println(isAvailable);
		}else {
			IO.println("Book already borrowed.");
		}
		
	}

	@Override
	public void returnItem() {
		
		if(this.isAvailable == false) {
			this.isAvailable = true;
			this.borrowerName = null;
			IO.println("Book returned Successfully.");
		}
		else {
			IO.println("Book is already available");
		}
		
	}

	@Override
	public boolean isAvailable() {
		return this.isAvailable;
	}

	@Override
	String getItemType() {
		
		return "BOOK";
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"\ngenre: " + this.genre + 
				"\npages: " +this.pageCount + "\n"+
				(this.isAvailable ? " " : "Borrowerd by: " + this.borrowerName);
		
	}

}
