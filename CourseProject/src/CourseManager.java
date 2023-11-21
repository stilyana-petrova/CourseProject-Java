import java.util.ArrayList;

public class CourseManager {

	//field
	private ArrayList<Course> courses;
	
	//ctor
	public CourseManager() {
		courses=new ArrayList<>();
	}
	//getters and setters
	public ArrayList<Course> getCourses(){
		return courses;
	}
	public void setCourses(ArrayList<Course> course) {
		this.courses=course;
	}
	
	//methods
	public void addCourse(Course course) {
		courses.add(course);
	}
	public void removeCourse(Course course) {
		courses.remove(course);
	}
	
	public void printAllCourses() {
		for (Course c : courses) {
		
			System.out.println("Course name: "+c.getName());
			System.out.println("Course code: "+ c.getCourseCode()+"\n");
		
		
		ArrayList<Participant> participants=c.getParticipants();
		System.out.println("Participants: ");
		for(Participant p:participants)
			System.out.println("\n Name: "+p.getName()+"\n Age: "+ p.getAge()+"\n Id: "+p.getId()+"\n");
		}
	}
}
