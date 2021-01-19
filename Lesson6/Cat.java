//1. Создать классы Собака и Кот с наследованием от класса Животное.
public class Cat extends Animals {
    public static int cats = 0;// К заданию 4.
    public Cat(String name, int age, int run, int swim) {
        super();
        setName(name);
        setRun(run);
        setAge(age);
        setSwim(swim);
        setType("Кот");
        cats++;
    }
    @Override
    void voice(){
        System.out.println(getType() + " " + getName() + " мяукает");
    }

}
