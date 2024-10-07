package Tuan4;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.print("Nhập vào một số nguyên: ");
        int so = sc.nextInt();
        
        if (Daoso(so)) {
            System.out.println(so + " là số đối xứng.");
        } else {
            System.out.println(so + " không phải là số đối xứng.");
        }
        
        sc.close();
    }
    
    public static boolean Daoso(int so) {
        int n1 = so;
        int n2 = 0;
        
        while (so != 0) {
            int r = so % 10;
            n2 = n2 * 10 + r;
            so /= 10;
        }
        
        return n1 == n2;
    }
}
