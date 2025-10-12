package personalFinanceTracker;

import java.time.LocalDate;

public class Transaction {

	private int ID;
	private LocalDate date;
	private double amount;
	private String description;
	private Category category;
	
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
		return this.date;
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
		return "Transaction ID = " + this.getId() + "\nDate = " + this.getDate() + "\nAmount = " + this.getAmount() + "\nDescription = " + this.getDescription()
				+ "\nCategory = " + this.getCategory() + "\n";
	}
}
