package lesson2;


import java.util.Arrays;
import java.util.Random;

public class Sample03
{
    public static int findElemtn(int[] a, int e){
        for (int i = 0; i < a.length; i++)
            if (a[i] == e)
                return i;
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = new int[5];
        int[] arr02;
        arr02 = new int[15];

        int[] arr03 = {2, -7, 12, 9, 4};



        for (int i = 0; i < 15; i++){
            arr02[i] = i;
        }

        for (int i = 0; i < 15; i++){
            System.out.format("%d ", arr02[i]);
        }

        int el = 13;
        int res = findElemtn(arr02, el);
        System.out.println("");
        System.out.format("Искомый элемент массива %d найден по индексу %d\n", el, res);

        int[] arr4 = new int[15];
        final Random random = new Random();
        for (int i = 0; i < 15; i++){
            arr4[i] = random.ints(-10, 10).findFirst().getAsInt();
            System.out.format("%d ", arr4[i]);
        }

        System.out.println("");
        Arrays.sort(arr4);
        for (int i = 0; i < 15; i++){
            System.out.format("%d ", arr4[i]);
        }
        int el2 = 3;
        int res02 = Arrays.binarySearch(arr4, el2);
        System.out.format("Искомый элемент массива %d найден по индексу %d\n", el2, res02);



        int[][] table = new int [3][4];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 4; j++){
                table[i][j] = random.ints(-10, 10).findFirst().getAsInt();
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }

        int eX = 0;
        int eY = 0;
        int min = table[eX][eY];
        for (int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                if (table[i][j] < min){
                    min = table[i][j];
                    eX = i;
                    eY = j;
                }
            }
        }

        System.out.format("Индекс минимального элемента массива: %d %d\n", eX, eY);
        System.out.println("Значение минимального элемента: " + min);








    }
}
