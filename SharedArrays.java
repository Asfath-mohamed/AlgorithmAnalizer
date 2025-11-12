import java.util.Random;

public class SharedArrays {
    private static final long SEED = 12345L;
    public static final int[] SIZES = {100, 500, 1000};

    public static int[] getArray(int size) {
        Random r = new Random(SEED + size); // same random numbers every time
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }
}
