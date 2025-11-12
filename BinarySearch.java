// Member2 change - test
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Algorithm: Binary Search (array sorted first)");
        System.out.println("Input Size | Sort Time (ms) | Search Time (ms) | FoundIndex");
        System.out.println("----------------------------------------------------------");

        for (int size : SharedArrays.SIZES) {
            int[] arr = SharedArrays.getArray(size); // fresh copy

            // Measure sorting time (optional to show)
            long sortStart = System.nanoTime();
            Arrays.sort(arr);
            long sortEnd = System.nanoTime();
            double sortMs = (sortEnd - sortStart) / 1_000_000.0;

            // choose target (exists)
            int target = arr[arr.length - 1];

            // Measure only binary search time
            long start = System.nanoTime();
            int found = binarySearch(arr, target);
            long end = System.nanoTime();
            double searchMs = (end - start) / 1_000_000.0;

            System.out.printf("%9d | %13.4f | %15.6f | %10d%n", size, sortMs, searchMs, found);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
