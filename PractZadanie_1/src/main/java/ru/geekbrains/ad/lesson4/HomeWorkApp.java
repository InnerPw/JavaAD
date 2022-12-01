package ru.geekbrains.ad.lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    private static int size;
    public static int winSize;

    private static int rLN;
    private static int cLN;
    private static int wcount;
    private static final char DOT_EMPTY = '*';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';

    private static char[][] MAP = new char[size][size];

    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();

    private static int turnsCount = 0;
    public static final String HEADER_FIRST_SYMBOL = "—";
    public static final String SPACE_MAP_SYMBOL = " ";

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        do {
            System.out.println("\n\nИгра начинается!");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "у", "+", "да" -> true;
            default -> false;
        };
    }

    private static void init() {
        turnsCount = 0;
        //получить размер игрового поля
        size = getSizeFromUser();
        //подобрать победную серию для выбранного размера
        winSize = getWinSize();
        initMap();
    }

    private static int getSizeFromUser() {
        System.out.println("Необходимо выбрать размер игрового поля: ");
        return getValidNumberFromScanner(3, 9);
    }

    private static int getWinSize() {
        if (size >= 3 && size <= 6) {
            return 3;
        } else if (size >= 6 && size <= 10) {
            return 4;
        }
        return 5;
    }
    private static void initMap() {
        MAP = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printBodyMap() {
        for (int i = 0; i < size; i++) {
            printMapNumber(i);
            for (int j = 0; j < size; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP_SYMBOL);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP_SYMBOL);
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP_SYMBOL);
        for (int i = 0; i < size; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void playGame() {
        while (true) {
            //ход человека
            humanTurn();
            //печать игрового поля
            printMap();
            //проверка на конец игры
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            //ход компьютера
            aiTurn();
            //печать игрового поля
            printMap();
            //проверка на конец игры
            if (checkEnd(DOT_AI)) {
                break;
            }
        }
    }

    private static boolean checkEnd(char symbol) {
        //победа

        if(checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("УРА! ВЫ ПОБЕДИЛИ!");
            } else {
                System.out.println("Восстание близко... Скайнет победил...");
            }
        }


        //ничья
        if (checkDraw()) {
            System.out.println("НИЧЬЯ!");
            return true;
        }

        return false;
    }

    private static boolean checkDraw() {
        /*
        for (char[] chars : MAP) {
            for (char symbol : chars) {
                if (symbol == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
        */
        return turnsCount >= size * size;
    }

    private static boolean checkWin(char symbol) {
        //проверка строки
        for (int i = 0; i < size; i++) {
            if (MAP[rLN][i] == symbol) {
                wcount++;
            }
        }
        if (wcount == winSize) {
            return true;
        } else wcount = 0;

        //проверка столбца
        for (int i = 0; i < size; i++) {
            if (MAP[i][cLN] == symbol) {
                wcount++;
            }
        }
        if (wcount == winSize) {
            return true;
        } else wcount = 0;
        /*//проверка основной диагонали
        int rLNmin;
        rLNmin = rLN - winSize;
        if (rLNmin < 0) {
            rLNmin = 0;
        }

        int cLNmin;
        cLNmin = cLN - winSize;
        if (cLNmin < 0) {
            cLNmin = 0;
        }

        int rLNmax;
        rLNmax = rLN + winSize;
        if (rLNmax > size) {
            rLNmax = size - 1;
        }

        int cLNmax;
        cLNmax = cLN + winSize;
        if (cLNmax > size) {
            cLNmax = size - 1;
        }

        for (int i = rLNmin, j = cLNmin; i <= rLNmax && j <= cLNmax; i++, j++) {
            if (MAP[i][j] == symbol) {
                wcount++;
            } else wcount = 0;
        }
        if (wcount == winSize) {
            return true;
        }*/

        //проверка вторичной диагонали


        return false;
    }


    private static void humanTurn() {
        System.out.println("\nХОД ЧЕЛОВЕКА!");

        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.println("Введите координату строки: ");
            rowNumber = getValidNumberMapLineFromScanner();
            rLN = rowNumber;
            System.out.println("Введите координату столбца: ");
            columnNumber = getValidNumberMapLineFromScanner();
            cLN = columnNumber;

            if(isCellFree(rowNumber, columnNumber)) {
                break;
            }

            System.out.printf("ОШИБКА! Ячейка с координатами %s:%s уже используется", rowNumber + 1, columnNumber + 1);
        }

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static int getValidNumberMapLineFromScanner() {
        return getValidNumberFromScanner(1, size) - 1;
    }

    private static int getValidNumberFromScanner(int min, int max) {
        while (true) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n, min, max)) {
                    return n;
                }
                System.out.printf("Ошибка! Проверьте значение координаты. Должно быть от %s до %s. Введено: %s%n", min, max, n);
            } else {
                System.out.printf("ОШИБКА! Ввод допускает лишь целые числа. %s - не целое число!%n", in.next());
                System.out.print("Введите число: ");
            }
        }

    }

    private static boolean isNumberValid(int n, int min, int max) {
        return n >= min && n <= max;
    }

    private static void aiTurn() {
        System.out.println("\nХОД КОМПЬЮТЕРА!");

        int rowNumber;
        int columnNumber;

        do {
            rowNumber = random.nextInt(size);
            columnNumber = random.nextInt(size);
        } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }
}
