package level3_lesson1_mission2;

import java.util.ArrayList;

public class Box<Fruit extends Fruits> {
    private ArrayList<Fruit> fruitBox;

    public Box(ArrayList<Fruit> fruitBox) {
        this.fruitBox = fruitBox;
    }

    /**
     * Метод высчитывает вес коробки
     *
     * @return возвращает вес float
     */
    public float getWeight() {
        float sum = 0.0f;
        for (Fruit fruit : fruitBox) {
            sum = sum + fruit.getWeight();
        }
        return sum;
    }

    /**
     * Метод добавляет фрукты в коробку
     *
     * @param e      класс фрукта
     * @param number количество фруктов
     */
    public void addFruit(Fruit e, int number) {
        for (int i = 0; i < number; i++) {
            fruitBox.add(e);
        }
    }

    /**
     * Метод сравнивает вес двух коробок
     *
     * @param another коробка с которой сравнивают
     * @return возвращет ложь или истину, равны ли коробки
     */
    public boolean compare(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.000001;
    }

    /**
     * Метод перекладывает фрукты из одной коробки в другую
     *
     * @param anotherBox коробка в которую помещают фрукты
     */
    public void changeBox(Box<Fruit> anotherBox) {
        ArrayList<Fruit> anotherFruitBox = new ArrayList<>(fruitBox);
        anotherBox.fruitBox = anotherFruitBox;
        this.fruitBox.removeAll(anotherFruitBox);
    }
}

