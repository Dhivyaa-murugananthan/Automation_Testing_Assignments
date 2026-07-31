package ConstructorChainingExample;

/*Create a class Mall with:

Default constructor printing "Welcome to the Mall"

Parameterized constructor calling default constructor using this()
Demonstrate constructor chaining in main.*/


class Mall {
    Mall() {
        System.out.println("Welcome to the Mall");
    }

    Mall(String mallName) {
        this(); // calls default constructor
        System.out.println("Mall name is: " + mallName);
    }
}

public class MallCase {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
        Mall obj = new Mall();
        Mall obj1 = new Mall("Phoenix MarketCity");
    }
}
/*
 * output:
 * 
 * Welcome to the Mall 
 * Welcome to the Mall 
 * Mall name is: Phoenix MarketCity
 */