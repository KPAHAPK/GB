package ru.geekbrains.courses.kpah.hw11;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass<T> {
    public T[] array;

    public MainClass(T... arrayElements) {
        array = arrayElements;
    }


    public void printArray(){
        int i = 0;
        int iMax = array.length;
        for (T a:
        array){
            i++;
            if (i < iMax)
                System.out.print(a + ",");
            else
                System.out.print(a);
        }
        System.out.println();
    }


    public void swap(int index1, int index2) {
        T temp;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public ArrayList<T> arrayToList(){
        ArrayList<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        return list;
    }
}



