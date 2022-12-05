package ru.geekbrains.ad.lesson5;

public class Employee {
    private String FIO;
    private String jobTitle;
    private String email;
    private int salary;
    public int age;

    public Employee(String FIO, String jobTitle, String email, int salary, int age) {
        this.FIO = FIO;
        this.jobTitle = jobTitle;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String FIO) {
        this.FIO = FIO;
        this.jobTitle = " ";
        this.email = " ";
    }

    public Employee() {
        this.FIO = " ";
        this.jobTitle = " ";
        this.email = " ";
    }

    void employeeInfo() {
        System.out.println(String.format("Сотрудник: %s, Должность: %s, Адрес электронной почты: %s, Зарплата: %s, Возраст: %s", FIO, jobTitle, email, salary, age));
    }

     /*void getEmloyeeAge(Employee employeeArray) {
        for (Employee employee : employeeArray) {
            if (this.age > 40)
                employee.employeeInfo();
        }
    }*/

}
