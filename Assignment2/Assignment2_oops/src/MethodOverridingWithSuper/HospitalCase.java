package MethodOverridingWithSuper;

/*Create a base class Hospital with a method emergencyService().
Create a subclass CityHospital that overrides the method and calls parent method using super.emergencyService().
Demonstrate overriding in main.*/

class Hospital{
	void emergencyService() {
		System.out.println("the univeral Emergency Service Line is: 108");
	}
}

class CityHospital extends Hospital{
	void emergencyService() {
		super.emergencyService();
		System.out.println("The emergency service line for KMCH hospital is: 2567-413");
	}
}

public class HospitalCase {

	public static void main(String[] args) {
		CityHospital obj = new CityHospital();
		obj.emergencyService();
		
		
		//Polymorphism concept
		Hospital ref = new CityHospital();
		ref.emergencyService();
	}

}
