import java.util.*;

public class Day95 {

    public static void bucketSort(double[] arr) {
        int n = arr.length;

        // Create n buckets
        ArrayList<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets
        for (double num : arr) {
            int index = (int) (num * n);
            buckets[index].add(num);
        }

        // Sort each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate buckets
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (double num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {

        double[] arr = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};

        bucketSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}