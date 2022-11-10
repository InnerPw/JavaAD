package ru.geekbrains.ad.lesson2;

public class HomeWorkApp {
    public static void main(String[] args) {
        taskOne(1, 13);
        taskTwo(-14);
        taskThree(1); //работает, не возвращает значение
        taskThree_2(1);
        taskFour(4, "rumble");
        //taskFive(1600); //не работает и не возвращает значение
        taskFive_2(12);
    }

    public static void taskOne(int a, int b) {
        /*
        1. Написать метод, принимающий на вход два целых числа и проверяющий,
        что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
        в противном случае – false.
         */

        int c = a + b;
        if (c >= 10 && c <= 20) {
            System.out.println("Задание 1: true");
        }
        else System.out.println("Задание 1: false");
    }
    public static void taskTwo(int a) {
        /*
        2. Написать метод, которому в качестве параметра передается целое число, метод должен
        напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль
        считаем положительным числом.
         */

        if (a >= 0) {
            System.out.println("Задание 2: число положительное");
        }
        else System.out.println("Задание 2: число отрицательное");
    }

    public static boolean taskThree(int a) {
        /*
        3. Написать метод, которому в качестве параметра передается целое число. Метод должен
        вернуть true, если число отрицательное, и вернуть false если положительное.
         */
        //ничего не выводит
        if (a < 0) {
            return true;
        }
        else return false;
    }

    public static void taskThree_2(int a) {
        /*
        3. Написать метод, которому в качестве параметра передается целое число. Метод должен
        вернуть true, если число отрицательное, и вернуть false если положительное.
         */
        if (a < 0) {
            System.out.println("Задание 3: true");
        }
        else System.out.println("Задание 3: false");
    }

    public static void taskFour(int number, String str) {
        /*
        4. Написать метод, которому в качестве аргументов передается строка и число,
        метод должен отпечатать в консоль указанную строку, указанное количество раз;
         */
        int i;
        System.out.println("Задание 4:");
        for (i = 0; i < number; i++) {
            System.out.println(str);
        }
    }

/*    public static boolean taskFive(int a) {
        *//*
        5. * Написать метод, который определяет, является ли год високосным, и возвращает
        boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным,
        кроме каждого 100-го, при этом каждый 400-й – високосный.
         *//*
        //вариант через boolean, не возвращает значение
        int check;
        int inner_check100;
        int inner_check400;
        check = a % 4;
        inner_check100 = a % 100;
        inner_check400 = a % 400;
        if (check == 0) {
            if (inner_check100 == 0 && inner_check400 == 0) {
                return true;
            } else if (inner_check100 == 0 && inner_check400 != 0) {
                return false;
            } else if (inner_check100 != 0 && inner_check400 != 0) {
                return true;
            }
        } else return false;
    }*/

    public static void taskFive_2(int a) {
        /*
        5. * Написать метод, который определяет, является ли год високосным, и возвращает
        boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным,
        кроме каждого 100-го, при этом каждый 400-й – високосный.
         */
        //вариант не через boolean
        int check;
        int inner_check100;
        int inner_check400;
        check = a % 4;
        inner_check100 = a % 100;
        inner_check400 = a % 400;
        if (check == 0) {
            if (inner_check100 == 0 && inner_check400 == 0) {
                System.out.println("Задание 5: год високосный!");
            }
            else if (inner_check100 == 0 && inner_check400 != 0) {
                System.out.println("Задание 5: год не високосный!");
            }
            else if (inner_check100 != 0 && inner_check400 != 0) {
                System.out.println("Задание 5: год високосный!");
            }
        } else System.out.println("Задание 5: год не високосный!");
    }
}
