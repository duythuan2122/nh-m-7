package TaiKhoanNganHang;
import java.util.Scanner;

public class Main_taikhoan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so tai khoan:");
        String soTaiKhoan = sc.nextLine();
        System.out.println("Nhap ten tai khoan:");
        String chuTaiKhoan = sc.nextLine();
        System.out.println("Nhap mat khau:");
        String matKhau = sc.nextLine();
        System.out.println("Nhap so du:");
        double soDu = sc.nextDouble();
        System.out.println("Nhap han muc thau chi:");
        double hanMucThauChi = sc.nextDouble();
        TaiKhoan taiKhoan = new TaiKhoan(soTaiKhoan, chuTaiKhoan, matKhau, soDu);
        TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(soTaiKhoan, chuTaiKhoan, matKhau, soDu);
        TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(soTaiKhoan, chuTaiKhoan, matKhau, soDu, hanMucThauChi);
        int luaChon;
        do {
            System.out.println("\n--- Chon ---");
            System.out.println("1. Gui tien");
            System.out.println("2. Rut tien");
            System.out.println("3. Doi mat khau");
            System.out.println("4. Kiem tra so du");
            System.out.println("5. Gui tiet kiem");
            System.out.println("6. Rut tien tu tai khoan tiet kiem");
            System.out.println("7. Thanh toan");
            System.out.println("8. Rut tien tu tai khoan thanh toan");
            System.out.println("9. Thoat");
            System.out.print("Lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); 
            switch (luaChon) {
                case 1:
                    System.out.println("Ban muon gui:");
                    double soTienGui = scanner.nextDouble();
                    taiKhoan.napTien(soTienGui);
                    break;
                case 2:
                    System.out.println("Ban muon rut:");
                    double soTienRut = scanner.nextDouble();
                    taiKhoan.rutTien(soTienRut);
                    break;
                case 3:
                    System.out.println("Mat khau cu:");
                    String matKhauCu = sc.nextLine();
                    System.out.println("Mat khau moi:");
                    String matKhauMoi = sc.nextLine();
                    taiKhoan.doiMatKhau(matKhauCu, matKhauMoi);
                    break;
                case 4:
                    taiKhoan.kiemTraSoDu();
                    break;
                case 5:
                    tkTietKiem.nhapThongTinGuiTien();
                    tkTietKiem.hienThiThongTin();
                    break;
                case 6:
                    tkTietKiem.kiemTraSoDuTK();
                    System.out.print("Nhap so tien muon rut tu tai khoan tiet kiem: ");
                    double soTienRutTietKiem = scanner.nextDouble();
                    tkTietKiem.rutTien(soTienRutTietKiem);
                    break;
                case 7:
//                    System.out.print("Nhap so tien muon nap: ");
//                    double napTT = scanner.nextDouble();
//                    tkThanhToan.napTien(napTT);
                    System.out.print("Nhap so tien can thanh toan: ");
                    double soTienThanhToan = scanner.nextDouble();
                    tkThanhToan.thanhToan(soTienThanhToan);
                    break;
                case 8:
                    System.out.print("Nhap so tien muon rut tu tai khoan thanh toan: ");
                    double soTienRutThanhToan = scanner.nextDouble();
                    tkThanhToan.rutTien(soTienRutThanhToan);
                    break;
                case 9:
                    System.out.println("Hen gap lai!");
                    break;
                default:
                    System.out.println("Loi!");
            }
        } while (luaChon != 9);
    }
}
