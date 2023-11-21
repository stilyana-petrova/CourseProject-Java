import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//Objects
		Course javaCourse=new Course("Java Course", "java1");
		Course mathCourse=new Course("Math", "m123");
		
		Student firstStudent=new Student("Peter Petrov", 23, 230132201);
		firstStudent.addGrade(6);
		firstStudent.addGrade(5);
		
		Student secondStudent=new Student("Raya Ivanova", 20, 230132202);
		secondStudent.addGrade(4);
		secondStudent.addGrade(6);
		
		//reads the information for the third student from user input
		/*
		System.out.println("Enter the name of the third student: ");
		String name = scanner.nextLine();
		System.out.println("Enter the age of the third student: ");
		int age = scanner.nextInt();
		System.out.println("Enter the id of the third student: ");
		int id=scanner.nextInt();
		Student thirdStudent=new Student(name, age, id);
		*/
		
		//asks if we want to add new instructor, if yes then creates new object and adds the new instructor in java course :)
		/*
		System.out.println("Do you want to add new Instructor?");
		String input=scanner.next();
		if(input.equals("yes")) {
			System.out.println("Enter the last name of the third instructor: ");
			String name3 = scanner.next();
			System.out.println("Enter the age of the third instructor: ");
			int age3 = scanner.nextInt();
			System.out.println("Enter the id of the third instructor: ");
			int id3=scanner.nextInt();
			Instructor instructor3=new Instructor(name3, age3, id3);
			javaCourse.addParticipant(instructor3);
		}
		else {
			System.out.println("Ok, here is the information: ");
		}
		*/
		
		Instructor instructor1=new Instructor("Prof. Stefanov", 34, 01);
		instructor1.addSubject("Java");
		
		Instructor instructor2=new Instructor("Prof. Metodieva", 45, 02);
		instructor2.addSubject("Math");
		
		javaCourse.addParticipant(instructor1);
		javaCourse.addParticipant(firstStudent);		
		javaCourse.addParticipant(secondStudent);
		//javaCourse.addParticipant(thirdStudent);

		mathCourse.addParticipant(instructor2);
		mathCourse.addParticipant(firstStudent);
		//mathCourse.addParticipant(thirdStudent);

		
		CourseManager cm=new CourseManager();
		cm.addCourse(javaCourse);
		cm.addCourse(mathCourse);
		
		cm.printAllCourses();
		
		
		scanner.close();
	}

}
