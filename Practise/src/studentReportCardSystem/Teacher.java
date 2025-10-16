package studentReportCardSystem;

import java.util.Scanner;

public class Teacher extends Person {
	
	String username;
	String password;
	String [] subjects;
	public Teacher(String name, String id, String username, String password, String[] subjects) {
		super(name, id);
		this.username = username;
		this.password = password;
		this.subjects = subjects;
		
	}
	
	boolean login(String username, String password) {
		if (this.username.equals(username) && this.password.equals(password)) {
			System.out.println("Login successful");
			return true;
		} else {
			System.out.println("Login failed");
			return false;
		}
	}

	void enterMarks(Student student) {
		System.out.println("Entering marks for student: " + student.name);
		for (int i = 0; i < student.marks[i].length; i++) {
			for (int j = 0; j < student.marks[i].length; j++) {
				System.out.println("Enter marks for subject " + subjects[i] + " (Test " + (j+1) + ") :");
                String score = new Scanner(System.in).nextLine(); 
                student.setMarks(i, j, score);
            }
			

		}
		
		System.out.println("Marks entry completed for student: " + student.name);
		
	}
	@Override
	void displayInfo() {
		System.out.println("Teacher Name: " + name);
		System.out.println("Teacher ID: " + id);
		System.out.println("Username: " + username);
		System.out.print("Subjects: ");
		for (String subject : subjects) {
			System.out.print(subject + " ");
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", id=" + id + ", username=" + username + ", subjects="
				+ String.join(", ", subjects) + "]";
	}

}
