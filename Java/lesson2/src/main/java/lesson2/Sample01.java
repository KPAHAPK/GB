package lesson2;

public class Sample01 {


    enum Seasons { Winter, Spring, Summer, Autumn };

    enum SeasonsV2 {
        Winter("Зима", " Декабрь - Февраль. Прогнозируемая Т: ", (int) (Math.random() * (55 + 1) - 50)),
        Spring("Весна", " Март - Май. Прогнозируемая Т: ", (int) (Math.random() * (25 + 1) - 5)),
        Summer("Лето", " Июнь - Август. Прогнозируемая Т: ", (int) (Math.random() * 15 + 15)),
        Autumn("Осень", " Сентябрь - Ноябрь. Прогнозируемая Т: ", (int) (Math.random() * (20 + 1) - 5));

        private String description;
        private String months;
        private int temperature;

        SeasonsV2(String descript, String month, int temperature){
            this.description = descript;
            this.months = month;
            this.temperature = temperature;

        }


        public String getDescriptionAndMonth () {
            return description + months + temperature;
        }
    }

    public static void task1(){
        System.out.println("Process task1 ...");
    }

    public static void task2(){
        System.out.println("Process task2 ...");
    }

    public static void main(String[] args) {

        int taskNumber = 4;

        switch (taskNumber){

            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            default:
                System.out.println("Не удалось определить блок подпрограммы.");
                break;
        }

        switch (taskNumber){

            case 1:
                task1();
                break;
            case 2:
            case 3:
            case 4:
                task2();
                break;
            default:
                System.out.println("Не удалось определить блок подпрограммы.");
                break;
        }

        Seasons seasons  = Seasons.Winter;

        switch (seasons){
            case Winter:
                System.out.println("Зима");
                break;
            case Summer:
                System.out.println("Лето");
                break;
            default:
                System.out.println("Другое время года.");
                break;
        }

        SeasonsV2 seasonsV2 = SeasonsV2.Spring;
        System.out.println("seasonsV2: " + seasonsV2.getDescriptionAndMonth());

    }
}
