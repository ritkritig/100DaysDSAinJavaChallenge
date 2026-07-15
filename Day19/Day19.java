/*Problem: Given an array of integers, find two elements whose sum is closest to zero.

        Input:
        - First line: integer n
- Second line: n space-separated integers

Output:
        - Print the pair of elements whose sum is closest to zero*/
import java.util.*;

public class Day19 {
    public static void findPairClosestToZero(int[] arr) {
        if (arr == null || arr.length < 2) return;
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        int bestSum = Integer.MAX_VALUE;
        int pairLeft = arr[left];
        int pairRight = arr[right];

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (Math.abs(currentSum) < Math.abs(bestSum)) {
                bestSum = currentSum;
                pairLeft = arr[left];
                pairRight = arr[right];
            }
            if (currentSum < 0) {
                left++;
            } else if (currentSum > 0) {
                right--;
            } else {
                break;
            }
        }

        System.out.println(pairLeft + " " + pairRight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findPairClosestToZero(arr);
        sc.close();
    }
}