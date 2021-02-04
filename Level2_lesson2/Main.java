package level2lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] sampleOne = new String[][]{
                {"9", "7", "6", "8"},
                {"2", "4", "6", "7"},
                {"2", "5", "7", "7"},
                {"4", "2", "2"}
        };

        String[][] sampleTwo = new String[][]{
                {"9", "7", "6", "8"},
                {"2", "4", "6", "7"},
                {"2", "5", "7", "7"},
                {"4", "p", "2", "8"}
        };


        /* 3. В методе main() вызвать полученный метод, обработать возможные исключения
        MySizeArrayException и MyArrayDataException, и вывести результат расчета.
         */
        try {
            getMistake(sampleOne); // Метод с неправильным размером массива
        } catch (MyArrayDataException e){
            e.printStackTrace();
            System.out.println("Данные введены неверно");
        } catch (MyArraySizeException e){
            e.printStackTrace();
            System.out.println("Неправильный массив");
        }

        /* 3. В методе main() вызвать полученный метод, обработать возможные исключения
        MySizeArrayException и MyArrayDataException, и вывести результат расчета.
         */
        try {
            getMistake(sampleTwo); // Метод с неправильным значением элемента массива
        } catch (MyArrayDataException e){
            e.printStackTrace();
            System.out.println("Данные введены неверно");
        } catch (MyArraySizeException e){
            e.printStackTrace();
            System.out.println("Неправильный массив");
        }

        System.out.println("End");
    }

    /* 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
    при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     */
    public static void getMistake(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != 4 || array[i].length != 4) {
                    throw new MyArraySizeException("Ваш массив " + array.length + "x" + array[i].length + ". Должен быть 4х4.");
                }
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Введите число в строке номер " + (i + 1) + ", столбце номер " + (j + 1));
                    /* 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
                     и просуммировать. Если в каком-то элементе массива преобразование не удалось
                     (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
                     исключение MyArrayDataException, с детализацией в какой именно ячейке лежат
                     неверные данные. */
                }
            }
        }
        System.out.println("Сумма всех элементов равна " + result);
    }
}

