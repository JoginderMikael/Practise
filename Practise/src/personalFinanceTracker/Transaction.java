package personalFinanceTracker;

import java.time.LocalDate;

public class Transaction {

	int ID;
	LocalDate date;
	double amount;
	String description;
	Category category;
	
	Transaction(int ID, LocalDate date, double amount, String description, Category category){
		this.ID = ID;
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.category = category;
	}
	
	public int getId() {
		return this.ID;
	}
	
	public LocalDate getDate() {
		return this.getDate();
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	@Override
	public String toString() {
		return "Transaction ID = " + this.ID + "\nDate = " + this.date + "\nAmount = " + this.amount + "\nDescription = " + this.description
				+ "\nCategory=" + this.category + "\n";
	}
}
