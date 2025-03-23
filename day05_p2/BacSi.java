package day05_p2;

public class BacSi {

	private double luongCoBan = 19000000;

	public BacSi() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 2 tham số truyền vào (lương cơ bản * hệ số lương)
	public double tinhLuong(double heSoLuong) {
		return luongCoBan * heSoLuong;

	}

	// 3 tham số truyền vào (lương cơ bản * hệ số lương * số năm kinh nghiệm)
	public double tinhLuong(double heSoLuong, double soNamKinhNghiem) {
		return luongCoBan * heSoLuong * soNamKinhNghiem;

	}

	// 4 tham số truyền vào (lương cơ bản * hệ số lương * số năm kinh nghiệm * loại)
	public double tinhLuong(double heSoLuong, double soNamKinhNghiem, int loai) {
		double heSoLoai = 1;
		if (loai == 1) {
			heSoLoai = 1.2;
		} else if (loai == 2) {
			heSoLoai = 1.45;
		}
		return luongCoBan * heSoLuong * soNamKinhNghiem * heSoLoai;

	}

}
