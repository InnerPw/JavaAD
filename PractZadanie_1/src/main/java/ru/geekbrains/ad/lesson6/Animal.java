package ru.geekbrains.ad.lesson6;

public abstract class Animal {
    private String name;
    private String kind;
    private String color;
    private int age;
    private int run;
    private int swim;

    public Animal(String name, String kind, String color, int age, int run, int swim) {
        this.name = name;
        this.kind = kind;
        this.color = color;
        this.age = age;
        this.run = run;
        this.swim = swim;
    }

    public Animal(String name) {
        this.name = name;
        this.kind = "unknown";
        this.color = "unknown";
        this.age = 0;
        this.run = 0;
        this.swim = 0;
    }

    public void run() {
        if (run > 0) {
            System.out.printf("%s %s может пробежать %s метров.%n", kind, name, run);
        } else {
            System.out.printf("%s %s не может бегать.%n", kind, name);
        }
    }

    public void swim() {
        if (swim > 0) {
            System.out.printf("%s %s может проплыть %s метров.%n", kind, name, run);
        } else {
            System.out.printf("%s %s не может плавать.%n", kind, name);
        }
    }

    public void viewInfo() {
        System.out.printf("Данные о животном.%n Имя: %s%n Вид: %s%n Цвет: %s%n Возраст: %s%n", name, kind, color, age);
    }

    public String getKind() {
        return kind;
    }
}
