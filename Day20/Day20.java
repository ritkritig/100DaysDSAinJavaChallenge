/*Problem: Given an array of integers, count the number of subarrays whose sum is equal to zero.

        Input:
        - First line: integer n
- Second line: n integers

Output:
        - Print the count of subarrays having sum zero*/
import java.util.HashMap;
import java.util.Scanner;
class SubarrayCalculator {
    public int countZeroSumSubarrays(int[] arr) {
        HashMap<Long, Integer> map = new HashMap<>();
        long runningSum = 0;
        int count = 0;
        for (int value : arr) {
            runningSum += value;
            if (runningSum == 0) {
                count++;
            }
            if (map.containsKey(runningSum)) {
                count += map.get(runningSum);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}
public class Day20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        SubarrayCalculator calculator = new SubarrayCalculator();
        int result = calculator.countZeroSumSubarrays(arr);
        System.out.println(result);
        scanner.close();
    }
}