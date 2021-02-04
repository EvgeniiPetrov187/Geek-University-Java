package level2lesson2;

public class MyArraySizeException extends IndexOutOfBoundsException {
    private String index;
    public MyArraySizeException(String index){
    super(index);
    this.index = index;
    }
}
