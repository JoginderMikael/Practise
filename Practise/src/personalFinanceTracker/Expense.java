package personalFinanceTracker;

import java.time.LocalDate;

public class Expense extends Transaction{

	String payMethod;
	
	Expense(int ID, LocalDate date, double amount, String description, Category category, String payMethod) {
		super(ID, date, amount, description, category);
		this.payMethod = payMethod;
	}
	
	String getPayMethod() {
		return this.payMethod;
	}
	
	@Override
	public String toString() {
		return "EXPENSE\n" + super.toString() + "Payment Method = " + this.getPayMethod() + "\n";
	}

}
