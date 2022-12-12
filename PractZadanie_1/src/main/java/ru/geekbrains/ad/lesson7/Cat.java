package ru.geekbrains.ad.lesson7;

public class Cat {
    private String name;
    private int appetite;

    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate plate) {
        // Задание 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
        // Задание 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            this.setSatiety(true);
            System.out.printf("Котик %s покушал успешно", this.name);
            System.out.println();
        } else {
            System.out.println("Милорд, я вижу дно!.. То есть миска пуста, мне нечего есть!");
            System.out.println();
        }
    }
}
