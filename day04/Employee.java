package day04;

public class Employee {
	private int employee_id;
	private String employee_name;
	private double employee_salary;

	public Employee(int employee_id, String employee_name, double employee_salary) {
		// TODO Auto-generated constructor stub
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_salary = employee_salary;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public double getEmployee_salary() {
		return employee_salary;
	}

	public void displayInfo() {
		System.out.println("EmployeeId: " + employee_id + ", EmployeeName: " + employee_name + ", EmployeeSalary: "
				+ employee_salary);
	}

}
