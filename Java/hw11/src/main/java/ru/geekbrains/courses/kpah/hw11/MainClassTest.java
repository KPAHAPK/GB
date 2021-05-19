package ru.geekbrains.courses.kpah.hw11;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClassTest {

    public static void main(String[] args) {
        MainClass<Integer> arrInt = new MainClass<>(1, 2, 3, 4, 5, 6, 7);
        MainClass<String> arrStr = new MainClass<>("\"1\"", "\"2\"", "\"3\"", "\"4\"", "\"5\"");
        MainClass<Double> arrDouble = new MainClass<>(1.0, 2.0, 3.0, 4.0, 5.0);

        int[] ints = new int[]{1,2,3,4};
        System.out.println(ints);
        System.out.println(arrInt);
        System.out.println(Arrays.toString(ints));




        System.out.println("Начальные массивы:");
        arrInt.printArray();
        arrStr.printArray();
        arrDouble.printArray();

        System.out.println("********************");
        System.out.println("Измененные массивы:");
        arrInt.swap(2, 4);
        arrStr.swap(2, 4);
        arrDouble.swap(2, 4);

        arrInt.printArray();
        arrStr.printArray();
        arrDouble.printArray();

        System.out.println("********************");
        System.out.println("Массив в лист:");
        ArrayList<Integer> listInt = arrInt.arrayToList();
        ArrayList<String> listStr = arrStr.arrayToList();
        ArrayList<Double> listDouble =arrDouble.arrayToList();

        System.out.println(listInt.toString());
        System.out.println(listStr.toString());
        System.out.println(listDouble.toString());


    }

}
