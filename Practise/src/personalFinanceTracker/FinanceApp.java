package personalFinanceTracker;

public class FinanceApp {

	public static void main(String[] args) {
		
		Transaction t1 = new Expense(1, java.time.LocalDate.of(2024, 6, 1), 50.0, "Grocery shopping", Category.FOOD);
		IO.println(t1.toString());
	}

}
