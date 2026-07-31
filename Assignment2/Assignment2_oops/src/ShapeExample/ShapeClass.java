/*Create a class Mall with:

Default constructor printing "Welcome to the Mall"

Parameterized constructor calling default constructor using this()
Demonstrate constructor chaining in main.
*/
package ShapeExample;

class Shape {
    int length;

    Shape(int length) {
        this.length = length;
    }

    void square() {
        int area = length * length;
        System.out.println("Area of Square: " + area);
    }

    void rectangle(int breadth) {
        int area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }

    void circle() {
        double area = Math.PI * length * length;
        System.out.println("Area of Circle: " + area);
    }
}

public class ShapeClass {
    public static void main(String[] args) {
        Shape s = new Shape(5);
        s.square();
        s.rectangle(10);
        s.circle();
    }
}
