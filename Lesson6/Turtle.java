//1. Создать классы Собака и Кот с наследованием от класса Животное.
public class Turtle extends Animals {
    public static int turtles = 0;// К заданию 4.
    public Turtle(String name, int age, int run, int swim) {
        super();
        setName(name);
        setRun(run);
        setAge(age);
        setSwim(swim);
        setType("Черепаха");
        turtles++;
    }
    @Override
    void voice(){
        System.out.println(getType() + " " + getName() + " не издаёт звуков");
    }

}
