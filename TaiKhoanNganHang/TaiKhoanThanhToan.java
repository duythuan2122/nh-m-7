package TaiKhoanNganHang;

public class TaiKhoanThanhToan extends TaiKhoan{
    private double hanMucThauChi;
    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, String matKhau, double soDu, double hanMucThauChi) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, soDu);
        this.hanMucThauChi = hanMucThauChi;
    }
    
    public double setHanMuc(){
        return hanMucThauChi;
    }
    
    public void getHanMuc (double hanmuc) {
	this.hanMucThauChi = hanmuc;
    }
    
    public void thanhToan(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Thanh toan thanh cong! So du: " + soDu);
        } else {
            System.out.println("So du khong du!");
        }
    }
    
//    @Override
//    public void napTien(double soTien) {
//        while (true) {
//            if (soTien >= 0 && soTien <= soDu) {
//                soDu += soTien;
//                System.out.println("Gui tien thanh cong! So du: " + soDu + " VND");
//                break;
//            } 
//            else {
//                System.out.println("So tien gui khong hop le!");
//                break;
//            }
//        }
//        soDu-= soTien;
//    }

    @Override
    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= (soDu + hanMucThauChi)) {
            soDu -= soTien;
            System.out.println("Rut tien thanh cong! So du: " + soDu);
        } else {
            System.out.println("So tien rut khong hop le!");
        }
    }
}
