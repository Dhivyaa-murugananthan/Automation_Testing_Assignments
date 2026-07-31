package InheritanceAndMethodOverriding;
/*Create a base class Vehicle with a method fuelType() which prints "Runs on fuel".
Create a child class ElectricCar and override the fuelType() method to print "Runs on electricity".
Create objects of both classes and call their respective methods.*/


//Base class
class Vehicle{
		void fuelType() {
			System.out.println("Runs on fuel");
		}
	}
	

//Child class
class ElectricCar extends Vehicle{
	    
		void fuelType() {
			System.out.println("Runs on electricity");
			super.fuelType();
		}
	}

public class BaseClass {

	public static void main(String[] args) {
		
		Vehicle obj = new Vehicle();
		obj.fuelType();
		ElectricCar obj1 = new ElectricCar();
		obj1.fuelType();
		
		
		
		

	}

}
