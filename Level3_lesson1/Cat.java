package geek_brains.lesson3;

import java.util.ArrayList;
import java.util.Arrays;

public class Cat <Unit> {
    private Unit[] cat;

    public Cat(Unit... cat) {
        this.cat = cat;
    }


    //1. Написать метод, который меняет два элемента массива местами.
    // (массив может быть любого ссылочного типа);
    public void changePlace(Unit[] cats, int x, int y) {
        Unit extraCat;
        try {
            extraCat = cats[x];
            cats[x] = cats[y];
            cats[y] = extraCat;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("У нас нет столько котов");
        }
    }


    //2. Написать метод, который преобразует массив в ArrayList;
    public ArrayList<Unit> getArrayList(Unit[] cats) {
        return new ArrayList<>(Arrays.asList(cats));
    }
}
