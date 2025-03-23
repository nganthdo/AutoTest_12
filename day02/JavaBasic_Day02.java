package day02;

import java.util.Scanner;

public class JavaBasic_Day02 {

	public static void main(String[] args) {
		tinhtong();

	}

	public static void tinhtong() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số lượng phần tử của mảng: ");
		int n = scanner.nextInt();

		System.out.println("Nhập giá trị phần tử: ");
		int[] danhsach = new int[n];

		for (int i = 0; i < n; i++) {
			danhsach[i] = scanner.nextInt();
		}
		int tong = 0;
		for (int i = 0; i < danhsach.length; i++) {
			tong += danhsach[i];

		}
		System.out.println("Tổng mảng là: " + tong);
		
		scanner.close();

	}

}
