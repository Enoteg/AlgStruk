import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Zarplata {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int employee1 = scanner.nextInt();
            int employee2 = scanner.nextInt();
            int employee3 = scanner.nextInt();

            int maxSalary = Math.max(employee1, Math.max(employee2, employee3));
            int minSalary = Math.min(employee1, Math.min(employee2, employee3));

            int result = maxSalary - minSalary;

            System.out.println(result);
            scanner.close();
        }
    }

