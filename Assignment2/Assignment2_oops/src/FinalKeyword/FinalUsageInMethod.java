package FinalKeyword;

/*Create a class Bank with a final variable IFSC and final method showIFSC().
Try creating a subclass HDFCBank and attempt overriding the final method (should show compile-time restriction).
Create a main method to demonstrate usage.*/

class Bank{
	static final String IFSC = "321Ec";
	
	static final String showIFSC(){
		return IFSC;
	}
	
}

class HDFCBank extends Bank{
	/*
	 * @Override static final String IFSC = "64RC13";
	 * 
	 * static final String showIFSC() { return IFSC; }
	 */
	
	
	/*
	 * output with error: Exception in thread "main" java.lang.Error: Unresolved compilation
	 * problem: Cannot override the final method from Bank
	 * 
	 * at Assignment2/FinalKeyword.HDFCBank.showIFSC(FinalUsageInMethod.java:20) at
	 * Assignment2/FinalKeyword.FinalUsageInMethod.main(FinalUsageInMethod.java:30)
	 */

}


public class FinalUsageInMethod {

	public static void main(String[] args) {
		
		System.out.println("Bank IFSC: " + Bank.showIFSC());
		System.out.println("HDFCBank (inherited): " + HDFCBank.showIFSC());
		

	}

}

/*
 * output without error 
 * Bank IFSC: 321Ec 
 * HDFCBank (inherited): 321Ec
 */
