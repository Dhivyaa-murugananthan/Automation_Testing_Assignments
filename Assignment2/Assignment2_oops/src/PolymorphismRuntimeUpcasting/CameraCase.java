package PolymorphismRuntimeUpcasting;

/*Create a class Camera with a method capture().
Create a subclass DSLCamera that overrides the method.
Use parent reference to call child object method (dynamic polymorphism).*/

class Camera{
	void capture() {
		System.out.println("camera captures pictures and videos");
		
	}
}

class DSLRCamera extends Camera{
	void capture() {
		System.out.println("DSLR Camera produces good quality pictures with standard pixels");
	}
}

public class CameraCase {
	public static void main(String[] args) {
		Camera ref = new DSLRCamera();
		ref.capture();
	}
}
/*
 * output:
 * 
 * DSLR Camera produces good quality pictures with standard pixels
 */