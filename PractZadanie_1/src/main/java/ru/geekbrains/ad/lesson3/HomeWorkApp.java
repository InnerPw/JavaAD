package ru.geekbrains.ad.lesson3;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class HomeWorkApp {
    public static Random random = new Random();

    public static void main(String[] args) {
          taskOne(6);
          taskTwo();
          taskThree();
          taskFour(4);
          taskFive(4,12);
          taskSix(4);
          int[] values = {2, 2, 3, 2, 5}; //массив для taskSeven
          System.out.println(taskSeven(values,3));
          //taskEight();
    }

    public static void taskOne(int size) {
        /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
        [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        int[] mass_one = new int[size];
        System.out.println("Задание 1:");
        System.out.println("Значения массива:");
        for(int i = 0; i < size; i++) {
            mass_one[i] = random.nextInt(2);
            System.out.println("mass_one[" + i + "] = " + mass_one[i]);
        }
        System.out.println(Arrays.toString(mass_one));
        System.out.println(" ");
        System.out.println("Измененные значения массива:");
        for(int i = 0; i < size; i++) {
            if (mass_one[i] == 0) {
                mass_one[i] = 1;
            }   else mass_one[i] = 0;
            System.out.println("mass_one[" + i + "] = " + mass_one[i]);
        }
        System.out.println(Arrays.toString(mass_one));
        System.out.println(" ");
    }

    public static void taskTwo() {
        /*
        2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
        значениями 1 2 3 4 5 6 7 8 … 100;
         */
        int[] mass_two = new int[100];
        System.out.println();
        System.out.println("Задание 2:");
        for(int i = 0; i < 100; i++) {
            mass_two[i] = i + 1;
            System.out.println("mass_two[" + i + "] = " + mass_two[i]);
        }
        System.out.println(Arrays.toString(mass_two));
        System.out.println(" ");
    }

    public static void taskThree() {
        /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему
        циклом, и числа меньшие 6 умножить на 2;
         */
        int[] mass_three = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println();
        System.out.println("Задание 3:");
        System.out.println("Значения массива: " + Arrays.toString(mass_three));
        for(int i = 0; i < mass_three.length; i++) {
            if (mass_three[i] < 6) {
                mass_three[i] = mass_three[i] * 2;
            }
        }
        System.out.println("Измененные значения массива: " + Arrays.toString(mass_three));
    }

    public static void taskFour(int size) {
        /*
        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
        одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        (можно только одну из диагоналей, если обе сложно). Определить элементы одной из
        диагоналей можно по следующему принципу: индексы таких элементов равны, то есть
        [0][0], [1][1], [2][2], …, [n][n];
         */
        int[][] mass_four = new int[size][size];
        System.out.println();
        System.out.println("Задание 4:");
        System.out.println("Значения массива:");
        //заполняем массив нулями и выводим в консоль
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                mass_four[i][j] = 0;
                if (j == (size - 1)) {
                    System.out.print(mass_four[i][j] + " ");
                    System.out.println();
                } else System.out.print(mass_four[i][j] + " ");
            }
        }

        System.out.println();
        System.out.println("Новые значения массива:");
        //проставляем единички для первой диагонали и выводим в консоль
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (i == j) {
                    mass_four[i][j] = 1;
                }
                if (j == (size - 1)) {
                    System.out.print(mass_four[i][j] + " ");
                    System.out.println();
                } else System.out.print(mass_four[i][j] + " ");
            }
        }

        System.out.println();
        System.out.println("Две диагонали:");
        int k = size - 1;
        //проставляем единички для второй диагонали
        for(int i = 0; i < size; i++) {
            mass_four[i][k] = 1;
            k = k - 1;
        }

        //выводим массив со второй диагональю в консоль
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (j == (size - 1)) {
                    System.out.print(mass_four[i][j] + " ");
                    System.out.println();
                } else System.out.print(mass_four[i][j] + " ");
            }
        }
    }

    public static void taskFive(int len, int initialValue) {
        /*
        5. Написать метод, принимающий на вход два аргумента: len и initialValue,
        и возвращающий одномерный массив типа int длиной len, каждая ячейка которого
        равна initialValue;
         */
        int[] mass_five = new int[len];
        System.out.println();
        System.out.println("Задание 5:");
        System.out.println("Значения массива:");
        for(int i = 0; i < len; i++) {
            mass_five[i] = initialValue;
        }
        System.out.println(Arrays.toString(mass_five));
    }

    public static void taskSix(int size) {
        /*
        6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
         */
        int[] mass_six = new int[size];
        System.out.println();
        System.out.println("Задание 6:");
        System.out.println("Значения массива:");
        //заполняем массив случайными числами
        for(int i = 0; i < size; i++) {
            mass_six[i] = random.nextInt(150);
        }
        System.out.println(Arrays.toString(mass_six));
        System.out.println();

        int compare_min = mass_six[0]; //присваиваем начальное значение для сравнения
        int compare_max = mass_six[0]; //присваиваем начальное значение для сравнения
        //сравниваем элементы
        for(int i = 0; i < size; i++) {
            if (mass_six[i] < compare_min) {
                compare_min = mass_six[i];
            }
            if (mass_six[i] > compare_max) {
                compare_max = mass_six[i];
            }
        }
        System.out.println("Минимальный элемент: " + compare_min);
        System.out.println("Максимальный элемент: " + compare_max);
    }

    public static boolean taskSeven(int[] numbers, int div) {
        /*
        7. ** Написать метод, в который передается не пустой одномерный целочисленный
        массив, метод должен вернуть true, если в массиве есть место, в котором сумма
        левой и правой части массива равны.

        **Примеры:
        checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
        checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1

        граница показана символами |||, эти символы в массив не входят и не имеют
        никакого отношения к ИЛИ.
         */

        //div - с номера этого элемента начинается правая часть массива
        int size = numbers.length; //определяем длину массива
        int left = 0; //объявляем переменную для суммы левой части
        int right = 0; //объявляем переменную для суммы правой части
        System.out.println();
        System.out.println("Задание 7:");

        //подсчитываем сумму левой части
        for(int i = 0; i < div; i++) {
            left = left + numbers[i];
        }

        //подсчитываем сумму правой части
        for(int j = div; j < size; j++) {
            right = right + numbers[j];
        }

        return left == right;
    }

    public static void taskEight(int a, int b) {
        /*
        8. *** Написать метод, которому на вход подается одномерный массив и число n
        (может быть положительным, или отрицательным), при этом метод должен сместить
        все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
        задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при
        n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) ->
        [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
         */

    }

}
