import java.util.ArrayList;

public class Student extends Participant{

	private ArrayList<Integer> grades;
	
	//ctor
	public Student(String name, int age, int id) {
		super(name, age, id);
		
		grades=new ArrayList<>();
	}
	
	//getters and setters
	public ArrayList<Integer> getGrades(){
		return grades;
	}
	public void setGrades(ArrayList<Integer> newGrades){
		this.grades=newGrades;
	}
	
	//addGrade method
	public void addGrade(int grade) {
		grades.add(grade);
	}

}
