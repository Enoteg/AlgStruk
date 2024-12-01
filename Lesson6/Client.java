package Lesson6;

import java.util.Arrays;
import java.util.Random;

public class Client {
    public static void main(String[] args){
        int size = 10;
        Random random = new Random();
        Stack stack = new Stack(size);
        Queue queue = new Queue(size);
        PriorityQueue priorityQueue = new PriorityQueue(size);

        for (int i = 0; i < size; i++) {
            queue.insert(random.nextLong(1000));
            priorityQueue.insert(random.nextLong(1000));
        }

        queue.display();
        priorityQueue.display();

        String str = "ABCBAF";
        char[] chars = str.toCharArray();
        for (char c: chars)
        {
            stack.push(c);
        }
        char[] charsStr = new char[size];
        for (int i = 0; !stack.isEmpty(); i++){

            charsStr[i] = stack.pop();
        }

        if (Arrays.equals(chars, charsStr))
            System.out.println("Строка " + str + " - палиндром");
        else System.out.println("Строка " + str + " - не палиндром");
    }
}