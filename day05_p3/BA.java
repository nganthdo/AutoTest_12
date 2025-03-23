package day05_p3;

public class BA extends Employee {
	private String ba_domain;

	public BA(int employee_id, String employee_name, String employee_phone, String ba_domain) {
		// TODO Auto-generated constructor stub
		super(employee_id, employee_name, employee_phone);
		this.ba_domain = ba_domain;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getBa_domain() {
		return ba_domain;
	}

	public void setBa_domain(String ba_domain) {
		this.ba_domain = ba_domain;
	}

	@Override
	public void displayInfo() {
		System.out.println("Employee Id: " + employee_id + ", Employee Name: " + employee_name + ", Employee Phone: "
				+ employee_phone + ", BA Domain: " + ba_domain);
	}

}
