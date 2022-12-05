package ru.geekbrains.ad.lesson5;

public class Employee {
    private String FIO;
    private String jobTitle;
    private String email;
    private int salary;
    private int age;

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

    public void employeeInfo() {
        System.out.println(String.format("Сотрудник: %s, Должность: %s, Адрес электронной почты: %s, Зарплата: %s, Возраст: %s", FIO, jobTitle, email, salary, age));
    }

     public int getEmployeeAge() {
         return age;
    }

}
