package ru.geekbrains.courses.kpah.hw3;

import java.util.Scanner;

public class Commands {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    static Scanner sc;

    public static void oneMoreTime() {
        sc = new Scanner(System.in);
        System.out.println("*************************************************************************");
        System.out.println("Хотите ещё раз сыграть?");
        do {
            int command;
            boolean isNumber;
            System.out.println("Введите 1, если хотите еще раз сыграть.\nВведите 0 для выхода в главное меню.");
            isNumber = sc.hasNextInt();
            if (isNumber) {
                command = sc.nextInt();
                switch (command) {
                    case 0:
                        System.out.println("*************************************************************************");
                        GameLauncher.selectGame();
                        return;
                    case 1:
                        switch (GameLauncher.command){
                            case 1:
                                GuessNumberGame.startGame();
                                return;
                            case 2:
                                GuessWordGame.startGame();
                                return;
                        }
                        break;
                    default:
                        System.out.println(ANSI_RED + "ОШИБКА" + ANSI_RESET + ": Следует указать существующую команду");
                }
            } else {
                System.out.println(ANSI_RED + "ОШИБКА" + ANSI_RESET + ": Введено некорректное значение.");
                sc.next();
            }
        } while (true);
    }
}

