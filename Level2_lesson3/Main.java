package Level2_lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        List<String> list = new ArrayList<>();
        list.add("Велосипед");
        list.add("Мотоцикл");
        list.add("Мопед");
        list.add("Автомобиль");
        list.add("Квадроцикл");
        list.add("Автомобиль");
        list.add("Лыжи");
        list.add("Велосипед");
        list.add("Самокат");
        list.add("Мотоцикл");
        list.add("Велосипед");
        list.add("Автомобиль");
        list.add("Санки");
        list.add("Лыжи");
        list.add("Мопед");

        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        findUnicum(list);

        // Посчитать сколько раз встречается каждое слово.
        findHowMuch(list);


        //В этот телефонный справочник с помощью метода add()
        // можно добавлять записи.
        add("Виктор", "89126446166");
        add("Григорий", "89127761676");
        add("Евгений", "89126789166");
        add("Виктор", "89126449966");
        add("Владимир", "89126454446");
        add("Виктор", "89156475232");

        //С помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        // тогда при запросе такой фамилии должны выводиться все телефоны.
        get("Виктор");
        get("Владимир");
    }

    /**
     * Метод возвращает в консоль количество упоминаний слова в коллекции List
     * @param list List<String>
     *
     */
    public static void findHowMuch(List<String> list){
        Set<String> unicum = new HashSet<>();
        for (int i = 0; i < list.size(); i++)
            unicum.add(list.get(i));
        for (String transport : unicum) {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (transport.equals(list.get(i))) {
                    count++;
                }
            }
            System.out.println("Слово " + transport + " встречается " + count + " раз");
        }
        System.out.println();
    }

    /**
     * Метод возвращает в консоль уникальные слова из коллекции List
     * @param list List<String>
     *
     */
    public static void findUnicum(List<String> list) {
        Set<String> unicum = new HashSet<>();
        for (int i = 0; i < list.size(); i++)
            unicum.add(list.get(i));
        System.out.println("Уникальные слова: " + unicum);
        System.out.println();
    }

    public static List<TelefonNumber> catalog = new ArrayList<>();// каталог абонентов

    /**
     * Метод записывает данные в коллекцию List
     * @param name String
     * @param number String
     */
    public static void add(String name, String number){
        TelefonNumber person = new TelefonNumber(name, number);
        catalog.add(person);
    }
    /**
     * Метод возвращает номер телефона абонента из коллекции
     * @param name String
     *
     */
    public static void get(String name) {
        for (int i = 0; i < catalog.size(); i++){
            if (name.equals(catalog.get(i).getName()))
        System.out.println("Абонент "+ name + " имеет телефонный номер " + catalog.get(i).getNumber());
        }
    }
}
