package Lesson4;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    public static final char emptyPlace = '_';
    public static final char myTurn = 'X';
    public static final char aiTurn = 'O';
    public static char[][] myMap;
    public static Random ai = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static int mapSize = finalSize(); // Выбор размера карты
    public static int score = Score(mapSize); // Подсчёт очков
    public static int comp = Difficulty(); // Выбор сложности

    // 1.Полностью разобраться с кодом, попробовать переписать с нуля,
    // стараясь не подглядывать в методичку.

    public static void main (String [] args) {
        battleField();//инициализация карты
        paintMap(); // прорисовка поля
        while (true) {
            manTurn(); //Ход человека
            paintMap(); // прорисовка поля
            if (winner(myTurn)) { //проверка победы
                System.out.println("Победил игрок");
                break;
            }
            if (draw()) { //проверка ничьи
                System.out.println("Ничья");
                break;
            }
            if (comp == 1)
                compTurn(); // Ход компьютера низкая сложность
            if (comp == 2)
                blockCompTurn(); // Ход компьютера высокая сложность
            paintMap(); // прорисовка поля
            if (winner(aiTurn)) { //проверка победы
                System.out.println("Победил искусственный интеллект");
                break;
            }
            if (draw()) {//проверка ничьи
                System.out.println("Ничья");
                break;
            }
        }
    }

    // Для задания 3. Выбор размера карты
    private static int finalSize(){
            int x = -1;
            for (int i = 0; ; i++) {
                System.out.println("Введите размер карты: 3 или 5");
                try {
                    x = scanner.nextInt();
                } catch (NoSuchElementException | IllegalStateException e){
                    System.out.println("Введите числа");
                    scanner = new Scanner(System.in);
                }
                if ((x == 3) || (x == 5))
                    break;
            }
            return x;
        }

        // Для задания 3. Подсчёт очков
        private static int Score(int size) {
            if (size > 3) {
                size--;
            }
            return size;
        }

    // Для задания 4. Выбор сложности
    private static int Difficulty(){
        int x = -1;
        for (int i = 0; ; i++) {
            System.out.println("Выберите сложность: 1 - Дружок(легко) или 2 - Демон(сложно)");
            try {
                x = scanner.nextInt();
            } catch (NoSuchElementException | IllegalStateException e){
                System.out.println("Введите числа 1 или 2");
                scanner = new Scanner(System.in);
            }
            if ((x == 1) || (x == 2))
                break;
        }
        return x;
    }


    private static void battleField () { //инициализация карты
        myMap = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                myMap[i][j] = emptyPlace;
            }
        }
    }

    private static void paintMap (){ // прорисовка поля
        for (int i = 0; i < mapSize; i++){
            for (int j = 0; j< mapSize; j++) {
                System.out.print(myMap[i][j]+" ");
            }
                System.out.println();
        }
    }

    private static void manTurn () { // Ход игрока
        int x = -1;
        int y = -1;
        for (int i = 0; ; i++) {
            System.out.println("Введите координаты х и у:");
            try {
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } catch (NoSuchElementException | IllegalStateException e){
                System.out.println("Введите числа");
                scanner = new Scanner(System.in);
            }
                if ((x >= 0 && x < mapSize) && (y >= 0 && y < mapSize) && (myMap[x][y] == emptyPlace)) {
                    myMap[x][y] = myTurn;
                    break;
                }
        }
    }
    private static void compTurn() { // Ход компьютера Дружок
        System.out.println("Ход компьютера");
        int x;
        int y;
        for (int i = 0; ; i++) {
            x = ai.nextInt(mapSize-1);
            y = ai.nextInt(mapSize-1);
            if (myMap[x][y] == emptyPlace) {
                myMap[x][y] = aiTurn;
                break;
            }
        }
    }
    // 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
    private static void blockCompTurn() { // Ход компьютера Демон
        System.out.println("Ход компьютера");
        int count = 0;
        for (int k = 0; k < 50; k++) {
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    if ((myMap[i][j] == emptyPlace) && (j > 0) && (j+1 < mapSize) && (myMap[i][j-1] == myTurn) && (myMap[i][j+1] == myTurn)) {
                        myMap[i][j] = aiTurn; // block center between right left
                        count++;
                        break;
                    } else if ((myMap[i][j] == emptyPlace) && (i > 0) && (i+1 < mapSize) && (myMap[i+1][j] == myTurn) && (myMap[i-1][j] == myTurn)) {
                        myMap[i][j] = aiTurn; // block center between up down
                        count++;
                        break;
                    } else if ((myMap[i][j] == emptyPlace) && (j+2 < mapSize) && (myMap[i][j+1] == myTurn) && (myMap[i][j+2] == myTurn)) {
                        myMap[i][j] = aiTurn; // block right
                        count++;
                        break;
                    } else if ((myMap[i][j] == emptyPlace) && (j-2 >= 0) && (myMap[i][j-1] == myTurn) && (myMap[i][j-2] == myTurn)) {
                        myMap[i][j] = aiTurn; // block left
                        count++;
                        break;
                    } else if ((myMap[i][j] == emptyPlace) && (i+2 < mapSize) && (myMap[i+1][j] == myTurn) && (myMap[i+2][j] == myTurn)) {
                        myMap[i][j] = aiTurn; // block down
                        count++;
                        break;
                    } else if ((myMap[i][j] == emptyPlace) && (i-2 >= 0) && (myMap[i-1][j] == myTurn) && (myMap[i-2][j] == myTurn)) {
                        myMap[i][j] = aiTurn; // block up
                        count++;
                        break;
                    } else if ((j+2+i < mapSize) && (myMap[j+i][j] == emptyPlace) && (myMap[j+1+i][j+1] == myTurn) && (myMap[j+2+i][j+2] == myTurn)){
                       myMap[j][j+i] = aiTurn; // block diag up left plus i
                       count++;
                       break;
                    } else if ((j+2 < mapSize) && (j-i >= 0) && (myMap[j-i][j] == emptyPlace) && (myMap[j+1-i][j+1] == myTurn) && (myMap[j+2-i][j+2] == myTurn)){
                        myMap[j-i][j] = aiTurn; // block diag up left minus i
                        count++;
                        break;
                    } else if ((j+i < mapSize) && (myMap[j+i][j] == emptyPlace) && (j-2 >= 0) && ((j-2+i) >= 0) && ((j-1+i) < mapSize) && (myMap[j-1+i][j-1] == myTurn) && (myMap[j-2+i][j-2] == myTurn)) {
                        myMap[j+i][j] = aiTurn; // block diag right down plus i
                        count++;
                        break;
                    } else if ((j-2-i >= 0) && (myMap[j-i][j] == emptyPlace) && (j-2 >= 0) && ((j-2-i) >= 0) && ((j-1-i) < mapSize) && (myMap[j-1-i][j-1] == myTurn) && (myMap[j-2-i][j-2] == myTurn)){
                        myMap[j-i][j] = aiTurn; // block diag right down minus i
                        count++;
                        break;
                    } else if ((mapSize-j-3+i >= 0) && (mapSize-j-1+i < mapSize) && (myMap[mapSize-j-1+i][j] == emptyPlace) && (j+2 < mapSize) && (myMap[mapSize-j-2+i][j+1] == myTurn) && (myMap[mapSize-j-3+i][j+2] == myTurn)){
                        myMap[mapSize-j-1+i][j] = aiTurn; // block diag left down plus i
                        count++;
                        break;
                    } else if ((mapSize-j-3-i >= 0) && (myMap[mapSize-j-1-i][j] == emptyPlace) && (j+2 < mapSize) && (myMap[mapSize-j-2-i][j+1] == myTurn) && (myMap[mapSize-j-3-i][j+2] == myTurn)){
                        myMap[mapSize-j-1-i][j] = aiTurn; // block diag left down minus i
                        count++;
                        break;
                    } else if ((j+2+i < mapSize) && (myMap[j+i][mapSize-1-j] == emptyPlace) && (mapSize-j-3 >= 0) && (myMap[j+1+i][mapSize-j-2] == myTurn) && (myMap[j+2+i][mapSize-j-3] == myTurn)) {
                        myMap[j+i][mapSize-1-j] = aiTurn; // block diag right up plus i
                        count++;
                        break;
                    } else if ((j+2-i < mapSize) && (j-i >= 0)&& (mapSize-j-3 >= 0) && (myMap[j-i][mapSize-1-j] == emptyPlace) && (myMap[j+1-i][mapSize-j-2] == myTurn) && (myMap[j+2-i][mapSize-j-3] == myTurn)) {
                        myMap[j-i][mapSize-1-j] = aiTurn; // block diag right up minus i
                        count++;
                        break;
                    } else if ((i > 0) && (i < mapSize-1 ) && (myMap[i][i] == emptyPlace)){
                            myMap[i][i] = aiTurn; // game in center
                            count++;
                            break;
                    } else if ((k == 49) && (myMap[i][j] == emptyPlace)){
                        myMap[i][j] = aiTurn; // last hope
                        count++;
                        break;
                    }
                }

            if (count == 1)
                break;
            }

            int x = 0;
            int y = 0;
            x = ai.nextInt(mapSize-1);
            y = ai.nextInt(mapSize-1);
            if (count == 1)
                break;
             else if (myMap[x][y] == emptyPlace){
                myMap[x][y] = aiTurn;
                break;
            }
        }
    }

    // 2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
    // например, с использованием циклов.
    // 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5
    // и количества фишек 4. Очень желательно не делать это просто набором условий для
    // каждой из возможных ситуаций;
    private static boolean winner(char result) { // Проверка победы для любого размера карты и подсчёт очков
        for (int i = 0; i < mapSize; i++){
            int pointHorizont = 0;
            int pointVertical = 0;
            int pointDiagPlus = 0;
            int pointDiagMinus = 0;
            int pointDiagBackPlus = 0;
            int pointDiagBackMinus = 0;
            for (int j = 0; j < mapSize; j++) {
                if (myMap[i][j] == result)
                    pointHorizont++;
                if (pointHorizont == score)
                    return true;
                if (myMap[j][i] == result)
                    pointVertical++;
                if (pointVertical == score)
                    return true;
                if (((i+j) < mapSize) && (myMap[j][j+i] == result))
                    pointDiagPlus++;
                if (pointDiagPlus == score)
                    return true;
                if (((j-i) >= 0) && (myMap[j][j-i] == result))
                    pointDiagMinus++;
                if (pointDiagMinus == score)
                    return true;
                if ((mapSize-1-j+i < mapSize) && (myMap[j][mapSize-1-j+i] == result))
                    pointDiagBackPlus++;
                if (pointDiagBackPlus == score)
                    return true;
                if ((mapSize-1-j-i >= 0) && (myMap[j][mapSize-1-j-i] == result))
                    pointDiagBackMinus++;
                if (pointDiagBackMinus == score)
                    return true;
                if (myMap[i][j] != result)
                    pointHorizont = 0;
                if (myMap[j][i] != result)
                    pointVertical = 0;
                if (((i+j) < mapSize) && (myMap[j][j+i] != result))
                    pointDiagPlus = 0;
                if (((j-i) >= 0) && (myMap[j][j-i] != result))
                    pointDiagMinus = 0;
                if ((mapSize-1-j+i < mapSize) && (myMap[j][mapSize-1-j+i] != result))
                    pointDiagBackPlus = 0;
                if ((mapSize-1-j-i >= 0) && (myMap[j][mapSize-1-j-i] != result))
                    pointDiagBackMinus = 0;
                }
            }
        return false;
    }

    private static boolean draw(){ // проверка ничьи
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (myMap[i][j] == emptyPlace) {
                    return false;
                }
            }
        }
        return true;
    }
}
