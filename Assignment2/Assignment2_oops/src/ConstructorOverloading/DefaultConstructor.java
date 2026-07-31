package ConstructorOverloading;

/*Create a class Product having instance variables productId, productName, and price.
Implement:

A default constructor that prints "Product Created".*/

class Product{
	int productId;
	String productName;
	int price;
	
	void display() {
		System.out.println("Product Id: " + productId);
		System.out.println("Product Name: " + productName);
		System.out.println("Price: " + price);
	}
	
}

public class DefaultConstructor {
	public static void main(String[] args) {
		Product obj = new Product();
		obj.display();
		
	}

}

//output
/*
 * Product Id: 0 
 * Product Name: null 
 * Price: 0
 */

