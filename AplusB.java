import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AplusB {
    public static void main(String[] args) {

        try {
            File input = new File("C:\\Users\\Enoteg\\Desktop\\progstuff\\input.txt");
            File output = new File("C:\\Users\\Enoteg\\Desktop\\progstuff\\output.txt");

            Scanner scanner = new Scanner(input);

            long a = scanner.nextLong();
            long b = scanner.nextLong();

            long sum = a + b;

            FileWriter writer = new FileWriter(output);
            writer.write(Long.toString(sum));
            writer.close();

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}