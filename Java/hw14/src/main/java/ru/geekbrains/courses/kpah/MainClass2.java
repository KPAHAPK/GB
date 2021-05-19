package ru.geekbrains.courses.kpah;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или
 единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 [ 1 1 1 4 4 1 4 4 ] -> true
 [ 1 1 1 1 1 1 ] -> false
 [ 4 4 4 4 ] -> false
 [ 1 4 4 1 1 4 3 ] -> false
 */

public class MainClass2 {
    Random random = new Random();
    int[] array;

    public static void main(String[] args) {
        MainClass2 mainClass2 = new MainClass2();
        mainClass2.setArray();
        System.out.println(Arrays.toString(mainClass2.array));
        mainClass2.checkArray(mainClass2.array);
        System.out.println(mainClass2.checkArray(mainClass2.array));

    }

    public void setArray() {
        int rnd = random.ints(4, 6).findAny().getAsInt();
        array = new int[]{1, 4, 1, 4, 4, 1, rnd};
    }

    public boolean checkArray(int[] array) {
        for (int a : array) {
            if (a != 1 && a != 4) {
                return false;
            }
        }
        return true;
    }
}
