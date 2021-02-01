package lesson1;

public interface Ability {
    void goJump(int jump);
    void goRun(int run);

    //4*. У препятствий есть длина (для дорожки) или высота (для стены),
    // а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий,
    // то дальше по списку он препятствий не идет.
    boolean isParticipant ();
}
