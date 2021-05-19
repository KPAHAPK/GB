package ru.geekbrains.courses.kpah.hw6;


public class hw6 {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик","Рыжий", 200, 0);
        Cat cat2 = new Cat("Васька","Белый", 200, 0);
        Dog dog1 = new Dog("Бобик","Пятнистый", 500, 10);
        Dog dog2 = new Dog("Тузик","Черный", 500, 10);
        Dog dog3 = new Dog("Шарик","Бурый", 500, 10);

        Animal[] animalsList = new Animal[5];
        animalsList[0] = cat1;
        animalsList[1] = cat2;
        animalsList[2] = dog1;
        animalsList[3] = dog2;
        animalsList[4] = dog3;

        for (Animal animals : animalsList){
            animals.count();
            animals.swim((int) (Math.random() * 15) + 1);
            animals.run((int) (Math.random() * 800) + 1);
            System.out.println();
        }
        System.out.printf("Всего в биатлоне учавствовало %d животных: %d кота(-ов) и %d пса(-ов)ю", Animal.getAmountOfAnimals(), Cat.getAmountOfCat(), Dog.getAmountOfDog());
    }



}
