package HierarchialInheritance;

/*Create a class Course with a method courseInfo().
Create subclasses Science, Commerce, and Arts each with their own method.
Create objects of each and call methods to show hierarchy.*/

class Course {
	void courseInfo() {
		System.out.println("The Basic info of course is as given");
	}
}

class Science extends Course{
	void scienceInfo() {
		super.courseInfo();
		System.out.println("Students aiming for engineering and medicine can take up this course");
	}
}

class Commerce extends Course{
	void commerceInfo() {
		super.courseInfo();
		System.out.println("Students aiming for banking sectors and fintech companies can take up this course");
	}
}

class Arts extends Course{
	void artsInfo() {
		super.courseInfo();
		System.out.println("Students with creative mind can take up this course");
	}
}

public class Hierrarchy {
	public static void main(String[] args) {
		Science obj = new Science();
		Commerce obj1 = new Commerce();
		Arts obj2 = new Arts();
		
		obj.scienceInfo();
		System.out.println("\n");
		obj1.commerceInfo();
		System.out.println("\n");
		obj2.artsInfo();
}
}

/*
 * output: 
 * The Basic info of course is as given 
 * Students aiming for engineering and medicine can take up this course
 * 
 * 
 * The Basic info of course is as given 
 * Students aiming for banking sectors and fintech companies can take up this course
 * 
 * 
 * The Basic info of course is as given 
 * Students with creative mind can take up this course
 */
