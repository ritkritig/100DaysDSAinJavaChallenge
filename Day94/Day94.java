import java.util.Arrays;

public class Day94 {

    public static int[] countingSort(int[] arr) {

        // Find maximum element
        int max = 0;

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Create frequency array
        int[] freq = new int[max + 1];

        // Count frequencies
        for (int num : arr) {
            freq[num]++;
        }

        // Compute prefix sums
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        // Build output array
        int[] output = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];

            output[freq[num] - 1] = num;
            freq[num]--;
        }

        return output;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        int[] result = countingSort(arr);

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(result));
    }
}