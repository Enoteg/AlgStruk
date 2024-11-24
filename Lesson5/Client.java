package Lesson5;

import java.util.Arrays;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        long end;
        long begin;

        int size = 10000;
        Interface bubbleArray = new BubbleSortArray(size);
        Interface insertArray = new InsertionSortArray(size);
        Interface selectArray = new SelectionSortArray(size);

        for (int i = 0; i < size; i++) {
            bubbleArray.insert(random.nextLong(10000));
            insertArray.insert(random.nextLong(10000));
            selectArray.insert(random.nextLong(10000));
        }

            System.out.println("Массив для BubbleSort: ");
            bubbleArray.display();
            bubbleArray.bubbleSort();
            System.out.println("Отсортированный массив сортировкой BubbleSort:");
            bubbleArray.bubbleSort();
            begin = System.currentTimeMillis();
            bubbleArray.display();
            end = System.currentTimeMillis();
            System.out.printf("Время выполнения: %d мс \n", end - begin);

            System.out.println();
            System.out.println("Массив для InsertionSort: ");
            insertArray.display();
            insertArray.insertionSort();
            System.out.println("Отсортированный массив сортировкой InsertionSort:");
            insertArray.insertionSort();
            begin = System.currentTimeMillis();
            insertArray.display();
            end = System.currentTimeMillis();
            System.out.printf("Время выполнения: %d мс \n", end - begin);

            System.out.println();
            System.out.println("Массив для SelectionSort: ");
            selectArray.display();
            selectArray.selectionSort();
            System.out.println("Отсортированный массив сортировкой SelectionSort:");
            selectArray.selectionSort();
            begin = System.currentTimeMillis();
            selectArray.display();
            end = System.currentTimeMillis();
            System.out.printf("Время выполнения: %d мс \n", end - begin);
    }
}
