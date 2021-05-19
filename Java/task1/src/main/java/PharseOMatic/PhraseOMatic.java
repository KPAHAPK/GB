package PharseOMatic;

public class PhraseOMatic {
    public static void main(String[] args) {

        String[] wordListOne = {"круглосуточный", "трех-звенный", "3000-футовый", "взаимный", "обоюдный выйгрыш", "фронтэенд", "на основе веб-технологий", "проникающий", "умный", "шесть сигм", "метод критичческого пути", "динамичный"};
        String[] worldListTwo = {"уполномоченный", "трудный", "чистый продукт", "ориентированный", "центральный", "распределенный", "кластеризованный", "фирменный", "нестандартный ум", "позиционированный", "сетевой", "сфокусроиванный", "использованный с выгодой", "выровненный", "нацеленный на", "обзий", "совместный", "ускоренный"};
        String[] worldListThree = {"процесс", "пункт разгрузки", "выход из положения", "тип структуры", "талант", "подход", "уровень завоеванного внимания", "портал", "период времени", "обхор", "образец", "пункт следования"};

        int oneLength = wordListOne.length;
        int twoLength =  worldListTwo.length;
        int threeLength = worldListThree.length;

        int rndOne = (int) (Math.random() * oneLength);
        int rndTwo = (int) (Math.random() * twoLength);
        int rndThree = (int) (Math.random() * threeLength);

        String phrase = wordListOne[rndOne] + " " + worldListTwo[rndTwo] + " " + worldListThree[rndThree];
        System.out.println("Все, что нам нужно, - это " + phrase);
    }
}
