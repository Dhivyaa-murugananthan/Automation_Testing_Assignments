package EncapsulationValidLodic;

/*Create a class Account with private variables accountHolderName and balance.
Provide setters and getters, where:

setBalance() should not accept negative values (print a warning).
Create an object and update values through setters only.*/

class Account{
	private String accountHolderName;
	private int balance;
	
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		
		
		if(balance < 0) {
			System.out.println("WARNING: Negative balance is not allowed");
		} else {
			this.balance = balance;
		}
	}
	
}

public class AccountCaseStudy {

	public static void main(String[] args) {
		Account obj = new Account();
		obj.setAccountHolderName("Dhivyaa");
		System.out.println(obj.getAccountHolderName());
		
		obj.setBalance(4000);
		System.out.println(obj.getBalance());

	}

}

/*output: 
	case 1:
	Dhivyaa
	WARNING: Negative balance is not allowed
	0
	
	case 2:
	Dhivyaa
	4000*/