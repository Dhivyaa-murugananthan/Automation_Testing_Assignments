package AbstractionAbstractClass;

/*Create an abstract class Animal with an abstract method sound().
Create two subclasses Dog and Cat and provide implementation for sound() method.
Create objects and call sound() for each.*/

abstract class Animal{
	abstract void sound();
}

class Dog extends Animal{
	void sound() {
		System.out.println("Dog barks");
	}
	
}

class Cat extends Animal{
	void sound() {
		System.out.println("Cat sounds meow");
	}
}

public class AbstractClassAnimal {
	public static void main(String[] args) {
		
		Dog obj = new Dog();
		obj.sound();
		
		Cat obj2 = new Cat();
		obj2.sound();
		
	}

}

/*
 * output Dog barks 
 * Cat sounds meow
 */