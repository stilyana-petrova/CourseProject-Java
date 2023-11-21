import java.util.ArrayList;

public class Course {

	private String name;
	private String courseCode;
	private ArrayList<Participant> participants;
	
	//ctor
	public Course(String name, String courseCode) {
		this.name=name;
		this.courseCode=courseCode;
		participants= new ArrayList<>();
	}
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		this.name=newName;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String code) {
		this.courseCode=code;
	}
	
	public ArrayList<Participant> getParticipants(){
		return participants;
	}
	public void setParticipants(ArrayList<Participant> participant) {
		this.participants=participant;
	}
	
	//Adding student in the course
	public void addParticipant(Participant participant) {
		participants.add(participant);
	}
}
