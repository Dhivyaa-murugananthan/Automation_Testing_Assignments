package StaticConcepts;

/*Create a class University with:

static variable country = "India"

instance variable universityName
Print values using different objects to show static effect.*/


class University {
    static String country = "India";
    String universityName;

    University(String universityName) {
        this.universityName = universityName;
        System.out.println("The university " + universityName + " is in " + country);
    }
}

public class UniversityCase {
    @SuppressWarnings("static-access")
	public static void main(String[] args) {
        University obj1 = new University("LPU");
        University obj2 = new University("IIT Madras");

        // Demonstrating static effect
        System.out.println("Country for obj1: " + obj1.country);
        System.out.println("Country for obj2: " + obj2.country);

        // Change static variable
        University.country = "USA";

        System.out.println("\nAfter changing country:");
        System.out.println("Country for obj1: " + obj1.country);
        System.out.println("Country for obj2: " + obj2.country);
    }
}
