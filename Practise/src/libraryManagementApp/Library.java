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
		
		boolean found = false;
		
		for (LibraryItem item : items) {
			
			if (item == null) {
				continue;
			}
			
			if (item.itemID.equals(itemID)) {
				found = true;
				if(item instanceof Borrowable) {
					((Borrowable) item).borrow(borrowerName);
				}else {
					IO.println("This Item Cannot be Borrowed.");
				
				}
				break;
			} 

		}
		
		if (found == false) {
		IO.println("Item Not Found.");	
		}
	}
	
	void returnItem(String itemID) {
		
		boolean found = false;
		
		for(LibraryItem item : items) {
			
			if (item == null) {
				continue;
			}
			
			if(item.itemID.equals(itemID)) {
				found = true;
				if(item instanceof Borrowable) {
					((Borrowable) item).returnItem();
				}else {
					IO.println("Item is not Returnable.");
				}
				
				break;
			}

		}
		
		if(found == false) {
		IO.println("Item is not found.");
		}
		
	}
	
	
}
