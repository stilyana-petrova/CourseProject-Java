import java.util.ArrayList;

public class Instructor extends Participant {

	private ArrayList<String> subjects;
	
	//ctor
	public Instructor(String name, int age, int id) {
		super(name, age, id);
		subjects=new ArrayList<>();
	}
	
	//getters and setters
	public ArrayList<String> getSubjects(){
		return subjects;
	}
	public void setSubjects(ArrayList<String> subject) {
		this.subjects=subject;
	}
	
	//addSubject method
	public void addSubject(String subject) {
		subjects.add(subject);
	}

}
