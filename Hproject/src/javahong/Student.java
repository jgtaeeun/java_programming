package javahong;

public class Student extends Employee {
	

	public Student(int pid, String name, int age, int eno, String dept, float salary){
		super( pid,  name, age,  eno,  dept,  salary);
		
    }
	
	public String toString() {
		return super.toString();}

}

