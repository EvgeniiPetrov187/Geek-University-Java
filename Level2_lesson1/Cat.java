package lesson1;

// 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
// Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
public class Cat implements Ability{
    private String name;
    private int maxRun;
    private int maxJump;
    private boolean isParticipant = true;

    public Cat(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public Cat() {
        this.name = "Барсик";
        this.maxRun = 3;
        this.maxJump = 2;
    }

    @Override
    public void goJump(int wall){
        if (maxJump <= 0){
            System.out.println(name + " не умеет прыгать");
        }
        else if (maxJump >= wall){
            System.out.println(name + " преодолел припятствие стена высотой " + wall + " м.");
        } else {
            System.out.println(name + " не может перепрыгнуть через стену высотой "+ wall + " м.");
            System.out.println(name + " выбывает из соревнований");
            this.isParticipant = false;
        }
    }

    @Override
    public void goRun(int track){
        if (maxRun <= 0){
            System.out.println(name + " не умеет бегать");
        }
        else if (maxRun >= track){
            System.out.println(name + " преодолел припятствие беговая дорожка длиной " + track + " км.");
        } else {
            System.out.println(name + " не может пробежать дорожку длиной "+ track + " км.");
            System.out.println(name + " выбывает из соревнований");
            this.isParticipant = false;
        }
    }

    @Override
    public boolean isParticipant() {
        return isParticipant;
    }

    public void setMaxJump(int maxJump) {
        this.maxJump = maxJump;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void setMaxRun(int maxJump) {
        this.maxRun = maxRun;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIsParticipant(boolean isParticipant) {
        this.isParticipant = isParticipant;
    }
    public boolean getIsParticipant(){
        return isParticipant;
    }
}
