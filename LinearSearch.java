public class LinearSearch {

    public static void main(String[] args) {
        System.out.println("Algorithm: Linear Search (time to find an element)");
        System.out.println("Input Size | Time (ms) | FoundIndex");
        System.out.println("-----------------------------------");

        for (int size : SharedArrays.SIZES) {
            int[] arr = SharedArrays.getArray(size); // create new array
            int target = arr[arr.length - 1]; // pick last element (exists)

            long start = System.nanoTime();
            int found = linearSearch(arr, target);
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;
            System.out.printf("%9d | %9.4f | %10d%n", size, ms, found);
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
}
