package ru.geekbrains.courses.kpah.hw10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

abstract class PhoneBook{
    static String name;
    static String number;
    static HashMap<Integer, String> hashMap = new HashMap<>();

    public static void add(String name, int number){
        hashMap.put(number, name);
    }

    public static void get(String name){
        int i = 0;
        for (Map.Entry<Integer, String> o : hashMap.entrySet()) {
            if (name.equals(o.getValue())){
                i++;
                System.out.printf("\n%d) %s's phonenumber is ", i, name);
                System.out.print(o.getKey());
            }
        }
    }

    public static void list(){
        for (Map.Entry<Integer, String> o : hashMap.entrySet()) {
            System.out.println(o.getValue() + ": " + o.getKey());
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static void main(String[] args) {
        PhoneBook.add("Ivan", 98998);
        PhoneBook.add("Ivan", 54655);
        PhoneBook.add("Sergey", 68465);
        PhoneBook.add("Vasiliy", 46468);
        PhoneBook.list();
        PhoneBook.get("Ivan");
    }
}
