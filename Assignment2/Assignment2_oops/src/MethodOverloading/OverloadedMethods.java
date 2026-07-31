package MethodOverloading;


/*Create a class Calculator with overloaded methods add():

add(int a, int b)

add(double a, double b)
Call both methods inside the main method and print results.*/

class Calculator{
	
	
		
	
	void add (int a, int b){
		int c = a+b;
		System.out.println("Addition of a and b is: "+ c );		
	}
	
	void add(double a, double b) {
		double d = a+b;
		System.out.println("Addition of a and b is: "+ d);
	}
}


public class OverloadedMethods {
	public static void main(String[] args) {
		Calculator obj = new Calculator();
		obj.add(7, 9);
		obj.add(34.5, 45.8);
	}

}
