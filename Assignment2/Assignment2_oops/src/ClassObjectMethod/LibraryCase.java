package ClassObjectMethod;


/*Create a class Library with an instance variable libraryName.
Create a default constructor to print "Welcome to the Library!".
Create a method showLocation() which prints "This library is located in Mumbai".
Create an object in main() and call both.*/


class Library{
	String libraryName;
	Library(){
		System.out.println("Welcome to the Library!");
	}
	
	void showLocation() {
		System.out.println("This library is located in Mumbai");
	}
}


public class LibraryCase {

	public static void main(String[] args) {
		Library obj = new Library();
		obj.showLocation();
	}

}


/*
 * output:
 * 
 * Welcome to the Library! This library is located in Mumbai
 */