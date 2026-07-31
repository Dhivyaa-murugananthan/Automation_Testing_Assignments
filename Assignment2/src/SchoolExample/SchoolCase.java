package SchoolExample;

/*Create a class named school ,create name as their instance variables 
Create a default constructor of this class which will have a print statement to display the name of school 
Create a method inside the class which will display a message as "This School is based out of Kolkata"
Create a object under main method and call the constructor and the method */


class School {
    String name;

    School() {
        name = "DPS School";
        System.out.println("School Name: " + name);
    }

    void displayMessage() {
        System.out.println("This School is based out of Kolkata");
    }
}

public class SchoolCase {
    public static void main(String[] args) {
        School s = new School();
        s.displayMessage();
    }
}
