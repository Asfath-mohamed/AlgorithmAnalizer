// Member3 change - test
public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("Algorithm: Bubble Sort (measure sorting time)");
        System.out.println("Input Size | Time (ms) | Sorted?");
        System.out.println("-----------------------------------");

        for (int size : SharedArrays.SIZES) {
            int[] arr = SharedArrays.getArray(size); // fresh copy

            long start = System.nanoTime();
            bubbleSort(arr);
            long end = System.nanoTime();
            double ms = (end - start) / 1_000_000.0;

            System.out.printf("%9d | %8.4f | %7b%n", size, ms, isSorted(arr));
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}
