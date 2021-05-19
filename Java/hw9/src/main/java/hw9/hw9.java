package hw9;

import java.util.Random;

public class hw9 {

    private String[][] array;
    int arrSum;
    static int blank = 6;

    public static void main(String[] args) {
        hw9 a = new hw9();
       try {
           a.setArray();
           int[][] arrInt = a.arrayStringToInt(a.getArray());
           a.arrSum = a.sumArray(arrInt);
           System.out.println("Сумма чисел массива равна: " + a.arrSum);
           int b = 0;
           Random random = new Random();
           b = random.ints(1,2, 4).findFirst().getAsInt();       }
       catch (NumberFormatException e1){
           System.out.println("Ошибка данных масива.");
           e1.printStackTrace();
       }
       catch (ArrayIndexOutOfBoundsException e2){
           System.out.println("Ошибка длины массива.");
           e2.printStackTrace();
       }
    }

    public void setArray(){
        array = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "2", "7", "8"},
                {"9", "k", "3", "12"},
                {"14", "15", "16", "17"}};
        checkArraySize(array.length, array[0].length);
    }

    public String[][] getArray(){
        return array;
    }

    public int[][] arrayStringToInt(String[][] arrString) throws NumberFormatException{
        int[][] arrInt = new int[arrString.length][arrString[0].length];
        int x;
        for (int i = 0; i < arrString.length; i++) {
            for (int j = 0; j < arrString[0].length; j++) {
                if (!isDigit(arrString[i][j])) {
                    throw new NumberFormatException("MyArrayDataException [" + i + "] " + "[" + j + "]");
                }else{
                    x = Integer.parseInt(arrString[i][j]);
                    arrInt[i][j] = x;
                }
            }
        }
        return arrInt;
    }

    public int sumArray(int[][] arr) {
        int arrSum = 0;
        for (int[] ints : arr) {
            for (int i = 0; i < arr[0].length; i++) {
                arrSum += ints[i];
            }
        }
        return arrSum;
    }

    public void checkArraySize(int n, int l) throws ArrayIndexOutOfBoundsException{
        if (n != 4 || l != 4)
            throw new ArrayIndexOutOfBoundsException("MyArraySizeException");
    }

    public boolean isDigit(String arrElement){
        try {
            Integer.parseInt(arrElement);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
