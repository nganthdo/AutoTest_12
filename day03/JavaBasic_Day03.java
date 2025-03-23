package day03;

import java.util.Arrays;
import java.util.Scanner;

public class JavaBasic_Day03 {

	public static void main(String[] args) {

		kiemtraso();
		sapxepso();

	}

	public static void kiemtraso() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số phần tử của danh sách:");
		int n = scanner.nextInt();

		System.out.println("Nhập phần tử của danh sách:");
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			if (x % 2 == 0 && x % 3 == 0) {
				System.out.println("Điều kiện thoát xảy ra");
				break;
			}

		}
		//scanner.close();
	}

	public static void sapxepso() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số phần tử của danh sách:");
		int n = scanner.nextInt();

		int[] ds = new int[n];
		System.out.println("Nhập phần tử của danh sách:");
		for (int i = 0; i < n; i++) {
			ds[i] = scanner.nextInt();

		}
		System.out.println("Danh sách dãy số:" + Arrays.toString(ds));

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (ds[j] < ds[j+1]) {
					int temp = ds[j];
					ds[j] = ds[j + 1];
					ds[j + 1] = temp;
				}
			}
		}

		System.out.println("Danh sách sau khi sắp xếp dãy số:");
		for (int num : ds) {
			System.out.print(num + " ");
		}

		scanner.close();

	}

}
