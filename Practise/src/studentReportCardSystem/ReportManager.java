package studentReportCardSystem;

public class ReportManager {

	
	static String generateReport(Student student) {
		student.calculateAverage();
		student.assignGrades();

		StringBuilder report = new StringBuilder();
		report.append("Report Card for ").append(student.name).append(" (ID: ").append(student.id).append(")\n");
		report.append("--------------------------------------------------\n");
		report.append(String.format("%-15s %-10s %-10s\n", "Subject", "Marks", "Grade"));
		report.append("--------------------------------------------------\n");

		for (int i = 0; i < student.subjects.length; i++) {
			String subject = student.subjects[i];
			String marksStr = String.join(", ", student.marks[i]);
			char grade = student.grades[i];
			report.append(String.format("%-15s %-10s %-10s\n", subject, marksStr, grade));
		}

		report.append("--------------------------------------------------\n");
		report.append(String.format("Overall Average: %.2f\n", student.average));

		return report.toString();
	}
	
	static String exportReport(Student student) {
	    
		String fileName = "ReportCard_" + student.id + ".txt";
		
		return generateReport(student);
	}
}
