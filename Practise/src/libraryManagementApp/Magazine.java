package libraryManagementApp;
//MAGAZINE THAT CAN BE BORROWED
public class Magazine extends LibraryItem implements Borrowable{
	
	int issueNumber;
	String publicationMonth;
	String borrowerName;
	
	Magazine(String itemID, String title, String authorOrEditor, String publicationMonth, int issueNumber) {
		super(itemID, title, authorOrEditor);
		this.issueNumber = issueNumber;
		this.publicationMonth = publicationMonth;
		this.borrowerName = null;
	}



	@Override
	public void borrow(String borrowerName) {
		if(this.isAvailable == true) {
			this.isAvailable = false;
			this.borrowerName = borrowerName;
			IO.println("Magzine Borrowed Successfully.");
			//IO.println(this.toString());
		}else {
			IO.println("Magazine is Already borrowed");
		}
		
	}

	@Override
	public void returnItem() {
		if(this.isAvailable == false) {
			this.isAvailable = true;
			this.borrowerName = null;
			IO.println("Magazine returned Sucessfully.");
			
		}else {
			IO.println("Magazine is already available");
		}
		
	}

	@Override
	public boolean isAvailable() {
		
		return this.isAvailable;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"\nIssue: " + this.issueNumber + 
				"\nMonth: " +this.publicationMonth + "\n"+
				(this.isAvailable ? " " : "Borrowerd by: " + this.borrowerName) +
				"\n===============================";
		
	}

	@Override
	String getItemType() {
		return "MAGAZINE";
	}

}
