package com.mycompany.bttuan4;
import java.util.Scanner;

public class Bai5 {
    public static int UCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int BCNN(int a, int b) {
        return (a * b) / UCLN(a, b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen thu nhat: ");
        int a = scanner.nextInt();
        System.out.print("Nhap so nguyen thu hai: ");
        int b = scanner.nextInt();
        int ucln = UCLN(a, b);
        int bcnn = BCNN(a, b);
        System.out.println("UCLN cua " + a + " va " + b + " la: " + ucln);
        System.out.println("BCNN cua " + a + " va " + b + " la: " + bcnn);
    }
}


