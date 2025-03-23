package day05_p2;

public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BacSi bacSi = new BacSi();

		// tính lương với 2 tham số
		System.out.printf("Tính Lương với hệ số 2: " + (long) bacSi.tinhLuong(2));

		// tính lương với 3 tham số
		System.out.printf("\nTính Lương với hệ số 2, 3 năm kinh nghiệm: " + (long) bacSi.tinhLuong(2, 3));

		// tính lương với 4 tham số
		System.out.printf("\nTính Lương với hệ số 2, 3 năm kinh nghiệm, loại 1: " + (long) bacSi.tinhLuong(2, 3, 1));
		System.out.printf("\nTính Lương với hệ số 2, 5 năm kinh nghiệm, loại 2: " + (long) bacSi.tinhLuong(2, 5, 2));


	}

}
