package libraryManagementApp;

//LIBRARY ITEMS MANAGED HERE
public class Library {
	
	LibraryItem[] items;
	int itemCount;

	Library(){
		this.items = new LibraryItem[50];
		this.itemCount = 0;
	}
	
	void addItem(LibraryItem item) {
		if(itemCount < items.length) {
			items[itemCount] = item;
			itemCount++;
			
		}else {
			IO.println("Sorry!Library if Full!");
		}
	}
	
	void displayAllItems() {
		for(LibraryItem item : items) {
			if(item!=null) {
				IO.println(item.toString());
			}
		}
	}
	
	void displayAvailableItems() {
		for(LibraryItem item : items ) {
			if (item != null && item.isAvailable == true) {
				IO.println(item.toString());
			}
		}
	}
	
	
	void borrowItem(String itemID, String borrowerName) {
		for (LibraryItem item : items) {
			if (item.itemID == itemID) {
				if(item instanceof Borrowable) {
					((Borrowable) item).borrow(borrowerName);
					break;
				}else {
					IO.println("This Item Cannot be Borrowed.");
				}
			} 
			IO.println("Item Not Found.");
			
			
		}
		
		
	}
	
	void returnItem(String itemID) {
		for(LibraryItem item : items) {
			if(item.itemID == itemID) {
				if(item instanceof Borrowable) {
					((Borrowable) item).returnItem();
					break;
				}else {
					IO.println("Item is not Returnable.");
				}
				
			}
			
			IO.println("Item is not found.");
		}
		
		
	}
	
	
}
