package studentReportCardSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] subjects = {"Math", "Science", "History"};
		Teacher teacher = new Teacher("Alice Smith", "T001", "admin", "admin", subjects);
		ArrayList< Student> students = new ArrayList<>();
		
		IO.println("=========Welcome to the Student Report Card System===========");
		
		IO.println("Please login to continue");
		IO.print("Username: ");
		String username = scanner.nextLine();
		IO.print("Password: ");
		String password = scanner.nextLine();
		
		
		if (teacher.login(username, password)) {
			IO.println("Login successful. Welcome, " + teacher.name + "!");

             IO.println("\nYou can now manage student report cards.");
             IO.println("=============================================\n");
             IO.print("Enter number of students to manage: ");
             int numStudents = Integer.parseInt(scanner.nextLine());
             
				for (int i = 0; i < numStudents; i++) {
					IO.print("Enter name for student " + (i + 1) + ": ");
					String studentName = scanner.nextLine();
					IO.print("Enter ID for student " + (i + 1) + ": ");
					String studentId = scanner.nextLine();

					Student student = new Student(studentName, studentId, subjects,3);
					teacher.enterMarks(student);
					
					
					
					IO.println("\nGenerating report for " + student.name + "...\n");
					String report = ReportManager.generateReport(student);
					IO.println(report);
					
					students.add(student);
					
					IO.print("Do you want to export the report to a text file? (yes/no): ");
					String exportChoice = scanner.nextLine();
					
					if (exportChoice.equalsIgnoreCase("yes")) {
						ReportManager.exportReport(student);
					}

				}
				
				IO.println("\nAll student reports:");
				ReportManager.viewAllReports(students.toArray(new Student[0]));
             

		} else {
			IO.println("Invalid username or password. Exiting the system.");
		}

	scanner.close();
	
	}

}
