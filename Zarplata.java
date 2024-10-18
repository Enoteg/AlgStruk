import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Zarplata {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\Enoteg\\Desktop\\progstuff\\input.txt"));
            FileWriter writer = new FileWriter("C:\\Users\\Enoteg\\Desktop\\progstuff\\output.txt");

            int employee1 = scanner.nextInt();
            int employee2 = scanner.nextInt();
            int employee3 = scanner.nextInt();

            int maxSalary = Math.max(employee1, Math.max(employee2, employee3));
            int minSalary = Math.min(employee1, Math.min(employee2, employee3));

            int result = maxSalary - minSalary;

            writer.write(Integer.toString(result));
            writer.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
