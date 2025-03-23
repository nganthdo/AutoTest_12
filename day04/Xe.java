package day04;

public class Xe {

	private String TenXe;
	private String LoaiXe;
	private int VanTocMax;

	public static void main(String[] args) {
		

	}
	
	public Xe(String tenxe, String loaixe, int vantocmax) {
		this.TenXe = tenxe;
		this.LoaiXe = loaixe;
		this.VanTocMax = vantocmax;
		
	}

	public String getTenXe() {
		return TenXe;
	}

	public void setTenXe(String tenXe) {
		TenXe = tenXe;
	}

	public String getLoaiXe() {
		return LoaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		LoaiXe = loaiXe;
	}

	public int getVanTocMax() {
		return VanTocMax;
	}

	public void setVanTocMax(int vanTocMax) {
		VanTocMax = vanTocMax;
	}
	
	public void thongtin() {
		System.out.println("Tên xe: " +TenXe + ", Loại xe: "+LoaiXe + ", Vận tốc max: "+VanTocMax);
		
	}

}
