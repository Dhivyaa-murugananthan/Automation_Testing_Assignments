package SchoolOverloadingExample;

/*create name, address,strength as their instance variables 
Create two constructor one with two variables and one with all the three variables 
Create a method that will display all the three parameters 
create two object of this class and call the respective methods */

class School {
    String name;
    String address;
    int strength;

    School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    School(String name, String address, int strength) {
        this.name = name;
        this.address = address;
        this.strength = strength;
    }

    void displayDetails() {
        System.out.println("School Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Strength: " + strength);
    }
}

public class SchoolOverloadingCase {
    public static void main(String[] args) {
        School obj = new School("DPS", "Kolkata");
        obj.displayDetails();

        School obj1 = new School("IIT School", "Delhi", 1200);
        obj1.displayDetails();
    }
}
