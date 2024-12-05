package Lesson7;

import java.util.Arrays;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        int size = 5;
        Random random = new Random();

        Stack stack = new Stack(size);
        Queue queue = new Queue(size);
        PriorityQueue priorityQueue = new PriorityQueue(size);

        for (int i = 0; i < size; i++) {
            queue.insert(random.nextInt(1000));
            priorityQueue.insert(random.nextInt(1000));
        }

        System.out.println("Содержимое обычной очереди:");
        queue.display();

        System.out.println("Содержимое приоритетной очереди:");
        priorityQueue.display();

        System.out.println();

        String str = "ABCBA";
        char[] chars = str.toCharArray();

        for (char c : chars) {
            stack.push(c);
        }

        if (stack.isFull()) {
            System.out.println("Ошибка: Стек переполнен! Проверка палиндрома невозможна.");
            return;
        }

        char[] charsStr = new char[chars.length];
        for (int i = 0; !stack.isEmpty(); i++) {
            charsStr[i] = stack.pop();
        }

        if (Arrays.equals(chars, charsStr)) {
            System.out.println("Строка \"" + str + "\" - палиндром");
        } else {
            System.out.println("Строка \"" + str + "\" - не палиндром");
        }
    }
}
