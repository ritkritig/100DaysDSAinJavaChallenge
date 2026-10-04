/*Problem: For each element, count how many smaller elements appear on right side.
Use merge sort technique or Fenwick Tree (BIT).*/
import java.util.*;

public class Day100 {

    static int[] count;
    static int[] index;

    public static int[] countSmaller(int[] nums) {

        int n = nums.length;

        count = new int[n];
        index = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        return count;
    }

    static void mergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    static void merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        int smaller = 0;

        while (i <= mid && j <= right) {

            if (nums[index[j]] < nums[index[i]]) {
                temp[k++] = index[j++];
                smaller++;
            } 
            else {
                count[index[i]] += smaller;
                temp[k++] = index[i++];
            }
        }

        while (i <= mid) {
            count[index[i]] += smaller;
            temp[k++] = index[i++];
        }

        while (j <= right) {
            temp[k++] = index[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            index[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {

        int[] nums = {5, 2, 6, 1};

        int[] result = countSmaller(nums);

        System.out.println("Count of smaller elements:");

        System.out.println(Arrays.toString(result));
    }
}