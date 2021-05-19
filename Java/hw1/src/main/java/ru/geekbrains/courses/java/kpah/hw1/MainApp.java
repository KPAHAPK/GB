package ru.geekbrains.courses.java.kpah.hw1;

public class MainApp {
    public static void main(String[] args) {
       //regionTask02
        byte a1 = 127;
        short b1 = 54;
        int  c1 = 41412;
        long d1 = -4757592475L;
        float e1 = 293810.13f;
        double f1 = -194184.141;
        char g1 = '\u12d2';
        boolean h1 = true;
        //endregion

        //regionTask03
        float a, b, c, d, res1;
        a = 23.43f;
        b = -123.2f;
        c = 3.42f;
        d = 31.32f;
        equation(a * (b + (c / d)));
        //endregion

        //regionTask04
        float firstNumber, secondNumber, doSumm;
        firstNumber = 16f;
        secondNumber = 4f;
        doSumm = firstNumber + secondNumber;
        System.out.println("Task04: " + between10And20((doSumm)));
        //endregion

        //regionTask05
        int positiveNegativeTestNumber = -8;
        isPositiveOrNegative(positiveNegativeTestNumber);
        //endregion

        //regionTask06
        System.out.println("Task06: " + isPositiveOrNegative2(8));
        //endregion

        //regionTask07
        printName("Name");
        //endregion

        //regionTask08
        int year = 800;
        isLeapYear(year);
        //endregion




    }
    //regionMethodTask03
    public static void equation(float res){
        System.out.println("Task03: " + res);
    }
    //endregion

    //regionMethodTask04
    public static boolean between10And20(float summ) {
        if (summ >= 10 && summ <= 20) {
            return true;
        } else {
            return false;
        }
    }
    //endregion

    //regionMethodTask05
    public static void isPositiveOrNegative(int check){
        if (check >= 0){
            System.out.println("Task05: " + "Positive");
        } else {
            System.out.println("Task05: " + "Negative");
        }

    }
    //endregion

    //regionMethodTask06
    public static boolean isPositiveOrNegative2(int check){
        if (check >= 0){
            return true;
        } else {
            return false;
        }
    }
    //endregion

    //regionMethodTask07
    public static void printName(String txtToPrint){
        System.out.println("Task07: " + txtToPrint);
    }
    //endregion

    //regionMethodTask08
    public static void isLeapYear(int check) {
        if (check % 400 == 0){
            System.out.println("Task08: " + "Leap year");
        }else if (check % 100 == 0){
            System.out.println("Task08: " + "Common year");
        }else if (check % 4 == 0){
            System.out.println("Task08: " + "Leap year");
        } else {
            System.out.println("Task08: " + "Common year");
        }

    }

    //endregion

}
