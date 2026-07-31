/*Create a Class named Shape with length as instance variable  , 
 * create three methods as square , rectangle , circle 
and find out their respective areas 
Create a object in main method and call these different methods with the instance of object */

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
