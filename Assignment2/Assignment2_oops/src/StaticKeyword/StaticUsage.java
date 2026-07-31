package StaticKeyword;

/*Create a class Student having static variable collegeName and instance variables name and rollNo.
Write a method to print both static and instance data.
Create multiple objects to show static value remains constant.
*/

class Student{
	static String collegeName = "IIT Madras";
	String name;
	int rollNo;
	
	Student (String name, int rollNo){
		
		this.name= name;
		this.rollNo= rollNo;
		
	}
	
	void display() {
		System.out.println("The college name is: " + collegeName);
		System.out.println("Student name is: " + name);
		System.out.println("Student roll no is: " + rollNo);
	}
}

public class StaticUsage {
	public static void main(String[] args) {
		//college name remains constant
		Student obj = new Student("Dhivyaa", 21047);
		Student obj1 = new Student("Dharshini", 21046);
		obj.display();
		obj1.display();
		
		//only after changing the college name it will change
		Student.collegeName = "IIT Delhi";
		Student obj2 = new Student("Janani", 21057);
		
		obj2.display();
	}

}

/*
 * output: 
 * The college name is: IIT Madras 
 * Student name is: Dhivyaa 
 * Student roll no is: 21047 
 * 
 * The college name is: IIT Madras 
 * Student name is: Dharshini
 * Student roll no is: 21046 
 * 
 * The college name is: IIT Delhi
 * Student name is:Janani 
 * Student roll no is: 21057
 */

