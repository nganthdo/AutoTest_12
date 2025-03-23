package day05;

public class HinhVuong extends HinhHoc {
	public int chieuDaiMotCanh;

	public HinhVuong(String tenHinh, int chieuDaiMotCanh) {
		// TODO Auto-generated constructor stub
		super(tenHinh);
		this.chieuDaiMotCanh = chieuDaiMotCanh;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tinhDienTich() {
		// TODO Auto-generated method stub
		double dientich_hinhvuong = 4*chieuDaiMotCanh;
		System.out.println("Diện tích " + getTenHinh() +" là: " +dientich_hinhvuong);
		
	}

}
