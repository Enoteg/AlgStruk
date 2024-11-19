import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Spirt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long C = scanner.nextLong();
        long H = scanner.nextLong();
        long O = scanner.nextLong();

        long MaxC = C / 2;
        long MaxH = H / 6;
        long MaxO = O;

        long MaxMol = Math.min((Math.min(MaxC, MaxH)), MaxO);

        System.out.println(MaxMol);
        scanner.close();
    }
}

