package EncapsulationGetterSetter;

//Create an object in the main method and assign values using setters then display them.
class Program3{
	private int empId;
	private String empName;
	private int salary;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	//creating method to display details
	
	public void displayDetails() {
		System.out.println("Employee ID is: " + empId);
		System.out.println("Employee Name is: " + empName);
		System.out.println("Employee Salary is: " + salary);
	}
	
	
}


public class CreateObjectInMainMethod {

	public static void main(String[] args) {
		Program2 obj = new Program2();
		obj.setEmpId(2123);
		obj.setEmpName("Dhivyaa");
		obj.setSalary(80000);
		
		obj.displayDetails();

	}

}
