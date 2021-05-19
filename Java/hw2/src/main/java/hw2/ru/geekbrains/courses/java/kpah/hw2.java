package hw2.ru.geekbrains.courses.java.kpah;

import java.util.Arrays;
import java.util.Random;

public class hw2 {
    public static long dt1;
    public static long dt2;
    public static long dt3;
    public static long dt4;
    public static long dt5;

    public static void main(String[] args) {
        //regionTask01
        System.out.print("Task01:\nБыло: ");
        int arrBin[] = new int[10];
        final Random random = new Random();
        for (int i = 0; i < arrBin.length; i++) {
            arrBin[i] = random.ints(0, 2).findFirst().getAsInt();
            System.out.print(arrBin[i] + " ");
        }
        System.out.print("\nСтало: ");
        for (int i = 0; i < arrBin.length; i++) {
            if (arrBin[i] == 0)
                arrBin[i] = 1;
            else arrBin[i] = 0;
            System.out.print(arrBin[i] + " ");
        }
        System.out.println("\n");
        //endregion

        //regionTask02
        System.out.println("Task02: ");
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.print(Arrays.toString(arr2));
        System.out.println("\n");
        //endregion

        //regionTask03
        System.out.println("Task03:");
        int arr3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int number = 6;
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < number)
                arr3[i] = arr3[i] * 2;
            System.out.print(arr3[i] + " ");
        }
        System.out.println("\n");
        //endregion

        //regionTask04
        System.out.print("Task04: \n");
        int arr4[][] = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4.length; j++) {
                if (j == i || j == arr4.length - (i + 1))
                    arr4[i][j] = 1;
                else
                    arr4[i][j] = random.ints(-9, 10).findFirst().getAsInt();
                System.out.print(arr4[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println(" ");

        //endregion

        //regionTask05
        System.out.print("Task05: \nInternet.Off()\n");
        int[] arr5 = new int[10];
        int min = arr5[0];
        int max = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.ints(-20, 21).findFirst().getAsInt();
            System.out.print(arr5[i] + " ");
        }
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] < min)
                min = arr5[i];
            else if (arr5[i] > max)
                max = arr5[i];
        }
        System.out.println("");
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("\n");

        //endregion

        //regionTask06
        System.out.print("Task06: \n");
        for (int k = 0; k < 100000; k++) {

            int[] arr6 = new int[1000];
            for (int i = 0; i < arr6.length - 1; i++) {
                arr6[i] = random.ints(0, 10).findFirst().getAsInt();
//            System.out.print(arr6[i] + " ");
            }
            isDividedSumBy2(arr6);
            System.out.println("\n");
        }
        System.out.println("Бинар: " + dt1);
        System.out.println("Твой 1: " + dt2);
        System.out.println("Веталя: " + dt3);
        System.out.println("Твой 2: " + dt4);
        System.out.println("Твой 3: " + dt5);
        //endregion

        //regionTask07
        System.out.print("Task06: \n");
        int[] arr7 = new int[7];
        for (int i = 0; i < arr7.length; i++) {
            arr7[i] = random.ints(0, 2).findFirst().getAsInt();
        }
        System.out.println(Arrays.toString(arr7));
        int n, nMax, nMin;
        nMax = arr7.length;
        nMin = (arr7.length - 1) * (-1);
        n = random.ints(nMin, nMax).findFirst().getAsInt();

        shiftArray(arr7, n);
        //endregion
    }

    //regionMethod06
    private static void isDividedSumBy2(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum = sum + j;
        }
        if (sum % 2 != 0) {
//            System.out.println("\nСумма чисел массива: " + sum + ". Не кратна 2. Баланса нет.");
        }
        else {
//            System.out.print("\nВариант 1:");
            long t1 = System.nanoTime();
//            checkBalance(arr);
            long t2 = System.nanoTime();
//            dt1 = t2 - t1;
//            System.out.printf("\nЗатраченное время на МОЙ варинат1: %.2f \n", (float) dt);


//            System.out.print("-----------------------\nБинарный вариант:");
            t1 = System.nanoTime();
            checkBalance2(arr);
            t2 = System.nanoTime();
            dt1 += t2 - t1;
//            System.out.printf("Затраченное время на МОЙ БИНАРНЫЙ вариант: %.2f \n", (float) dt);

//            System.out.print("-----------------------\nТвой 1 вариант:");
            t1 = System.nanoTime();
            checkBalance3(arr);
            t2 = System.nanoTime();
            dt2 += t2 - t1;
//            System.out.printf("Затраченное время на ТВОЙ 1 вариант: %.2f \n", (float) dt);

//            System.out.print("-----------------------\nТвой 2 вариант :");
            t1 = System.nanoTime();
            checkBalance4(arr);
            t2 = System.nanoTime();
            dt3 += t2 - t1;
//            System.out.printf("Затраченное время на ТВОЙ 2 вариант: %.2f \n", (float) dt);

//            System.out.print("-----------------------\nВеталя вариант :");
            t1 = System.nanoTime();
            checkBalance5(arr);
            t2 = System.nanoTime();
            dt4 += t2 - t1;
//            System.out.printf("\nЗатраченное время на Веталя вариант: %.2f \n", (float) dt);

//            System.out.print("-----------------------\nТвой 3 вариант :");
            t1 = System.nanoTime();
            checkBalance6(arr);
            t2 = System.nanoTime();
            dt5 += t2 - t1;
//            System.out.printf("Затраченное время на ТВОЙ 3 вариант: %.2f \n", (float) dt);
        }
    }

    private static void checkBalance(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;
        StringBuilder leftBalance = new StringBuilder();
        StringBuilder rightBalance = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            leftSum = leftSum + arr[i];
            leftBalance.append(arr[i]).append(" ");
            for (int j = i + 1; j < arr.length; j++) {
                rightSum = rightSum + arr[j];
                rightBalance.append(arr[j]).append(" ");
            }
            if (leftSum == rightSum) {
//                System.out.print("\nЕсть баланс: " /*+ leftBalance + "|| " + rightBalance*/);
                return;
            } else {
                rightSum = 0;
                rightBalance = new StringBuilder();
            }
        }
    }

    private static void checkBalance2(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int middleIndex = (rightIndex + leftIndex) / 2;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0, j = middleIndex + 1 ; i <= middleIndex; i++, j++) {
            leftSum += arr[i];
            rightSum += arr[j];
        }
        int step = 0;
