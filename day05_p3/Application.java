package day05_p3;

import java.util.Scanner;

import java.util.ArrayList;

public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enterInfo();

	}

	public static void enterInfo() {

		Scanner scanner = new Scanner(System.in);

		ArrayList<Employee> employees = new ArrayList<>();
		System.out.println("Enter the number of employees: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter employee department (1-Developer, 2-Tester, 3-BA): ");
		int type = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("Enter employee id");
			int emp_id = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter employee name");
			String emp_name = scanner.nextLine();

			System.out.println("Enter employee phone");
			String emp_phone = scanner.nextLine();

			switch (type) {
			case 1:
				System.out.println("Enter developer skill: ");
				String emp_skill = scanner.nextLine();
				Developer dev = new Developer(emp_id, emp_name, emp_phone, emp_skill);
				employees.add(dev);
				break;
			case 2: 
				System.out.println("Enter tester level: ");
				String emp_level = scanner.nextLine();
				Tester tester = new Tester(emp_id, emp_name, emp_phone, emp_level);
				employees.add(tester);
				break;
			case 3:
				System.out.println("Enter BA Domain: ");
				String emp_domain = scanner.nextLine();
				BA ba = new BA(emp_id, emp_name, emp_phone, emp_domain);
				employees.add(ba);
				break;
			default:
				System.out.println("Invalid Department");
				break;
				
			} 

		}
		System.out.println("Employees List: ");
		for (Employee e : employees) {
			e.displayInfo();

		}
		scanner.close();

	}

}
