import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Biser {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            long a = scanner.nextLong();

            long result = a + 1;

            System.out.println(result);

            scanner.close();

        }
    }

