package personalFinanceTracker;

import java.time.LocalDate;
import java.util.ArrayList;

public class FinanceApp {

	public static void main(String[] args) {
		
	//	Transaction t1 = new Expense(1, LocalDate.now(), 50.0, "Grocery shopping", Category.FOOD);
	//	IO.println(t1.toString());
	//	Income i1 = new Income(2, LocalDate.now(), 2000.0, "Salary for June", Category.SALARY, "Company XYZ");
	//	IO.println(i1.toString());
	//	Expense e1 = new Expense(3, LocalDate.now(), 100.0, "Electricity bill", Category.BILLS, "Credit Card");
	//	IO.println(e1.toString());
		
	//	ArrayList<Transaction> transactions = new ArrayList<>();
	//	transactions.add(new Expense(1, LocalDate.now(), 50.0, "Grocery shopping", Category.FOOD, "Cash"));
	//	transactions.add(new Income(2, LocalDate.now(), 2000.0, "Salary for June", Category.SALARY, "Company XYZ"));
	//	transactions.add(new Expense(3, LocalDate.now(), 100.0, "Electricity bill", Category.BILLS, "Credit Card"));
	//	transactions.add(new Income(4, LocalDate.now(), 150.0, "Freelance project", Category.OTHER, "Client ABC"));
		
	// FileHandler fileHandler = new FileHandler();
	// fileHandler.writeToFile("transactions.csv", transactions);
		
		
	TransactionManager manager = new TransactionManager();

	manager.loadFromFile();
	
		
	
	}

}
