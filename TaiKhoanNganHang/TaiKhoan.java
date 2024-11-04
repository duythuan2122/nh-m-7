package TaiKhoanNganHang;

public class TaiKhoan {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected String matKhau;
    protected double soDu;

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, String matKhau, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.matKhau = matKhau;
        this.soDu = soDu;
    }

    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Nap tien thanh cong! So du: " + soDu);
        } else {
            System.out.println("So tien nap khong hop le!");
        }
    }

    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rut tien thanh cong! So du: " + soDu);
        } else {
            System.out.println("So tien rut khong hop le.");
        }
    }

    public void kiemTraSoDu() {
        System.out.println("So du: " + soDu);
    }

    public void doiMatKhau(String matKhauCu, String matKhauMoi) {
        if (this.matKhau.equals(matKhauCu)) {
            this.matKhau = matKhauMoi;
            System.out.println("Doi mat khau thanh cong!");
        } else {
            System.out.println("Mat khau cu khong chinh xac!");
        }
    }
}
