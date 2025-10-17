package studentReportCardSystem;

import java.io.FileWriter;

public class ReportManager {

	//generating the report for a student
	static String generateReport(Student student) {
		student.calculateAverage();
		student.assignGrades();

		StringBuilder report = new StringBuilder();
		report.append("Report Card for ").append(student.name).append(" (ID: ").append(student.id).append(")\n");
		report.append("--------------------------------------------------\n");
		report.append(String.format("%-15s %-10s %-10s\n", "Subject", "Marks", "Grade"));
		report.append("--------------------------------------------------\n");

		for (int i = 0; i < student.getSubjects().length; i++) {
			String subject = student.getSubjects()[i];
			String marksStr = String.join(", ", student.getMarks()[i]);
			char grade = student.getGrades()[i];
			report.append(String.format("%-15s %-10s %-10s\n", subject, marksStr, grade));
		}

		report.append("--------------------------------------------------\n");
		report.append(String.format("Overall Average: %.2f\n", student.getAverage()));

		return report.toString();
	}
	
	
	// exporting the report to a text file
	static void exportReport(Student student) {
	    
		String fileName = "ReportCard_" + student.id + ".txt";
		FileWriter writer = null;
		
		
		try {
			writer = new FileWriter(fileName);
			String reportContent = generateReport(student);
			writer.write(reportContent);
			System.out.println("Report exported successfully to " + fileName);
		} catch (Exception e) {
			System.out.println("Error exporting report: " + e.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {
				System.out.println("Error closing file writer: " + e.getMessage());
			}
		}
		
		//return generateReport(student);
	}
	
	// viewing all reports for a list of students
	static void viewAllReports(Student[] students) {
		for (Student student : students) {
			String report = generateReport(student);
			System.out.println(report);
		}
	}
	
	
}
