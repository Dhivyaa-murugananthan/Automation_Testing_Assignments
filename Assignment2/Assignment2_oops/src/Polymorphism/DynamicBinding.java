package Polymorphism;

class Shape{
	void area() {
		System.out.println("Calculate the are using appropriate formula");
	}
}

class Rectangle extends Shape{
	
	int l;
	int b;
	
	Rectangle(int l, int b){
		this.l=l;
		this.b=b;
	}
	@Override
	void area() {
		int area_of_rectangle = l*b;
		System.out.println("Area of Rectangle is :" + area_of_rectangle );
	}
}

class Circle extends Shape{
	int r;
	
	Circle(int r){
		this.r=r;
	}
	@Override
	void area() {
		double area_of_circle = Math.PI*Math.sqrt(r);
		System.out.println("Area of Circle is : " + area_of_circle);
	}
}

public class DynamicBinding {
	public static void main(String[] args) {
		Shape ref;
		
		ref = new Rectangle(2,5);
		ref.area();
		
		ref = new Circle(67);
		ref.area();
	}

}


/*
 * output Area of Rectangle is :10 
 * Area of Circle is : 25.71504413515534
 */