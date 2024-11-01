package Lesson3;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        String separator = "__________________________________________________________";
        Random random = new Random();
        int size = 1000;
        CommonArray commonArray = new CommonArray(size);
        OrderedArray orderedArray = new OrderedArray(size);

        for (int i = 0; i < size; i++) { // заполнение массива
            boolean insertResultCommonArray = false;
            boolean insertResultOrderedArray = false;

            while (!insertResultCommonArray) {
                insertResultCommonArray = commonArray.insert(random.nextLong(1000));
            }

            while (!insertResultOrderedArray) {
                insertResultOrderedArray = orderedArray.insert(random.nextLong(1000));
            }
        }

        long searchValue = random.nextLong(500);

        System.out.println("Ищем значение: " + searchValue);

        if (commonArray.contains(searchValue)) {
            System.out.println("Значение было найдено в CommonArray: " + searchValue);
        } else {
            System.out.println("Не удалось найти значение в CommonArray: " + searchValue);
        }

        System.out.println(separator);

        if (orderedArray.contains(searchValue)) {
            System.out.println("Значение было найдено в OrderedArray: " + searchValue);
        } else {
            System.out.println("Не удалось найти значение в OrderedArray: " + searchValue);
        }
    }
}    