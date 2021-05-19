package ru.geekbrains.courses.kpah.hw11;

import java.util.ArrayList;
import java.util.Locale;

public class Box<T extends Fruit>{
    private final ArrayList<T> box = new ArrayList<>();
    String boxName;

    public Box(String boxName){
        this.boxName = boxName;
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public float getBoxWeight(){
        float boxWeight = 0.0f;
        for (T a :
                this.box) {
            boxWeight += a.getWeight();
        }
        return boxWeight;
    }

    public void compareBox(Box<?> a, boolean ShowResult){

        float comparedBox1 = a.getBoxWeight();
        float comparedBox2 = getBoxWeight();
        if (ShowResult){
            System.out.printf("%s и %s одинаковые по весу? (%b)\n", boxName, a.boxName.toLowerCase(Locale.ROOT), comparedBox1 == comparedBox2);
            if(comparedBox1 != comparedBox2)
                System.out.printf("%s тяжелее.\n", comparedBox1 > comparedBox2 ? boxName : a.boxName);
        }
    }



    public void putInTheBox(T fruit, int amount){
        for (int i = 0; i < amount; i++ ) {
            box.add(fruit);
        }
    }

    public void contentOf(){
        System.out.printf("%s содержит:\n", boxName);
        for (T a :
                box) {
            System.out.println(a.getTypeOfFruit());
        }
        System.out.printf("Всего - %d шт.\n", box.size());
    }

    public void pourTo(Box<T> secondBox){
        for (T fruitFromFirstBox :
                box) {
            secondBox.getBox().add(fruitFromFirstBox);
        }
        box.clear();
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> appleBox1 = new Box<>("Коробка №1 с яблоками");
        Box<Apple> appleBox2 = new Box<>("Коробка №2 с яблоками");
        Box<Orange> orangeBox1 = new Box<>("Коробка №1 с апельсинами");
        Box<Orange> orangeBox2 = new Box<>("Коробка №2 с апельсинами");

        appleBox1.putInTheBox(apple, 3);
        appleBox2.putInTheBox(apple, 5);
        orangeBox1.putInTheBox(orange, 2);
        orangeBox2.putInTheBox(orange, 4);

        appleBox1.contentOf();
        orangeBox1.contentOf();
        appleBox2.contentOf();
        orangeBox2.contentOf();

        System.out.println();
        System.out.println("Результаты взвешивания коробок коробок:");
        appleBox1.compareBox(orangeBox1, true);
        appleBox1.compareBox(appleBox2, true);
        appleBox2.compareBox(orangeBox1, false);
        appleBox2.compareBox(orangeBox2, false);

        System.out.println();
        appleBox1.pourTo(appleBox2);
        System.out.println("Результат пересыпания:");
        appleBox1.contentOf();
        appleBox2.contentOf();

    }
}
