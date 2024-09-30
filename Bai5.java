package com.mycompany.bttuan3;
import java.util.Scanner;

public class Bai5 {
    public static boolean kiemTraTamGiac(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
    public static String xacDinhLoaiTamGiac(double a, double b, double c) {
        if (a == b && b == c) {
            return "Tam giac deu";
        } else if (a == b || b == c || a == c) {
            return "Tam giac can";
        } else if (kiemTraTamGiacVuong(a, b, c)) {
            return "Tam giac vuong";
        } else {
            return "Tam giac thuong";
        }
    }
    public static boolean kiemTraTamGiacVuong(double a, double b, double c) {
        return (a*a+b*b==c*c) || (c*c+b*b==a*a) || (a*a+c*c==b*b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
        System.out.print("Nhap canh a: ");
        double a = sc.nextDouble();       
        System.out.print("Nhap canh b: ");
        double b = sc.nextDouble();       
        System.out.print("Nhap canh c: ");
        double c = sc.nextDouble();
        if (kiemTraTamGiac(a, b, c)) {
            System.out.println("Day la tam giac.");
            System.out.println("Loai tam giac: " + xacDinhLoaiTamGiac(a, b, c));
        } else {
            System.out.println("Day khong phai tam giac.");
        }
    }    
}


