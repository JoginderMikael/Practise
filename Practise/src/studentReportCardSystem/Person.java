package studentReportCardSystem;

public abstract class Person {
	String name;
	String id;
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	abstract void displayInfo();
	
	@Override
	public String toString() {
		return "Name: " + name + "\nID: " + id;
	}

}
