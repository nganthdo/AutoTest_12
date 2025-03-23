package day05;

public class HinhTron extends HinhHoc {
	public int banKinh;

	public HinhTron(String tenHinh, int banKinh) {
		// TODO Auto-generated constructor stub
		super(tenHinh);
		this.banKinh = banKinh;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tinhDienTich() {
		// TODO Auto-generated method stub
		double dientich_hinhtron = 2*3.14*banKinh;
		System.out.println("Diện tích " + getTenHinh() + " là: " +dientich_hinhtron);
	}

}
