import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Summa {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\Enoteg\\Desktop\\progstuff\\input.txt"));
            FileWriter writer = new FileWriter("C:\\Users\\Enoteg\\Desktop\\progstuff\\output.txt");

            int N = scanner.nextInt();
            int result = 0;

            if (N >= 1) {
                result = N * (N + 1) / 2;
            } else {
                
                for (int i = 1; i >= N; i--) {
                    result += i;
                }
            }

            writer.write(Integer.toString(result));
            writer.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

