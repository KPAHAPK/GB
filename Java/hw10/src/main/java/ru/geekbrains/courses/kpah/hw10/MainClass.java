package ru.geekbrains.courses.kpah.hw10;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Кошка");
        arrayList.add("Собака");
        arrayList.add("Дом");
        arrayList.add("Замок");
        arrayList.add("Зал");
        arrayList.add("Окно");
        arrayList.add("Небо");
        arrayList.add("Солнце");
        arrayList.add("Солнце");
        arrayList.add("Дерево");
        arrayList.add("Вода");
        arrayList.add("Замок");
        arrayList.add("Птица");
        arrayList.add("Шнур");
        arrayList.add("Молекула");
        arrayList.add("Ядро");
        arrayList.add("Школа");
        arrayList.add("Здание");
        arrayList.add("Солнце");
        arrayList.add("Море");
        arrayList.add("Шнур");
        arrayList.add("Мышь");
        arrayList.add("Небо");

        System.out.println("Массив: " + arrayList);
        System.out.println();

        HashSet<String> hashSet = new HashSet<String>(arrayList);
        System.out.println("Массив уникальных слов: " + hashSet);
        System.out.println();

        int count;
        for (String a : hashSet) {
            count = 0;
            for (String b :
                    arrayList) {
                if (b.equals(a)){
                    count++;
                }
            }
            System.out.println("Слово \"" + a + "\" встречается " + count + " раз(-а).");
        }



    }
}


