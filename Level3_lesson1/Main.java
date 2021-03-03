package geek_brains.lesson3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] cats = {"Tom", "Barsik", "Murzik", "Mars"};
        Cat<Object> newCats = new Cat<>(cats);

        System.out.println(Arrays.toString(cats));

        newCats.changePlace(cats, 0, 3);

        System.out.println(Arrays.toString(cats));

        System.out.println(newCats.getArrayList(cats));
    }
}


