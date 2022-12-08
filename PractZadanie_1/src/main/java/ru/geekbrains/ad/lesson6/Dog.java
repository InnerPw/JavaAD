package ru.geekbrains.ad.lesson6;

public class Dog extends Animal {
    private int dogsCount;
    public Dog(String name, String color, int age, int run, int swim) {
        super(name, "Собака", color, age, run, swim);
        dogsCount++;
    }

    public void viewDogsCount() {
        System.out.printf("Количество кошек: %s", dogsCount);
    }
}
