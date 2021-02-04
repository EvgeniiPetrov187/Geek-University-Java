package level2lesson2;

public class MyArrayDataException extends IllegalArgumentException {
    private String number;

    public MyArrayDataException(String number){
        super(number);
        this.number = number;
    }
}
