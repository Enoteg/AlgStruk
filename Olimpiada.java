import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Olimpiada {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\Enoteg\\Desktop\\progstuff\\input.txt"));
            FileWriter writer = new FileWriter("C:\\Users\\Enoteg\\Desktop\\progstuff\\output.txt");

            int N = scanner.nextInt();
            int[] time = new int[N];

            for (int i = 0; i < N; i++) {
                time[i] = scanner.nextInt();
            }

            int[] results = new int[3];
            int[] penalties = new int[3];

            results[2] = solve(time, penalties, 2);

            int[] reversedTime = reverse(time);
            results[1] = solve(reversedTime, penalties, 1);

            int[] sortedTime = Arrays.copyOf(time, N);
            Arrays.sort(sortedTime);
            results[0] = solve(sortedTime, penalties, 0);

            int winner = 0;
            for (int i = 1; i < 3; i++) {
                if (results[i] > results[winner] || (results[i] == results[winner] && penalties[i] < penalties[winner])) {
                    winner = i;
                }
            }

            writer.write(Integer.toString(winner + 1));
            writer.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int[] taskTimes, int[] penalties, int studentIndex) {
        int currentTime = 0;
        int solved = 0;
        int penalty = 0;

        for (int time : taskTimes) {
            if (currentTime + time <= 300) {
                currentTime += time;
                solved++;
                penalty += currentTime;
            } else {
                break;
            }
        }

        penalties[studentIndex] = penalty;
        return solved;
    }

    private static int[] reverse(int[] array) {
        int[] reversed = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length / 2; i++) {
            int temp = reversed[i];
            reversed[i] = reversed[array.length - 1 - i];
            reversed[array.length - 1 - i] = temp;
        }
        return reversed;
    }
}
