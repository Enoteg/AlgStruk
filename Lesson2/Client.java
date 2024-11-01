package Lesson2;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();

        int size = 150;
        Interface array = new ArrayImp(size);

        for (int i = 0; i < size; i++) {
            array.insert(random.nextLong(150));
        }

        array.display();

        long searchVal = random.nextLong(size);
        if (array.find(searchVal)) {
            System.out.println("Удалось найти значение. " + searchVal);
        } else {
            System.out.println("Не удалось найти значение. " + searchVal);
        }

        System.out.println("Количество элементов в массиве:" + array.getSize());
        System.out.println("Наибольший элемент в массиве:" + array.getMax());
        System.out.println("Наименьший элемент в массиве:" + array.getMin());
    }
}
