package ru.geekbrains.courses.kpah.hw5;

//        Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//        Конструктор класса должен заполнять эти поля при создании объекта.
//        Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
//        Создать массив из 5 сотрудников.
//        Пример:
//        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//        persArray[1] = new Person(...);
//        ...
//        persArray[4] = new Person(...);
//        С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
public class Employees {
    String lastName;
    String firstName;
    String patronymic;
    String position;
    String email;
    String cellNumber;
    int salary;
    int age;

    Employees(String lastName, String firstName, String patronymic, String position, String email, String phoneNumber, int salary, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.cellNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public  String getFirstName() {
        return firstName;
    }

    public  String getPatronymic() {
        return patronymic;
    }

    public  String getPosition() {
        return position;
    }

    public  String getEmail() {
        return email;
    }

    public  String getCellNumber() {
        return cellNumber;
    }

    public  int getSalary() {
        return salary;
    }

    public  int getAge() {
        return age;
    }

    public static void main (String[]args){

        Employees[] employeesArray = new Employees[5];
        employeesArray[0] = new Employees("Ivanov", "Ivan", "Ivanovich", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employeesArray[1] = new Employees("Petrov", "Petr", "Petrovich", "Engineer", "ppetrov@mailbox.com", "895304923", 400000, 20);
        employeesArray[2] = new Employees("Vasiliev", "Vasiliy", "Vasilievich", "Engineer", "vasvsaliev@mailbox.com", "89063419", 50000, 35);
        employeesArray[3] = new Employees("Tikhanov", "Tikhon", "Tikhonovich", "Engineer", "ttiknoh@mailbox.com", "80218491", 60000, 41);
        employeesArray[4] = new Employees("Pushkin", "Aleksander", "Sergeevich", "Engineer", "pas@mailbox.com", "89252349", 70000, 50);

        for (int identifier = 0; identifier < employeesArray.length; identifier++){
            employeesArray[identifier].showEmployeesData(identifier);
        }

        System.out.println();
        System.out.print("Сотрудники старше 40 лет:");
        int i = 0;
        while(i < employeesArray.length){
            if (employeesArray[i].age >= 40){
                employeesArray[i].showEmployeesData(i);
            }
            i++;
        }

    }
    void showEmployeesData(int id) {
        System.out.format("\nСотрудник %d: \n", id + 1 );
        System.out.format
                ("Фамилия: %s \nИмя: %s \nОтчество: %s \nДолжность: %s \nЭл. почта: %s \nТелефон: %s \nЗарпалта: %d \nВозраст: %d \n",
                        getLastName(), getFirstName(), getPatronymic(), getPosition(), getEmail(), getCellNumber(), getSalary(), getAge());
    }
}





