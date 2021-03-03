package level3_lesson1_mission2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        ArrayList<Orange> oranges = new ArrayList<>();

        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);
        Box<Apple> appleBox2 = new Box<>(apples);

        appleBox.addFruit(new Apple(), 10);
        orangeBox.addFruit(new Orange(), 8);

        System.out.println(appleBox.getWeight() + " - вес первой коробки с яблоками");
        System.out.println(orangeBox.getWeight() + " - вес первой коробки с апельсинами");

        System.out.println(appleBox.compare(orangeBox) + " - равны ли коробки");

        appleBox.changeBox(appleBox2);

        System.out.println(appleBox.getWeight() + " - вес первой коробки с яблоками");
        System.out.println(appleBox2.getWeight() + " - вес второй коробки с яблоками");

    }
}
