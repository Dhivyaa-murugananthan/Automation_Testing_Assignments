package EncapsulationGetterSetter;
//Create a class named Employee with private instance variables empId, empName, and salary.
//Provide public getters and setters for all variables.


class Program1{
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
	
	
	
}

public class EmployeePrivateInstance {

	public static void main(String[] args) {
		
		Program1 obj = new Program1();
		
		obj.setEmpId(21312);
		System.out.println(obj.getEmpId());
		
		obj.setEmpName("Dhivyaa");
		System.out.println(obj.getEmpName());
		
		obj.setSalary(80000);
		System.out.println(obj.getSalary());
		

	}

}
