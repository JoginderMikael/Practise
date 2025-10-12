package personalFinanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

	void writeToFile(String fileName, ArrayList<Transaction> transaction) {
		FileWriter writer = null;
		
		try {
			String type;
			String extraField = "";
			
			for(Transaction t : transaction) {
			if(t instanceof Income) {
				type = "INCOME";
				Income income = (Income) t;
				extraField = income.getSource();
				
			}else if (t instanceof Expense){
					type = "EXPENSE";
					Expense expense = (Expense) t;
					extraField = expense.getPayMethod();
				}else {
					type = "TRANSACTION";
				}
			
			String line = type + "," +
							t.getDate() + "," +
							t.getAmount() + "," +
							t.getDescription() + "," +
							extraField + "," +
							t.getCategory() + "\n";
			writer.write(line);
				
			}
			
			IO.println("Transaction has been saved sucessfully. " + fileName);
		}catch(IOException e) {
			IO.println("ERROR while saving file. " + e.getMessage());
		} finally {
			try {
				if (writer != null) writer.close();
			}catch(IOException e) {
				IO.println ("ERROR: " + e.getMessage());
			}
		}
		}
	
	
	void readFromFile(String fileName) {

	}
}
