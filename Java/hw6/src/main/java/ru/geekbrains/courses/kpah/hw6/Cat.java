package ru.geekbrains.courses.kpah.hw6;

public class Cat extends Animal{

    static int amountOfCat;

    Cat(String name, String color, int maxDistanceOfRunning, int maxDistanceOfSwimming) {
        super(name, color, maxDistanceOfRunning, maxDistanceOfSwimming);
    }

    @Override
    public void count(){
        super.count();
        amountOfCat ++;
    }

    public static int getAmountOfCat() {
        return amountOfCat;
    }
}
