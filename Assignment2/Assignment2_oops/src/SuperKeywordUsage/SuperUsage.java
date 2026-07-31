package SuperKeywordUsage;

/*Create a class Person with a constructor that prints "Person Created".
Create a subclass Student that calls the parent constructor using super() and prints "Student Created".
Create an object and observe the order of execution.*/


class Person{
	Person(){
		System.out.println("Person Created");
	}
}

class Student extends Person{
	Student(){
		super();
		System.out.println("Student Created");
	}
	
}


public class SuperUsage {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Student obj = new Student();
		

	}

}
