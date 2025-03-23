package day05;

public abstract class HinhHoc {
	private String tenHinh;

	public HinhHoc(String tenHinh) {
		// TODO Auto-generated constructor stub
		this.tenHinh = tenHinh;
	}

	public String getTenHinh() {
		return tenHinh;
	}

	public void setTenHinh(String tenHinh) {
		this.tenHinh = tenHinh;
	}
	
	public abstract void tinhDienTich();
		
	

}
