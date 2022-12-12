package ru.geekbrains.ad.lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Чача",7);
        Plate plate = new Plate(30);

        plate.info();

//      plate.setFood(plate.getFood() - cat.getAppetite());

        cat.eat(plate);

        plate.info();
    }
}
