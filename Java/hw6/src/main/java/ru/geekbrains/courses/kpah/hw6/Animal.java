package ru.geekbrains.courses.kpah.hw6;
//        Создать классы Собака и Кот с наследованием от класса Животное.
//        Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//        У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//        * Добавить подсчет созданных котов, собак и животных.

public abstract class Animal {
    static int amountOfAnimals;
    int distance;
    int maxDistanceOfRunning;
    int maxDistanceOfSwimming;
    final String name;
    final String color;

    Animal(String name, String color, int maxDistanceOfRunning, int maxDistanceOfSwimming){
        this.maxDistanceOfRunning = maxDistanceOfRunning;
        this.maxDistanceOfSwimming = maxDistanceOfSwimming;
        this.name = name;
        this.color = color;

    }

    public void run(int range){
        this.distance = range;
        if (range > maxDistanceOfRunning) {
            System.out.println(color + " " + name + " не смог(-ла) пробежать "+ range + " метра(-ов).");
            return;
        }
        System.out.println(color + " " + name + " пробежал(-а) " + range + " метра(-ов).");
    }

    public void swim(int range){
        this.distance = range;
        if (maxDistanceOfSwimming == 0) {
            System.out.println(color + " " + name + " не умеет плавать.");
            return;
        }
        if (range > maxDistanceOfSwimming) {
            System.out.println(color + " " + name + " не смог(-ла) проплыть "+ range + " метра(-ов).");
            return;
        }
        System.out.println(color + " " + name + " проплыл(-а) " + range + " метра(-ов).");
    }

    public void count(){
        amountOfAnimals ++;
    }

    public static int getAmountOfAnimals() {
        return amountOfAnimals;
    }
}

