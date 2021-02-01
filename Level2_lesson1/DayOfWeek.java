package lesson1;

    // 5*. Задание с перечислениями. Прикрелено в материалах урока
public enum DayOfWeek {
    MONDAY( 8),
    TUESDAY( 8),
    WEDNESDAY( 8),
    THURSDAY( 8),
    FRIDAY( 8),
    SATURDAY(0),
    SUNDAY( 0);
    private final int workHours;


    DayOfWeek(int workHours){
        this.workHours = workHours;
    }

    public int getWorkHours() {
        return workHours;
    }
}
