package personalFinanceTracker;

import java.time.LocalDate;

public class Expense extends Transaction{

	Expense(int ID, LocalDate date, double amount, String description, Category category) {
		super(ID, date, amount, description, category);
		
	}

}
