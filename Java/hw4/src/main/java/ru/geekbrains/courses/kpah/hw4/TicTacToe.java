package ru.geekbrains.courses.kpah.hw4;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static final char DOT_HUMAN = 'X'; // Фишка - игрок
    static final char DOT_AI = 'O'; // Фишка - компьютер
    static final char DOT_EMPTY = '•'; // Пустое поле
    static final Scanner sc = new Scanner(System.in);
    static final Random rnd = new Random();
    static char[][] field; // Игровое поле
    static int fieldSizeX; // Размер поля по Х
    static int fieldSizeY; // Размер поля по Y
    static int winCondition; // Символов ряд для победы
    static int totalNumberTurn = -1; // Количество сделанных ходов (комп + человек).


    static void setFieldSize() {
        int x_y = 0;
        do {
            if (sc.hasNextInt()) {
                x_y = sc.nextInt();
                if (x_y >= 3 && x_y <= 9) {
                    fieldSizeX = x_y;
                    fieldSizeY = x_y;
                    field = new char[fieldSizeY][fieldSizeX];
                } else {
                    System.out.print("Введите корректный размер поля (от 3 до 9): ");
                }
            } else {
                System.out.print("Введите корректный размер поля (от 3 до 9): ");
                sc.next();
            }
        } while (!(x_y >= 3 && x_y <= 9));

    }

    static void setWinCondition() {
        int wC = 0;
        do {
            if (sc.hasNextInt()) {
                wC = sc.nextInt();
                if (wC <= fieldSizeX && wC >= 3) {
                    winCondition = wC;
                } else
                    System.out.format("Введите число (от 3 до %d): ", fieldSizeX);
            } else {
                System.out.format("Введите число (от 3 до %d): ", fieldSizeX);
                sc.next();
            }
        } while (!(wC <= fieldSizeX && wC >= 3));
    }

    static void initialize() {
        System.out.print("Давайте создадим игровое поле. Введите размер поля (от 3 до 9): ");
        setFieldSize();

        System.out.printf("Введите количество символов в ряд, которое нужно собрать для победы (от 3 до %d): ", fieldSizeX);
        setWinCondition();

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "¦");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "¦");
            }
            System.out.println();
        }
        System.out.println("________________________________________________");
    }

    static void humanTurn() {
        totalNumberTurn++;
        int x, y;
        do {
            x = -1;
            y = -1;
            System.out.printf("Введите координаты хода X и Y (от 1 до %d) через пробел: ", fieldSizeX);
            if (sc.hasNextInt()) {
                x = sc.nextInt() - 1;
                if (sc.hasNextInt()) {
                    y = sc.nextInt() - 1;
                } else
                    sc.next();
            } else
                sc.next();
        } while (!isCellValid(y, x) || !isCellEmpty(y, x));
        field[y][x] = DOT_HUMAN;
    }

    static void aiTurn() {
//        int x, y;
//        do{
//            x = rnd.nextInt(fieldSizeX);
//            y = rnd.nextInt(fieldSizeY);
//        }
//        while (!isCellEmpty(x, y));
//        field[y][x] = DOT_AI;
//    }

        totalNumberTurn++;
        int[] arrEmptyXCoordinate = new int[fieldSizeY * fieldSizeX - totalNumberTurn];// Массив координат Х пустых ячеек
        int[] arrEmptyYCoordinate = new int[fieldSizeY * fieldSizeX - totalNumberTurn];// Массив координат Y пустых ячеек

        for (int y = 0, i = -1; y < fieldSizeY; y++) { // Ищем пустые ячейки и их координаты добавляем в массив Х и Y пустых ячеек
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) {
                    i++;
                    arrEmptyXCoordinate[i] = x;
                    arrEmptyYCoordinate[i] = y;
                }
            }
        }
        for (int i = 0; i < arrEmptyXCoordinate.length; i++) { // Делаем одинаковое перемешивание массивов Х и Y пустых ячеек
            int randomIndexToSwap = rnd.nextInt(arrEmptyXCoordinate.length);
            int bufferX = arrEmptyXCoordinate[i];
            int bufferY = arrEmptyYCoordinate[i];
            arrEmptyXCoordinate[i] = arrEmptyXCoordinate[randomIndexToSwap];
            arrEmptyYCoordinate[i] = arrEmptyYCoordinate[randomIndexToSwap];
            arrEmptyXCoordinate[randomIndexToSwap] = bufferX;
            arrEmptyYCoordinate[randomIndexToSwap] = bufferY;
        }

        int x, y;
        for (int i = 0; i < arrEmptyXCoordinate.length; i++) { // Прогоняем по всем пустым ячейкам DOT_AI и проверяем выграл ли комп при следующем ходе
            x = arrEmptyXCoordinate[i];
            y = arrEmptyYCoordinate[i];
            field[y][x] = DOT_AI;
            if (checkWin(DOT_AI, winCondition)) // Если выйграл, то оставляем и выходим.
                return;
            else // Если не выйграл, то возвращаем пустую ячейку.
                field[y][x] = DOT_EMPTY;
        }

        for (int k = 0; k <= 1; k++) { // Прогоняем по всем пустым ячейкам DOT_HUMAN и проверяем выграл ли человек (думаем на 1, а потом на 2 шага вперед)
            for (int i = 0; i < arrEmptyXCoordinate.length; i++) {
                x = arrEmptyXCoordinate[i];
                y = arrEmptyYCoordinate[i];
                field[y][x] = DOT_HUMAN;
                if (checkWin(DOT_HUMAN, winCondition - k)) { // Если человек выйграл то ставим на это место DOT_AI и выходим
                    field[y][x] = DOT_AI;
                    return;
                } else // Если не выйграл, то возвращаем пустую ячейку.
                    field[y][x] = DOT_EMPTY;
            }
        }
        for (int k = 1; k < winCondition; k++) {// Прогоняем по всем пустым ячейкам DOT_AI и проверяем в какой ячейке комп приблизится к выйгрышу.
            for (int i = 0; i < arrEmptyXCoordinate.length; i++) {
                x = arrEmptyXCoordinate[i];
                y = arrEmptyYCoordinate[i];
                field[y][x] = DOT_AI;
                if (checkWin(DOT_AI, winCondition - k)) {// Если выйграл, то оставляем и выходим.
                    return;
                } else // Если не выйграл, то возвращаем пустую ячейку.
                    field[y][x] = DOT_EMPTY;
            }
        }
    }


    static boolean isCellEmpty(int y, int x){
        return field[y][x] == DOT_EMPTY;
    }

    static boolean isCellValid(int y, int x){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    static boolean checkWin(char c, int winCondition){
        int horizontal;
        int vertical;
        int[] diagonals = new int[fieldSizeX * 4]; // Массив диагоналей
        for(int y = 0; y < fieldSizeY; y++) {
            int i;
            i = -1;
            vertical = 0;
            horizontal = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                horizontal = field[y][x] == c? ++horizontal : 0; // Проверка победы по горизонталям
                vertical = field[x][y] == c? ++vertical : 0; // Проверка победы по вериткалям
                i++;
                if (isCellValid(y, x + y))
                    diagonals[i] = (field[y][x + y] == c)? ++diagonals[i]: 0; // Проверка победы по диагонале \ и расположенных выше
                else
                    diagonals[i] = 0;
                i++;
                if (isCellValid(y, x - y))
                    diagonals[i] = (field[y][x - y] == c)? ++diagonals[i]: 0; // Проверка победы по диагонале \ и расположенных ниже
                else
                    diagonals[i] = 0;
                i++;
                if (isCellValid(y, (fieldSizeY - 1 - x) + y))
                    diagonals[i] = (field[y][(fieldSizeY - 1 - x) + y] == c)? ++diagonals[i]: 0; // Проверка победы по диагонале / и расположенных выше
                else
                    diagonals[i] = 0;
                i++;
                if (isCellValid(y, (fieldSizeY - 1 - x) - y))
                    diagonals[i] = (field[y][(fieldSizeY - 1 - x) - y] == c)? ++diagonals[i]: 0; // Проверка победы по диагонале / и расположенных ниже
                else
                    diagonals[i] = 0;
                if (    horizontal == winCondition || vertical == winCondition) // Проверка достижения победного условия по горизонтали и вертикали
                    return true;
                for (int diagonal : diagonals) {
                    if (diagonal == winCondition) // Проверка достижения победного условия по диагоналям
                        return true;
                }
                }
        }
        return false;
    }

    static boolean checkDraw(){
        for(int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++ ){
                if (isCellEmpty(y, x)) return false;
            }
        }
        return true;
    }

    static boolean gameChecks(char dot, String s){
        if (checkWin(dot, winCondition)){
            System.out.println(s);
            return true;
        }

        if (checkDraw()){
            System.out.println("Ничья.");
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Приветсвую в игре \"Крестики нолики\"");
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameChecks(DOT_HUMAN, "Вы победили")) {
                    totalNumberTurn = -1;
                    break;
                }
                aiTurn();
                printField();
                if (gameChecks(DOT_AI, "Вы проиграли")) {
                    totalNumberTurn = -1;
                    break;
                }
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");

            if (!sc.next().toLowerCase(Locale.ROOT).equals("y")) {
                System.out.println("*************Конец*************");
                break;
            }
            System.out.println("************************************************");
        }
    }
}

