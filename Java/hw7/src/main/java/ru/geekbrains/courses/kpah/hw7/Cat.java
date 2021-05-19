package ru.geekbrains.courses.kpah.hw7;

public class Cat {
    private final String name;
    private int appetite;
    private int satiety;

    public String getName() {
        return name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public int getAppetite() {
        return appetite;
    }

    public Cat(String name, int satiety, int appetite){
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate plate){
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            satiety = appetite;
        }
    }

    public boolean isSatiety(){
        return satiety == appetite;
    }
}
