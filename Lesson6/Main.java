public class Main {



    public static void main (String [] args){

        // 3.У каждого животного есть ограничения на действия (бег: кот 200 м.,
        // собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
        Rabbit croch = new Rabbit("Крош", 5 ,1000, 0);
        Turtle leo = new Turtle("Леонардо", 45, 0, 100);
        Cat tom = new Cat("Том", 3, 200, 0);
        Dog spot = new Dog("Спот", 4,500,10);
        Dog iran = new Dog("Иран", 5,500,10);


        // 2. Все животные могут бежать и плыть. В качестве параметра каждому методу
        // передается длина препятствия. Результатом выполнения действия будет печать в консоль.
        // (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
        spot.running(600);
        spot.swimming(100);
        spot.voice();
        System.out.println();

        iran.running(450);
        iran.swimming(10);
        iran.voice();
        System.out.println();

        croch.running(100);
        croch.swimming(150);
        croch.voice();
        System.out.println();

        tom.running(150);
        tom.swimming(40);
        tom.voice();
        System.out.println();

        leo.running(10);
        leo.swimming(120);
        leo.voice();
        System.out.println();

        // 4.* Добавить подсчет созданных котов, собак и животных.
        int zoo = Animals.count;
        int dogs = Dog.dogs;
        int cats = Cat.cats;
        int turtles = Turtle.turtles;
        int rabbits = Rabbit.rabbits;
        System.out.println("У нас есть "+ zoo + " животных из них собак: " + dogs + ", кошек: " + cats + ", черепах: " + turtles + ", кроликов: " + rabbits);







    }
}
