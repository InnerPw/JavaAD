package ru.geekbrains.ad.lesson6;

public abstract class Animal {
    public String name;
    public String kind;
    public String color;
    public int age;
    public int run;
    public int swim;

    public Animal(String name, String kind, String color, int age, int run, int swim) {
        this.name = name;
        this.kind = kind;
        this.color = color;
        this.age = age;
        this.run = run;
        this.swim = swim;
    }

    public void run() {
        if (run > 0) {
            System.out.printf("%s может пробежать %s метров.%n", name, run);
        } else {
            System.out.printf("%s не может бегать.%n", name);
        }
    }

    public void swim() {
        if (swim > 0) {
            System.out.printf("%s может проплыть %s метров.%n", name, swim);
        } else {
            System.out.printf("%s не может плавать.%n", name);
        }
    }
}
