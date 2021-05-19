package lesson2;

public class Sample02 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++){
            System.out.println("i= " + i);
        }

        for (int i = 0, k = 15; i < k; i++, k--){
            System.out.println("i - k -> " + i + "-" + k);
        }

        int j;

        for (j = 0; j < 10; j++){
            System.out.println("j= " + j);
        }

        for(;;){
            if (j > 5)
                break;
        }

        int counter = 0;

        do{
            System.out.print(counter + " ");
            counter++;
        }
        while (counter < 10);

        System.out.println("");

        while (counter > 0){
            counter--;
            System.out.print(counter + " ");
        }

        System.out.println("");

        String s1 = "Hello!";
        for (char cccc1 : s1.toCharArray() ) {
            System.out.println(cccc1);
        }

    }
}
