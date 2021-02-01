package lesson1;

// 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
// участники должны выполнять соответствующие действия (бежать или прыгать),
// результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
public class Track implements Movable{
    private int trackLength;

    public Track(int trackLength){
        this.trackLength = trackLength;
    }

    @Override
    public void movement(Ability player) {
        player.goRun(trackLength);
    }

    @Override
    public void info(){
        System.out.println("Дорожка имеет длину " + trackLength + " км.");
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public int getTrackLength() {
        return trackLength;
    }

}
