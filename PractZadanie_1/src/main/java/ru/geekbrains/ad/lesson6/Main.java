package ru.geekbrains.ad.lesson6;

public class Main {
    public static void main(String[] args) {

        Animal[] animalsArray = new Animal[4];
        animalsArray[0] = new Cat("Барсик", "Черный", 2, 100, 0);
        animalsArray[1] = new Cat("Суслик", "Серый", 6, 110, 20);
        animalsArray[2] = new Dog("Бобик", "Бежевый", 13, 0, 20);
        animalsArray[3] = new Dog("Тузик", "Коричневый", 3, 300, 150);

        for (Animal animal : animalsArray) {
            animal.viewInfo();
            animal.run();
            animal.swim();
            System.out.println();
        }

        //viewCatsCount();
        //viewDogsCount();
    }
}
