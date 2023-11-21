
public class Participant {
	//fields
	private String name;
	private int age;
	private int id;
	
	//ctor
	public Participant(String name, int age, int id) {
		this.name=name;
		this.age=age;
		this.id=id;
	}

	//getters and setters
	public String getName() {
	    return name;
	  }
	  public void setName(String newName) {
	    this.name = newName;
	  }
	  
	  
	  
	  public int getAge() {
		  return age;
	  }
	  public void setAge(int newAge) {
		  this.age=newAge;
	  }
	  
	  
	  public int getId() {
		  return id;
	  }
	  public void setId(int newId) {
		  this.id=newId;
	  }
}
