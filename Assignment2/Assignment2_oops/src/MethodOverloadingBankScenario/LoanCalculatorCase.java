package MethodOverloadingBankScenario;

/*Create a class LoanCalculator with two overloaded methods:

calculateLoan(int amount)

calculateLoan(int amount, double interestRate)
Print loan details accordingly. Call both methods from main.*/

class LoanCalculator{
	//int amount;
	void calculateLoan(int amount) {
		System.out.println("The amount without interest to repay the loan is " + amount);
	}
	
	void calculateLoan(int amount, double interestRate) {
	
		System.out.println("The amount with interest to repay the loan is:  " + (amount+interestRate));
	}
}

public class LoanCalculatorCase {
	public static void main(String[] args) {
		LoanCalculator obj = new LoanCalculator();
		obj.calculateLoan(600000);
		obj.calculateLoan(600000, 6000);
	}
}

/*
 * output: 
 * The amount without interest to repay the loan is 600000 
 * The amount with interest to repay the loan is: 606000.0
 */