package ru.geekbrains.ad.lesson7;

public class Main {
    public static void main(String[] args) {
//      Cat cat = new Cat("Чача",7);
        Cat[] catsArray = new Cat[3];

        catsArray[0] = new Cat("Барчик",4);
        catsArray[1] = new Cat("Мурзик",6);
        catsArray[2] = new Cat("Борис",10);

        Plate plate = new Plate(19);

        System.out.println("Еды в миске до кормежки: ");
        plate.info();

//      plate.setFood(plate.getFood() - cat.getAppetite());

//        cat.eat(plate);

        // Задание 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
        for (Cat cat : catsArray) {
            cat.eat(plate);
        }

        System.out.println("Еды в миске после кормежки: ");
        plate.info();

//        System.out.println("Кот сыт: " + cat.getSatiety());

    }
}
