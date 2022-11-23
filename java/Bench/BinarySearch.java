package Bench;


public class BinarySearch {

    public static void init() {
        int[] array = new int[1000000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        binarySearch(array, 125000);
    }

    public static void binarySearch(int[] nums, int check) {
        int hi = nums.length - 1;
        int lo = 0;
        while (hi >= lo) {
            int guess = (lo + hi) >>> 1;  // from OpenJDK
            if (nums[guess] > check) {
                hi = guess - 1;
            } else if (nums[guess] < check) {
                lo = guess + 1;
            } else {
                return;
            }
        }
    }
}
