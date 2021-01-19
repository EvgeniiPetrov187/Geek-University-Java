//1. Создать классы Собака и Кот с наследованием от класса Животное.
public abstract class Animals {
    private String name;
    private int age;
    private int run;
    private int swim;
    private String type;
    public static int count;// К заданию 4.


    public Animals(String name, int age, int run, int swim) {
        this.name = name;
        this.age = age;
        this.run = run;
        this.swim = swim;

    }
        public Animals(){
        this.name = "Геракл";
        this.age = 3;
        this.run = 100;
        this.swim = 10;
        this.type = "Животное";
        count++;
    }

    // К заданию 3.
    void running(int run){
        if (this.run == 0){
            System.out.println(age + "-летний(-яя) " + type + " " + name + " не умеет бегать");
        } else if (run > this.run){
            System.out.println(age + "-летний(-яя) " + type +" " + name + " не может пробежать " + run + " метров");
        }  else {
            System.out.println(age + "-летний(-яя) " + type +" " + name + " пробежал(-а) " + run + " метров");
        }
    }

    // К заданию 3.
    void swimming(int swim){
        if (this.swim == 0) {
            System.out.println(age + "-летний(-яя) " + type + " " + name + " не умеет плавать");
        } else if (swim > this.swim){
            System.out.println(age + "-летний(-яя) " + type +" " + name + " не может проплыть " + swim + " метров");
        } else {
            System.out.println(age + "-летний(-яя) " + type +" " + name + " проплыл(-а) " + swim + " метров");
        }
    }

    abstract void voice();

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setRun(int run){
        this.run = run;
    }
    public int getRun(){
        return run;
    }
    public void setSwim(int swim){
        this.swim = swim;
    }
    public int getSwim(){
        return swim;
    }

}
