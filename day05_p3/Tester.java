package day05_p3;

public class Tester extends Employee {
	private String tester_level;

	public Tester(int employee_id, String employee_name, String employee_phone, String tester_level) {
		// TODO Auto-generated constructor stub
		super(employee_id, employee_name, employee_phone);
		this.tester_level = tester_level;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getTester_level() {
		return tester_level;
	}

	public void setTester_level(String tester_level) {
		this.tester_level = tester_level;
	}

	@Override
	public void displayInfo() {
		System.out.println("Employee Id: " + employee_id + ", Employee Name: " + employee_name + ", Employee Phone: "
				+ employee_phone + "Tester Level: " + tester_level);
	}

}
