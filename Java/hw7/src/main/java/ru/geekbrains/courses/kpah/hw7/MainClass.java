package ru.geekbrains.courses.kpah.hw7;

public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Mozart", 0,300);
        cats[1] = new Cat("Barsik", 0, 350);
        cats[2] = new Cat("Boris", 0,400);
        cats[3] = new Cat("Tom", 0,320);
        cats[4] = new Cat("Eek", 0,210);
        Plate plate = new Plate(1000);
        for (Cat cat : cats) {
            plate.info();
            cat.eat(plate);
            System.out.printf("Котик %s  %s.", cat.getName(),cat.isSatiety()? "поел":"не поел");
            while (!cat.isSatiety()){
                System.out.print("\nПодсыпем еще 50гр корма.\n\t\t\t↓");
                plate.addFood(50);
                plate.info();
                cat.eat(plate);
                System.out.printf("Котик %s  %s.", cat.getName(),cat.isSatiety()? "поел":"не поел");

            }
            System.out.println("\n-------------------------------------");
        }
        plate.info();
        System.out.println("Все сыты и пошли спать.");
    }
}
