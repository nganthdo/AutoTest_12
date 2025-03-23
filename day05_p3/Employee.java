package day05_p3;

public class Employee {
	int employee_id;
	String employee_name;
	String employee_phone;

	public Employee(int employee_id, String employee_name, String employee_phone) {
		// TODO Auto-generated constructor stub
		this.employee_id = employee_id;
		this.employee_name = employee_name;

		this.employee_phone = employee_phone;
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

	public void displayInfo() {
		System.out.println("Employee Id: " + employee_id + ", Employee Name: " + employee_name + ", Employee Phone: "
				+ employee_phone);
	}

}
