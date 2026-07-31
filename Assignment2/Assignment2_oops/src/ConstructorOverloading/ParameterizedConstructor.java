package ConstructorOverloading;

/*A parameterized constructor that initializes the product details.
Write a method displayProduct() to print product details.
Create both types of objects in the main method.*/

class Product1{
	int productId;
	String productName;
	int price;
	
	Product1(){
		System.out.println("Product created");
	}
	
	Product1(int productId, String productName, int price){
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		
	}
	
	void displayProduct() {
		System.out.println("Product Id: " + productId);
		System.out.println("Product Name: " + productName);
		System.out.println("Price: " + price);
	}
	
}

public class ParameterizedConstructor {
	public static void main(String[] args) {
		
		Product1 obj = new Product1();
		obj.displayProduct();
		
		Product1 obj1 = new Product1(45, "Rice", 564);
		obj1.displayProduct();
		
		
		
	}

}
