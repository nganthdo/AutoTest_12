package day05;

public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HinhTron hinhTron = new HinhTron("Hình Tròn", 3);
		System.out.println("Tên Hình: " +hinhTron.getTenHinh());
		hinhTron.tinhDienTich();
		
		HinhVuong hinhVuong = new HinhVuong("Hình Vuông", 3);
		System.out.println("Tên Hình: " +hinhVuong.getTenHinh());
		hinhVuong.tinhDienTich();

	}

}
