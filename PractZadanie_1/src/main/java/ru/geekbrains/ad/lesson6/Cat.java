package ru.geekbrains.ad.lesson6;

public class Cat extends Animal {
    private int catsCount;
    public Cat(String name, String color, int age, int run, int swim) {
        super(name, "Кошка", color, age, run, swim);
        catsCount++;
    }

    public void viewCatsCount() {
        System.out.printf("Количество кошек: %s", catsCount);
    }
}
