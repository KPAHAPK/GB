package ru.geekbrains.courses.kpah.hw7;

public class Plate {
    private int food;

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
            this.food = food;

    }

    public Plate(int food) {
        this.food = food;
    }
    public void info(){
        System.out.println("\nВ тарелке: " + food + " гр. корма.");
    }

    public void decreaseFood(int catAppetite){
            food -= catAppetite;
    }

    public void addFood(int amount){
        food += amount;
    }
}
