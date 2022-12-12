package ru.geekbrains.ad.lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Чача",7);
        Plate plate = new Plate(7);

        System.out.println("Еды в миске до кормежки: ");
        plate.info();

//      plate.setFood(plate.getFood() - cat.getAppetite());

        cat.eat(plate);

        System.out.println("Еды в миске после кормежки: ");
        plate.info();

        System.out.println("Кот сыт: " + cat.setSatiety());
    }
}
