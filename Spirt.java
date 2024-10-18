import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Spirt {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\Enoteg\\Desktop\\progstuff\\input.txt"));
            FileWriter writer = new FileWriter("C:\\Users\\Enoteg\\Desktop\\progstuff\\output.txt");

            long C = scanner.nextLong();
            long H = scanner.nextLong();
            long O = scanner.nextLong();

            long MaxC = C / 2;
            long MaxH = H / 6;
            long MaxO = O;

            long MaxMol = Math.min((Math.min(MaxC, MaxH)), MaxO);

            writer.write(Long.toString(MaxMol));
            writer.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

