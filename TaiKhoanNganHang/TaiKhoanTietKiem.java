package TaiKhoanNganHang;
import java.util.Scanner;

public class TaiKhoanTietKiem extends TaiKhoan {
    private int soThangGui;
    public double laiSuat; 
    private double soTienGui;
    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, String matKhau, double soDu) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, soDu);
        this.soTienGui = 0;
        this.laiSuat = 0.05;
    }
    
     public void nhapThongTinGuiTien() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so tien muon gui (VND):");
        this.soTienGui = scanner.nextDouble();
        System.out.println("Ky gui trong bao lau (thang):");
        this.soThangGui = scanner.nextInt();
    }
    
    public double tinhLaiSuat() {
        double laiSuatThang = laiSuat / 12;
        double soTienLai = soTienGui * Math.pow(1 + laiSuatThang, soThangGui) - soTienGui;
        return soTienLai;
    }

    public void hienThiThongTin() {
        System.out.println("So tien gui: " + soTienGui + " VND");
        System.out.println("Ky gui: " + soThangGui + "thang");
        System.out.println("Lai suat: " + (laiSuat * 100) + "% moi nam");
        System.out.println("So tien lai sau " + soThangGui + " thang: " + tinhLaiSuat() + " VND");
        System.out.println("Tong so tien nhan duoc: " + (soTienGui + tinhLaiSuat()) + " VND");
    }
    
   @Override
    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soTienGui) {
            soTienGui -= soTien;
            System.out.println("Rut thanh cong! So du: " + soTienGui);
        } else {
            System.out.println("So tien rut khong hop le!");
        }
    }
    
    public void kiemTraSoDuTK() {
        System.out.println("So du: " + soTienGui + " VND");
    }
}
