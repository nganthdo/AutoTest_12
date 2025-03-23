package day02;

import java.util.Scanner;

public class ThucHanh_Day02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Kết quả phép tính là: " + pheptinh(1123, 6745, 500));
		solonhon();

	}

	public static double pheptinh(double a, double b, double c) {
		double ketqua = (a * b) / c;
		return ketqua;
	}

	public static void solonhon() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số a = ");
		double a = scanner.nextDouble();
		System.out.println("Nhập số b = ");
		double b = scanner.nextDouble();

		if (a > b) {
			System.out.println("Số lớn hơn là: " + a);
		} else {
			System.out.println("Số lớn hơn là: " + b);
		}

	}

}
