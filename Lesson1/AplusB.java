import java.util.Scanner;

public class AplusB {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            long a = scanner.nextLong();

            long b = scanner.nextLong();

            long sum = a + b;

            System.out.println(sum);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