//        for (int i = middleIndex + 1; i < arr.length; i++) {
//            rightSum += arr[i];
//        }
        do {
            step = 0;
            if (leftSum == rightSum) {
//                System.out.println("\nЕсть баланс: после " + middleIndex + " элемента.");
                return;
            }
            if (leftSum > rightSum) {
                rightIndex = middleIndex;
                middleIndex = (rightIndex + leftIndex) / 2;
                for (int i = middleIndex + 1; i <= rightIndex; i++) {
                    step += arr[i];
                }
                leftSum -= step;
                rightSum += step;
            } else {
                leftIndex = middleIndex;
                middleIndex = (rightIndex + leftIndex) / 2;
                for (int i = leftIndex + 1; i <= middleIndex; i++) {
                    step += arr[i];
                }
                leftSum += step;
                rightSum -= step;
            }
        }while (!(rightIndex == leftIndex + 1));
    }

    private static void checkBalance3(int[] arr) {
        int sumArr = 0;
        int balance;
        for (int a :
                arr) {
            sumArr += a;
        }
        balance = sumArr / 2;
        for (int i = 0; i < arr.length; i++) {
            balance = balance - arr[i];
            if (balance == 0){
//                System.out.println("\nБаланс массива: после " + i + " элемента.");
                return;
            }
        }
    }

    public static void checkBalance4(int[] arrays) {
        int balanceSum = 0, arraysSum = 0, i = 0;
        for (int z : arrays)
            arraysSum += z;
        for (int l : arrays) {
            balanceSum += l;
            if (balanceSum > arraysSum / 2) {
//                System.out.println("Баланса нету");
                break;
            } else if (arraysSum / 2 == balanceSum) {
//                System.out.println("Сумма массива: " + arraysSum);
//                System.out.println("Баланс: " + arraysSum / 2);
//                System.out.println("Длинна массива: " + arrays.length);
//                System.out.println("Баланс после: " + i + " индекса\n");
                break;
            }
                i++;

        }
    }
    static void checkBalance5(int[] arr) {

        int arrSum = 0;
        for (int l : arr)
            arrSum += l;

        int rSum = 0;
        for (int i : arr) {
            rSum += i;

            if(rSum == arrSum - rSum) {
//                System.out.print("Balance Detected!!!");
            }
        }
    }

    public static boolean checkBalance6(int[] arr) {

        int balSum = 0, arrSum = 0;
        for (int z : arr) {
            arrSum += z;

        }

        int i = 0;
        while  ( !(balSum >= arrSum / 2)) {
            if(arrSum % 2 != 0){
                System.out.println(false);
                break;
            }
            balSum += arr[i++];

        }
        return balSum >= arrSum / 2;

    }



    //endregion

    //regionMethod07
    private static void shiftArray(int[] arr, int n) {
        System.out.print("Смещение: ");
        if (n == 0) {
            System.out.println("без смещения.");
        }
        if (n > 0) {
            System.out.print("на " + Math.abs(n) + " вправо.\n");
            int buffer;
            for (int i = 0; i < arr.length - Math.abs(n); i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    buffer = arr[(j + 1) % arr.length];
                    arr[(j + 1) % arr.length] = arr[j];
                    arr[j] = buffer;
                }
            }
        }
        if (n < 0) {
            System.out.print("на " + Math.abs(n) + " влево.\n");
            int buffer;
            for (int i = 0; i < arr.length - Math.abs(n); i++) {
                for (int j = arr.length - 1; j > 0; j--) {
                    buffer = arr[(j - 1) % arr.length];
                    arr[(j - 1) % arr.length] = arr[j];
                    arr[j] = buffer;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }//endregion
}



