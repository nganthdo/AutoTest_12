package day04;

public class XeTaxi extends Xe {

	public XeTaxi(String tenxe, String loaixe, int vantocmax) {
		// TODO Auto-generated constructor stub
		super(tenxe, loaixe, vantocmax);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xe taxi = new Xe("XanhSM", "Xe Điện", 190);
		taxi.thongtin();

	}

}
