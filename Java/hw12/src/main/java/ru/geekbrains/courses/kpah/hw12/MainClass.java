package ru.geekbrains.courses.kpah.hw12;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass{

    static final int SIZE = 1000000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];
    ArrayList<float[]> partsOfTheMainArray = new ArrayList<>();

    public static void main(String[] args) {
        MainClass a = new MainClass();
        MainClass b = new MainClass();
        Arrays.fill(a.arr, 1.0f);
        Arrays.fill(b.arr, 1.0f);

        long startArrRandomFilling = System.currentTimeMillis();
        a.doWork(a.arr);
        long endArrRandomFilling = System.currentTimeMillis();
        long time2 = endArrRandomFilling - startArrRandomFilling;
        System.out.println("Затраченное время 1.0 -> Formula: " + time2 + " мс");

        long startArrRandomFillingInTwoThreads = System.currentTimeMillis();
        b.doTwoThreadWork(b.arr);
        long endArrRandomFillingTwoThreads = System.currentTimeMillis();
        long time3 = endArrRandomFillingTwoThreads - startArrRandomFillingInTwoThreads;
        System.out.println("Затраченное время 1.0 -> Formula(общее время для двух потоков): " + time3 + " мс");
    }

    void doWork(float[] array){
        for (int i = 0; i < array.length; i ++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
    }

        void doTwoThreadWork(float[] array){
            long startTime = System.currentTimeMillis();
            Thread one = new Thread(() -> doFirstThread(array));
            Thread two = new Thread(() -> doSecondThread(array));
            one.setName("First Thread");
            two.setName("Second Thread");
            one.start();
            two.start();
            try {
                one.join();
                two.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endSplittingTime = System.currentTimeMillis();
            long splittingTime = endSplittingTime - startTime;
            System.out.println("Затраченное время 1.0 -> Formula(разделение и расчет): " + splittingTime + " мс");
            long startConcatenationTime = System.currentTimeMillis();
            float [] concatenatedArray = concatenateArray(partsOfTheMainArray.get(0), partsOfTheMainArray.get(1));
//            System.out.println(Arrays.toString(concatenatedArray));
            long endConcatenationTime = System.currentTimeMillis();
            long ConcatenationTime = endConcatenationTime - startConcatenationTime;
            System.out.println("Затраченное время на объединение двух массивов: " + ConcatenationTime + " мс");

    }

   void doFirstThread(float[] array){
        System.out.println(Thread.currentThread().getName() + " начал работу");
        long startTime = System.currentTimeMillis();
        float[] arr = new float[HALF];
        System.arraycopy(array, 0, arr, 0, HALF);
        doWork(arr);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
//        System.out.println(Arrays.toString(arr1));
        System.out.println("Затраченное время 1.0 -> Formula(первый поток): " + time + " мс");
        System.out.println(Thread.currentThread().getName() + " закончил работу");
        partsOfTheMainArray.add(arr);
    }

    void doSecondThread(float[] array){
        System.out.println(Thread.currentThread().getName() + " начал работу");
        long startTime = System.currentTimeMillis();
        float[] arr = new float[HALF];
        System.arraycopy(array, HALF, arr, 0, HALF);
        doWork(arr);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
//        System.out.println(Arrays.toString(arr2));
        System.out.println("Затраченное время 1.0 -> RandomFormula(второй поток): " + time + " мс");
        System.out.println(Thread.currentThread().getName() + " закончил работу");
        partsOfTheMainArray.add(arr);
    }

    float[] concatenateArray(float[] array1, float[] array2){
        float[] array = new float[array1.length + array2.length];
        System.arraycopy(array1, 0, array, 0, HALF);
        System.arraycopy(array2, 0, array, HALF, HALF);
        return array;
    }

}
