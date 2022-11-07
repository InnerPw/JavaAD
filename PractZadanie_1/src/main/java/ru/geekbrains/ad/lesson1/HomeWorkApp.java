package ru.geekbrains.ad.lesson1;

import java.util.concurrent.ThreadLocalRandom;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    private static void checkSumSign() {
        int a = 13;
        int b = 22;
        if ((a + b) >= 0)
            System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }
    private static void printColor() {
        int value = ThreadLocalRandom.current().nextInt(-300, 300);
        System.out.println(value);
        if (value <= 0)
            System.out.println("Красный");
        else if (value > 0 && value <= 100)
            System.out.println("Желтый");
        else if (value > 100)
            System.out.println("Зеленый");
    }
    private static void compareNumbers() {
        int a = -10;
        int b = 150;
        if (a >= b)
            System.out.println("a >= b");
        else System.out.println("a < b");
    }
}