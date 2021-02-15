public class Main {
    static final int size = 1000000;
    static final int h = size/2;

    public static void main(String[] args) throws InterruptedException {
        float [] arr1 = new float[size];
        float [] arr2 = new float[size];
        float[] firstArr = new float[size / 2];
        float[] secondArr = new float[size / 2];
        for (int i = 0; i < size; i++){
            arr1[i] = 1;
            arr2[i] = 1;
        }

        long a = System.currentTimeMillis(); // время начала операции вычисления для первого случая

        for (int i = 0; i < size; i++)
            arr1[i] = (float)(arr1[i]*Math.sin(0.2f + i / 5)*Math.cos(0.2f + i / 5)*Math.cos(0.4f + i / 2));

        System.out.println(System.currentTimeMillis()-a); // время конца операции вычисления для первого случая

        // первый поток
        Thread partOne = new Thread(() -> {
            System.arraycopy(arr2, 0, firstArr, 0, h);
            for (int i = 0; i < firstArr.length; i++) {
                firstArr[i] = (float)(firstArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(firstArr, 0, arr2, 0, h);
        });

        // второй поток
        Thread partTwo = new Thread(() -> {
            System.arraycopy(arr2, h, secondArr, 0, h);
            for (int i = 0; i < secondArr.length; i++){
                secondArr[i] = (float)(secondArr[i]*Math.sin(0.2f + i / 5)*Math.cos(0.2f + i / 5)*Math.cos(0.4f + i / 2));
            }
            System.arraycopy(secondArr, 0, arr2, h, h);
        });

        long b = System.currentTimeMillis(); // время начала операции вычисления для второго случая

        partOne.start();
        partTwo.start();
        try {
            partOne.join();
            partTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis()-b); // время конца операции вычисления для второго случая

    }
}
