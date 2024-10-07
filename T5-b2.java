package com.mycompany.bttuan5;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap kich thuoc mang: ");
        int kichThuoc = scanner.nextInt();
        int[] mang = new int[kichThuoc];
        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < kichThuoc; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            mang[i] = scanner.nextInt();
        }
        int bd = 0;
        int kt = kichThuoc - 1;
        while (bd < kt) {
            int temp = mang[bd];
            mang[bd] = mang[kt];
            mang[kt] = temp;
            bd = bd + 1;
            kt = kt - 1;
        }
        System.out.println("Mang sau khi sap xep:");
        for (int phanTu : mang) {
            System.out.print(phanTu + " ");
        }
    }
}


