public class KiemTraSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một số nguyên: ");
        int number = scanner.nextInt();
        if (number > 0) {
            System.out.println(number + " là số dương.");
        } else if (number < 0) {
            System.out.println(number + " là số âm.");
        } else {
            System.out.println(number   
 + " bằng 0.");
        }
   scanner.close();
    }
}
