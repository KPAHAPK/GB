package ru.geekbrains.courses.kpah.hw8;

//        1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
//        2. Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
//        3.* Написать метод, который проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
//        4.** Написать метод, проверяющий, есть ли указанное слово в папке


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws IOException {

        //region Task01
        String str01 = "How many cookies could a good cook cook, if a good cook could cook cookies? ";
        String str02 = "A good cook could cook as many cookies as a good cook who could cook cookies.";

        File file = new File("C:\\hw8");
        if (!file.exists()) {
            System.out.println("Директория не существует");
            if (file.mkdir())
                System.out.println("Диерктория успешно создана");
        } else
            System.out.println("Не удалось создать директорию");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\hw8\\str01.txt");
            byte[] buf = str01.getBytes();
            System.out.println("\nПервая строка в байтах: " + Arrays.toString(buf));
            fileOutputStream.write(buf, 0, buf.length);
            System.out.println("Данные успешно записаны в файл str01.txt.");

            FileOutputStream fileOutputStream1 = new FileOutputStream("C:\\hw8\\str02.txt");
            byte[] buf1 = str02.getBytes();
            System.out.println("\nВторая строка в байтах: " + Arrays.toString(buf1));
            fileOutputStream1.write(buf1, 0, buf1.length);
            System.out.println("Данные успеШно записаны в файл str02.txt.");
        } finally {
        }
        //endregion

        //region Task02
        System.out.println("\n***************");
        System.out.println("Задание 2:");
        appendFiles("C:\\hw8\\str01.txt", "C:\\hw8\\str02.txt");
        //endregion

        //region Task03
        System.out.println("\n***************");
        System.out.println("Задание 3:");
        searchWordFromFile("C:\\hw8\\str01_append_to_str02.txt", "as");
        //endregion

        //region Task04
        System.out.println("\n***************");
        System.out.println("Задание 4:");
        searchWordFromDirectory("C:\\hw8", "as");
        //endregion

    }

    //Task02
    public static void appendFiles(String directoryOfFirstFile, String directoryOfSecondFile) throws IOException {
        try (FileReader fileReader = new FileReader(directoryOfFirstFile);
             FileReader fileReader1 = new FileReader(directoryOfSecondFile)) {
            char[] buf = new char[256];
            System.out.println("\n***Чтение файла str01.txt***");
            int c;
            while ((c = fileReader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
            }
            System.out.println("Чтение файла str01.txt в массив символов: " + Arrays.toString(buf));
            System.out.println("***Чтение из файла str01.txt завершено***");

            System.out.println("\n***Чтение файла str02.txt***");
            char[] buf1 = new char[256];
            while ((c = fileReader1.read(buf1)) > 0) {
                if (c < 256) {
                    buf1 = Arrays.copyOf(buf1, c);
                }
            }
            System.out.println("Чтение файла str01.txt в массив символов: " + Arrays.toString(buf1));
            System.out.println("***Чтение из файла str02.txt завершено***");


            String string = new String(buf);
            String string1 = new String(buf1);
            System.out.println("\nТекст после слияния: " + string + string1);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\hw8\\str01_append_to_str02.txt");
                byte[] bufAppendedToBuf1 = (string + string1).getBytes();
                System.out.println("Первая + вторая строка в байтах: " + Arrays.toString(bufAppendedToBuf1));
                fileOutputStream.write(bufAppendedToBuf1, 0, bufAppendedToBuf1.length);
                System.out.println("Создан файл str01_append_to_str02.txt.");
            } finally {
            }
        }
    }

    //Task03
    public static void searchWordFromFile(String directoryOfFile, String word) throws IOException {

        File file = new File(directoryOfFile);
        Scanner scanner = new Scanner(file);
        int counter = 0;
        try {
            while (scanner.hasNextLine()) {
                String textLine = scanner.nextLine();
                String[] splitText = textLine.split(" ");
                System.out.println("Разбитый текст файла str01_append_to_str02.txt" + Arrays.toString(splitText));
                for (String n : splitText) {
                    if (n.equals(word)) {
                        counter++;
                    }
                }
            }
        } finally {
            scanner.close();
        }
        String resultLine = "В файле " + directoryOfFile + " слово \"" + word + "\" встречается " + counter + " раз(-а).";
        System.out.println(resultLine);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\hw8\\search_result.txt");
            byte[] bufAppendedToBuf1 = resultLine.getBytes();
            fileOutputStream.write(bufAppendedToBuf1, 0, bufAppendedToBuf1.length);
            System.out.println("Создан файл search_result.txt");
        } finally {
        }
    }

    //Task04
    public static void searchWordFromDirectory(String directoryOf, String word) throws IOException {
        File dir = new File(directoryOf);
        File[] files = dir.listFiles();
        int counter = 0;
        System.out.println("Файлы в дирекотории " + directoryOf + ":");
        for (int i = 0; i < files.length; i++) {
            if (!files[i].toString().contains("search_result")) {
                System.out.println(files[i]);
                Scanner scanner = new Scanner(files[i]);
                try {
                    while (scanner.hasNextLine()) {
                        String textLine = scanner.nextLine();
                        String[] splitText = textLine.split(" ");
                        System.out.println("Разбитый текст файла " + files[i] + Arrays.toString(splitText));
                        for (String n : splitText) {
                            if (n.equals(word))
                                counter++;
                        }
                    }
                } finally {
                    scanner.close();
                }
            }
        }
        String resultLine = "В папке " + directoryOf + " слово \"" + word + "\" встречается " + counter + " раз(-а).";
        System.out.println();
        System.out.println(resultLine);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\hw8\\search_result.txt", true);
            byte[] bufAppendedToBuf1 = ("\n" + resultLine).getBytes();
            fileOutputStream.write(bufAppendedToBuf1, 0, bufAppendedToBuf1.length);
            System.out.println("Создан файл search_result.txt");
        } finally {
        }
    }
}
