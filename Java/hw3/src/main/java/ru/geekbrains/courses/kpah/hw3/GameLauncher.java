package ru.geekbrains.courses.kpah.hw3;

import java.util.Scanner;

public class GameLauncher {

    public static Scanner sc;
    static String name;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    static int command;

    public static void main(String[] args) {

        System.out.println("Приветствую вас!\nПредлагаю вам сыграть со мной.");
        System.out.print("Для начала укажите, пожалуйста, ваш никнейм:");
        sc = new Scanner(System.in);
        boolean isString;
        name = null;

        do {
            isString = sc.hasNext();
            if (isString) {
                name = sc.nextLine();
                if (name != null && name.length() >= 3 )
                    break;
                else{
                    System.out.print("Пожалуйста введите имя состоящее хотя бы из 3 символов:");
                    sc.next();
                }
            } else {
                System.out.print("Пожалуйста введите имя состоящее хотя бы из 3 символов:");
                sc.next();
            }
        }while (!(name != null && name.length() >= 3));

        System.out.println("Рад познакомится, меня зовут Роман!\n" + name + ", в моем каталоге имеется две игры.\n");
        selectGame();
    }
    public static int selectGame(){
        System.out.println("Действие                 | Команда");
        System.out.println("-------------------------|---------");
        System.out.println("Запустить \"Угадай число\" | 1");
        System.out.println("Запустить \"Угадай слово\" | 2");
        System.out.println("Выход                    | 0 ");
        System.out.println();

        boolean isNumber;
        do {
            System.out.print("Выберите команду, указав её код:");
            isNumber = sc.hasNextInt();
            if (isNumber) {
                command = sc.nextInt();
                switch (command){
                    case 0:
                        System.out.println("Заврешение работы приложения.");
                        return command;
                    case 1:
                        GuessNumberGame.startGame();
                        return command;
                    case 2:
                        GuessWordGame.startGame();
                        return command;
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
