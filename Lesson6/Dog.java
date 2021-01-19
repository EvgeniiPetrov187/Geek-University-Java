//1. Создать классы Собака и Кот с наследованием от класса Животное.
public class Dog extends Animals {
    public static int dogs = 0;// К заданию 4.
    public Dog(String name, int age, int run, int swim) {
        super();
        setName(name);
        setRun(run);
        setAge(age);
        setSwim(swim);
        setType("Собака");
        dogs++;
    }
    @Override
    void voice(){
        System.out.println(getType() + " " + getName() + " лает");
    }

}
