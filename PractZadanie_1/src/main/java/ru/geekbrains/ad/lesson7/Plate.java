package ru.geekbrains.ad.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println(food);
        System.out.println();
    }

    public void decreaseFood(int n) {
        // Задание 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
        if ((food - n) >= 0) {
            food -= n;
        }
    }

    public void addFood(int n) {

    }
}
