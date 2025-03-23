package day05_p3;

public class Developer extends Employee {
	String developer_skill;

	public Developer(int employee_id, String employee_name, String employee_phone, String developer_skill) {
		// TODO Auto-generated constructor stub
		super(employee_id, employee_name, employee_phone);
		this.developer_skill = developer_skill;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getDeveloper_skill() {
		return developer_skill;
	}

	public void setDeveloper_skill(String developer_skill) {
		this.developer_skill = developer_skill;
	}

	@Override
	public void displayInfo() {
		System.out.println("Employee Id: " + employee_id + ", Employee Name: " + employee_name + ", Employee Phone: "
				+ employee_phone + ", Developer Skill: " + developer_skill);
	}

}
