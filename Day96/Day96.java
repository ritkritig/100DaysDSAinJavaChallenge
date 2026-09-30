import java.util.*;

public class Day96 {

    static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static long mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long count = 0;

        // Count inversions in left half
        count += mergeSort(arr, left, mid);

        // Count inversions in right half
        count += mergeSort(arr, mid + 1, right);

        // Count inversions across both halves
        count += merge(arr, left, mid, right);

        return count;
    }

    static long merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        long count = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } 
            else {
                // arr[i] > arr[j]
                // All elements from i to mid are also greater than arr[j]
                count += (mid - i + 1);

                temp[k++] = arr[j++];
            }
        }

        // Remaining elements of left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Remaining elements of right half
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements back
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {5, 3, 2, 4, 1};

        long inversions = countInversions(arr);

        System.out.println("Number of inversions: " + inversions);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}