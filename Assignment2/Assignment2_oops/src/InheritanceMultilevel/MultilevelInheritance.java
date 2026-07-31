package InheritanceMultilevel;


/*Create three classes:

Device → method start()

Mobile extends Device → method calling()

SmartPhone extends Mobile → method internet()
Create object of SmartPhone and call all methods.*/

class Device{
	void start() {
		System.out.println("Your Device is set to use");
	}
}
class Mobile extends Device{
	void calling() {
		super.start();
		System.out.println("Insert sim to call person X");
	}
	
}

class SmartPhone extends Mobile{
	void internet() {
		super.calling();
		System.out.println("Requires Internet to access Google");
	}
	
}


public class MultilevelInheritance {

	public static void main(String[] args) {
		SmartPhone obj = new SmartPhone();
		obj.internet();
		/*
		 * instead of using super, you can also use --> obj.calling(); obj.start(); and generate the output.
		 */

	}

}
