package personalFinanceTracker;

import java.time.LocalDate;

public class FinanceApp {

	public static void main(String[] args) {
		
		//Transaction t1 = new Expense(1, LocalDate.now(), 50.0, "Grocery shopping", Category.FOOD);
	//	IO.println(t1.toString());
		Income i1 = new Income(2, LocalDate.now(), 2000.0, "Salary for June", Category.SALARY, "Company XYZ");
		IO.println(i1.toString());
	//	Expense e1 = new Expense(3, LocalDate.now(), 100.0, "Electricity bill", Category.BILLS, "Credit Card");
	//	IO.println(e1.toString());
		
		
	}

}
