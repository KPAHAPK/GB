package ru.geekbrains.courses.kpah.hw6;

public class Dog extends Animal{

    static int amountOfDog;

    Dog(String name, String color, int maxDistanceOfRunning, int maxDistanceOfSwimming) {
        super(name, color, maxDistanceOfRunning, maxDistanceOfSwimming);
    }

    @Override
    public void count(){
        super.count();
        amountOfDog ++;
    }



    public static int getAmountOfDog() {
        return amountOfDog;
    }
}
