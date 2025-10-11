package personalFinanceTracker;

import java.time.LocalDate;

public class Income extends Transaction{

	Income(int ID, LocalDate date, double amount, String description, Category category) {
		super(ID, date, amount, description, category);
		
	}

}
