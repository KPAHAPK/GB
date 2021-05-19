package ru.geekbrains.courses.kpah.hw3;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

//        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//        сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
//        Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
//        apple – загаданное
//        apricot - ответ игрока
//        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//        Для сравнения двух слов посимвольно можно пользоваться:
//        String str = "apple";
//        char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//        Играем до тех пор, пока игрок не отгадает слово.
//        Используем только маленькие буквы.


public class GuessWordGame {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    static Scanner sc;

    public static void startGame() {

        System.out.println("*************************************************************************");
        System.out.println("Вас приветствует игра \"Угадай число\".");

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato", "watermelon"};
        Random random = new Random();
        sc = new Scanner(System.in);
        String rightAnswer;
        rightAnswer = words[random.ints(0, words.length - 1).findFirst().getAsInt()];

        System.out.println(GameLauncher.name + ", перед вами список слов. Одно из них я загадал");
        arrToTable(words);


        System.out.println("\nУгадайте же какое это слово.");
        String userAnswer;
        boolean isString;
        char userLetter, rightLetter;
        int count = 0;
        do {
            count++;
            System.out.print("Ваш ответ:");
            userAnswer = "";
            isString = sc.hasNext();
            if (isString) {
                userAnswer = sc.nextLine();
                userAnswer = userAnswer.toLowerCase(Locale.ROOT);
                if (Objects.equals(userAnswer, rightAnswer)) {
                    System.out.println(ANSI_GREEN + "Вы угадали! Мои поздравления." + ANSI_RESET + "\nКоличество проделанных попыток: " + count);
                    break;
                }
                System.out.print(ANSI_RED + "Вы не угадали слово. Попробуйте снова." + ANSI_RESET + "\nВот вам подсказка. ");
                System.out.println("Если какие-нибудь буквы совпали со своими местами в слове то они появятся ниже.");
                int minWordLength = Math.min(userAnswer.length(), rightAnswer.length());
                for (int i = 0; i < minWordLength; i++) {
                    userLetter = userAnswer.charAt(i);
                    rightLetter = rightAnswer.charAt(i);
                    if (userLetter == rightLetter)
                        System.out.print(rightLetter);
                    else
                        System.out.print("#");
                    if (i == minWordLength - 1) {
                        System.out.println("##############");
                        System.out.println("________________________________________________________________________");
                        arrToTable(words);
                    }
                }

            } else {
                System.out.println(ANSI_RED + "ОШИБКА:" + ANSI_RESET + ": Ваш ответ должен содержать слово.");
                sc.next();
            }
        } while (!(Objects.equals(userAnswer, rightAnswer)));

        Commands.oneMoreTime();

    }

    public static void arrToTable(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % (int) Math.sqrt(arr.length - 1) == 0) {
                System.out.println();
            }
            if (arr[i].length() <= 3)
                System.out.print(arr[i] + "\t\t\t");
            else if (arr[i].length() >= 8)
                System.out.print(arr[i] + "\t");
            else
                System.out.print(arr[i] + "\t\t");
        }
        System.out.println();
        System.out.println();
    }
}
