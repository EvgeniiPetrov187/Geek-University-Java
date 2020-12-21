package Metodichka.lesson1;

public class FirstApp {
    public static void main (String [] args){
        System.out.println(Summe(2,2, 3, 5));
        //Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат

        System.out.println(Strait(7,4));
        // Написать метод, принимающий на вход два целых числа и проверяющий,
        // что их сумма лежит в пределах от 10 до 20 (включительно), если да –
        // вернуть true, в противном случае – false

        Question(-5);
        // Написать метод, которому в качестве параметра передается целое число, метод
        // должен напечатать в консоль, положительное ли число передали или отрицательное.
        // Замечание: ноль считаем положительным числом.


        System.out.println(Negat(7));
        // Написать метод, которому в качестве параметра передается целое число.
        // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.

        Name("Виктор");
        // Написать метод, которому в качестве параметра передается строка, обозначающая имя.
        // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».

        Year(2020);
        //* Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    }

    public static float Summe (float a, float b, float c, float d) {
        return a * (b + c / d);
    }


    public static boolean Strait (int a, int b){
        if ((a + b) >= 10 && (a + b) <= 20){
            return true;
        } else {
            return false;
        }
    }

    public static void Question (int a){
        if (a >= 0){
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }

    public static boolean Negat (int a){
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void Name (String name){
        System.out.println("Привет, " + name + "!");
    }


    public static void Year (int year){
        if ((year % 100) != 0 || (year % 400) == 0  && (year % 4) == 0){
            System.out.println(year + "-й год является Високосным");
        } else {
            System.out.println(year + "-й год не является Високосным");
        }
    }
    }

