//1. Создать классы Собака и Кот с наследованием от класса Животное.
public class Rabbit extends Animals {
    public static int rabbits = 0;// К заданию 4.
    public Rabbit(String name, int age, int run, int swim) {
        super();
        setName(name);
        setRun(run);
        setAge(age);
        setSwim(swim);
        setType("Кролик");
        rabbits++;
    }
    @Override
    void voice(){
        System.out.println(getType() + " " + getName() + " не издаёт звуков");
    }

}

