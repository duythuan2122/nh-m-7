package com.mycompany.bttuan5;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap kich thuoc mang: ");
        int kichThuoc = scanner.nextInt();       
        int[] mang = new int[kichThuoc];
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < kichThuoc; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            mang[i] = scanner.nextInt();
        }
        int tong = 0;
        for (int phanTu : mang) {
            tong = tong + phanTu;
        }
        System.out.println("Tong cac phan tu cua mang: " + tong);
}
}


