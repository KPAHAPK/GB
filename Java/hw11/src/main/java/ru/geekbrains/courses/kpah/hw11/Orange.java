package ru.geekbrains.courses.kpah.hw11;

public class Orange extends Fruit{
    float weight = 1.5f;
    String typeOfFruit;

    public Orange(){
        typeOfFruit = "Апельсин";
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
