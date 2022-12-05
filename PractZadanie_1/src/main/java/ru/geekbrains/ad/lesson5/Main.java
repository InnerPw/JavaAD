package ru.geekbrains.ad.lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Иванов Сергей Сергеевич", "Руководитель", "mynute130@yandex.ru", 150000, 43);
        employeeArray[1] = new Employee("Ретов Дмитрий Олегович", "Заместитель руководителя", "mars01@yandex.ru", 95000, 32);
        employeeArray[2] = new Employee("Максимов Николай Николаевич", "Специалист", "jurynod929@mail.ru", 64000, 23);
        employeeArray[3] = new Employee("Кретова Инна Артемьевна", "Специалист", "ladaryb2@yandex.ru", 64000, 29);
        employeeArray[4] = new Employee("Целиков Владимир Федорович", "Бухгалтер", "nunuprob80@gmail.com", 80000, 36);

        for (Employee employee : employeeArray) {
            if (employee.age > 40)
            employee.employeeInfo();
        }
    }
}
