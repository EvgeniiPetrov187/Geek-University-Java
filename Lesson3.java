package Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {

        //1. Написать программу, которая загадывает случайное число от 0 до 9
        // и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить,
        // больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
        // (1 – повторить, 0 – нет).
          Secret();


        // 2. * Создать массив из слов
        // String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
        // "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
        // "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
        // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        // сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
        // Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        // apple – загаданное
        // apricot - ответ игрока
        // ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        // Для сравнения двух слов посимвольно можно пользоваться:
        // String str = "apple";
        // char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        // Играем до тех пор, пока игрок не отгадает слово.
        // Используем только маленькие буквы.

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Words(words);

    }



    // Для задания 1
    public static void Secret() {
        Random digit = new Random();
        int x = digit.nextInt(9);
        System.out.println("Введите загаданное число от 0 до 9");
        for (int i = 0; i < 3; i++) {
            Scanner fromUser = new Scanner(System.in);
            int y = fromUser.nextInt();
            if (x > y) {
                System.out.println("Неверно. Загаданное число больше");
            }
            if (x < y) {
                System.out.println("Неверно. Загаданное число меньше");
            }
            if (x == y) {
                System.out.println("Всё верно. Вы выиграли!");
            break;
            }
            if (i >= 2) {
                System.out.println("Вы проиграли!");
            break;
            }
        }
        More();
    }
    public static void More() {
        System.out.println("Если хотите сыграть ещё раз, нажмите 1,\nесли нет нажмите 0.");
        Scanner trying = new Scanner(System.in);
        int n = trying.nextInt();
        if (n == 1) {
            Secret();
        } else {
            System.out.println("Game Over");
        }
    }



    // Для задания 2.
    private static void Words(String[] words) {
        Random word = new Random();
        int wordNumber = word.nextInt(words.length - 1);
        String compWord = words[wordNumber];
        char[] Sett = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
        for (int i = 0; ; i++) {
            System.out.println("Угадайте слово (писать маленькими буквами на английском)");
            Scanner fromUser = new Scanner(System.in);
            String myWord = fromUser.nextLine();
            if (myWord.equals(compWord)) {
                System.out.println("Вы угадали слово");
                break;
            } else {
                if (compWord.length() >= myWord.length()){
                    for (int j = 0; j < myWord.length(); j++) {
                        Sett[j] = compWord.charAt(j);
                        if (myWord.charAt(j) != Sett[j]) {
                            Sett[j] = '#';
                        }
                    }
                }
                if (compWord.length() < myWord.length()){
                    for (int x = 0; x < compWord.length(); x++) {
                        Sett[x] = compWord.charAt(x);
                        if (myWord.charAt(x) != Sett[x]) {
                            Sett[x] = '#';
                        }
                    }
                } System.out.println(Sett);
            }
        }
    }
}



