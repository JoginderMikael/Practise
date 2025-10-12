package personalFinanceTracker;

import java.time.LocalDate;

public class Income extends Transaction{

	
	private String source;
	
	Income(int ID, LocalDate date, double amount, String description, Category category, String source) {
		super(ID, date, amount, description, category);
		this.source = source;
	}
	
	String getSource() {
		return this.source;
	}
	
	@Override
	public String toString() {
		return "INCOME\n" + super.toString() + "Source = " + this.getSource() + "\n";
	}
	
}

