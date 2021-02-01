package lesson1;

public class Main {
    public static void main(String[] args) {

        Ability[] participants = {
                new Human("Вася", 15, 3),
                new Robot("C3PO", 40, 1),
                new Cat("Том", 3, 3)
        };

        Movable[] stages = {
                new Track(3),
                new Wall(2),
                new Track(10),
                new Wall(3)
        };

        // 3. Создайте два массива: с участниками и препятствиями,
        // и заставьте всех участников пройти этот набор препятствий.
        for (Movable stage : stages) {
            stage.info();
            for (Ability player : participants) {
                if (player.isParticipant()) {
                    stage.movement(player);
                }
            }
        }

        System.out.println();
        // 5*. Задание с перечислениями. Прикрелено в материалах урока
        howLongWork(DayOfWeek.THURSDAY);
    }

    public static void howLongWork(DayOfWeek someday) {
        int howLongWork = 0;
        boolean work = false;
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.equals(someday)){
                work = true;
                if (day.getWorkHours() == 0){
                    System.out.println("Сегодня выходной");
                    break;
                }
            }
            if (work)
                howLongWork += day.getWorkHours();
        }
        if (howLongWork != 0)
        System.out.println("До конца недели осталось работать " + howLongWork + " часов");
    }
}


