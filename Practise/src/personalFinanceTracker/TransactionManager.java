package personalFinanceTracker;

import java.util.ArrayList;

public class TransactionManager {

	ArrayList<Transaction> transactions;
	
	TransactionManager() {
		this.transactions = new ArrayList<>();
	}
	
	void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
	
	void viewTransactions() {
		for (Transaction transaction : this.transactions) {
			IO.println(transaction.toString());
		}
	}
	
	void searchByDate(String date) {
		for (Transaction transaction : this.transactions) {
			if (transaction.getDate().toString().equals(date)) {
				IO.println(transaction.toString());
			}
		}
	}
	
	double searchByCategory(Category category) {
		double total = 0.0;
		for (Transaction transaction : this.transactions) {
			if (transaction.getCategory() == category) {
				IO.println(transaction.toString());
				total += transaction.getAmount();
			}
		}
		return total;
	}
	
	double getTotalIncome() {
		double totalIncome = 0.0;
		for (Transaction transaction : this.transactions) {
			if (transaction instanceof Income) {
				totalIncome += transaction.getAmount();
			}
		}
		return totalIncome;
	}
	
	double getTotalExpense() {
		double totalExpense = 0.0;
		for (Transaction transaction : this.transactions) {
			if (transaction instanceof Expense) {
				totalExpense += transaction.getAmount();
			}
		}
		return totalExpense;
	}
	
	
	double getBalance() {
		return this.getTotalIncome() - this.getTotalExpense();
	}
	
	void saveToFile() {
		FileHandler fileHandler = new FileHandler();
		fileHandler.writeToFile("transactions.csv", this.transactions);
	}
	
	void loadFromFile() {
		this.transactions = FileHandler.readFromFile("transactions.csv");
	}
	
	void deleteTransaction(int id) {
		this.transactions.removeIf(transaction -> transaction.getId() == id);
	}
}
