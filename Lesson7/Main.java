package Lesson7;

import java.util.ArrayList;

public class Main {
    public static void main (String [] args){
        //  5.Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
        //  и потом вывести информацию о сытости котов в консоль.
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Моисей", 30);
        cats[1] = new Cat("Барсик", 50);
        cats[2] = new Cat("Васька", 40);

        Bowl bowl = new Bowl("Стандарт",120);
        Bowl bigBowl = new Bowl("Супер",200);

        // 1. Расширить задачу про котов и тарелки с едой.
        CatEat(cats, bowl);

        Catfullness(cats);

        CatEat(cats, bowl);

        bowl.fillBowl(30);
        System.out.println();

        CatEat(cats, bigBowl);

        CatEat(cats, bigBowl);

        CatEat(cats, bowl);

        Catfullness(cats);

        bowl.info();

        bigBowl.info();
    }

    public static void CatEat (Cat[] cats, Bowl bowl){
        for (Cat cat : cats) {
            cat.eat(bowl);
        }
        System.out.println();
    }
    public static void Catfullness(Cat[] cats){
        for (Cat cat : cats) {
            cat.catFullness();
        }
        System.out.println();
    }
}
