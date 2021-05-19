package ru.geekbrains.courses.kpah;

import java.util.Arrays;
import java.util.Random;

/**
 * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
 * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
 * необходимо выбросить RuntimeException.
 * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 *
 */


public class MainClass {
    private int[] resultArray;
    private Integer[] array;
    Random random = new Random();

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();

        mainClass.setArray(9);
        System.out.println(Arrays.toString(mainClass.array));

        mainClass.checkArray(mainClass.array);

        mainClass.getDigitsAfterLastFourAndCreateNewArray(mainClass.array);
        System.out.println(Arrays.toString(mainClass.resultArray));
    }

    void setArray(int length){
        array = new Integer[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.ints(0,10).findAny().getAsInt();
        }

    }

    void checkArray(Integer[] array){
        if (!Arrays.asList(array).contains(4)){
            throw new RuntimeException("Массив не содержит \"4\"");
        }
    }

    int[] getDigitsAfterLastFourAndCreateNewArray(Integer[] array){
        for(int i = array.length - 1; i > 0; i--){
            if (array[i] == 4){
                resultArray = new int[array.length - 1 - i];
                for (int k = 0, j = i + 1; j < array.length; j++, k++)
                    resultArray[k] = array [j];
                break;
            }
        }
        return resultArray;
    }

}
