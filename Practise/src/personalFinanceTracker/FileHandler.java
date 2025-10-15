package personalFinanceTracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileHandler {

	void writeToFile(String fileName, ArrayList<Transaction> transaction) {
		
		FileWriter writer = null;
		
		try {
			
			writer = new FileWriter(fileName);
			
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
	
	
	public static ArrayList<Transaction> readFromFile(String fileName) {
		
		ArrayList<Transaction> transactions = new ArrayList<>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			
			while((line = reader.readLine()) != null) {
				
				String[]  parts = line.split(",");
				
				if(parts.length < 6) {
					continue;
				}
				
				String type = parts[0];
				LocalDate date = LocalDate.parse(parts[1]);
				double amount = Double.parseDouble(parts[2]);
				String description = parts[3];
				String extraField = parts[4];
				Category category = Category.valueOf(parts[5]);
				
				
				Transaction t = null;
				int id = transactions.size();
				
				if(type.equalsIgnoreCase("INCOME")) {
					t = new Income(id, date, amount, description, category, extraField);
				} else if(type.equalsIgnoreCase("EXPENSE")) {
					t = new Income(id, date, amount, description, category, extraField);
				}
				
				if(t != null) {
					transactions.add(t);
				}
			}
		} catch (IOException e) {
			System.out.println("Error while reading the transaction: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Data format issue: " + e.getMessage());
		} finally {
			try {
				if (reader != null) reader.close();
			} catch (IOException e) {
				System.out.println("Error closing file: " + e.getMessage());
			}
		}
		return transactions;
	}
}
