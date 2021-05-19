package ru.geekbrains.courses.kpah.hw3;

import java.util.Random;
import java.util.Scanner;

// Написать программу, которая загадывает случайное число от 0 до 9
// и пользователю дается 3 попытки угадать это число. При каждой попытке
// компьютер должен сообщить, больше ли указанное пользователем число, чем
// загаданное, или меньше. После победы или проигрыша выводится запрос –
// «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)

public class GuessNumberGame {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    static Scanner sc;

    public static void startGame() {
        int rightAnswer;
        Random random = new Random();
        sc = new Scanner(System.in);
        rightAnswer = random.ints(0, 10).findFirst().getAsInt();
        System.out.println("*************************************************************************");
        System.out.println("Вас приветствует игра \"Угадай число\".");
        System.out.println("Мной загадано число от 0 до 9. Ваша цель: угадать число с 3 попыток.");


        boolean isNumber;
        int userAnswer = 0;
        int trying = 3;
        do {
            System.out.print("Введите число от 0 до 9:");
            isNumber = sc.hasNextInt();
            if (isNumber) {
                userAnswer = sc.nextInt();
                if (userAnswer <= 9 && userAnswer >= 0) {
                    if (userAnswer > rightAnswer) {
                        trying--;
                        System.out.println("Вы ввели слишком большое значение. У вас осталось: " + trying + " попыток.");
                        System.out.println("________________________________________________________________________");
                    } else if (userAnswer < rightAnswer) {
                        trying--;
                        System.out.println("Вы ввели слишком маленькое значение. У вас осталось: " + trying + " попыток.");
                        System.out.println("________________________________________________________________________");
                    }
                } else
                    System.out.println(ANSI_RED + "ОШИБКА" + ANSI_RESET + ": Введено некорректное значение.");
            } else {
                System.out.println(ANSI_RED + "ОШИБКА" + ANSI_RESET + ": Введено некорректное значение.");
                sc.next();
            }
        } while (!(trying == 0 || userAnswer == rightAnswer));
        System.out.println("*************************************************************************");
        if (trying == 0) {
            System.out.println(ANSI_RED + "Вы использовали все свои попытки. Вы проиграли." + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Подздравляю! Вы угадали число. Было загадано число: " + rightAnswer + ANSI_RESET);
        }
        Commands.oneMoreTime();
    }
}


