import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Summa {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int N = scanner.nextInt();
            int result = 0;

            if (N >= 1) {
                result = N * (N + 1) / 2;
            } else {
                
                for (int i = 1; i >= N; i--) {
                    result += i;
                }
            }

            System.out.println(result);
            scanner.close();
        }
    }


