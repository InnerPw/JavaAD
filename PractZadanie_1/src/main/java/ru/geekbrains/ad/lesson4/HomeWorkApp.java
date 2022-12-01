package ru.geekbrains.ad.lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    private static int size;
    private static int winSize;
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
        System.out.println("Введите размер игрового поля: ");
        return in.nextInt();
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
        /*
        if(checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("УРА! ВЫ ПОБЕДИЛИ!");
            } else {
                System.out.println("Восстание близко... Скайнет победил...");
            }
        }
        */

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
        return false;
    }


    private static void humanTurn() {
        System.out.println("\nХОД ЧЕЛОВЕКА!");

        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.println("Введите координату строки: ");
            rowNumber = in.nextInt() - 1;
            System.out.println("Введите координату столбца: ");
            columnNumber = in.nextInt() - 1;

            if(isCellFree(rowNumber, columnNumber)) {
                break;
            }

            System.out.printf("ОШИБКА! Ячейка с координатами %s:%s уже используется", rowNumber + 1, columnNumber + 1);
        }

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
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
