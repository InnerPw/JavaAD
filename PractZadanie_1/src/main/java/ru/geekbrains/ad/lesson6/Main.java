package ru.geekbrains.ad.lesson6;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[7];
        Cat[] cats = new Cat[3];
        Dog[] dogs = new Dog[4];
        Cat cat1 = new Cat("Барсик", "Черный", 2, 100, 0);
        Cat cat2 = new Cat("Суслик", "Серый", 6, 110, 20);
        Dog dog1 = new Dog("Бобик", "Бежевый", 13, 0, 20);
        Dog dog2 = new Dog("Тузик", "Коричневый", 3, 300, 150);

        cat1.run();
        cat1.swim();
        cat2.run();
        cat2.swim();
        dog1.run();
        dog1.swim();
        dog2.run();
        dog2.swim();
    }
}
