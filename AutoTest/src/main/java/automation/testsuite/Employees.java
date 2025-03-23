package automation.testsuite;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Employees {

	@Test
	public void enterEmployeeName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of employees: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		String[] danhsachNv = new String[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter employee name: ");
			danhsachNv[i] = scanner.nextLine();
		}

		System.out.println("Employee name list: ");
		for (String name : danhsachNv) {

			System.out.println("-" + name);
		}

		scanner.close();

	}

}
