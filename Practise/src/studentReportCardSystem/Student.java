package studentReportCardSystem;

public class Student extends Person{

	String[] subjects;
	 String[][] marks;
	char[] grades;
	double average;
	
	public Student(String name, String id, String[] subjects, int numTests) {
		super(name, id);
		this.subjects = subjects;
		this.marks = new String[this.subjects.length][numTests];
		this.grades = new char[this.subjects.length];
		this.average = 0.0;
	}

	void setMarks(int subjectIndex, int testIndex, String score) {
		if (subjectIndex >= 0 && subjectIndex < subjects.length && testIndex >= 0
				&& testIndex < marks[subjectIndex].length) {
			marks[subjectIndex][testIndex] = score;
		} else {
			System.out.println("Invalid subject or test index.");
		}
	}
	
	void calculateAverage() {
		double total = 0.0;
		int count = 0;
		for (int i = 0; i < subjects.length; i++) {
			for (int j = 0; j < marks[i].length; j++) {
				if (marks[i][j] != null) {
					try {
						total += Double.parseDouble(marks[i][j]);
						count++;
					} catch (NumberFormatException e) {
						System.out.println("Invalid score format for " + subjects[i] + " test " + (j + 1));
					}
				}
			}
		}
		
		if (count > 0) {
			this.average = total / count;
		} else {
			this.average = 0.0;
		}
	}
	
	void assignGrades() {
		for (int i = 0; i < subjects.length; i++) {
			double total = 0.0;
			int count = 0;
			for (int j = 0; j < marks[i].length; j++) {
				if (marks[i][j] != null) {
					try {
						total += Double.parseDouble(marks[i][j]);
						count++;
					} catch (NumberFormatException e) {
						System.out.println("Invalid score format for " + subjects[i] + " test " + (j + 1));
					}
				}
			}

			if (count > 0) {
				double subjectAverage = total / count;
				if (subjectAverage >= 90) {
					grades[i] = 'A';
				} else if (subjectAverage >= 80) {
					grades[i] = 'B';
				} else if (subjectAverage >= 70) {
					grades[i] = 'C';
				} else if (subjectAverage >= 60) {
					grades[i] = 'D';
				} else {
					grades[i] = 'F';
				}
			} else {
				grades[i] = 'N'; // N for No grades
			}
		}
	}
	
	@Override
	void displayInfo() {
		IO.println("Student Name: " + name);
		IO.println("Student ID: " + id);
		IO.println("--------------------------");
		for (int i = 0; i < subjects.length; i++) {
			IO.print("Subject: " + subjects[i] + " | Marks: ");
			for (int j = 0; j < marks[i].length; j++) {
				IO.print((marks[i][j] != null ? marks[i][j] : "N/A") + " ");
			}
			IO.println("| Grade: " + grades[i]);
		}
		
	}
	
	@Override
	public String toString() {
		
		String REPORT = "==============================\n";
		        REPORT += "        Report Card          \n";
				REPORT += "Student Name: " + name + "\n";
				REPORT += "Student ID: " + id + "\n";
				
				for (int i = 0; i < subjects.length; i++) {
					REPORT += "------------------------------\n";
					REPORT += "Subject: " + subjects[i] + "\nMarks: ";
					for (int j = 0; j < marks[i].length; j++) {
						REPORT += (marks[i][j] != null ? marks[i][j] : "N/A") + " ";
					}
					REPORT += "\nGrade: " + grades[i] + "\n";
				}
		return REPORT;
		
	}

}
