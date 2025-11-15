// Member4 change - test
public class QuickSort {

    public static void main(String[] args) {
        System.out.println("Algorithm: Quick Sort (measure sorting time)");
        System.out.println("Input Size | Time (ms) | Sorted?");
        System.out.println("-----------------------------------");

        for (int size : SharedArrays.SIZES) {
            int[] arr = SharedArrays.getArray(size); // fresh copy

            long start = System.nanoTime();
            quickSort(arr, 0, arr.length - 1);
            long end = System.nanoTime();
            double ms = (end - start) / 1_000_000.0;

            System.out.printf("%9d | %8.4f | %7b%n", size, ms, isSorted(arr));
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}
