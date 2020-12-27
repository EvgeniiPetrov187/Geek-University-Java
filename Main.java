import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 0, 1};
        Binar(arr);


        //2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] eight = new int[8];
        superEight(eight);


        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        //пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] room = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiple(room);


        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] three = new int[3][3];
        Matrix(three);


        // 5.** Задать одномерный массив и найти в нем минимальный и максимальный
        // элементы (без помощи интернета);
        int[] maxmin = {16, 2, 1, 10, 8, 13, 4, 6, 15, 2, 6, 8, 12};
        maxMin(maxmin);


        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
        // части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы
        // в массив не входят.
        int[] mass = {10, 2, 1, 1, 2, 6, 5, 5};
        checkBalance(mass);
        System.out.println();


        // 7. **** Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен сместить все
        // элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя
        // пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один
        // вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        // При каком n в какую сторону сдвиг можете выбирать сами.
        int[] array = {1, 2, 3, 4, 5, 6};
        lastManStanding(1, array);


        // Задание из вэбинара
        Scanner first = new Scanner(System.in);
        int x = first.nextInt();
        if (x % 3 == 0) {
            System.out.println("Число кратное 3");
        }
        if (x % 5 == 0) {
            System.out.println("Число кратное 5");
        }
    }


    // Задание 1.
    public static void Binar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else if (arr[i] == 1) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }


    // Задание 2.
    public static void superEight(int[] eight) {
        for (int i = 0; i < eight.length; i++) {
            eight[i] = i * 3;
        }
        System.out.println(Arrays.toString(eight));
        System.out.println();
    }


    // Задание 3.
    public static void multiple(int[] six) {
        for (int i = 0; i < six.length; i++) {
            if (six[i] < 6) {
                six[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(six));
        System.out.println();
    }


    // Задание 4.
    public static void Matrix(int[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 && j != 1) {
                    matrix[i][j] = 1;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    // Задание 5.
    public static void maxMin(int[] maxmin) {
        int max = maxmin[0];
        int min = maxmin[0];
        for (int i = 0; i < maxmin.length; i++) {
            if (max > maxmin[i]) {
                continue;
            }
            max = maxmin[i];
        }
        for (int i = 0; i < maxmin.length; i++) {
            if (min < maxmin[i]) {
                continue;
            }
            min = maxmin[i];
        }
        System.out.println("Максимальное число = " + max);
        System.out.println("Минимальное число = " + min);
        System.out.println();
    }


    //Задание 6.
    public static void checkBalance(int[] mass) {
        int sumFirst = 0;
        int sumLast = 0;
        for (int i = 0, j = mass.length - 1; i < mass.length / 2; i++, j--) {
            sumFirst += mass[i];
            sumLast += mass[j];
            if (sumFirst == sumLast) {
                break;
            }
        }
        if (sumFirst > sumLast) {
            if (mass.length % 2 == 1) {
                sumFirst += mass[mass.length / 2];
            }
            for (int i = mass.length / 2; i >= 1; i--) {
                sumFirst -= mass[i];
                sumLast += mass[i];
                if (sumFirst <= sumLast) {
                    break;
                }
            }
        }
        if (sumFirst < sumLast) {
            if (mass.length % 2 == 1) {
                sumLast += mass[mass.length / 2];
            }
            for (int i = mass.length / 2; i < mass.length; i++) {
                sumFirst += mass[i];
                sumLast -= mass[i];
                if (sumFirst >= sumLast) {
                    break;
                }
            }
        }
        if (sumFirst == sumLast) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println();
    }

    // Задание 7.
    public static void lastManStanding(int n, int[] arr) {
        int x = 0;
        if (n < 0) {
            for (int i = 0; i > n; i--) {
                x = arr[0];
                for (int j = 0; j < arr.length; j++) {
                    if ((j + 1) < arr.length) {
                        arr[j] = arr[j + 1];
                    }
                }
                arr[arr.length - 1] = x;
            }
        }
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                x = arr[arr.length - 1];
                for (int j = arr.length - 1; j >= 0; j--) {
                    if ((j - 1) >= 0) {
                        arr[j] = arr[j - 1];
                    }
                }
                arr[0] = x;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }
}



