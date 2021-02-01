package lesson1;

    // 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
    // участники должны выполнять соответствующие действия (бежать или прыгать),
    // результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
public class Wall implements Movable{
    private int wallHeight;

    public Wall(int wallHeight){
        this.wallHeight = wallHeight;
    }

    @Override
    public void movement(Ability player) {
        player.goJump(wallHeight);
    }

    @Override
    public void info(){
        System.out.println("Стена имеет высоту " + wallHeight + " м.");
    }

    public void setWallHeight (int wallHeight){
        this.wallHeight = wallHeight;
    }

    public int getWallHeight() {
        return wallHeight;
    }


}
