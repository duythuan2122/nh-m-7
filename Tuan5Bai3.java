package Tuan5;

import java.util.Arrays;
import java.util.Scanner;

public class Bai3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        System.out.println("Mảng sau khi sắp xếp theo thứ tự tăng dần: ");
        for (int i : array) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}
