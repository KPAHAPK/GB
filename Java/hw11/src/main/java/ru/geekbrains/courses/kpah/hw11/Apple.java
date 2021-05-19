package ru.geekbrains.courses.kpah.hw11;

public class Apple extends Fruit{
    float weight = 1.0f;
    String typeOfFruit;

    public Apple(){
        typeOfFruit = "Яблоко";
    }

    @Override
    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
