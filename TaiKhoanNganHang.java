package com.mycompany.thlthdt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaiKhoanNganHang {

    // Lớp trừu tượng TaiKhoan
    abstract class TaiKhoan {

        protected String soTk;
        protected String chuTk;
        protected double soDu;
        private String matKhau;

        public TaiKhoan(String soTk, String chuTk, double soDu, String matKhau) {
            this.soTk = soTk;
            this.chuTk = chuTk;
            this.soDu = soDu;
            this.matKhau = matKhau;
        }

        // Phương thức gửi tiền
        public void guiTien(double soTien) {
            if (soTien > 0) {
                soDu += soTien;
                System.out.println("Gui tien thanh cong. So du hien tai: " + soDu);
            } else {
                System.out.println("So tien gui khong hop le.");
            }
        }

        // Phương thức kiểm tra số dư
        public double kiemTraSoDu() {
            return soDu;
        }

        // Phương thức trừu tượng rút tiền, sẽ được triển khai khác nhau ở các lớp con
        public abstract boolean rutTien(double soTien);

        public boolean taoTaiKhoan(Scanner sc, List<TaiKhoan> taiKhoans) {
            System.out.print("Nhap so tai khoan: ");
            soTk = sc.nextLine();

            // Kiểm tra tài khoản đã tồn tại
            for (TaiKhoan tk : taiKhoans) {
                if (tk.soTk.equals(soTk)) {
                    System.out.println("Tai khoan da ton tai. Vui long chon so tai khoan khac.");
                    return false;
                }
            }

            System.out.print("Nhap ten chu tai khoan: ");
            chuTk = sc.nextLine();
            System.out.print("Nhap mat khau: ");
            matKhau = sc.nextLine();
            System.out.print("Nhap so du ban dau: ");
            soDu = sc.nextDouble();
            sc.nextLine(); // Đọc dòng mới
            System.out.println("Tao tai khoan thanh cong!");
            return true;
        }

        // Phương thức đổi mật khẩu
        public void doiMatKhau(Scanner sc) {
            System.out.print("Nhap mat khau hien tai: ");
            String matKhauHienTai = sc.nextLine();
            if (matKhauHienTai.equals(matKhau)) {
                System.out.print("Nhap mat khau moi: ");
                String matKhauMoi = sc.nextLine();
                matKhau = matKhauMoi;
                System.out.println("Doi mat khau thanh cong.");
            } else {
                System.out.println("Mat khau hien tai khong dung.");
            }
        }

        // Phương thức in thông tin tài khoản
        public void inThongTin() {
            System.out.println("Thong tin tai khoan:");
            System.out.println("So tai khoan: " + soTk);
            System.out.println("Chu tai khoan: " + chuTk);
            System.out.println("So du: " + soDu);
        }
    }

    // Lớp TaiKhoanTietKiem
    class TaiKhoanTietKiem extends TaiKhoan {

        private double laiSuat;

        public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double laiSuat) {
            super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
            this.laiSuat = laiSuat;
        }

        @Override
        public boolean rutTien(double soTien) {
            if (soTien > 0 && soTien <= soDu) {
                soDu -= soTien;
                System.out.println("Rut tien thanh cong. So du con lai: " + soDu);
                return true;
            } else {
                System.out.println("So tien rut khong hop le hoac vuot qua so du hien co.");
                return false;
            }
        }

        @Override
        public boolean taoTaiKhoan(Scanner sc, List<TaiKhoan> taiKhoans) {
            if (!super.taoTaiKhoan(sc, taiKhoans)) {
                return false;
            }
            System.out.print("Nhap lai suat: ");
            laiSuat = sc.nextDouble();
            sc.nextLine();
            System.out.println("Tao tai khoan tiet kiem thanh cong.");
            return true;
        }
    }

    // Lớp TaiKhoanThanhToan
    class TaiKhoanThanhToan extends TaiKhoan {

        private double hanMucThauChi;

        public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double hanMucThauChi) {
            super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
            this.hanMucThauChi = hanMucThauChi;
        }

        @Override
        public boolean rutTien(double soTien) {
            if (soTien > 0 && soTien <= (soDu + hanMucThauChi)) {
                soDu -= soTien;
                System.out.println("Rut tien thanh cong. So du con lai: " + soDu);
                return true;
            } else {
                System.out.println("So tien rut vuot qua han muc cho phep.");
                return false;
            }
        }

        @Override
        public boolean taoTaiKhoan(Scanner sc, List<TaiKhoan> taiKhoans) {
            if (!super.taoTaiKhoan(sc, taiKhoans)) {
                return false;
            }
            System.out.print("Nhap han muc thau chi: ");
            hanMucThauChi = sc.nextDouble();
            sc.nextLine();
            System.out.println("Tao tai khoan thanh toan thanh cong.");
            return true;
        }
    }

    // Hàm main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        TaiKhoan taiKhoanDangNhap = null;

        int chon;
        do {
            System.out.println("------ Menu ------");
            System.out.println("1. Tao tai khoan");
            System.out.println("2. Dang nhap");
            System.out.println("3. Gui tien");
            System.out.println("4. Rut tien");
            System.out.println("5. Kiem tra so du");
            System.out.println("6. Doi mat khau");
            System.out.println("7. In thong tin");
            System.out.println("8. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.println("Chon loai tai khoan:");
                    System.out.println("1. Tai khoan tiet kiem");
                    System.out.println("2. Tai khoan thanh toan");
                    int loaiTk = sc.nextInt();
                    sc.nextLine();

                    if (loaiTk == 1) {
                        TaiKhoanTietKiem tkTietKiem = new TaiKhoanNganHang().new TaiKhoanTietKiem("", "", 0, "", 0);
                        if (tkTietKiem.taoTaiKhoan(sc, taiKhoans)) {
                            taiKhoans.add(tkTietKiem);
                        }
                    } else if (loaiTk == 2) {
                        System.out.print("Nhap han muc thau chi: ");
                        double hanMucThauChi = sc.nextDouble();
                        sc.nextLine();
                        TaiKhoanThanhToan tkThanhToan = new TaiKhoanNganHang().new TaiKhoanThanhToan("", "", 0, "", hanMucThauChi);
                        if (tkThanhToan.taoTaiKhoan(sc, taiKhoans)) {
                            taiKhoans.add(tkThanhToan);
                        }
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;

                case 2:
                    System.out.print("Nhap so tai khoan: ");
                    String soTaiKhoanDangNhap = sc.nextLine();
                    System.out.print("Nhap mat khau: ");
                    String matKhauDangNhap = sc.nextLine();

                    // Kiểm tra tài khoản
                    for (TaiKhoan tk : taiKhoans) {
                        if (tk.soTk.equals(soTaiKhoanDangNhap) && tk.matKhau.equals(matKhauDangNhap)) {
                            taiKhoanDangNhap = tk;
                            System.out.println("Dang nhap thanh cong!");
                            break;
                        }
                    }
                    if (taiKhoanDangNhap == null) {
                        System.out.println("So tai khoan hoac mat khau khong dung.");
                    }
                    break;

                case 3:
                    if (taiKhoanDangNhap != null) {
                        System.out.print("Nhap so tien muon gui: ");
                        double soTienGui = sc.nextDouble();
                        taiKhoanDangNhap.guiTien(soTienGui);
                    } else {
                        System.out.println("Vui long dang nhap truoc.");
                    }
                    break;

                case 4:
                    if (taiKhoanDangNhap != null) {
                        System.out.print("Nhap so tien muon rut: ");
                        double soTienRut = sc.nextDouble();
                        if (taiKhoanDangNhap.rutTien(soTienRut)) {
                            System.out.println("Rut tien thanh cong. So du con lai: " + taiKhoanDangNhap.kiemTraSoDu());
                        }
                    } else {
                        System.out.println("Vui long dang nhap truoc.");
                    }
                    break;

                case 5:
                    if (taiKhoanDangNhap != null) {
                        System.out.println("So du hien tai: " + taiKhoanDangNhap.kiemTraSoDu());
                    } else {
                        System.out.println("Vui long dang nhap truoc.");
                    }
                    break;

                case 6:
                    if (taiKhoanDangNhap != null) {
                        taiKhoanDangNhap.doiMatKhau(sc);
                    } else {
                        System.out.println("Vui long dang nhap truoc.");
                    }
                    break;

                case 7:
                    if (taiKhoanDangNhap != null) {
                        taiKhoanDangNhap.inThongTin();
                    } else {
                        System.out.println("Vui long dang nhap truoc.");
                    }
                    break;

                case 8:
                    System.out.println("Cam on ban da su dung dich vu. Hen gap lai!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
            }
        } while (chon != 8);

        sc.close();
    }
}
